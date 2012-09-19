package liglab.imag.fr.metadata.ui.editor.page.component;

import liglab.imag.fr.metadata.ui.editor.MetadataEditor;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class ComponentMasterPage extends FormPage {

	private ComponentMasterDetailBlock block;
	
	public ComponentMasterPage(FormEditor editor, String id, String title) {
	   super(editor, id, title);
	   block = new ComponentMasterDetailBlock((MetadataEditor) editor, this);

   }
	
	protected void createFormContent(final IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		//FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Component Type Definition"); //$NON-NLS-1$
//		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(
//				FormArticlePlugin.IMG_FORM_BG));
		block.createContent(managedForm);
	}

}
