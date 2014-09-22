/**
 * 
 */
package ipojo.project.creation.wizard;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


import liglab.imag.fr.ipojo.preferences.util.IPojoPreferencesContants;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModelFactory;
import org.eclipse.pde.core.plugin.IFragment;
import org.eclipse.pde.core.plugin.IPlugin;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.core.plugin.IPluginLibrary;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.TargetPlatformHelper;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.core.bundle.BundlePluginBase;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundleFragmentModel;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModelBase;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginBase;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.natures.PDE;
import org.eclipse.pde.internal.core.plugin.WorkspaceFragmentModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModel;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.core.util.CoreUtility;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.PDEUIMessages;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.AbstractFieldData;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginClassCodeGenerator;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.pde.ui.IBundleContentWizard;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.IFragmentFieldData;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.pde.ui.IPluginFieldData;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.osgi.framework.Constants;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author Gabriel Pedraza Ferreira
 *
 */
@SuppressWarnings("restriction")
public class NewPojoProjectCreationOperation extends WorkspaceModifyOperation {

	private IPluginContentWizard fContentWizard;

	private IFieldData fData;

	private PluginClassCodeGenerator fGenerator;

	private WorkspacePluginModelBase fModel;

	private IProjectProvider fProjectProvider;

	private boolean fResult;
	
	private final static String METADATA_TEXT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ipojo xmlns=\"org.apache.felix.ipojo\">\n</ipojo>";

	/**
	 * @param data
	 * @param provider representation of the project
	 * @param contentWizard wizard to run to get details for the chosen template, may be <code>null</code> if a template is not being used
	 */
	public NewPojoProjectCreationOperation(IFieldData data, IProjectProvider provider, IPluginContentWizard contentWizard) {
		fData = data;
		fProjectProvider = provider;
		fContentWizard = contentWizard;
	}

	// function used to modify Manifest just before it is written out (after all project artifacts have been created.
	protected void adjustManifests(IProgressMonitor monitor, IProject project, IPluginBase bundle) throws CoreException {
		// if libraries are exported, compute export package (173393)
		IPluginLibrary[] libs = fModel.getPluginBase().getLibraries();
		Set packages = new TreeSet();
		for (int i = 0; i < libs.length; i++) {
			String[] filters = libs[i].getContentFilters();
			// if a library is fully exported, then export all source packages (since we don't know which source folders go with which library)
			if (filters.length == 1 && filters[0].equals("**")) { //$NON-NLS-1$
				addAllSourcePackages(project, packages);
				break;
			}
			for (int j = 0; j < filters.length; j++) {
				if (filters[j].endsWith(".*")) //$NON-NLS-1$
					packages.add(filters[j].substring(0, filters[j].length() - 2));
			}
		}
		if (!packages.isEmpty()) {
			IBundle iBundle = ((WorkspaceBundlePluginModelBase) fModel).getBundleModel().getBundle();
			iBundle.setHeader(Constants.EXPORT_PACKAGE, getCommaValuesFromPackagesSet(packages, fData.getVersion()));
		}
	}

	private void createBuildPropertiesFile(IProject project) throws CoreException {
		IFile file = PDEProject.getBuildProperties(project);
		if (!file.exists()) {
			WorkspaceBuildModel model = new WorkspaceBuildModel(file);
			IBuildModelFactory factory = model.getFactory();

			// BIN.INCLUDES
			IBuildEntry binEntry = factory.createEntry(IBuildEntry.BIN_INCLUDES);
			fillBinIncludes(project, binEntry);
			createSourceOutputBuildEntries(model, factory);
			model.getBuild().add(binEntry);
			model.save();
		}
	}

