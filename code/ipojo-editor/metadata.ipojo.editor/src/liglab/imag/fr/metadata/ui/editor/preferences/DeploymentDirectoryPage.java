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

/**
 * 
 * @author Gabriel Pedraza Ferreira
 * 
 */
public class DeploymentDirectoryPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private DirectoryFieldEditor deploymentDirectoryFieldEditor;

	private boolean directoryModified = false;

	private static final String TARGET_PLATFORM_NAME = "iPojo-RT";

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
		deploymentDirectoryFieldEditor = new DirectoryFieldEditor(ComponentEditorPlugin.DIRECTORY_PREFERENCE,
		      "&OSGi (iPojo) installation directory:", getFieldEditorParent());
		
		deploymentDirectoryFieldEditor.getTextControl(getFieldEditorParent()).setEditable(false);

		addField(deploymentDirectoryFieldEditor);
		addField(new BooleanFieldEditor(ComponentEditorPlugin.ICASA_IMPORT_PREFERENCE,
		      "&Add iCasa packages to new iPojo Projects ", getFieldEditorParent()));
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
			String newDirectory = deploymentDirectoryFieldEditor.getStringValue().trim();
			if (!newDirectory.isEmpty())
				configureTargetPlaform(deploymentDirectoryFieldEditor.getStringValue());
			else 
				removeTargetPlatform();
			directoryModified = false;
		}

		return ok;
	}


	/*
	@Override
	protected void checkState() {
	   super.checkState();
	   if (!isValid())
	   	return;

      String fileName = deploymentDirectoryFieldEditor.getStringValue();
      fileName = fileName.trim();
      File file = new File(fileName);
      boolean isOk = file.isDirectory() && file.exists();
      setValid(isOk);
      if (!isOk) {
      	setErrorMessage("Must have a valid directory");
      }      	  
	}
	
	*/


	
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		FieldEditor emmiter = (FieldEditor) event.getSource();

		if (deploymentDirectoryFieldEditor == emmiter) 
			directoryModified = true;
	}

	
		

	/**
	 * Configures a new Felix-iPojo target platform
	 * 
	 * @param path
	 */
	private void configureTargetPlaform(String path) {

		ITargetPlatformService service = getTargetService();

		if (service == null)
			return;

		ITargetDefinition targetDefinition = getTargetDefinition(TARGET_PLATFORM_NAME, service);

		try {
			if (targetDefinition != null) {

				ITargetHandle defaultHandler = service.getWorkspaceTargetHandle();
				targetDefinition = setTargetLocations(targetDefinition, service, path);
				if (targetDefinition != defaultHandler.getTargetDefinition())
					LoadTargetDefinitionJob.load(targetDefinition);
			} else {
				targetDefinition = service.newDefaultTarget();
				targetDefinition.setName(TARGET_PLATFORM_NAME);
				targetDefinition = setTargetLocations(targetDefinition, service, path);
				LoadTargetDefinitionJob.load(targetDefinition);
			}
			service.saveTargetDefinition(targetDefinition);
			
			
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	private void removeTargetPlatform() {
		ITargetPlatformService service = getTargetService();

		if (service == null)
			return;

		ITargetDefinition targetDefinition = getTargetDefinition(TARGET_PLATFORM_NAME, service);
		try {
			if (targetDefinition != null) {
				service.deleteTarget(targetDefinition.getHandle());				
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Find a target platform definition by name
	 * 
	 * @param name
	 *           the platform name to search
	 * @param service
	 *           the TargetPlatform service
	 * @return the found target platform service or null if not found
	 */
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

	/**
	 * Sets the target location to use default directories
	 * 
	 * @param targetDefinition
	 *           the TargetDefinition
	 * @param service
	 *           the TargetPlatform service
	 * @param path
	 *           new OSGi (Felix) platform path
	 * @return
	 */
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
	

	/**
	 * 
	 * @return
	 */
	private ITargetPlatformService getTargetService() {
		return (ITargetPlatformService) ComponentEditorPlugin.getDefault().acquireService(
		      ITargetPlatformService.class.getName());
	}


	
	/*
	class MyDirectoryFieldEditor extends DirectoryFieldEditor {
		
		public MyDirectoryFieldEditor(String name, String labelText, Composite parent) {
			super(name, labelText, parent);
		}
		
		@Override
		protected boolean doCheckState() {
		   boolean ok = super.doCheckState();
		   System.out.println("doCheckState " + ok);
		   return ok;
		}
		
	}
	*/
	
}