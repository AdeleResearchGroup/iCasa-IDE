/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.providers;

import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * Label Provider for Specification Table Viewer
 * 
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
	      String label = "Name: " +  property.getName();
	      String specification = property.getType();
	      if (specification!=null && !specification.isEmpty())
	      	label = label + " - Type: " + specification;
	      String value = property.getValue();
	      if (value!=null && !value.isEmpty())
	      	label = label + " - Value :" + value;
	      
	      return label;	      
      }
		return null;
	}
}