	protected void createSourceOutputBuildEntries(WorkspaceBuildModel model, IBuildModelFactory factory) throws CoreException {
		String srcFolder = fData.getSourceFolderName();
		if (!fData.isSimple() && srcFolder != null) {
			String libraryName = fData.getLibraryName();
			if (libraryName == null)
				libraryName = "."; //$NON-NLS-1$
			// SOURCE.<LIBRARY_NAME>
			IBuildEntry entry = factory.createEntry(IBuildEntry.JAR_PREFIX + libraryName);
			if (srcFolder.length() > 0)
				entry.addToken(new Path(srcFolder).addTrailingSeparator().toString());
			else
				entry.addToken("."); //$NON-NLS-1$
			model.getBuild().add(entry);

			// OUTPUT.<LIBRARY_NAME>
			entry = factory.createEntry(IBuildEntry.OUTPUT_PREFIX + libraryName);
			String outputFolder = fData.getOutputFolderName().trim();
			if (outputFolder.length() > 0)
				entry.addToken(new Path(outputFolder).addTrailingSeparator().toString());
			else
				entry.addToken("."); //$NON-NLS-1$
			model.getBuild().add(entry);
		}
	}

	protected void createContents(IProgressMonitor monitor, IProject project) throws CoreException, JavaModelException, InvocationTargetException, InterruptedException {
	}

	private void createManifest(IProject project) throws CoreException {
		IFile fragmentXml = PDEProject.getFragmentXml(project);
		IFile pluginXml = PDEProject.getPluginXml(project);
		if (fData.hasBundleStructure()) {
			IFile manifest = PDEProject.getManifest(project);
			if (fData instanceof IFragmentFieldData) {
				fModel = new WorkspaceBundleFragmentModel(manifest, fragmentXml);
			} else {
				fModel = new WorkspaceBundlePluginModel(manifest, pluginXml);
			}
		} else {
			if (fData instanceof IFragmentFieldData) {
				fModel = new WorkspaceFragmentModel(fragmentXml, false);
			} else {
				fModel = new WorkspacePluginModel(pluginXml, false);
			}
		}
		IPluginBase pluginBase = fModel.getPluginBase();
		String targetVersion = ((AbstractFieldData) fData).getTargetVersion();
		pluginBase.setSchemaVersion(TargetPlatformHelper.getSchemaVersionForTargetVersion(targetVersion));
		pluginBase.setId(fData.getId());
		pluginBase.setVersion(fData.getVersion());
		pluginBase.setName(fData.getName());
		pluginBase.setProviderName(fData.getProvider());
		if (fModel instanceof IBundlePluginModelBase) {
			IBundlePluginModelBase bmodel = ((IBundlePluginModelBase) fModel);
			((IBundlePluginBase) bmodel.getPluginBase()).setTargetVersion(targetVersion);
			bmodel.getBundleModel().getBundle().setHeader(Constants.BUNDLE_MANIFESTVERSION, "2"); //$NON-NLS-1$
		}
		if (pluginBase instanceof IFragment) {
			IFragment fragment = (IFragment) pluginBase;
			IFragmentFieldData data = (IFragmentFieldData) fData;
			fragment.setPluginId(data.getPluginId());
			fragment.setPluginVersion(data.getPluginVersion());
			fragment.setRule(data.getMatch());
		} else {
			if (((IPluginFieldData) fData).doGenerateClass())
				((IPlugin) pluginBase).setClassName(((IPluginFieldData) fData).getClassname());
		}
		if (!fData.isSimple()) {
			setPluginLibraries(fModel);
		}

		IPluginReference[] dependencies = getDependencies();
		for (int i = 0; i < dependencies.length; i++) {
			IPluginReference ref = dependencies[i];
			IPluginImport iimport = fModel.getPluginFactory().createImport();
			iimport.setId(ref.getId());
			iimport.setVersion(ref.getVersion());
			iimport.setMatch(ref.getMatch());
			pluginBase.add(iimport);
		}
		// add Bundle Specific fields if applicable
		if (pluginBase instanceof BundlePluginBase) {
			IBundle bundle = ((BundlePluginBase) pluginBase).getBundle();
			if (fData instanceof AbstractFieldData) {

				// Set required EE
				String exeEnvironment = ((AbstractFieldData) fData).getExecutionEnvironment();
				if (exeEnvironment != null) {
					bundle.setHeader(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT, exeEnvironment);
				}

				String framework = ((AbstractFieldData) fData).getOSGiFramework();
				if (framework != null) {
					String value = getCommaValuesFromPackagesSet(getImportPackagesSet(), fData.getVersion());
					if (value.length() > 0)
						bundle.setHeader(Constants.IMPORT_PACKAGE, value);
					// if framework is not equinox, skip equinox step below to add extra headers
					if (!framework.equals(ICoreConstants.EQUINOX))
						return;
				}
			}
			if (fData instanceof IPluginFieldData && ((IPluginFieldData) fData).doGenerateClass()) {
				if (targetVersion.equals("3.1")) //$NON-NLS-1$
					bundle.setHeader(ICoreConstants.ECLIPSE_AUTOSTART, "true"); //$NON-NLS-1$
				else {
					double version = Double.parseDouble(targetVersion);
					if (version >= 3.4) {
						bundle.setHeader(Constants.BUNDLE_ACTIVATIONPOLICY, Constants.ACTIVATION_LAZY);
					} else {
						bundle.setHeader(ICoreConstants.ECLIPSE_LAZYSTART, "true"); //$NON-NLS-1$
					}
				}

			}
			if (fContentWizard != null) {
				String[] newFiles = fContentWizard.getNewFiles();
				if (newFiles != null)
					for (int i = 0; i < newFiles.length; i++) {
						if ("plugin.properties".equals(newFiles[i])) { //$NON-NLS-1$
							bundle.setHeader(Constants.BUNDLE_LOCALIZATION, "plugin"); //$NON-NLS-1$
							break;
						}
					}
			}
		}
	}
	
