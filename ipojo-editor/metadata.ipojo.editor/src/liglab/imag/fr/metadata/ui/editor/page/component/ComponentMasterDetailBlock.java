/**
 * 
 */
package liglab.imag.fr.metadata.ui.editor.page.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import liglab.imag.fr.metadata.emf.CommandFactory;
import liglab.imag.fr.metadata.emf.ModelUtil;
import liglab.imag.fr.metadata.ui.editor.MetadataEditor;
import liglab.imag.fr.metadata.ui.editor.PojoMasterDetailBlock;
import liglab.imag.fr.metadata.ui.editor.providers.ComponentContentProvider;
import liglab.imag.fr.metadata.util.JDTUtil;
import liglab.imag.fr.metadata.util.ValidatorVisitor;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.RequiresType;
import org.apache.felix.impl.ComponentTypeImpl;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.editor.FormPage;

/**
 * Master Detail Block for components types
 * 
 * @author Gabriel
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
		return "Project component type definition, details are editable on the right";
	}

	@Override
	protected String getPanelTitle() {
		return "Component Types List";
	}

	@Override
	public IContentProvider getContentProvider() {
		return new ComponentContentProvider();
	}

	@Override
	protected void addContextMenu() {
		final GenerateComponentClassAction generateClassAction = new GenerateComponentClassAction(
		      "Generate Implementation Class");
		final ValidateComponentAction validateComponentAction = new ValidateComponentAction(
		      "Validate Component");

		final MenuManager menuMng = new MenuManager();
		menuMng.setRemoveAllWhenShown(true);

		menuMng.addMenuListener(new IMenuListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse
			 * .jface.action.IMenuManager)
			 */
			public void menuAboutToShow(IMenuManager manager) {
				IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
				if (!selection.isEmpty()) {
					// Add instance action is used on Component Types
					if (selection.getFirstElement() instanceof ComponentType) {
						menuMng.add(generateClassAction);
						menuMng.add(validateComponentAction);
					}
				}
			}
		});
		componentsViewer.getControl().setMenu(menuMng.createContextMenu(componentsViewer.getControl()));
	}

	/**
	 * Gets a list with generated source code for each property using fields
	 * 
	 * @param componentType
	 * @return
	 */
	private List<String> getFieldPropertyCode(ComponentType componentType) {
		List<String> fields = new ArrayList<String>();

		List<PropertiesType> propertiesLists = componentType.getProperties();

		if (!propertiesLists.isEmpty()) {
			List<PropertyType> properties = propertiesLists.get(0).getProperty();

			for (PropertyType property : properties) {
				String field = property.getField();
				StringBuffer code = new StringBuffer();
				code.append("/** Field for ");
				code.append(field);
				code.append(" property */");
				code.append("\n");
				code.append("private Object ");
				code.append(field);
				code.append(";\n\n");
				fields.add(code.toString());
			}
		}
		return fields;
	}

	/**
	 * Gets a list with generated source code for each dependency using fields
	 * 
	 * @param componentType
	 * @return
	 */
	private List<String> getFieldDependencyCode(ComponentType componentType) {
		List<String> fields = new ArrayList<String>();
		List<RequiresType> requires = componentType.getRequires();

		for (RequiresType require : requires) {

			if (ModelUtil.isFieldDependency(require)) {
				String field = require.getField();
				StringBuffer code = new StringBuffer();
				code.append("/** Field for ");
				code.append(field);
				code.append(" dependency */");
				code.append("\n");
				code.append("private Object ");
				code.append(field);
				code.append(";\n\n");
				fields.add(code.toString());
			}
		}
		return fields;
	}

	/**
	 * Gets a list with generated source code for each dependency using methods
	 * (bind, unbind)
	 * 
	 * @param componentType
	 * @return
	 */
	private List<String> getDependenciesMethodsCode(ComponentType componentType) {
		List<String> methods = new ArrayList<String>();
		List<RequiresType> requires = componentType.getRequires();

		for (RequiresType require : requires) {
			if (!ModelUtil.isFieldDependency(require)) {
				String id = require.getId();
				String bindMethod = ModelUtil.getBindCallback(require).getMethod();
				String unbindMethod = ModelUtil.getUnbindCallback(require).getMethod();

				StringBuffer code = new StringBuffer();
				code.append("/** Bind Method for ");
				code.append(id);
				code.append(" dependency */");
				code.append("\n");
				code.append("public void ");
				code.append(bindMethod);
				code.append("(Object ");
				code.append(id);
				code.append("){}\n\n");

				methods.add(code.toString());

				code = new StringBuffer();
				code.append("/** Unbind Method for ");
				code.append(id);
				code.append(" dependency */");
				code.append("\n");
				code.append("public void ");
				code.append(unbindMethod);
				code.append("(Object ");
				code.append(id);
				code.append("){}\n\n");

				methods.add(code.toString());
			}
		}

		return methods;
	}

	/**
	 * Gets a list with generated source code for lifecycle methods (bind,
	 * unbind)
	 * 
	 * @param componentType
	 * @return
	 */
	private List<String> getLifecycleMethodsCode(ComponentType componentType) {
		List<String> methods = new ArrayList<String>();
		CallbackType validateCallbackType = ModelUtil.getValidateCallback(componentType);
		CallbackType invalidateCallbackType = ModelUtil.getInvalidateCallback(componentType);

		if (validateCallbackType != null) {
			StringBuffer code = new StringBuffer();
			code.append("/** Component Validate Method */");
			code.append("\n");
			code.append("public void ");
			code.append(validateCallbackType.getMethod());
			code.append("(){}\n\n");
			methods.add(code.toString());
		}

		if (invalidateCallbackType != null) {
			StringBuffer code = new StringBuffer();
			code.append("/** Component Invalidate Method */");
			code.append("\n");
			code.append("public void ");
			code.append(invalidateCallbackType.getMethod());
			code.append("(){}\n\n");
			methods.add(code.toString());
		}

		return methods;
	}

	private Map<String, String> getDependenciesFields(ComponentType componentType) {
		Map<String, String> fields = new HashMap<String, String>();

		List<RequiresType> requires = componentType.getRequires();
		for (RequiresType require : requires) {
			if (ModelUtil.isFieldDependency(require)) {
				String field = require.getField();
				fields.put(field, field);
			}
		}

		return fields;
	}

	private Map<String, String> getPropertiesFields(ComponentType componentType) {
		Map<String, String> fields = new HashMap<String, String>();

		List<PropertiesType> propertiesLists = componentType.getProperties();
		if (!propertiesLists.isEmpty()) {
			List<PropertyType> properties = propertiesLists.get(0).getProperty();
			for (PropertyType property : properties) {
				String field = property.getField();
				String name = property.getName();
				fields.put(field, name);
			}
		}
		return fields;
	}

	private Map<String, String> getDependenciesMethods(ComponentType componentType) {
		Map<String, String> methods = new HashMap<String, String>();
		List<RequiresType> requires = componentType.getRequires();

		for (RequiresType require : requires) {
			if (!ModelUtil.isFieldDependency(require)) {
				String id = require.getId();
				String bindMethod = ModelUtil.getBindCallback(require).getMethod();
				String unbindMethod = ModelUtil.getUnbindCallback(require).getMethod();
				methods.put(bindMethod, id);
				methods.put(unbindMethod, id);
			}
		}
		return methods;
	}

	/**
	 * Action to generate the implementation class for the selected component
	 * 
	 * @author Gabriel
	 * 
	 */
	class GenerateComponentClassAction extends Action {

		public GenerateComponentClassAction(String text) {
			super(text);
		}

		@Override
		public void run() {

			IJavaProject javaProject = JDTUtil.getJavaProject();

			IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
			if (!selection.isEmpty()) {
				ComponentType componentType = (ComponentType) selection.getFirstElement();
				String fullClassName = componentType.getClassname();

				List<String> interfaces = ModelUtil.getInterfaces(componentType);
				IType newClass = JDTUtil.openCreateJavaClassWizard(fullClassName, javaProject, interfaces);

				try {

					List<String> fieldDependencyCode = getFieldDependencyCode(componentType);
					for (String fieldCode : fieldDependencyCode)
						newClass.createField(fieldCode, null, true, null);

					List<String> fieldPropertyCode = getFieldPropertyCode(componentType);
					for (String fieldCode : fieldPropertyCode)
						newClass.createField(fieldCode, null, true, null);

					List<String> dependenciesMethods = getDependenciesMethodsCode(componentType);
					for (String methodCode : dependenciesMethods)
						newClass.createMethod(methodCode, null, true, null);

					List<String> lifecycleMethods = getLifecycleMethodsCode(componentType);
					for (String methodCode : lifecycleMethods)
						newClass.createMethod(methodCode, null, true, null);

					EditingDomain editingDomain = editor.getEditingDomain();
					Command command = CommandFactory.createSetComponentClassCommand(editingDomain, componentType,
					      newClass.getFullyQualifiedName());
					ModelUtil.executeCommand(editingDomain, command);

					componentsViewer.setSelection(selection);

				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Action to validate the implementation class for the selected component
	 * 
	 * @author Gabriel
	 * 
	 */
	class ValidateComponentAction extends Action {

		public ValidateComponentAction(String text) {
			super(text);
		}

		@Override
		public void run() {

			IJavaProject javaProject = JDTUtil.getJavaProject();

			IStructuredSelection selection = (IStructuredSelection) componentsViewer.getSelection();
			if (!selection.isEmpty()) {
				ComponentType componentType = (ComponentType) selection.getFirstElement();

				Map<String, String> propertiesFields = getPropertiesFields(componentType);
				Map<String, String> dependenciesFields = getDependenciesFields(componentType);
				Map<String, String> dependenciesMethods = getDependenciesMethods(componentType);

				try {

					String fullClassName = componentType.getClassname();
					ICompilationUnit compilationUnit = JDTUtil.getCompilationUnit(javaProject, fullClassName);
					List<String> errorMsgs = new ArrayList<String>();
					if (compilationUnit != null) {
						ASTParser parser = ASTParser.newParser(AST.JLS3);
						parser.setKind(ASTParser.K_COMPILATION_UNIT);
						parser.setSource(compilationUnit); // set source
						parser.setResolveBindings(true); // we need bindings later
						                                 // on
						CompilationUnit unit = (CompilationUnit) parser.createAST(null /* IProgressMonitor */); // parse
						ValidatorVisitor visitor = new ValidatorVisitor(propertiesFields, dependenciesFields,
						      dependenciesMethods);
						errorMsgs = visitor.process(unit);
					} else {
						errorMsgs.add("The implementation class " + fullClassName + " does not exist");
					}
					
					IResource resource = javaProject.getUnderlyingResource();
					String componentName = componentType.getName();
					deletePreviousErrors(resource, componentName);
					if (!errorMsgs.isEmpty()) {						
						generateErrors(resource, errorMsgs, componentName);
					} else {
						String message = "The implementation class of component " +  componentName + " is valid";
						MessageDialog.openConfirm(null, "iCasa Component Validation", message);
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	private void deletePreviousErrors(IResource resource, String componentName) {
		IMarker[] problems = null;
		try {
	      problems = resource.findMarkers("icasa.env.marker", false, IResource.DEPTH_ZERO);
			for (int i = 0; i < problems.length; i++) {
				IMarker problem = problems[i];
				String markerComponentName = (String) problem.getAttribute("Component");
				if (markerComponentName != null && markerComponentName.equals(componentName))
					problem.delete();
			}
      } catch (CoreException e) {
	      e.printStackTrace();
      }

	}

	private void generateErrors(IResource resource, List<String> errorMsgs, String componentName) {
		try {
			// Create the new problems
			for (String error : errorMsgs) {
				IMarker marker = resource.createMarker("icasa.env.marker");
				marker.setAttribute(IMarker.MESSAGE, error);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
				marker.setAttribute("Component", componentName);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
