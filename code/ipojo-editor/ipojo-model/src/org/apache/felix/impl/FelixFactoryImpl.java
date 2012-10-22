/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import org.apache.felix.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FelixFactoryImpl extends EFactoryImpl implements FelixFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FelixFactory init() {
		try {
			FelixFactory theFelixFactory = (FelixFactory)EPackage.Registry.INSTANCE.getEFactory("org.apache.felix.ipojo"); 
			if (theFelixFactory != null) {
				return theFelixFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FelixFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FelixFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FelixPackage.CALLBACK_TYPE: return createCallbackType();
			case FelixPackage.COMPONENT_TYPE: return createComponentType();
			case FelixPackage.CONTROLLER_TYPE: return createControllerType();
			case FelixPackage.DEPENDENCY_CALLBACK_TYPE: return createDependencyCallbackType();
			case FelixPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case FelixPackage.HANDLER_TYPE: return createHandlerType();
			case FelixPackage.INSTANCE_PROPERTY_TYPE: return createInstancePropertyType();
			case FelixPackage.INSTANCE_TYPE: return createInstanceType();
			case FelixPackage.IPOJO_TYPE: return createIpojoType();
			case FelixPackage.PROPERTIES_TYPE: return createPropertiesType();
			case FelixPackage.PROPERTY_TYPE: return createPropertyType();
			case FelixPackage.PROVIDES_TYPE: return createProvidesType();
			case FelixPackage.REQUIRES_TYPE: return createRequiresType();
			case FelixPackage.ROOT_ELEMENT_TYPE: return createRootElementType();
			case FelixPackage.SERVICE_CONTROLLER_TYPE: return createServiceControllerType();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE: return createServiceDependencyType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FelixPackage.POLICY_TYPE:
				return createPolicyTypeFromString(eDataType, initialValue);
			case FelixPackage.SCOPE_TYPE:
				return createScopeTypeFromString(eDataType, initialValue);
			case FelixPackage.TRANSITION_TYPE:
				return createTransitionTypeFromString(eDataType, initialValue);
			case FelixPackage.TYPE_TYPE:
				return createTypeTypeFromString(eDataType, initialValue);
			case FelixPackage.POLICY_TYPE_OBJECT:
				return createPolicyTypeObjectFromString(eDataType, initialValue);
			case FelixPackage.SCOPE_TYPE_OBJECT:
				return createScopeTypeObjectFromString(eDataType, initialValue);
			case FelixPackage.TRANSITION_TYPE_OBJECT:
				return createTransitionTypeObjectFromString(eDataType, initialValue);
			case FelixPackage.TYPE_TYPE_OBJECT:
				return createTypeTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FelixPackage.POLICY_TYPE:
				return convertPolicyTypeToString(eDataType, instanceValue);
			case FelixPackage.SCOPE_TYPE:
				return convertScopeTypeToString(eDataType, instanceValue);
			case FelixPackage.TRANSITION_TYPE:
				return convertTransitionTypeToString(eDataType, instanceValue);
			case FelixPackage.TYPE_TYPE:
				return convertTypeTypeToString(eDataType, instanceValue);
			case FelixPackage.POLICY_TYPE_OBJECT:
				return convertPolicyTypeObjectToString(eDataType, instanceValue);
			case FelixPackage.SCOPE_TYPE_OBJECT:
				return convertScopeTypeObjectToString(eDataType, instanceValue);
			case FelixPackage.TRANSITION_TYPE_OBJECT:
				return convertTransitionTypeObjectToString(eDataType, instanceValue);
			case FelixPackage.TYPE_TYPE_OBJECT:
				return convertTypeTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallbackType createCallbackType() {
		CallbackTypeImpl callbackType = new CallbackTypeImpl();
		return callbackType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType createComponentType() {
		ComponentTypeImpl componentType = new ComponentTypeImpl();
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerType createControllerType() {
		ControllerTypeImpl controllerType = new ControllerTypeImpl();
		return controllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyCallbackType createDependencyCallbackType() {
		DependencyCallbackTypeImpl dependencyCallbackType = new DependencyCallbackTypeImpl();
		return dependencyCallbackType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandlerType createHandlerType() {
		HandlerTypeImpl handlerType = new HandlerTypeImpl();
		return handlerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstancePropertyType createInstancePropertyType() {
		InstancePropertyTypeImpl instancePropertyType = new InstancePropertyTypeImpl();
		return instancePropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceType createInstanceType() {
		InstanceTypeImpl instanceType = new InstanceTypeImpl();
		return instanceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpojoType createIpojoType() {
		IpojoTypeImpl ipojoType = new IpojoTypeImpl();
		return ipojoType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType createPropertiesType() {
		PropertiesTypeImpl propertiesType = new PropertiesTypeImpl();
		return propertiesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createPropertyType() {
		PropertyTypeImpl propertyType = new PropertyTypeImpl();
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesType createProvidesType() {
		ProvidesTypeImpl providesType = new ProvidesTypeImpl();
		return providesType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiresType createRequiresType() {
		RequiresTypeImpl requiresType = new RequiresTypeImpl();
		return requiresType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootElementType createRootElementType() {
		RootElementTypeImpl rootElementType = new RootElementTypeImpl();
		return rootElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceControllerType createServiceControllerType() {
		ServiceControllerTypeImpl serviceControllerType = new ServiceControllerTypeImpl();
		return serviceControllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDependencyType createServiceDependencyType() {
		ServiceDependencyTypeImpl serviceDependencyType = new ServiceDependencyTypeImpl();
		return serviceDependencyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyType createPolicyTypeFromString(EDataType eDataType, String initialValue) {
		PolicyType result = PolicyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPolicyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType createScopeTypeFromString(EDataType eDataType, String initialValue) {
		ScopeType result = ScopeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScopeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType createTransitionTypeFromString(EDataType eDataType, String initialValue) {
		TransitionType result = TransitionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransitionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType createTypeTypeFromString(EDataType eDataType, String initialValue) {
		TypeType result = TypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyType createPolicyTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createPolicyTypeFromString(FelixPackage.Literals.POLICY_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPolicyTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPolicyTypeToString(FelixPackage.Literals.POLICY_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType createScopeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createScopeTypeFromString(FelixPackage.Literals.SCOPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScopeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertScopeTypeToString(FelixPackage.Literals.SCOPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType createTransitionTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createTransitionTypeFromString(FelixPackage.Literals.TRANSITION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransitionTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTransitionTypeToString(FelixPackage.Literals.TRANSITION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType createTypeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createTypeTypeFromString(FelixPackage.Literals.TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertTypeTypeToString(FelixPackage.Literals.TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FelixPackage getFelixPackage() {
		return (FelixPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FelixPackage getPackage() {
		return FelixPackage.eINSTANCE;
	}

} //FelixFactoryImpl
