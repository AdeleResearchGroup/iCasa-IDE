package liglab.imag.fr.metadata.ui.editor.page.instance;

import liglab.imag.fr.metadata.ui.editor.MetadataEditor;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class InstanceMasterPage extends FormPage {

	private InstanceMasterDetailBlock block;
	
	public InstanceMasterPage(FormEditor editor, String id, String title) {
	   super(editor, id, title);
	   block = new InstanceMasterDetailBlock((MetadataEditor) editor, this);
   }
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Component Configuration"); //$NON-NLS-1$
//		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(
//				FormArticlePlugin.IMG_FORM_BG));
		block.createContent(managedForm);
	}
	
	@Override
	public void setActive(boolean active) {
	   super.setActive(active);
	   block.refreshComponentList();
	}
	
	public void refreshComponentList() {
		block.refreshComponentList();
	}


}
