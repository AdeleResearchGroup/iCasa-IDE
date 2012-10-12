package liglab.imag.fr.metadata.ui.editor.providers;

import liglab.imag.fr.metadata.emf.ModelUtil;

import org.apache.felix.PropertyType;
import org.apache.felix.RequiresType;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * LabelProvider used for elements of a component(properties and
 * dependencies)
 * 
 * @author Gabriel
 * 
 */
public class ComponentElementsLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
   public Image getColumnImage(Object element, int columnIndex) {
	   // TODO Auto-generated method stub
	   return null;
   }

	@Override
   public String getColumnText(Object element, int columnIndex) {
		if (element instanceof RequiresType) {
			RequiresType requirement = (RequiresType) element;
			if (ModelUtil.isFieldDependency(requirement)) {
				String text = requirement.getField() + " (0..1)";
				return text;
			} else { // Method Requirement
				if (requirement.getId() != null) {
					String text = requirement.getId() + " (0..n)";
					return text;
				}					
				return "anonymous";
			}
		}
		if (element instanceof PropertyType) {
			PropertyType property = (PropertyType) element;
			return property.getName();
		}
		return null;
   }

}