	private IFile createMetadataFile(IProject project) throws CoreException {
		final IFile metadataFile = project.getFile("/metadata.xml");
		InputStream stream;
      try {
	      stream = new ByteArrayInputStream(METADATA_TEXT.getBytes("UTF-8"));
	      metadataFile.create(stream, true, new NullProgressMonitor());
      } catch (UnsupportedEncodingException e) {
      }		
      return metadataFile;
	}

	private IProject createProject() throws CoreException {
		IProject project = fProjectProvider.getProject();
		if (!project.exists()) {
			CoreUtility.createProject(project, fProjectProvider.getLocationPath(), null);
			project.open(null);
		}
		if (!project.hasNature(PDE.PLUGIN_NATURE))
			CoreUtility.addNatureToProject(project, PDE.PLUGIN_NATURE, null);
		if (!fData.isSimple() && !project.hasNature(JavaCore.NATURE_ID))
			CoreUtility.addNatureToProject(project, JavaCore.NATURE_ID, null);
		if (!fData.isSimple() && fData.getSourceFolderName() != null && fData.getSourceFolderName().trim().length() > 0) {
			IFolder folder = project.getFolder(fData.getSourceFolderName());
			if (!folder.exists())
				CoreUtility.createFolder(folder);
		}
		
		// IPOJO Task : Add the ipojo Nature to the project
		addIPojoNature(project);
		return project;
	}
	
