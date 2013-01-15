/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.providers;

import liglab.imag.fr.metadata.emf.ModelUtil;

import org.apache.felix.RequiresType;
import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * @author Gabriel
 * 
 */
public class DependencyLabelProvider extends ColumnLabelProvider {

	public static int NAME = 0;
	public static int CARDINALITY = 1;
	public static int TYPE = 2;

	private int attribute;

	public DependencyLabelProvider(int attribute) {
		this.attribute = attribute;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof RequiresType) {
			RequiresType dependency = (RequiresType) element;

			if (attribute == NAME)
				return dependency.getField();
			

			if (attribute == CARDINALITY) {
				if (ModelUtil.isFieldDependency(dependency))
					if (dependency.isOptional())
						return "0..1";
					else
						return "1..1";
				else if (dependency.isOptional())
					return "0..n";
				else
					return "1..n";
			}

			if (attribute == TYPE) {
				String specification = dependency.getSpecification();
				if (specification != null && !specification.isEmpty())
					return specification;
				return "Unknown";
			}

			return null;
		}
		return null;
	}

}
