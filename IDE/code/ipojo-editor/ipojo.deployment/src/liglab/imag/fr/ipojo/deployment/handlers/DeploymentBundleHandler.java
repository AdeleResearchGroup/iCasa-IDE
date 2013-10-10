/**
 * 
 */
package liglab.imag.fr.ipojo.deployment.handlers;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import liglab.imag.fr.ipojo.deployment.IPojoDeploymentPlugin;
import liglab.imag.fr.ipojo.preferences.util.IPojoPreferencesContants;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Constants;

/**
 * @author Gabriel
 * 
 */
public class DeploymentBundleHandler extends AbstractHandler {

	/** Workspace root */
	// private IWorkspaceRoot pWorkspaceRoot;

	/** Default manifest file name (MANIFEST.MF) */
	public static final String MANIFEST_NAME = "MANIFEST.MF";

	/** Default manifest parent folder (META-INF) */
	public static final String META_INF_FOLDER = "META-INF";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection newSelection = (IStructuredSelection) selection;
			if (newSelection.getFirstElement() instanceof IJavaProject) {
				IJavaProject project = (IJavaProject) newSelection.getFirstElement();

				//IPreferenceStore store = IPojoDeploymentPlugin.getDefault().getPreferenceStore();
				IPreferencesService preferencesService = Platform.getPreferencesService();
				// String deploymentDirectory =
				// store.getString(IPojoDeploymentPlugin.TARGET_DIRECTORY_PREFERENCE);

				String deploymentDirectory = preferencesService.getString("ipojo.preferences",
						IPojoPreferencesContants.TARGET_DIRECTORY_PREFERENCE, "", null);

				if (deploymentDirectory != null && !deploymentDirectory.trim().isEmpty()) {
					// String appsDirectory =
					// store.getString(IPojoDeploymentPlugin.APPS_DIRECTORY_PREFERENCE);
					String appsDirectory = preferencesService.getString("ipojo.preferences",
							IPojoPreferencesContants.APPS_DIRECTORY_PREFERENCE, "", null);
					if (appsDirectory.isEmpty())
						appsDirectory = "load";
					deploymentDirectory = deploymentDirectory + System.getProperty("file.separator") + appsDirectory;
					String message = "Deployment of " + project.getElementName() + " to " + deploymentDirectory
					      + " was sucessfull";

					try {
						exportBundle((IProject) project.getCorrespondingResource(), deploymentDirectory, null);
					} catch (JavaModelException e) {
						e.printStackTrace();
					} catch (CoreException e) {
						e.printStackTrace();
					}

					MessageDialog.openConfirm(null, "iCasa Environment", message);
				}

			}
		}

		return null;
	}

	/**
	 * Exports the given project as an iPOJO bundle
	 * 
	 * @param project
	 *           Project to be exported
	 * @param aMonitor
	 *           A progress monitor
	 */
	public void exportBundle(final IProject project, String deploymentDirectory, final IProgressMonitor aMonitor)
	      throws CoreException {

		// Store the workspace root (should'nt move...)
		// pWorkspaceRoot = aProject.getWorkspace().getRoot();

		// Rebuild the project (incremental build)
		project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, aMonitor);

		// Get the project manifest
		final Manifest projectManifest = getManifestContent(project);

		// Get the Java project nature
		final IJavaProject javaProject = (IJavaProject) project.getNature(JavaCore.NATURE_ID);

		// Prepare the File -> Entry map
		final Map<IFile, String> jarEntriesMapping = new HashMap<IFile, String>();

		// Don't use the build.properties file
		prepareProjectFilesList(javaProject, project, jarEntriesMapping);

		// Make the JAR file
		try {
			byte[] jarContent = makeJar(projectManifest, jarEntriesMapping);

			// Prepare the output file
			final File outputJarFile = new File(deploymentDirectory, getJarFileName(project, projectManifest));

			// Make parent directories if needed
			outputJarFile.getParentFile().mkdirs();

			// Write it down
			final FileOutputStream outStream = new FileOutputStream(outputJarFile);
			outStream.write(jarContent);
			outStream.close();

			// Update Eclipse resource, if the JAR is visible from the IDE
			IWorkspaceRoot pWorkspaceRoot = project.getWorkspace().getRoot();
			final IFile[] eclipseFiles = pWorkspaceRoot.findFilesForLocationURI(outputJarFile.toURI());
			if (eclipseFiles != null) {
				for (IFile eclipseFile : eclipseFiles) {
					eclipseFile.refreshLocal(IResource.DEPTH_ONE, aMonitor);
				}
			}

		} catch (IOException e) {

			throw new CoreException(new Status(IStatus.ERROR, IPojoDeploymentPlugin.PLUGIN_ID,
			      "Error writing JAR file for '" + project.getName() + "'", e));
		}
	}

	/**
	 * Prepares the project output files mapping for a JAR output, based on the
	 * Java project output folder
	 * 
	 * @param javaProject
	 *           A Java project (JDT)
	 * @param aJarEntriesMapping
	 *           A map to populate with found files
	 * @throws CoreException
	 */
	protected void prepareProjectFilesList(final IJavaProject javaProject, final IProject project,
	      final Map<IFile, String> aJarEntriesMapping) throws CoreException {

		try {
			// Get the project output folder
			final IPath outputLocation = javaProject.getOutputLocation();
			final IWorkspaceRoot workspaceRoot = project.getWorkspace().getRoot();
			final IFolder outputFolder = workspaceRoot.getFolder(outputLocation);

			// Look for any file in out folder (generally bin)
			visitFolder(outputFolder.getProjectRelativePath(), outputFolder, aJarEntriesMapping);

			IResource[] members = project.members(false);

			Set<IResource> selectedMembers = new HashSet<IResource>(Arrays.asList(members));

			selectedMembers.remove(outputFolder);
			selectedMembers.remove(project.getFile(new Path(".classpath")));
			selectedMembers.remove(project.getFile(new Path("build.properties")));
			selectedMembers.remove(project.getFile(new Path(IProjectDescription.DESCRIPTION_FILE_NAME)));
			selectedMembers.remove(project.getFolder(new Path(".settings")));

			// Remove source folders
			IClasspathEntry[] entries = javaProject.getRawClasspath();
			for (IClasspathEntry entry : entries) {
				if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					selectedMembers.remove(workspaceRoot.getFolder(entry.getPath()));
				}
			}

			for (IResource resource : selectedMembers) {
				if (resource instanceof IFolder) {
					// Folder included : visit it
					visitFolder(new Path("/"), (IFolder) resource, aJarEntriesMapping);
				} else if (resource instanceof IFile) {
					// Map the file directly
					aJarEntriesMapping.put((IFile) resource, resource.getProjectRelativePath().toString());
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prepares the list of files in the given folder to be stored in the output
	 * JAR file
	 * 
	 * @param aBasePath
	 *           All found files paths will be relative to this path
	 * @param aFolder
	 *           Folder to look into
	 * @param aJarEntriesMapping
	 *           Jar entries map
	 * @throws CoreException
	 *            An error occurred while listing members of a resource
	 */
	protected void visitFolder(final IPath aBasePath, final IFolder aFolder, final Map<IFile, String> aJarEntriesMapping)
	      throws CoreException {

		for (IResource resource : aFolder.members()) {

			if (resource instanceof IFolder) {
				// Recursively visit the folder
				visitFolder(aBasePath, (IFolder) resource, aJarEntriesMapping);

			} else if (resource instanceof IFile) {
				/*
				 * Only store files. Entry names are relative to the root of the
				 * resulting JAR.
				 */
				String filePath = resource.getProjectRelativePath().makeRelativeTo(aBasePath).toString();
				aJarEntriesMapping.put((IFile) resource, filePath);
			}
		}
	}

	/**
	 * Makes the JAR file in memory (using a ByteOutputStream object)
	 * 
	 * @param aManifest
	 *           The project Manifest
	 * @param aJarContentsMapping
	 *           Source file -> JAR Entry mapping
	 * @return The JAR file content
	 * @throws CoreException
	 *            An error occurred working with an Eclipse resource
	 * @throws IOException
	 *            An error occurred generating the JAR file content
	 */
	protected byte[] makeJar(final Manifest aManifest, final Map<IFile, String> aJarContentsMapping)
	      throws CoreException, IOException {

		final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		final JarOutputStream jarStream = new JarOutputStream(byteStream, aManifest);

		// Add all found files
		for (Entry<IFile, String> jarEntry : aJarContentsMapping.entrySet()) {
			System.out.println("File to process " + jarEntry.getKey().getName());
			addFile(jarStream, jarEntry.getKey(), jarEntry.getValue());
		}

		jarStream.close();
		return byteStream.toByteArray();
	}

	/**
	 * Adds the given source file to the JAR stream using the given entry name
	 * 
	 * @param aJarStream
	 *           Output JAR stream
	 * @param aSourceFile
	 *           Source file
	 * @param aEntryName
	 *           File name in the output JAR
	 * @throws IOException
	 *            An error occurred while working on the JAR stream
	 * @throws CoreException
	 *            An error occurred while reading the source file
	 */
	protected void addFile(final JarOutputStream aJarStream, final IFile aSourceFile, final String aEntryName)
	      throws IOException, CoreException {

		// Ignore the manifest file (already included)
		if (aSourceFile.getName().equalsIgnoreCase(MANIFEST_NAME)) {
			return;
		}

		// Open the source file
		final BufferedInputStream sourceStream = new BufferedInputStream(aSourceFile.getContents());

		// Prepare the entry
		final JarEntry entry = new JarEntry(aEntryName);
		aJarStream.putNextEntry(entry);

		// 8 kb buffer
		byte[] buffer = new byte[8192];
		while (true) {
			int read = sourceStream.read(buffer);
			if (read <= 0) {
				// EOF (or error, ...)
				break;
			}

			// Be careful on read length...
			aJarStream.write(buffer, 0, read);
		}

		// Release streams
		sourceStream.close();
		aJarStream.closeEntry();
	}

	/**
	 * Generates the JAR file name (without path), based on the bundle symbolic
	 * name or the project name
	 * 
	 * @param aProject
	 *           Exported project
	 * @param aManifest
	 *           Project manifest content
	 * @return The JAR file name
	 */
	public String getJarFileName(final IProject aProject, final Manifest aManifest) {

		// Try with the manifest content ...
		String fileName = aManifest.getMainAttributes().getValue(Constants.BUNDLE_SYMBOLICNAME);

		if (fileName == null) {
			// ... else, use the project
			fileName = aProject.getName();
		}

		// Append the jar extension
		return fileName + ".jar";
	}

	/**
	 * Reads the manifest file content and retrieves it as a Manifest object
	 * 
	 * @param aProject
	 *           Current manipulated project
	 * @return The manifest object
	 * @throws CoreException
	 *            An error occurred while reading the file
	 */
	public Manifest getManifestContent(final IProject aProject) throws CoreException {

		final IFile manifestFile = getManifestFile(aProject, true);

		try {
			return new Manifest(manifestFile.getContents(true));

		} catch (IOException e) {
			// Propagate the error
			IStatus exceptionStatus = new Status(IStatus.WARNING, IPojoDeploymentPlugin.PLUGIN_ID,
			      "Couldn't read the manifest content", e);
			throw new CoreException(exceptionStatus);
		}
	}

	/**
	 * Retrieves a reference to the manifest file. Try to create if needed.
	 * 
	 * @param aProject
	 *           Current manipulated project
	 * @param aForce
	 *           Creates the Manifest file if it doesn't exist yet
	 * @return A reference to the manifest file, null if the file doesn't exist
	 *         and aForce is false
	 */
	public IFile getManifestFile(final IProject aProject, final boolean aForce) throws CoreException {

		// Search for the Manifest file
		final IFile manifestFile = findFile(aProject, MANIFEST_NAME);
		if (manifestFile == null && aForce) {
			// Try to create a brand new one
			return createDefaultManifest(aProject);
		}

		return manifestFile;
	}

	/**
	 * Creates an empty manifest file, to allow manifest result output
	 * 
	 * @param aProject
	 *           Current manipulated project
	 * @return A valid manifest IFile reference
	 * @throws CoreException
	 *            An error occurred while creating the manifest file or parent
	 *            folder
	 */
	protected IFile createDefaultManifest(final IProject aProject) throws CoreException {

		// Create the folder
		IFolder metaInf = aProject.getFolder(META_INF_FOLDER);
		if (!metaInf.exists()) {
			metaInf.create(true, false, null);
		}

		// Prepare the input
		ByteArrayOutputStream manifestOutstream = new ByteArrayOutputStream();
		Manifest emptyManifest = new Manifest();

		// To be valid, a manifest must contain a Manifest-Version attribute
		emptyManifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");

		try {
			emptyManifest.write(manifestOutstream);

		} catch (IOException ex) {

		}

		// Create the file
		IFile manifestIFile = metaInf.getFile(MANIFEST_NAME);
		manifestIFile.create(new ByteArrayInputStream(manifestOutstream.toByteArray()), true, null);

		return manifestIFile;
	}

	/**
	 * Search for the given file
	 * 
	 * @param aRoot
	 *           Root container to look in
	 * @param aFileName
	 *           File to look for
	 * @return The File, or null if not found
	 * @throws CoreException
	 *            An error occurred while reading members list (mainly on remote
	 *            files)
	 */
	protected IFile findFile(final IContainer aRoot, final String aFileName) {

		if (aRoot == null || aFileName == null || aFileName.isEmpty()) {
			return null;
		}

		IResource[] members;
		try {
			members = aRoot.members();

		} catch (CoreException ex) {

			return null;
		}

		if (members == null) {
			return null;
		}

		for (IResource resource : members) {

			if (resource.getName().equalsIgnoreCase(aFileName)) {
				if (resource.getType() == IResource.FILE) {
					return (IFile) resource;
				}

			} else if (resource.getType() == IResource.FOLDER) {
				IFile found = findFile((IContainer) resource, aFileName);
				if (found != null) {
					return found;
				}
			}
		}

		return null;
	}

}
