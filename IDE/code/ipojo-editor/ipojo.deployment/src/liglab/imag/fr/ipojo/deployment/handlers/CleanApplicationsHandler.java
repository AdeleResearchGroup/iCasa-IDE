package liglab.imag.fr.ipojo.deployment.handlers;

import java.io.File;

import liglab.imag.fr.ipojo.preferences.util.IPojoPreferencesContants;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This handler is used to clean the applications directory at the execution
 * platform
 * 
 * @author Gabriel
 * 
 */
public class CleanApplicationsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection newSelection = (IStructuredSelection) selection;
			if (newSelection.getFirstElement() instanceof IJavaProject) {

				IPreferencesService preferencesService = Platform.getPreferencesService();

				String deploymentDirectory = preferencesService.getString("ipojo.preferences",
				      IPojoPreferencesContants.TARGET_DIRECTORY_PREFERENCE, "", null);

				if (deploymentDirectory != null && !deploymentDirectory.trim().isEmpty()) {
					String appsDirectory = preferencesService.getString("ipojo.preferences", IPojoPreferencesContants.APPS_DIRECTORY_PREFERENCE, "", null);
					if (appsDirectory.isEmpty())
						appsDirectory = "load";
					deploymentDirectory = deploymentDirectory + System.getProperty("file.separator") + appsDirectory;

					File dir = new File(deploymentDirectory);
					if (dir.isDirectory()) {
						for (File bundle : dir.listFiles()) {
							if (!bundle.isDirectory())
								bundle.delete();
						}
					}

					MessageDialog.openConfirm(null, "iCasa Environment",
					      "iCasa Applications directory was cleaned sucessfully");
				}

			}
		}

		return null;
	}

}