	/**
	 * Adds the ipojo nature to the new project
	 * @param project
	 * @throws CoreException
	 */
	private void addIPojoNature(IProject project)  throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] prevNatures = description.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 1, prevNatures.length);
		newNatures[0] = "org.ow2.chameleon.eclipse.ipojo.iPojoNature";
		description.setNatureIds(newNatures);	
		project.setDescription(description, null);
	}
	
	
	/**
	 * Adds the annotations class path container to the project build path
	 * 
	 * @param aProject
	 *            Project to be modified
	 */
	private void addAnnotationsLibrary(final IProject aProject) {

		// Get the Java nature
		final IJavaProject javaProject;
		try {
			javaProject = (IJavaProject) aProject.getNature(JavaCore.NATURE_ID);

		} catch (CoreException e) {
			PDEPlugin.logErrorMessage("Can't get the Java nature " + aProject.getName());
			return;
		}

		// Get current entries
		final IClasspathEntry[] currentEntries;
		try {
			currentEntries = javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			PDEPlugin.logErrorMessage("Error reading project classpath " + aProject.getName());
			return;
		}
		
		IPath annotationsContainerPath = new Path("org.ow2.chameleon.ipojo.CLASSPATH_CONTAINER");

		for (IClasspathEntry entry : currentEntries) {

			if (annotationsContainerPath.equals(entry.getPath())) {
				// The annotation container is already here.
				return;
			}
		}

		// Set up the new class path array
		final IClasspathEntry[] newEntries = new IClasspathEntry[currentEntries.length + 1];
		System.arraycopy(currentEntries, 0, newEntries, 0, currentEntries.length);

		// Add the new entry
		newEntries[currentEntries.length] = JavaCore.newContainerEntry(annotationsContainerPath);

		// Set the project class path
		try {
			javaProject.setRawClasspath(newEntries, null);
		} catch (JavaModelException e) {
			PDEPlugin.logErrorMessage("Error setting up the new project class path" + aProject.getName());
		}
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.WorkspaceModifyOperation#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {

		// start task
		monitor.beginTask(PDEUIMessages.NewProjectCreationOperation_creating, getNumberOfWorkUnits());
		monitor.subTask(PDEUIMessages.NewProjectCreationOperation_project);

		// create project
		IProject project = createProject();
		monitor.worked(1);
		createContents(monitor, project);

		// set classpath if project has a Java nature
		if (project.hasNature(JavaCore.NATURE_ID)) {
			monitor.subTask(PDEUIMessages.NewProjectCreationOperation_setClasspath);
			setClasspath(project, fData);
			monitor.worked(1);
		}

		if (fData instanceof PluginFieldData) {
			PluginFieldData data = (PluginFieldData) fData;

			// generate top-level Java class if that option is selected
			if (data.doGenerateClass()) {
				generateTopLevelPluginClass(project, new SubProgressMonitor(monitor, 1));
			}

			// add API Tools nature if requested
			if (data.doEnableAPITooling()) {
				addApiAnalysisNature();
			}

		}
		// generate the manifest file
		monitor.subTask(PDEUIMessages.NewProjectCreationOperation_manifestFile);
		createManifest(project);
		monitor.worked(1);

		// IPOJO Task : create the metadatxml file
		IFile metadataFile = createMetadataFile(project);
		addAnnotationsLibrary(project);
		
		
		
		// generate the build.properties file
		monitor.subTask(PDEUIMessages.NewProjectCreationOperation_buildPropertiesFile);
		createBuildPropertiesFile(project);
		monitor.worked(1);		
		
		// generate content contributed by template wizards
		boolean contentWizardResult = true;
		if (fContentWizard != null) {
			contentWizardResult = fContentWizard.performFinish(project, fModel, new SubProgressMonitor(monitor, 1));
		}

		if (fData instanceof AbstractFieldData) {
			String framework = ((AbstractFieldData) fData).getOSGiFramework();
			if (framework != null) {
				IEclipsePreferences pref = new ProjectScope(project).getNode(PDECore.PLUGIN_ID);
				if (pref != null) {
					pref.putBoolean(ICoreConstants.RESOLVE_WITH_REQUIRE_BUNDLE, false);
					pref.putBoolean(ICoreConstants.EXTENSIONS_PROPERTY, false);
					if (!ICoreConstants.EQUINOX.equals(framework))
						pref.putBoolean(ICoreConstants.EQUINOX_PROPERTY, false);
					try {
						pref.flush();
					} catch (BackingStoreException e) {
						PDEPlugin.logException(e);
					}
				}
			}
		}

		if (fData.hasBundleStructure() && fModel instanceof WorkspaceBundlePluginModelBase) {
			adjustManifests(new SubProgressMonitor(monitor, 1), project, fModel.getPluginBase());
		}

		fModel.save();
		openFile(metadataFile);
		monitor.worked(1);

		fResult = contentWizardResult;
	}

	private Set getImportPackagesSet() {
		TreeSet set = new TreeSet();
		if (fGenerator != null) {
			String[] packages = fGenerator.getImportPackages();
			for (int i = 0; i < packages.length; i++) {
				set.add(packages[i]);
			}
		}
		if (fContentWizard instanceof IBundleContentWizard) {
			String[] packages = ((IBundleContentWizard) fContentWizard).getImportPackages();
			for (int i = 0; i < packages.length; i++) {
				set.add(packages[i]);
			}
		}
		
		// IPOJO Task : Add the iCasa import packages
		IPreferencesService prefService = Platform.getPreferencesService();
		boolean addImports = prefService.getBoolean("ipojo.preferences", IPojoPreferencesContants.ICASA_IMPORT_PREFERENCE, false, null);
		if (addImports) {
			
			IPluginModelBase[] models = PluginRegistry.getActiveModels();
			
			for (int i = 0; i < models.length; i++) {
				BundleDescription desc = models[i].getBundleDescription();
				ExportPackageDescription[] exported = desc.getExportPackages();
				for (int j = 0; j < exported.length; j++) {
					String name = exported[j].getName();		

					if (name.startsWith("fr.liglab.adele.icasa")) {
						set.add(name);
					}
				}				
			}
			
			// Add the org.json package
			set.add("org.json");
			
		}
				
		return set;
	}
	
	

	protected void fillBinIncludes(IProject project, IBuildEntry binEntry) throws CoreException {
		if ((!fData.hasBundleStructure() || fContentWizard != null) && ((AbstractFieldData) fData).getOSGiFramework() == null)
			binEntry.addToken(fData instanceof IFragmentFieldData ? ICoreConstants.FRAGMENT_FILENAME_DESCRIPTOR : ICoreConstants.PLUGIN_FILENAME_DESCRIPTOR);
		if (fData.hasBundleStructure())
			binEntry.addToken("META-INF/"); //$NON-NLS-1$
		if (!fData.isSimple()) {
			String libraryName = fData.getLibraryName();
			binEntry.addToken(libraryName == null ? "." : libraryName); //$NON-NLS-1$
		}
		if (fContentWizard != null) {
			String[] files = fContentWizard.getNewFiles();
			for (int j = 0; j < files.length; j++) {
				if (!binEntry.contains(files[j]))
					binEntry.addToken(files[j]);
			}
		}
	}

	private void generateTopLevelPluginClass(IProject project, IProgressMonitor monitor) throws CoreException {
		PluginFieldData data = (PluginFieldData) fData;
		fGenerator = new PluginClassCodeGenerator(project, data.getClassname(), data, fContentWizard != null);
		fGenerator.generate(monitor);
		monitor.done();
	}

	private IClasspathEntry[] getClassPathEntries(IJavaProject project, IFieldData data) {
		IClasspathEntry[] internalClassPathEntries = getInternalClassPathEntries(project, data);
		IClasspathEntry[] entries = new IClasspathEntry[internalClassPathEntries.length + 2];
		System.arraycopy(internalClassPathEntries, 0, entries, 2, internalClassPathEntries.length);

		// Set EE of new project
		String executionEnvironment = null;
		if (data instanceof AbstractFieldData) {
			executionEnvironment = ((AbstractFieldData) data).getExecutionEnvironment();
		}
		ClasspathComputer.setComplianceOptions(project, executionEnvironment);
		entries[0] = ClasspathComputer.createJREEntry(executionEnvironment);
		entries[1] = ClasspathComputer.createContainerEntry();

		return entries;
	}

	private IPluginReference[] getDependencies() {
		ArrayList result = new ArrayList();
		if (fGenerator != null) {
			IPluginReference[] refs = fGenerator.getDependencies();
			for (int i = 0; i < refs.length; i++) {
				result.add(refs[i]);
			}
		}

		if (fContentWizard != null) {
			IPluginReference[] refs = fContentWizard.getDependencies(fData.isLegacy() ? null : "3.0"); //$NON-NLS-1$
			for (int j = 0; j < refs.length; j++) {
				if (!result.contains(refs[j]))
					result.add(refs[j]);
			}
		}
					
		return (IPluginReference[]) result.toArray(new IPluginReference[result.size()]);
	}

	protected IClasspathEntry[] getInternalClassPathEntries(IJavaProject project, IFieldData data) {
		if (data.getSourceFolderName() == null) {
			return new IClasspathEntry[0];
		}
		IClasspathEntry[] entries = new IClasspathEntry[1];
		IPath path = project.getProject().getFullPath().append(data.getSourceFolderName());
		entries[0] = JavaCore.newSourceEntry(path);
		return entries;
	}

	protected int getNumberOfWorkUnits() {
		int numUnits = 4;
		if (fData.hasBundleStructure())
			numUnits++;
		if (fData instanceof IPluginFieldData) {
			IPluginFieldData data = (IPluginFieldData) fData;
			if (data.doGenerateClass())
				numUnits++;
			if (fContentWizard != null)
				numUnits++;
		}
		return numUnits;
	}

	public boolean getResult() {
		return fResult;
	}

	/**
	 * Attempts to select the given file in the active workbench part and open the file
	 * in its default editor.  Uses asyncExec to join with the UI thread.
	 * 
	 * @param file file to open the editor on
	 */
	private void openFile(final IFile file) {
		PDEPlugin.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				final IWorkbenchWindow ww = PDEPlugin.getActiveWorkbenchWindow();
				final IWorkbenchPage page = ww.getActivePage();
				if (page == null)
					return;
				IWorkbenchPart focusPart = page.getActivePart();
				if (focusPart instanceof ISetSelectionTarget) {
					ISelection selection = new StructuredSelection(file);
					((ISetSelectionTarget) focusPart).selectReveal(selection);
				}
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
	}

	private void setClasspath(IProject project, IFieldData data) throws JavaModelException, CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		// Set output folder
		if (data.getOutputFolderName() != null) {
			IPath path = project.getFullPath().append(data.getOutputFolderName());
			javaProject.setOutputLocation(path, null);
		}
		IClasspathEntry[] entries = getClassPathEntries(javaProject, data);
		javaProject.setRawClasspath(entries, null);
	}

	protected void setPluginLibraries(WorkspacePluginModelBase model) throws CoreException {
		String libraryName = fData.getLibraryName();
		if (libraryName == null && !fData.hasBundleStructure()) {
			libraryName = "."; //$NON-NLS-1$
		}
		if (libraryName != null) {
			IPluginLibrary library = model.getPluginFactory().createLibrary();
			library.setName(libraryName);
			library.setExported(!fData.hasBundleStructure());
			fModel.getPluginBase().add(library);
		}
	}

	/**
	 * @param values a {@link Set} containing packages names as {@link String}s
	 * @param version a {@link String} representing the version to set on the package, <code>null</code> allowed.
	 * @return a {@link String} representing the given packages, with the exported version set correctly.<br>
	 * If there's only one package and version is not null, package is exported with that version number. 
	 */
	protected String getCommaValuesFromPackagesSet(Set values, String version) {
		StringBuffer buffer = new StringBuffer();
		Iterator iter = values.iterator();
		while (iter.hasNext()) {
			if (buffer.length() > 0) {
				buffer.append(",\n "); //$NON-NLS-1$ // space required for multiline headers
			}
			String value = iter.next().toString();
			buffer.append(value);

			if (value.indexOf(";version=") == -1 && (version != null) && (values.size() == 1)) { //$NON-NLS-1$
				buffer.append(";version=\"").append(version).append("\""); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}		
		return buffer.toString();
	}

	private void addAllSourcePackages(IProject project, Set list) {
		try {
			IJavaProject javaProject = JavaCore.create(project);
			IClasspathEntry[] classpath = javaProject.getRawClasspath();
			for (int i = 0; i < classpath.length; i++) {
				IClasspathEntry entry = classpath[i];
				if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					IPath path = entry.getPath().removeFirstSegments(1);
					if (path.segmentCount() > 0) {
						IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(project.getFolder(path));
						IJavaElement[] children = root.getChildren();
						for (int j = 0; j < children.length; j++) {
							IPackageFragment frag = (IPackageFragment) children[j];
							if (frag.getChildren().length > 0 || frag.getNonJavaResources().length > 0)
								list.add(children[j].getElementName());
						}
					}
				}
			}
		} catch (JavaModelException e) {
		}
	}

	/**
	 * Add the API analysis nature to the project
	 * @param add
	 */
	private void addApiAnalysisNature() {
		try {
			IProject project = fProjectProvider.getProject();
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length + 1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = "org.eclipse.pde.api.tools.apiAnalysisNature"; //$NON-NLS-1$
			description.setNatureIds(newNatures);
			project.setDescription(description, new NullProgressMonitor());
		} catch (CoreException ce) {
			//ignore
		}
	}


}
