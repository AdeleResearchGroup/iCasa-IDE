/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.preferences;

import liglab.imag.fr.metadata.editor.ComponentEditorPlugin;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @author Gabriel
 *
 */
public class PojoEditorPreferenceInitializer extends AbstractPreferenceInitializer {


	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = ComponentEditorPlugin.getDefault().getPreferenceStore();
		store.setDefault(ComponentEditorPlugin.APPS_DIRECTORY_PREFERENCE, "applications");
		store.setDefault(ComponentEditorPlugin.ICASA_IMPORT_PREFERENCE, true);
	}

}
