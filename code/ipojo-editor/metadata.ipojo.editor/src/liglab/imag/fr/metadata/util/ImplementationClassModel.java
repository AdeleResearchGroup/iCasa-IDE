package liglab.imag.fr.metadata.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import liglab.imag.fr.metadata.emf.ModelUtil;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

public class ImplementationClassModel {

	/**
	 * The component type asociated to the class model
	 */
	private ComponentType componentType;
	
	private Map<String, PropertyType> propertiesFields;
	
	private Map<String, PropertyType> servicePropertiesFields;
	
	private Map<String, RequiresType> dependencyFields;
	
	private Map<String, RequiresType> dependencyMethods;
	
	private Map<String, CallbackType> lifecycleMethods;
	
	private static String METHOD_BODY = "){\n// TODO: Add your implementation code here\n}\n";



	public ImplementationClassModel(ComponentType componentType) {
	   this.componentType = componentType;
		calculateDependenciesFields();
		calculateDependenciesMethods();
		calculatePropertiesFields();
		calculateLifecycleMethods();
		calculateServicePropertiesFields();
   }
		
	private void calculateDependenciesFields() {
		dependencyFields = new HashMap<String, RequiresType>();

		List<RequiresType> requires = componentType.getRequires();
		for (RequiresType dependency : requires) {
			if (ModelUtil.isFieldDependency(dependency)) {
				String field = dependency.getField();
				dependencyFields.put(field, dependency);
			}
		}
	}

	private void calculatePropertiesFields() {
		propertiesFields = new HashMap<String, PropertyType>();

		List<PropertiesType> propertiesLists = componentType.getProperties();
		if (!propertiesLists.isEmpty()) {
			List<PropertyType> properties = propertiesLists.get(0).getProperty();
			for (PropertyType property : properties) {
				String field = property.getField();
				propertiesFields.put(field, property);
			}
		}
	}
	
	private void calculateServicePropertiesFields() {
		servicePropertiesFields = new HashMap<String, PropertyType>();

		List<ProvidesType> specifications = componentType.getProvides();
		for (ProvidesType specification : specifications) {
			List<PropertyType> properties = specification.getProperty();
			for (PropertyType property : properties) {
				String field = property.getField();
				if (field!=null)
					servicePropertiesFields.put(field, property);
			}
      }
	}
	
	private void calculateDependenciesMethods() {
		dependencyMethods = new HashMap<String, RequiresType>();
		List<RequiresType> requires = componentType.getRequires();

		for (RequiresType require : requires) {
			if (!ModelUtil.isFieldDependency(require)) {
				String bindMethod = ModelUtil.getBindCallback(require).getMethod();
				String unbindMethod = ModelUtil.getUnbindCallback(require).getMethod();
				dependencyMethods.put(bindMethod, require);
				dependencyMethods.put(unbindMethod, require);
			}
		}
	}
	
	private void calculateLifecycleMethods() {
		lifecycleMethods = new HashMap<String, CallbackType>();
		
		CallbackType validateCallbackType = ModelUtil.getValidateCallback(componentType);
		CallbackType invalidateCallbackType = ModelUtil.getInvalidateCallback(componentType);
		if (validateCallbackType != null) {
			lifecycleMethods.put(validateCallbackType.getMethod(), validateCallbackType);
		}
		if (invalidateCallbackType != null) {
			lifecycleMethods.put(invalidateCallbackType.getMethod(), invalidateCallbackType);
		}
	}
	
	public List<String> getErrorMessages() {
		List<String> errors = new ArrayList<String>();

		for (String propertiesField : propertiesFields.keySet()) {
			String propertyName = propertiesFields.get(propertiesField).getName();
			errors.add("Implementation class has to define the field " + propertiesField
			      + " associated to property " + propertyName);
		}

		for (String propertiesField : servicePropertiesFields.keySet()) {
			String propertyName = propertiesFields.get(propertiesField).getName();
			errors.add("Implementation class has to define the field " + propertiesField
			      + " associated to service property " + propertyName);
		}
		
		for (String dependenciesField : dependencyFields.keySet()) {
			String dependencyName = dependencyFields.get(dependenciesField).getField();
			errors.add("Implementation class has to define the field " + dependenciesField
			      + " associated to dependency " + dependencyName);
		}

		for (String dependenciesMethod : dependencyMethods.keySet()) {
			String dependencyName = dependencyMethods.get(dependenciesMethod).getId();
			errors.add("Implementation class has to define the method " + dependenciesMethod
			      + " associated to dependency " + dependencyName);
		}

		for (String lifecycleMethod : lifecycleMethods.keySet()) {			
			errors.add("Implementation class has to define the method " + lifecycleMethod
			      + " associated to the component lifecycle ");
		}

		
		return errors;
	}
	
	
	public void removeField(String field) {
		propertiesFields.remove(field);
		dependencyFields.remove(field);
		servicePropertiesFields.remove(field);
	}
	
