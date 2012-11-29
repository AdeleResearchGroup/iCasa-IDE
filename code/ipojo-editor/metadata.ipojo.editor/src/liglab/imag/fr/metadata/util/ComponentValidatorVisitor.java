package liglab.imag.fr.metadata.util;

import java.util.List;

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
public class ComponentValidatorVisitor extends ASTVisitor {

	private ImplementationClassModel classModel;

	public ComponentValidatorVisitor(ImplementationClassModel classModel) {
		this.classModel = classModel;
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		List<VariableDeclarationFragment> fragments = node.fragments();
		for (VariableDeclarationFragment fragment : fragments) {
			String fieldName = fragment.getName().getIdentifier();
			classModel.removeField(fieldName);
		}
		return false;
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		classModel.removeMethod(node.getName().getIdentifier());
		return false;
	}

	/**
	 * Process the compilation unit (component implementation java class)
	 * @param unit
	 * @return
	 */
	public ImplementationClassModel process(CompilationUnit unit) {
		unit.accept(this);	
		classModel.setCompilationUnit(unit);
		return classModel;
	}

}
