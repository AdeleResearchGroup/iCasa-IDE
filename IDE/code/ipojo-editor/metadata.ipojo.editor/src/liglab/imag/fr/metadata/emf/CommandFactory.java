package liglab.imag.fr.metadata.emf;

import java.util.Collections;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.DependencyCallbackType;
import org.apache.felix.FelixFactory;
import org.apache.felix.FelixPackage;
import org.apache.felix.InstancePropertyType;
import org.apache.felix.InstanceType;
import org.apache.felix.IpojoType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;
import org.apache.felix.TransitionType;
import org.apache.felix.TypeType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Class used to create commands to be executed by the editor
 * 
 * @author Gabriel
 *
 */
public class CommandFactory {

	// ----- Instances related commands ------ //
	
	/**
	 * Creates a command to add an Instance (InstanceType) into the model
	 * @param editingDomain
	 * @param component
	 * @param instance
	 * @return
	 */
	public static Command createAddInstanceCommand(EditingDomain editingDomain, ComponentType component, InstanceType instance) {		
		Object owner = ((EObject)component).eContainer();
		EStructuralFeature feature = FelixPackage.eINSTANCE.getIpojoType_Instance();
		return AddCommand.create(editingDomain, owner, feature, instance);
	}
	

	/**
	 * Sets the component name of the specified instance
	 * @param editingDomain
	 * @param instance
	 * @param newComponentName
	 * @return
	 */
	public static Command createSetInstanceComponentNameCommand(EditingDomain editingDomain, InstanceType instance,
	      String newComponentName) {
		//AdapterFactoryEditingDomain.getEditingDomainFor((EObject)instance);
		EStructuralFeature feature = FelixPackage.eINSTANCE.getInstanceType_Component();
		return SetCommand.create(editingDomain, instance, feature, newComponentName);
	}

	
	
	/**
	 * Creates a set command to change the name of a instance (InstanceType)
	 * @param editingDomain
	 * @param instance
	 * @param newName
	 * @return
	 */
	public static Command createSetInstanceNameCommand(EditingDomain editingDomain, InstanceType instance,
	      String newName) {
		AdapterFactoryEditingDomain.getEditingDomainFor((EObject)instance);
		EStructuralFeature feature = FelixPackage.eINSTANCE.getInstanceType_Name();
		return SetCommand.create(AdapterFactoryEditingDomain.getEditingDomainFor((EObject)instance), instance, feature, newName);
	}
	
