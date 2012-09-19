package liglab.imag.fr.metadata.emf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.DependencyCallbackType;
import org.apache.felix.FelixFactory;
import org.apache.felix.InstancePropertyType;
import org.apache.felix.InstanceType;
import org.apache.felix.IpojoType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;
import org.apache.felix.TransitionType;
import org.apache.felix.TypeType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

public class ModelUtil {

	/**
	 * Return a validate callback type
	 * @param component
	 * @return
	 */
	public static CallbackType getValidateCallback(ComponentType component) {
		return getCallback(component, TransitionType.VALIDATE);
	}
	
	/**
	 * Return a unvalidate callback type
	 * @param component
	 * @return
	 */
	public static CallbackType getInvalidateCallback(ComponentType component) {
		return getCallback(component, TransitionType.INVALIDATE);
	}
	
	/**
	 * Return a CallbackType for a type of TransitionType searching in all callbacks lists 
	 * @param component the component
	 * @param transition the transition
	 * @return a CallbackType for the TransitionType
	 */
	public static CallbackType getCallback(ComponentType component, TransitionType transition) {
		List<CallbackType> callbacks = component.getCallback();
		for (CallbackType callback : callbacks) {
	      if (callback.getTransition().equals(transition))
	      	return callback;
      }
		return null;
	}
	

	/**
	 * Get the callback method (DependencyCallbackType) associated to bind action
	 * @param dependency
	 * @return
	 */
	public static DependencyCallbackType getBindCallback(RequiresType dependency) {
		return getRequirementCallback(dependency, TypeType.BIND);
	}
	
	/**
	 * Get the callback method (DependencyCallbackType) associated to unbind action
	 * @param dependency
	 * @return
	 */
	public static DependencyCallbackType getUnbindCallback(RequiresType dependency) {
		return getRequirementCallback(dependency, TypeType.UNBIND);
	}
	
	
	/**
	 * Determines if the dependency is based on a field
	 * 
	 * @param requirement
	 * @return
	 */
	public static boolean isFieldDependency(RequiresType requirement) {
		return requirement.getCallback().isEmpty();
	}
	
	/**
	 * Return a callbacl method (DependencyCallbackType) by TypeType (bind, unbind)
	 * @param requirement the requirement (RequiresType)
	 * @param type the type can be (bind, unbind)
	 * @return the callback
	 */
	public static DependencyCallbackType getRequirementCallback(RequiresType requirement, TypeType type) {
		List<DependencyCallbackType> callbacks = requirement.getCallback();
		for (DependencyCallbackType dependencyCallbackType : callbacks) {
	      if (dependencyCallbackType.getType().equals(type))
	      	return dependencyCallbackType;
		}
		return null;
	}
	
	/**
	 * Creates a DependencyCallbackType
	 * @param method the method name
	 * @param type the type can be (bind, unbind)
	 * @return
	 */
	public static DependencyCallbackType createRequirementCallBack(String method, TypeType type) {
		DependencyCallbackType callback = FelixFactory.eINSTANCE.createDependencyCallbackType();
		callback.setType(type);
		callback.setMethod(method);
		return callback;
	}
	
	/**
	 * Creates a component type (ComponentType) instance and sets its name 
	 * @param name
	 * @return
	 */
	public static ComponentType createComponentType(String name) {
		ComponentType componentType = FelixFactory.eINSTANCE.createComponentType();
		componentType.setName(name);
		return componentType;
	}
	
	/**
	 * gets the list of instances (InstanceType) associated to a component type (ComponentType)
	 * @param component
	 * @return
	 */
	public static List<InstanceType> getInstances(ComponentType component) {
		List<InstanceType> filteredList = new ArrayList<InstanceType>();
		
		EList<InstanceType> allList = ((IpojoType)((EObject)component).eContainer()).getInstance();
		
		for (InstanceType instanceType : allList) {
	      if (instanceType.getComponent().equals(component.getName()))
	      	filteredList.add(instanceType);
      }
		return filteredList;
	}
	
	
	/**
	 * Gets the component type (ComponentType) corresponding to this instance
	 * @param instance
	 * @return
	 */
	public static ComponentType getComponentFromInstance(InstanceType instance) {
		EList<ComponentType> allList = ((IpojoType)((EObject)instance).eContainer()).getComponent();
		
		for (ComponentType componentType : allList) {
	      if (componentType.getName().equals(instance.getComponent()))
	      	return componentType;
      }		
		return null;
	}
	
	/**
	 * Gets the property (InstancePropertyType) by name if it is defined, otherwise returns null 
	 * @param instance
	 * @param name
	 * @return
	 */
	public static InstancePropertyType getPropertyInstance(InstanceType instance, String name) {
		List<InstancePropertyType> properties = instance.getProperty();
		for (InstancePropertyType instancePropertyType : properties) {
			if (instancePropertyType.getName().equals(name))
				return instancePropertyType;
		}
		return null;
	}
	
	/**
	 * Executes a command using a editing domain
	 * @param editingDomain
	 * @param command
	 */
	public static void executeCommand(EditingDomain editingDomain, Command command) {
		editingDomain.getCommandStack().execute(command);
	}
	
	/**
	 * Gets the list of implemented interfaces
	 * @param component
	 * @return
	 */
	public static List<String> getInterfaces(ComponentType component) {		
		if (!component.getProvides().isEmpty()) {
			ProvidesType provides = component.getProvides().get(0);
			String specsStr = provides.getSpecifications();
			if (specsStr!=null)
				return Arrays.asList(specsStr.split("\\s*,\\s*"));
		}		
		return new ArrayList<String>();
	}
	
}
