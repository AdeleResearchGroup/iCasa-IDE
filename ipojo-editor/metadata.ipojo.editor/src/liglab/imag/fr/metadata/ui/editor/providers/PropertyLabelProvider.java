/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.providers;

import org.apache.felix.PropertyType;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * @author Gabriel
 *
 */
public class PropertyLabelProvider extends ColumnLabelProvider {
	
	public static int NAME = 0;
	public static int FIELD = 1;
	public static int TYPE = 2;
	public static int VALUE = 3;
	
	
	private int attribute;

	public PropertyLabelProvider(int attribute) {
		this.attribute = attribute;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof PropertyType) {
			PropertyType property = (PropertyType) element;
			
			if (attribute == NAME) 
				return property.getName();
						
			if (attribute == FIELD)
				return property.getField();
			
			if (attribute == TYPE) {
				String specification = property.getType();
				if (specification!=null && !specification.isEmpty())
					return specification;
				return "Unknown";
			}				
			
			if (attribute == VALUE) {
				String value = property.getValue();
				if (value!=null && !value.isEmpty())
					return value;
				return "Unassigned";
				
			}
			
		}
		return null;
	}
	
}
