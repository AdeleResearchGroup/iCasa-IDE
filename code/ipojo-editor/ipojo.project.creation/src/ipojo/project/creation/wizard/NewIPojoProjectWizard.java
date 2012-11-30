package ipojo.project.creation.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.PDEPluginImages;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.NewWizard;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

@SuppressWarnings("restriction")
public class NewIPojoProjectWizard extends NewWizard implements IExecutableExtension {

	public static final String PLUGIN_POINT = "pluginContent"; //$NON-NLS-1$
	public static final String TAG_WIZARD = "wizard"; //$NON-NLS-1$
	public static final String DEF_PROJECT_NAME = "project_name"; //$NON-NLS-1$
	public static final String DEF_TEMPLATE_ID = "template-id"; //$NON-NLS-1$


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

			getContainer().run(false, true, new NewPojoProjectCreationOperation(fPluginData, fProjectProvider, null));

			IWorkingSet[] workingSets = fMainPage.getSelectedWorkingSets();
			if (workingSets.length > 0)
				getWorkbench().getWorkingSetManager().addToWorkingSets(fProjectProvider.getProject(), workingSets);


			return true;
		} catch (InvocationTargetException e) {
			PDEPlugin.logException(e);
		} catch (InterruptedException e) {
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

	/*
	private void closeEditorFile(final IFile file) {

		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorInput input = new FileEditorInput(file);
				IEditorPart editor = activePage.findEditor(input);
				if (editor != null)
					activePage.closeEditor(editor, false);
			}
		});
	}

	private void openEditorFile(final IFile file) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbench workbench = PlatformUI.getWorkbench();
				IWorkbenchPage activePage = workbench.getActiveWorkbenchWindow().getActivePage();
				IEditorInput editorInput = new FileEditorInput(file);
				IEditorDescriptor desc = workbench.getEditorRegistry().getDefaultEditor(file.getName());
				try {
					activePage.openEditor(editorInput, desc.getId());
				} catch (PartInitException e1) {
				}
			}
		});
	}
	*/

}
