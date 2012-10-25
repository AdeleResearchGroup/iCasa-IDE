/**
 * 
 */
package ipojo.project.creation.wizard;

import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.plugin.AbstractFieldData;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginContentPage;

/**
 * @author Gabriel
 *
 */
@SuppressWarnings("restriction")
public class IPojoPluginContentPage extends PluginContentPage {

	public IPojoPluginContentPage(String pageName, IProjectProvider provider,
			NewProjectCreationPage page, AbstractFieldData data) {
		super(pageName, provider, page, data);
	}
	
	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		fGenerateActivator.setSelection(false);
	}	
	
}