	public void removeMethod(String method) {
		dependencyMethods.remove(method);
		lifecycleMethods.remove(method);
	}

	private void generatePropertyCode(IType implClass, PropertyType property, boolean isComponent) {
		String field = property.getField();
		String specification = property.getType();
		StringBuffer code = new StringBuffer();
		if (isComponent)
			code.append("/** Injected field for the component property " + property.getName() + " */\n");
		else
			code.append("/** Injected field for the service property " + property.getName() + " */\n");
		if (specification != null && !specification.isEmpty())
			code.append("private " + JDTUtil.getJavaClassName(specification) + " ");
		else
			code.append("private Object ");
		code.append(field);
		code.append(";\n\n");
		try {
			implClass.createField(code.toString(), null, true, null);
			if (specification != null && !specification.isEmpty())
				createImport(implClass, specification);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	private void generateFieldDependecyCode(IType implClass, RequiresType dependency) {
		String field = dependency.getField();
		String specification = dependency.getSpecification();
		StringBuffer code = new StringBuffer();
		code.append("/** Field for " + field + " dependency */\n");
		if (specification != null && !specification.isEmpty())
			code.append("private " + JDTUtil.getJavaClassName(specification) + " ");
		else
			code.append("private Object ");
		code.append(field);
		code.append(";\n\n");
		try {
			implClass.createField(code.toString(), null, true, null);
			if (specification != null && !specification.isEmpty())
				createImport(implClass, specification);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	private void generateBindMethodDependecyCode(IType implClass, RequiresType require) {
		StringBuffer code = new StringBuffer();
		String id = require.getId();
		String bindMethod = ModelUtil.getBindCallback(require).getMethod();
		String specification = require.getSpecification();

		code.append("/** Bind Method for " + id + " dependency */\n");
		code.append("public void ");
		code.append(bindMethod);
		if (specification != null && !specification.isEmpty())
			code.append("(" + JDTUtil.getJavaClassName(specification) + " ");
		else
			code.append("(Object ");
		code.append(id);
		code.append(METHOD_BODY);

		try {
			implClass.createMethod(code.toString(), null, true, null);
			if (specification != null && !specification.isEmpty())
				createImport(implClass, specification);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	private void generateUnbindMethodDependecyCode(IType implClass, RequiresType require) {
		StringBuffer code = new StringBuffer();
		String id = require.getId();
		String unbindMethod = ModelUtil.getUnbindCallback(require).getMethod();
		String specification = require.getSpecification();

		code.append("/** Unbind Method for " + id + " dependency */\n");
		code.append("public void ");
		code.append(unbindMethod);
		if (specification != null && !specification.isEmpty())
			code.append("(" + JDTUtil.getJavaClassName(specification) + " ");
		else
			code.append("(Object ");
		code.append(id);
		code.append(METHOD_BODY);

		try {
			implClass.createMethod(code.toString(), null, true, null);
			if (specification != null && !specification.isEmpty())
				createImport(implClass, specification);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}	
	
	private void generateLifecycleMethodCode(IType implClass, CallbackType callback) {
		StringBuffer code = new StringBuffer();
		code.append("/** Component Lifecycle Method */\n");
		code.append("public void ");
		code.append(callback.getMethod() + "(");
		code.append(METHOD_BODY);

		try {
			implClass.createMethod(code.toString(), null, true, null);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	private void createImport(IType implClass, String classToImport) throws JavaModelException {
		String aPackage = JDTUtil.getJavaPackageName(classToImport);
		if (aPackage.equals("java.lang"))
			return;
		implClass.getCompilationUnit().createImport(classToImport, implClass, null);
	}
	
		
	public void completeImplementationClass(IType implClass) {
		// Generation of dependencies based on fields
		for (RequiresType dependency : dependencyFields.values()) {
	      generateFieldDependecyCode(implClass, dependency);
      }	
		
		// Generation of dependencies based on methods
		Set<RequiresType> dependencies = new HashSet<RequiresType>(dependencyMethods.values());
		for (RequiresType dependency : dependencies) {
	      generateBindMethodDependecyCode(implClass, dependency);
	      generateUnbindMethodDependecyCode(implClass, dependency);
      }		
		// Generation of component configuration properties
		for (PropertyType property : propertiesFields.values()) {
	      generatePropertyCode(implClass, property, true);
      }
		// Generation of service properties
		for (PropertyType property : servicePropertiesFields.values()) {
	      generatePropertyCode(implClass, property, false);
      }
		
		// Generation of lifecycle methods
		for (CallbackType callback : lifecycleMethods.values()) {
	      generateLifecycleMethodCode(implClass, callback);
      }
		
		try {
			ICompilationUnit compilationUnit = implClass.getCompilationUnit();
	      JDTUtil.formatCompilationUnit(compilationUnit);
			compilationUnit.save(null, true);
      } catch (JavaModelException e) {
	      e.printStackTrace();
      }
	}
	
}
