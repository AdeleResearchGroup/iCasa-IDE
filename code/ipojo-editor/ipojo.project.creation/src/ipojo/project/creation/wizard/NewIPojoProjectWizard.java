package ipojo.project.creation.wizard;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.internal.core.bundle.BundlePluginBase;
import org.eclipse.pde.internal.core.bundle.WorkspaceBundlePluginModel;
import org.eclipse.pde.internal.core.ibundle.IBundle;
import org.eclipse.pde.internal.core.plugin.WorkspacePluginModelBase;
import org.eclipse.pde.internal.core.project.PDEProject;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.PDEPluginImages;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.NewWizard;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.osgi.framework.Constants;

@SuppressWarnings("restriction")
public class NewIPojoProjectWizard extends NewWizard implements IExecutableExtension {

	public static final String PLUGIN_POINT = "pluginContent"; //$NON-NLS-1$
	public static final String TAG_WIZARD = "wizard"; //$NON-NLS-1$
	public static final String DEF_PROJECT_NAME = "project_name"; //$NON-NLS-1$
	public static final String DEF_TEMPLATE_ID = "template-id"; //$NON-NLS-1$

	private final static String metadataSrt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ipojo xmlns=\"org.apache.felix.ipojo\">\n</ipojo>";

	private IConfigurationElement fConfig;
	private PluginFieldData fPluginData;
	private IProjectProvider fProjectProvider;
	protected NewProjectCreationPage fMainPage;
	protected IPojoPluginContentPage fContentPage;

	// private TemplateListSelectionPage fWizardListPage;

	public NewIPojoProjectWizard() {
		setDefaultPageImageDescriptor(PDEPluginImages.DESC_NEWPPRJ_WIZ);
		setDialogSettings(PDEPlugin.getDefault().getDialogSettings());
		setWindowTitle("New iPojo Project");
		setNeedsProgressMonitor(true);
		fPluginData = new PluginFieldData();
	}

	public NewIPojoProjectWizard(String osgiFramework) {
		this();
		fPluginData.setOSGiFramework(osgiFramework);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	public void addPages() {
		
		// Sets the default the project as an standard osgi project
		IDialogSettings settings = getDialogSettings();
		settings.put("osgiProject", true);
		settings.put("targetName", "standard");
		
		fMainPage = new NewProjectCreationPage("main", fPluginData, false, getSelection()); //$NON-NLS-1$
		fMainPage.setTitle("iPojo Project");
		fMainPage.setDescription("Create a new iPojo project");
		
		String pname = getDefaultValue(DEF_PROJECT_NAME);
		if (pname != null)
			fMainPage.setInitialProjectName(pname);
		addPage(fMainPage);

		fProjectProvider = new IProjectProvider() {
			public String getProjectName() {
				return fMainPage.getProjectName();
			}

			public IProject getProject() {
				return fMainPage.getProjectHandle();
			}

			public IPath getLocationPath() {
				return fMainPage.getLocationPath();
			}
		};


		fContentPage = new IPojoPluginContentPage("page2", fProjectProvider, fMainPage, fPluginData); //$NON-NLS-1$


		addPage(fContentPage);


	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	public boolean canFinish() {
		IWizardPage page = getContainer().getCurrentPage();
		return super.canFinish() && page != fMainPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.pde.internal.ui.wizards.NewWizard#performFinish()
	 */
	public boolean performFinish() {
		try {
			fMainPage.updateData();
			fContentPage.updateData();
			IDialogSettings settings = getDialogSettings();
			if (settings != null) {
				fMainPage.saveSettings(settings);
				fContentPage.saveSettings(settings);
			}
			BasicNewProjectResourceWizard.updatePerspective(fConfig);


			getContainer().run(false, true, new NewProjectCreationOperation(fPluginData, fProjectProvider, null));

			IWorkingSet[] workingSets = fMainPage.getSelectedWorkingSets();
			if (workingSets.length > 0)
				getWorkbench().getWorkingSetManager().addToWorkingSets(fProjectProvider.getProject(), workingSets);

			// Adds the ipojo nature to the project
			IProject project = fMainPage.getProjectHandle();
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newnatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newnatures, 1, natures.length);
			newnatures[0] = "org.ow2.chameleon.eclipse.ipojo.iPojoNature";
			description.setNatureIds(newnatures);
			project.setDescription(description, null);

			// Creates the metadata file
			final IFile metadataFile = project.getFile("/metadata.xml");
			InputStream stream = new ByteArrayInputStream(metadataSrt.getBytes("UTF-8"));
			metadataFile.create(stream, true, new NullProgressMonitor());

			// Adds the imports

			IPreferencesService prefService = Platform.getPreferencesService();
			boolean addImports = prefService.getBoolean("metadata.ipojo.editor", "iCasa_Import_Preference", false, null);

			if (addImports) {
				IFile pluginXml = PDEProject.getPluginXml(project);
				IFile manifest = PDEProject.getManifest(project);
				WorkspacePluginModelBase fModel = new WorkspaceBundlePluginModel(manifest, pluginXml);
				IPluginBase pluginBase = fModel.getPluginBase();

				if (pluginBase instanceof BundlePluginBase) {
					IBundle bundle = ((BundlePluginBase) pluginBase).getBundle();
					bundle.setHeader(
					      Constants.IMPORT_PACKAGE,
					      "fr.liglab.adele.icasa.device, fr.liglab.adele.icasa.device.light, fr.liglab.adele.icasa.device.temperature," +
					      "fr.liglab.adele.icasa.device.power, fr.liglab.adele.icasa.device.presence," +
					      "fr.liglab.adele.icasa.device.sound,fr.liglab.adele.icasa.device.util");
				}
				fModel.save();
			}
			
			closeManifest();
			openFileInEditor(metadataFile);
											
			return true;
		} catch (InvocationTargetException e) {
			PDEPlugin.logException(e);
		} catch (InterruptedException e) {
		} catch (CoreException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org
	 * .eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 * java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
	      throws CoreException {
		fConfig = config;
	}

	public String getPluginId() {
		return fPluginData.getId();
	}

	public String getPluginVersion() {
		return fPluginData.getVersion();
	}

	
	private void closeManifest() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] references =  activePage.getEditorReferences();
		IEditorReference manifestReference = null;
		
		for (IEditorReference iEditorReference : references) {
         System.out.println(iEditorReference.getName());
         if (iEditorReference.getName().equals("MANIFEST.MF")) {
         	manifestReference = iEditorReference;
         	break;
         }
         	
      }
		
		if (manifestReference!=null) {
			activePage.closeEditor(manifestReference.getEditor(false), false);
		}
	}
	
	private void openFileInEditor(IFile file) {
		IEditorInput editorInput = new FileEditorInput(file);
		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
			      .openEditor(editorInput, desc.getId());
		} catch (PartInitException e1) {
			e1.printStackTrace();
		}
	}
	
}
