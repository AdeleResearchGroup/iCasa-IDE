/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.component;

import liglab.imag.fr.metadata.ui.editor.MetadataEditor;
import liglab.imag.fr.metadata.ui.editor.PojoMasterDetailBlock;
import liglab.imag.fr.metadata.ui.editor.providers.ComponentContentProvider;

import org.apache.felix.impl.ComponentTypeImpl;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.editor.FormPage;

/**
 * @author Gabriel
 * 
 */
public class ComponentMasterDetailBlock extends PojoMasterDetailBlock {

	public ComponentMasterDetailBlock(MetadataEditor editor, FormPage page) {
		super(editor, page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.forms.MasterDetailsBlock#registerPages(org.eclipse.ui.forms
	 * .DetailsPart)
	 */
	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.registerPage(ComponentTypeImpl.class, new ComponentDetailsPage(editor, componentsViewer));
	}

	@Override
   protected boolean addEditionButtons() {
	   return true;
   }

	@Override
   protected String getPanelMessage() {
	   return "Project component definition, details are editable on the right";
   }
	
	@Override
	protected String getPanelTitle() {
	   return "Component Definition List";
	}

	@Override
   public IContentProvider getContentProvider() {
	   return new ComponentContentProvider();
   }

	
	
}