	/**
	 * Creates a command to add a Property (InstancePropertyType) into a instance (InstanceType)
	 * @param editingDomain
	 * @param component
	 * @param property
	 * @return
	 */
	public static Command createAddPropertyInstanceCommand(EditingDomain editingDomain, InstanceType instance,
			InstancePropertyType property) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getInstanceType_Property();
		return AddCommand.create(editingDomain, instance, feature, property);
	}
		
	/**
	 * Creates a remove command for a Property (InstancePropertyType) from a instance (InstanceType)
	 * @param editingDomain
	 * @param instance
	 * @param property
	 * @return
	 */
	public static Command createRemovePropertyInstanceCommand(EditingDomain editingDomain, InstanceType instance,
			InstancePropertyType property) {
		EObject owner = ((EObject) property).eContainer();
		EStructuralFeature feature = ((EObject) property).eContainingFeature();
		return RemoveCommand.create(editingDomain, owner, feature, Collections.singleton(property));
	}
	
	
	/**
	 * Creates a set command to change the value of a property
	 * @param editingDomain
	 * @param property
	 * @param newValue
	 * @return
	 */
	public static Command createSetPropertyInstanceValueCommand(EditingDomain editingDomain, InstancePropertyType property,
	      String newValue) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getInstancePropertyType_Value();
		return SetCommand.create(editingDomain, property, feature, newValue);
	}
	
	
	/**
	 * 
	 * @param editingDomain
	 * @param instance
	 * @return
	 */
	public static Command createRemoveInstanceCommand(EditingDomain editingDomain, InstanceType instance) {
		EObject owner = ((EObject) instance).eContainer();
		EStructuralFeature feature = ((EObject) instance).eContainingFeature();
		return RemoveCommand.create(editingDomain, owner, feature, Collections.singleton(instance));
	}

	
	
	// ----- Properties related commands ------ //
	
	/**
	 * Creates a command to add a Property (PropertyType) into a component
	 * @param editingDomain
	 * @param component
	 * @param property
	 * @return
	 */
	public static Command createAddPropertyCommand(EditingDomain editingDomain, ComponentType component,
	      PropertyType property) {

		EList<PropertiesType> propertiesList = component.getProperties();
		if (propertiesList.size() == 0) {
			PropertiesType propertiesType = FelixFactory.eINSTANCE.createPropertiesType();
			component.getProperties().add(propertiesType);
		}

		EObject owner = component.getProperties().get(0);

		EStructuralFeature feature = FelixPackage.eINSTANCE.getPropertiesType_Property();
		return AddCommand.create(editingDomain, owner, feature, property);
	}
	
	/**
	 * Creates a remove command for a Property (PropertyType) from a component (ComponentType)
	 * @param editingDomain
	 * @param component
	 * @param property
	 * @return
	 */
	public static Command createRemovePropertyCommand(EditingDomain editingDomain, ComponentType component,
	      PropertyType property) {
		EObject owner = ((EObject) property).eContainer();
		EStructuralFeature feature = ((EObject) property).eContainingFeature();
		return RemoveCommand.create(editingDomain, owner, feature, Collections.singleton(property));
	}
	
	public static Command createSetNamePropertyCommand(EditingDomain editingDomain,
			PropertyType property, String name) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getPropertyType_Name();
		return SetCommand.create(editingDomain, property, feature, name);
	}
	
	public static Command createSetFieldPropertyCommand(EditingDomain editingDomain,
			PropertyType property, String fieldName) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getPropertyType_Field();
		return SetCommand.create(editingDomain, property, feature, fieldName);
	}
	
	public static Command createSetValuePropertyCommand(EditingDomain editingDomain,
			PropertyType property, String value) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getPropertyType_Value();
		return SetCommand.create(editingDomain, property, feature, value);
	}
	
	public static Command createSetTypePropertyCommand(EditingDomain editingDomain,
			PropertyType property, String type) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getPropertyType_Type();
		return SetCommand.create(editingDomain, property, feature, type);
	}
	
	// ---- Dependencies related commands ----- //

	/**
	 * Creates a command to add a Property (RequiresType) into a component
	 * @param editingDomain
	 * @param component
	 * @param requirement
	 * @return
	 */
	public static Command createAddRequirementCommand(EditingDomain editingDomain, ComponentType component,
	      RequiresType requirement) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getComponentType_Requires();
		return AddCommand.create(editingDomain, component, feature, requirement);
	}

	/**
	 * Creates a remove command for a Requirement (RequiresType) from a component (ComponentType)
	 * @param editingDomain
	 * @param component
	 * @param requirement
	 * @return
	 */
	public static Command createRemoveRequirementCommand(EditingDomain editingDomain, ComponentType component,
	      RequiresType requirement) {
		EObject owner = ((EObject) requirement).eContainer();
		EStructuralFeature feature = ((EObject) requirement).eContainingFeature();
		return RemoveCommand.create(editingDomain, owner, feature, Collections.singleton(requirement));
	}

	
	// ------ Component related commands ------ //
	
	
	public static Command createAddComponentTypeCommand(EditingDomain editingDomain, IpojoType ipojoType) {
		ComponentType componentType = ModelUtil.createComponentType("New Component");
		EStructuralFeature feature = FelixPackage.eINSTANCE.getIpojoType_Component();
		return AddCommand.create(editingDomain, ipojoType, feature, componentType);
	}

	public static Command createRemoveComponentTypeCommand(EditingDomain editingDomain,
	      ComponentType componentType) {
		EObject owner = ((EObject) componentType).eContainer();
		EStructuralFeature feature = FelixPackage.eINSTANCE.getIpojoType_Component();
		return RemoveCommand.create(editingDomain, owner, feature, componentType);
	}
	
	/**
	 * Creates a set command to change the name of a component (ComponentType)
	 * @param editingDomain
	 * @param component
	 * @param newName
	 * @return
	 */
	public static Command createSetComponentNameCommand(EditingDomain editingDomain, ComponentType component,
	      String newName) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getComponentType_Name();
		return SetCommand.create(editingDomain, component, feature, newName);
	}

	public static Command createSetComponentClassCommand(EditingDomain editingDomain, ComponentType component,
	      String className) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getComponentType_Classname();
		return SetCommand.create(editingDomain, component, feature, className);
	}
	
	
	// ------  Specification related commands ----- //
	
	public static Command createAddSpecification(EditingDomain editingDomain, ComponentType component,
	      String newInterface) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getProvidesType_Specifications();
		Object owner = component.getProvides().get(0);
		return SetCommand.create(editingDomain, owner, feature, newInterface);
	}
	
	public static Command createAddProvidesCommand(EditingDomain editingDomain, ComponentType component, String specification) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getComponentType_Provides();
		ProvidesType providesType = FelixFactory.eINSTANCE.createProvidesType();
		providesType.setSpecifications(specification);
		return AddCommand.create(editingDomain, component, feature, providesType);
	}
	
	public static Command createSetInterfacesProvidesCommand(EditingDomain editingDomain, ProvidesType provides, String interfaces) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getProvidesType_Specifications();
		return SetCommand.create(editingDomain, provides, feature, interfaces);
	}
		
	public static Command createRemoveProvidesCommand(EditingDomain editingDomain, ProvidesType provides) {
		EObject owner = ((EObject) provides).eContainer();
		EStructuralFeature feature = ((EObject) provides).eContainingFeature();
		return RemoveCommand.create(editingDomain, owner, feature, Collections.singleton(provides));
	}
	
	public static Command createAddSpecPropertyCommand(EditingDomain editingDomain, ProvidesType provides,
	      PropertyType property) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getProvidesType_Property();
		return AddCommand.create(editingDomain, provides, feature, property);
	}
	
	public static Command createRemoveSpecPropertyCommand(EditingDomain editingDomain, PropertyType property) {
		EObject owner = ((EObject) property).eContainer();
		EStructuralFeature feature = ((EObject) property).eContainingFeature();
		return RemoveCommand.create(editingDomain, owner, feature, Collections.singleton(property));
	}
	
	
	// ------  Callbacks related commands ----- //
	
	public static Command createRemoveCallbackDependencyCommand(EditingDomain editingDomain, RequiresType dependency,
			DependencyCallbackType callback) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getRequiresType_Callback();
		return RemoveCommand.create(editingDomain, dependency, feature, Collections.singleton(callback));
	}
	
	public static Command createSetCallbackDependencyCommand(EditingDomain editingDomain, RequiresType dependency,
	      String methodName, TypeType type) {
		
		DependencyCallbackType callback = ModelUtil.getRequirementCallback(dependency, type);
		
		if (!methodName.isEmpty()) {
			if (callback != null) {
				EStructuralFeature feature = FelixPackage.eINSTANCE.getDependencyCallbackType_Method();
				return SetCommand.create(editingDomain, callback, feature, methodName);
			} else {
				EStructuralFeature feature = FelixPackage.eINSTANCE.getRequiresType_Callback();
				callback = ModelUtil.createRequirementCallBack(methodName, type);
				return AddCommand.create(editingDomain, dependency, feature, Collections.singleton(callback));
			}
		}		
		return UnexecutableCommand.INSTANCE;
	}
	
	

	public static Command createSetValidateTransitionCommand(EditingDomain editingDomain,
	      ComponentType component, String methodName) {
		return createSetCallbackCommand(editingDomain, component, methodName, TransitionType.VALIDATE);
	}

	public static Command createSetInvalidateTransitionCommand(EditingDomain editingDomain,
	      ComponentType component, String methodName) {
		return createSetCallbackCommand(editingDomain, component, methodName, TransitionType.INVALIDATE);
	}

	public static Command createSetFieldDependencyCommand(EditingDomain editingDomain,
	      RequiresType requirement, String fieldName) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getRequiresType_Field();
		return SetCommand.create(editingDomain, requirement, feature, fieldName);
	}
	
	
	public static Command createSetAggregateDependencyCommand(EditingDomain editingDomain,
	      RequiresType requirement, Boolean aggregate) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getServiceDependencyType_Aggregate();
		if (aggregate==null) 
			return SetCommand.create(editingDomain, requirement, feature, SetCommand.UNSET_VALUE);
		return SetCommand.create(editingDomain, requirement, feature, aggregate);
	}
	
	public static Command createSetOptionalDependencyCommand(EditingDomain editingDomain,
	      RequiresType requirement, Boolean optional) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getServiceDependencyType_Optional();
		if (optional==null) // Default value
			return SetCommand.create(editingDomain, requirement, feature, SetCommand.UNSET_VALUE);
		return SetCommand.create(editingDomain, requirement, feature, optional);
	}
	
	public static Command createSetIDDependencyCommand(EditingDomain editingDomain,
	      RequiresType requirement, String id) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getServiceDependencyType_Id();
		return SetCommand.create(editingDomain, requirement, feature, id);
	}

	public static Command createSetFilterDependencyCommand(EditingDomain editingDomain,
	      RequiresType requirement, String filter) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getServiceDependencyType_Filter();
		return SetCommand.create(editingDomain, requirement, feature, filter);
	}
	
	/**
	 * Creates a command to set the specification field in a dependency 
	 * @param editingDomain
	 * @param requirement
	 * @param specification
	 * @return
	 */
	public static Command createSetSpecificationDependencyCommand(EditingDomain editingDomain,
	      RequiresType requirement, String specification) {
		EStructuralFeature feature = FelixPackage.eINSTANCE.getServiceDependencyType_Specification();
		return SetCommand.create(editingDomain, requirement, feature, specification);
	}

	/**
	 * It creates, modifies or removes an callback method definition for a component
	 * @param editingDomain
	 * @param component
	 * @param methodName
	 * @param type
	 * @return
	 */
	public static Command createSetCallbackCommand(EditingDomain editingDomain, ComponentType component,
	      String methodName, TransitionType type) {

		CallbackType callback = ModelUtil.getCallback(component, type);

		if (!methodName.isEmpty()) {
			if (callback != null) {
				EStructuralFeature feature = FelixPackage.eINSTANCE.getCallbackType_Method();
				return SetCommand.create(editingDomain, callback, feature, methodName);
			} else {
				EStructuralFeature feature = FelixPackage.eINSTANCE.getComponentType_Callback();
				callback = FelixFactory.eINSTANCE.createCallbackType();
				callback.setTransition(type);
				callback.setMethod(methodName);
				return AddCommand.create(editingDomain, component, feature, Collections.singleton(callback));
			}
		} else {
			EStructuralFeature feature = FelixPackage.eINSTANCE.getComponentType_Callback();
			return RemoveCommand.create(editingDomain, component, feature, Collections.singleton(callback));
		}
	}


}
