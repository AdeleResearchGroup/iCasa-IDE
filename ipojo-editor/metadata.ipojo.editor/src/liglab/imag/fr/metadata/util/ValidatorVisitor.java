package liglab.imag.fr.metadata.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

/**
 * 
 * A validator for component implementation classes 
 * 
 * @author Gabriel
 *
 */
public class ValidatorVisitor extends ASTVisitor {

	private Map<String, String> propertiesFields;
	private Map<String, String> dependenciesFields;
	private Map<String, String> dependenciesMethods;

	public ValidatorVisitor(Map<String, String> propertiesFields, Map<String, String> dependenciesFields,
	      Map<String, String> dependenciesMethods) {
		this.propertiesFields = propertiesFields;
		this.dependenciesFields = dependenciesFields;
		this.dependenciesMethods = dependenciesMethods;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		List<VariableDeclarationFragment> fragments = node.fragments();
		for (VariableDeclarationFragment fragment : fragments) {
			String fieldName = fragment.getName().getIdentifier();
			dependenciesFields.remove(fieldName);
			propertiesFields.remove(fieldName);
		}

		return false;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		dependenciesMethods.remove(node.getName().getIdentifier());
		return false;
	}

	/**
	 * Process the compilation unit (component implementation java class)
	 * @param unit
	 * @return
	 */
	public List<String> process(CompilationUnit unit) {
		unit.accept(this);
		List<String> errors = new ArrayList<String>();

		for (String propertiesField : propertiesFields.keySet()) {
			String propertyName = propertiesFields.get(propertiesField);
			errors.add("Implementation class has to define the field " + propertiesField
			      + " associated to property " + propertyName);
		}

		for (String dependenciesField : dependenciesFields.keySet()) {
			String dependencyName = dependenciesFields.get(dependenciesField);
			errors.add("Implementation class has to define the field " + dependenciesField
			      + " associated to dependency " + dependencyName);
		}

		for (String dependenciesMethod : dependenciesMethods.keySet()) {
			String dependencyName = dependenciesMethods.get(dependenciesMethod);
			errors.add("Implementation class has to define the method " + dependenciesMethod
			      + " associated to dependency " + dependencyName);
		}

		return errors;
	}

}
