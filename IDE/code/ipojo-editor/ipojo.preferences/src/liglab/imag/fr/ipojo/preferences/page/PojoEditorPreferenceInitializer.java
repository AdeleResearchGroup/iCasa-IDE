/**
 * 
 */
package liglab.imag.fr.ipojo.preferences.page;

import liglab.imag.fr.ipojo.preferences.IPojoPreferencesPlugin;
import liglab.imag.fr.ipojo.preferences.util.IPojoPreferencesContants;

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
		IPreferenceStore store = IPojoPreferencesPlugin.getDefault().getPreferenceStore();
		store.setDefault(IPojoPreferencesContants.APPS_DIRECTORY_PREFERENCE, "applications");
		store.setDefault(IPojoPreferencesContants.ICASA_IMPORT_PREFERENCE, true);
	}

}
