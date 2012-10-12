/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.providers;

import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * @author Gabriel
 *
 */
public class SpecificationLabelProvider extends LabelProvider {
	
	@Override
	public String getText(Object element) {
		if (element instanceof ProvidesType) {
	      ProvidesType provides = (ProvidesType) element;
	      return provides.getSpecifications();
      }
		if (element instanceof PropertyType) {
	      PropertyType property = (PropertyType) element;
	      return property.getName();	      
      }
		return null;
	}
}
