package liglab.imag.fr.metadata.ui.editor.preferences;

import liglab.imag.fr.metadata.editor.ComponentEditorPlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.pde.core.target.ITargetDefinition;
import org.eclipse.pde.core.target.ITargetHandle;
import org.eclipse.pde.core.target.ITargetLocation;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.core.target.LoadTargetDefinitionJob;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class DeploymentDirectoryPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	DirectoryFieldEditor deploymentDirectoryFieldEditor;

	private boolean directoryModified = false;

	public DeploymentDirectoryPage() {
		super(GRID);
		setPreferenceStore(ComponentEditorPlugin.getDefault().getPreferenceStore());
		setDescription("Deployment Directory Page");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		deploymentDirectoryFieldEditor = (new DirectoryFieldEditor(ComponentEditorPlugin.DIRECTORY_PREFERENCE,
		      "&OSGi (iPojo) installation directory:", getFieldEditorParent()));

		addField(deploymentDirectoryFieldEditor);
		addField(new BooleanFieldEditor(ComponentEditorPlugin.ICASA_IMPORT_PREFERENCE, "&Add iCasa packages to new iPojo Projects ", getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
		boolean ok = super.performOk();
		if (directoryModified) {
			configureTargetPlaform(deploymentDirectoryFieldEditor.getStringValue());
			directoryModified = false;
		}

		return ok;
	}

	private void configureTargetPlaform(String path) {

		ITargetPlatformService service = getTargetService();

		if (service == null)
			return;

		ITargetDefinition targetDefinition = getTargetDefinition("iPojo-RT", service);
		if (targetDefinition != null) {
			try {
				ITargetHandle defaultHandler = service.getWorkspaceTargetHandle();
				if (targetDefinition != defaultHandler.getTargetDefinition())
					LoadTargetDefinitionJob.load(targetDefinition);
			} catch (CoreException e) {
				e.printStackTrace();
			}

		} else {
			targetDefinition = service.newDefaultTarget();
			targetDefinition.setName("iPojo-RT");
		}

		targetDefinition = setTargetLocations(targetDefinition, service, path);

		try {
			service.saveTargetDefinition(targetDefinition);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private ITargetDefinition getTargetDefinition(String name, ITargetPlatformService service) {
		ITargetHandle[] targetsHandlers = service.getTargets(null);
		for (ITargetHandle targetHandle : targetsHandlers) {
			ITargetDefinition definition;
			try {
				definition = targetHandle.getTargetDefinition();
				if (definition.getName().equals(name))
					return definition;
			} catch (CoreException e) {
			}
		}
		return null;
	}

	private ITargetDefinition setTargetLocations(ITargetDefinition targetDefinition, ITargetPlatformService service,
	      String path) {
		String fileSeparator = System.getProperty("file.separator");

		ITargetLocation[] containers = new ITargetLocation[3];
		containers[0] = service.newDirectoryLocation(path + fileSeparator + "bin");
		containers[1] = service.newDirectoryLocation(path + fileSeparator + "load");
		containers[2] = service.newDirectoryLocation(path + fileSeparator + "bundle");

		targetDefinition.setTargetLocations(containers);
		return targetDefinition;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		FieldEditor emmiter = (FieldEditor) event.getSource();

		if (deploymentDirectoryFieldEditor == emmiter)
			directoryModified = true;

	}

	private ITargetPlatformService getTargetService() {
		return (ITargetPlatformService) ComponentEditorPlugin.getDefault().acquireService(
		      ITargetPlatformService.class.getName());
	}

}