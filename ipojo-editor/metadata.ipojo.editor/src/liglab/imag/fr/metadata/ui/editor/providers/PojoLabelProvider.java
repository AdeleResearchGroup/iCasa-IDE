package liglab.imag.fr.metadata.ui.editor.providers;

import org.apache.felix.ComponentType;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class PojoLabelProvider extends LabelProvider implements ITableLabelProvider {

	
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO Auto-generated method stub		
		return ((ComponentType) element).getName();
	}
}
