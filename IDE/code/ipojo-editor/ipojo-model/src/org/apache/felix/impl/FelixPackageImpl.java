/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.ControllerType;
import org.apache.felix.DependencyCallbackType;
import org.apache.felix.DocumentRoot;
import org.apache.felix.FelixFactory;
import org.apache.felix.FelixPackage;
import org.apache.felix.HandlerType;
import org.apache.felix.InstancePropertyType;
import org.apache.felix.InstanceType;
import org.apache.felix.IpojoType;
import org.apache.felix.PolicyType;
import org.apache.felix.PropertiesType;
import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;
import org.apache.felix.RootElementType;
import org.apache.felix.ScopeType;
import org.apache.felix.ServiceControllerType;
import org.apache.felix.ServiceDependencyType;
import org.apache.felix.TransitionType;
import org.apache.felix.TypeType;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FelixPackageImpl extends EPackageImpl implements FelixPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callbackTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controllerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyCallbackTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass handlerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instancePropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ipojoTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiresTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceControllerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceDependencyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum policyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scopeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transitionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType policyTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType scopeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType transitionTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.apache.felix.FelixPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FelixPackageImpl() {
		super(eNS_URI, FelixFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FelixPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FelixPackage init() {
		if (isInited) return (FelixPackage)EPackage.Registry.INSTANCE.getEPackage(FelixPackage.eNS_URI);

		// Obtain or create and register package
		FelixPackageImpl theFelixPackage = (FelixPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FelixPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FelixPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFelixPackage.createPackageContents();

		// Initialize created meta-data
		theFelixPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFelixPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FelixPackage.eNS_URI, theFelixPackage);
		return theFelixPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallbackType() {
		return callbackTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallbackType_Method() {
		return (EAttribute)callbackTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCallbackType_Transition() {
		return (EAttribute)callbackTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentType() {
		return componentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Group() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Callback() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Provides() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Requires() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Properties() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentType_Controller() {
		return (EReference)componentTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Any() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Architecture() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Classname() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_FactoryMethod() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Immediate() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Name() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Public() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentType_Version() {
		return (EAttribute)componentTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControllerType() {
		return controllerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControllerType_Field() {
		return (EAttribute)controllerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyCallbackType() {
		return dependencyCallbackTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyCallbackType_Method() {
		return (EAttribute)dependencyCallbackTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyCallbackType_Type() {
		return (EAttribute)dependencyCallbackTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Callback() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Component() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Controller() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Handler() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Instance() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Ipojo() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Properties() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Provides() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Requires() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHandlerType() {
		return handlerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Group() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Any() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Architecture() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Classname() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Level() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Name() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandlerType_Namespace() {
		return (EAttribute)handlerTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstancePropertyType() {
		return instancePropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstancePropertyType_Property() {
		return (EReference)instancePropertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstancePropertyType_Name() {
		return (EAttribute)instancePropertyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstancePropertyType_Type() {
		return (EAttribute)instancePropertyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstancePropertyType_Value() {
		return (EAttribute)instancePropertyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceType() {
		return instanceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceType_Group() {
		return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceType_Property() {
		return (EReference)instanceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceType_Component() {
		return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceType_Name() {
		return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceType_Version() {
		return (EAttribute)instanceTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIpojoType() {
		return ipojoTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpojoType_Group() {
		return (EAttribute)ipojoTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpojoType_Handler() {
		return (EReference)ipojoTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpojoType_Instance() {
		return (EReference)ipojoTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIpojoType_Component() {
		return (EReference)ipojoTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIpojoType_Any() {
		return (EAttribute)ipojoTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertiesType() {
		return propertiesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType_Group() {
		return (EAttribute)propertiesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertiesType_Property() {
		return (EReference)propertiesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType_Pid() {
		return (EAttribute)propertiesTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType_Propagation() {
		return (EAttribute)propertiesTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertiesType_Updated() {
		return (EAttribute)propertiesTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyType() {
		return propertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Field() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Mandatory() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Method() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Name() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Type() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Value() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProvidesType() {
		return providesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidesType_Group() {
		return (EAttribute)providesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesType_Property() {
		return (EReference)providesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProvidesType_Controller() {
		return (EReference)providesTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidesType_PostRegistration() {
		return (EAttribute)providesTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidesType_PostUnregistration() {
		return (EAttribute)providesTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidesType_Specifications() {
		return (EAttribute)providesTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProvidesType_Strategy() {
		return (EAttribute)providesTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiresType() {
		return requiresTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_Group() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequiresType_Callback() {
		return (EReference)requiresTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_DefaultImplementation() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_Field() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_From() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_Nullable() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_Proxy() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequiresType_Scope() {
		return (EAttribute)requiresTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootElementType() {
		return rootElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceControllerType() {
		return serviceControllerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceControllerType_Field() {
		return (EAttribute)serviceControllerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceControllerType_Value() {
		return (EAttribute)serviceControllerTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceDependencyType() {
		return serviceDependencyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Aggregate() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Comparator() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Filter() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Id() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Optional() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Policy() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceDependencyType_Specification() {
		return (EAttribute)serviceDependencyTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPolicyType() {
		return policyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScopeType() {
		return scopeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransitionType() {
		return transitionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeType() {
		return typeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPolicyTypeObject() {
		return policyTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getScopeTypeObject() {
		return scopeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTransitionTypeObject() {
		return transitionTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeTypeObject() {
		return typeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FelixFactory getFelixFactory() {
		return (FelixFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		callbackTypeEClass = createEClass(CALLBACK_TYPE);
		createEAttribute(callbackTypeEClass, CALLBACK_TYPE__METHOD);
		createEAttribute(callbackTypeEClass, CALLBACK_TYPE__TRANSITION);

		componentTypeEClass = createEClass(COMPONENT_TYPE);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__GROUP);
		createEReference(componentTypeEClass, COMPONENT_TYPE__CALLBACK);
		createEReference(componentTypeEClass, COMPONENT_TYPE__PROVIDES);
		createEReference(componentTypeEClass, COMPONENT_TYPE__REQUIRES);
		createEReference(componentTypeEClass, COMPONENT_TYPE__PROPERTIES);
		createEReference(componentTypeEClass, COMPONENT_TYPE__CONTROLLER);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__ANY);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__ARCHITECTURE);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__CLASSNAME);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__FACTORY_METHOD);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__IMMEDIATE);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__NAME);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__PUBLIC);
		createEAttribute(componentTypeEClass, COMPONENT_TYPE__VERSION);

		controllerTypeEClass = createEClass(CONTROLLER_TYPE);
		createEAttribute(controllerTypeEClass, CONTROLLER_TYPE__FIELD);

		dependencyCallbackTypeEClass = createEClass(DEPENDENCY_CALLBACK_TYPE);
		createEAttribute(dependencyCallbackTypeEClass, DEPENDENCY_CALLBACK_TYPE__METHOD);
		createEAttribute(dependencyCallbackTypeEClass, DEPENDENCY_CALLBACK_TYPE__TYPE);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CALLBACK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__COMPONENT);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONTROLLER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__HANDLER);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INSTANCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IPOJO);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROVIDES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__REQUIRES);

		handlerTypeEClass = createEClass(HANDLER_TYPE);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__GROUP);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__ANY);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__ARCHITECTURE);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__CLASSNAME);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__LEVEL);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__NAME);
		createEAttribute(handlerTypeEClass, HANDLER_TYPE__NAMESPACE);

		instancePropertyTypeEClass = createEClass(INSTANCE_PROPERTY_TYPE);
		createEReference(instancePropertyTypeEClass, INSTANCE_PROPERTY_TYPE__PROPERTY);
		createEAttribute(instancePropertyTypeEClass, INSTANCE_PROPERTY_TYPE__NAME);
		createEAttribute(instancePropertyTypeEClass, INSTANCE_PROPERTY_TYPE__TYPE);
		createEAttribute(instancePropertyTypeEClass, INSTANCE_PROPERTY_TYPE__VALUE);

		instanceTypeEClass = createEClass(INSTANCE_TYPE);
		createEAttribute(instanceTypeEClass, INSTANCE_TYPE__GROUP);
		createEReference(instanceTypeEClass, INSTANCE_TYPE__PROPERTY);
		createEAttribute(instanceTypeEClass, INSTANCE_TYPE__COMPONENT);
		createEAttribute(instanceTypeEClass, INSTANCE_TYPE__NAME);
		createEAttribute(instanceTypeEClass, INSTANCE_TYPE__VERSION);

		ipojoTypeEClass = createEClass(IPOJO_TYPE);
		createEAttribute(ipojoTypeEClass, IPOJO_TYPE__GROUP);
		createEReference(ipojoTypeEClass, IPOJO_TYPE__HANDLER);
		createEReference(ipojoTypeEClass, IPOJO_TYPE__INSTANCE);
		createEReference(ipojoTypeEClass, IPOJO_TYPE__COMPONENT);
		createEAttribute(ipojoTypeEClass, IPOJO_TYPE__ANY);

		propertiesTypeEClass = createEClass(PROPERTIES_TYPE);
		createEAttribute(propertiesTypeEClass, PROPERTIES_TYPE__GROUP);
		createEReference(propertiesTypeEClass, PROPERTIES_TYPE__PROPERTY);
		createEAttribute(propertiesTypeEClass, PROPERTIES_TYPE__PID);
		createEAttribute(propertiesTypeEClass, PROPERTIES_TYPE__PROPAGATION);
		createEAttribute(propertiesTypeEClass, PROPERTIES_TYPE__UPDATED);

		propertyTypeEClass = createEClass(PROPERTY_TYPE);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__FIELD);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__MANDATORY);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__METHOD);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__NAME);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__TYPE);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__VALUE);

		providesTypeEClass = createEClass(PROVIDES_TYPE);
		createEAttribute(providesTypeEClass, PROVIDES_TYPE__GROUP);
		createEReference(providesTypeEClass, PROVIDES_TYPE__PROPERTY);
		createEReference(providesTypeEClass, PROVIDES_TYPE__CONTROLLER);
		createEAttribute(providesTypeEClass, PROVIDES_TYPE__POST_REGISTRATION);
		createEAttribute(providesTypeEClass, PROVIDES_TYPE__POST_UNREGISTRATION);
		createEAttribute(providesTypeEClass, PROVIDES_TYPE__SPECIFICATIONS);
		createEAttribute(providesTypeEClass, PROVIDES_TYPE__STRATEGY);

		requiresTypeEClass = createEClass(REQUIRES_TYPE);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__GROUP);
		createEReference(requiresTypeEClass, REQUIRES_TYPE__CALLBACK);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__DEFAULT_IMPLEMENTATION);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__FIELD);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__FROM);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__NULLABLE);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__PROXY);
		createEAttribute(requiresTypeEClass, REQUIRES_TYPE__SCOPE);

		rootElementTypeEClass = createEClass(ROOT_ELEMENT_TYPE);

		serviceControllerTypeEClass = createEClass(SERVICE_CONTROLLER_TYPE);
		createEAttribute(serviceControllerTypeEClass, SERVICE_CONTROLLER_TYPE__FIELD);
		createEAttribute(serviceControllerTypeEClass, SERVICE_CONTROLLER_TYPE__VALUE);

		serviceDependencyTypeEClass = createEClass(SERVICE_DEPENDENCY_TYPE);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__AGGREGATE);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__COMPARATOR);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__FILTER);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__ID);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__OPTIONAL);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__POLICY);
		createEAttribute(serviceDependencyTypeEClass, SERVICE_DEPENDENCY_TYPE__SPECIFICATION);

		// Create enums
		policyTypeEEnum = createEEnum(POLICY_TYPE);
		scopeTypeEEnum = createEEnum(SCOPE_TYPE);
		transitionTypeEEnum = createEEnum(TRANSITION_TYPE);
		typeTypeEEnum = createEEnum(TYPE_TYPE);

		// Create data types
		policyTypeObjectEDataType = createEDataType(POLICY_TYPE_OBJECT);
		scopeTypeObjectEDataType = createEDataType(SCOPE_TYPE_OBJECT);
		transitionTypeObjectEDataType = createEDataType(TRANSITION_TYPE_OBJECT);
		typeTypeObjectEDataType = createEDataType(TYPE_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		handlerTypeEClass.getESuperTypes().add(this.getRootElementType());
		instanceTypeEClass.getESuperTypes().add(this.getRootElementType());
		requiresTypeEClass.getESuperTypes().add(this.getServiceDependencyType());

		// Initialize classes and features; add operations and parameters
		initEClass(callbackTypeEClass, CallbackType.class, "CallbackType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCallbackType_Method(), theXMLTypePackage.getString(), "method", null, 1, 1, CallbackType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCallbackType_Transition(), this.getTransitionType(), "transition", null, 1, 1, CallbackType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentTypeEClass, ComponentType.class, "ComponentType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_Callback(), this.getCallbackType(), null, "callback", null, 0, -1, ComponentType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_Provides(), this.getProvidesType(), null, "provides", null, 0, -1, ComponentType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_Requires(), this.getRequiresType(), null, "requires", null, 0, -1, ComponentType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_Properties(), this.getPropertiesType(), null, "properties", null, 0, -1, ComponentType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponentType_Controller(), this.getControllerType(), null, "controller", null, 0, -1, ComponentType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ComponentType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Architecture(), theXMLTypePackage.getBoolean(), "architecture", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Classname(), theXMLTypePackage.getString(), "classname", null, 1, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_FactoryMethod(), theXMLTypePackage.getString(), "factoryMethod", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Immediate(), theXMLTypePackage.getBoolean(), "immediate", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Public(), theXMLTypePackage.getBoolean(), "public", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentType_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, ComponentType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controllerTypeEClass, ControllerType.class, "ControllerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getControllerType_Field(), theXMLTypePackage.getString(), "field", null, 1, 1, ControllerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyCallbackTypeEClass, DependencyCallbackType.class, "DependencyCallbackType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependencyCallbackType_Method(), theXMLTypePackage.getString(), "method", null, 1, 1, DependencyCallbackType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependencyCallbackType_Type(), this.getTypeType(), "type", null, 1, 1, DependencyCallbackType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Callback(), this.getCallbackType(), null, "callback", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Component(), this.getComponentType(), null, "component", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Controller(), this.getControllerType(), null, "controller", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Handler(), this.getHandlerType(), null, "handler", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Instance(), this.getInstanceType(), null, "instance", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Ipojo(), this.getIpojoType(), null, "ipojo", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Properties(), this.getPropertiesType(), null, "properties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Provides(), this.getProvidesType(), null, "provides", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Requires(), this.getRequiresType(), null, "requires", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(handlerTypeEClass, HandlerType.class, "HandlerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHandlerType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, HandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHandlerType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, HandlerType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getHandlerType_Architecture(), theXMLTypePackage.getBoolean(), "architecture", "false", 0, 1, HandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHandlerType_Classname(), theXMLTypePackage.getString(), "classname", null, 1, 1, HandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHandlerType_Level(), theXMLTypePackage.getInt(), "level", null, 0, 1, HandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHandlerType_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, HandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHandlerType_Namespace(), theXMLTypePackage.getString(), "namespace", null, 0, 1, HandlerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instancePropertyTypeEClass, InstancePropertyType.class, "InstancePropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstancePropertyType_Property(), this.getInstancePropertyType(), null, "property", null, 0, -1, InstancePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstancePropertyType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, InstancePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstancePropertyType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, InstancePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstancePropertyType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, InstancePropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceTypeEClass, InstanceType.class, "InstanceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstanceType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstanceType_Property(), this.getInstancePropertyType(), null, "property", null, 0, -1, InstanceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceType_Component(), theXMLTypePackage.getString(), "component", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceType_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, InstanceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ipojoTypeEClass, IpojoType.class, "IpojoType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIpojoType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, IpojoType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIpojoType_Handler(), this.getHandlerType(), null, "handler", null, 0, -1, IpojoType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIpojoType_Instance(), this.getInstanceType(), null, "instance", null, 0, -1, IpojoType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIpojoType_Component(), this.getComponentType(), null, "component", null, 0, -1, IpojoType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIpojoType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, IpojoType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(propertiesTypeEClass, PropertiesType.class, "PropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertiesType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertiesType_Property(), this.getPropertyType(), null, "property", null, 0, -1, PropertiesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertiesType_Pid(), theXMLTypePackage.getString(), "pid", null, 0, 1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertiesType_Propagation(), theXMLTypePackage.getBoolean(), "propagation", null, 0, 1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertiesType_Updated(), theXMLTypePackage.getString(), "updated", null, 0, 1, PropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyTypeEClass, PropertyType.class, "PropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyType_Field(), theXMLTypePackage.getString(), "field", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Mandatory(), theXMLTypePackage.getBoolean(), "mandatory", "false", 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Method(), theXMLTypePackage.getString(), "method", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providesTypeEClass, ProvidesType.class, "ProvidesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProvidesType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ProvidesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProvidesType_Property(), this.getPropertyType(), null, "property", null, 0, -1, ProvidesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getProvidesType_Controller(), this.getServiceControllerType(), null, "controller", null, 0, -1, ProvidesType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getProvidesType_PostRegistration(), theXMLTypePackage.getString(), "postRegistration", null, 0, 1, ProvidesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProvidesType_PostUnregistration(), theXMLTypePackage.getString(), "postUnregistration", null, 0, 1, ProvidesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProvidesType_Specifications(), theXMLTypePackage.getString(), "specifications", null, 0, 1, ProvidesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProvidesType_Strategy(), theXMLTypePackage.getString(), "strategy", null, 0, 1, ProvidesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requiresTypeEClass, RequiresType.class, "RequiresType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequiresType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequiresType_Callback(), this.getDependencyCallbackType(), null, "callback", null, 0, -1, RequiresType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresType_DefaultImplementation(), theXMLTypePackage.getString(), "defaultImplementation", null, 0, 1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresType_Field(), theXMLTypePackage.getString(), "field", null, 0, 1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresType_From(), theXMLTypePackage.getString(), "from", null, 0, 1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresType_Nullable(), theXMLTypePackage.getBoolean(), "nullable", null, 0, 1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresType_Proxy(), theXMLTypePackage.getBoolean(), "proxy", null, 0, 1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequiresType_Scope(), this.getScopeType(), "scope", null, 0, 1, RequiresType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootElementTypeEClass, RootElementType.class, "RootElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serviceControllerTypeEClass, ServiceControllerType.class, "ServiceControllerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceControllerType_Field(), theXMLTypePackage.getString(), "field", null, 1, 1, ServiceControllerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceControllerType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ServiceControllerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceDependencyTypeEClass, ServiceDependencyType.class, "ServiceDependencyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceDependencyType_Aggregate(), theXMLTypePackage.getBoolean(), "aggregate", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceDependencyType_Comparator(), theXMLTypePackage.getString(), "comparator", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceDependencyType_Filter(), theXMLTypePackage.getString(), "filter", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceDependencyType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceDependencyType_Optional(), theXMLTypePackage.getBoolean(), "optional", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceDependencyType_Policy(), this.getPolicyType(), "policy", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceDependencyType_Specification(), theXMLTypePackage.getString(), "specification", null, 0, 1, ServiceDependencyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(policyTypeEEnum, PolicyType.class, "PolicyType");
		addEEnumLiteral(policyTypeEEnum, PolicyType.DYNAMIC);
		addEEnumLiteral(policyTypeEEnum, PolicyType.STATIC);
		addEEnumLiteral(policyTypeEEnum, PolicyType.DYNAMIC_PRIORITY);

		initEEnum(scopeTypeEEnum, ScopeType.class, "ScopeType");
		addEEnumLiteral(scopeTypeEEnum, ScopeType.GLOBAL);
		addEEnumLiteral(scopeTypeEEnum, ScopeType.COMPOSITE);
		addEEnumLiteral(scopeTypeEEnum, ScopeType.COMPOSITE_GLOBAL);

		initEEnum(transitionTypeEEnum, TransitionType.class, "TransitionType");
		addEEnumLiteral(transitionTypeEEnum, TransitionType.VALIDATE);
		addEEnumLiteral(transitionTypeEEnum, TransitionType.INVALIDATE);

		initEEnum(typeTypeEEnum, TypeType.class, "TypeType");
		addEEnumLiteral(typeTypeEEnum, TypeType.BIND);
		addEEnumLiteral(typeTypeEEnum, TypeType.UNBIND);
		addEEnumLiteral(typeTypeEEnum, TypeType.MODIFIED);

		// Initialize data types
		initEDataType(policyTypeObjectEDataType, PolicyType.class, "PolicyTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(scopeTypeObjectEDataType, ScopeType.class, "ScopeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(transitionTypeObjectEDataType, TransitionType.class, "TransitionTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeTypeObjectEDataType, TypeType.class, "TypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";				
		addAnnotation
		  (callbackTypeEClass, 
		   source, 
		   new String[] {
			 "name", "CallbackType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getCallbackType_Method(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "method"
		   });			
		addAnnotation
		  (getCallbackType_Transition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "transition"
		   });			
		addAnnotation
		  (componentTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ComponentType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getComponentType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });			
		addAnnotation
		  (getComponentType_Callback(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callback",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getComponentType_Provides(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "provides",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getComponentType_Requires(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "requires",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getComponentType_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "properties",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getComponentType_Controller(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "controller",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getComponentType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":6",
			 "processing", "lax",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getComponentType_Architecture(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "architecture"
		   });			
		addAnnotation
		  (getComponentType_Classname(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "classname"
		   });			
		addAnnotation
		  (getComponentType_FactoryMethod(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "factory-method"
		   });			
		addAnnotation
		  (getComponentType_Immediate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "immediate"
		   });			
		addAnnotation
		  (getComponentType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getComponentType_Public(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "public"
		   });			
		addAnnotation
		  (getComponentType_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "version"
		   });			
		addAnnotation
		  (controllerTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ControllerType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getControllerType_Field(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field"
		   });			
		addAnnotation
		  (dependencyCallbackTypeEClass, 
		   source, 
		   new String[] {
			 "name", "DependencyCallbackType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getDependencyCallbackType_Method(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "method"
		   });			
		addAnnotation
		  (getDependencyCallbackType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Callback(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callback",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Component(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Controller(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "controller",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Handler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "handler",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Instance(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "instance",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Ipojo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ipojo",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Properties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "properties",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Provides(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "provides",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Requires(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "requires",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (handlerTypeEClass, 
		   source, 
		   new String[] {
			 "name", "HandlerType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getHandlerType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });		
		addAnnotation
		  (getHandlerType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##any",
			 "name", ":1",
			 "processing", "skip",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getHandlerType_Architecture(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "architecture"
		   });			
		addAnnotation
		  (getHandlerType_Classname(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "classname"
		   });			
		addAnnotation
		  (getHandlerType_Level(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "level"
		   });			
		addAnnotation
		  (getHandlerType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getHandlerType_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });			
		addAnnotation
		  (instancePropertyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InstancePropertyType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInstancePropertyType_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getInstancePropertyType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getInstancePropertyType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });			
		addAnnotation
		  (getInstancePropertyType_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });			
		addAnnotation
		  (instanceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "InstanceType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getInstanceType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });			
		addAnnotation
		  (getInstanceType_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getInstanceType_Component(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "component"
		   });			
		addAnnotation
		  (getInstanceType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getInstanceType_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "version"
		   });			
		addAnnotation
		  (ipojoTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ipojo_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getIpojoType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });			
		addAnnotation
		  (getIpojoType_Handler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "handler",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getIpojoType_Instance(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "instance",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getIpojoType_Component(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "component",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (getIpojoType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax",
			 "group", "#group:0"
		   });		
		addAnnotation
		  (policyTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "policy_._type"
		   });		
		addAnnotation
		  (policyTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "policy_._type:Object",
			 "baseType", "policy_._type"
		   });			
		addAnnotation
		  (propertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PropertiesType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPropertiesType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });			
		addAnnotation
		  (getPropertiesType_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getPropertiesType_Pid(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pid"
		   });			
		addAnnotation
		  (getPropertiesType_Propagation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "propagation"
		   });			
		addAnnotation
		  (getPropertiesType_Updated(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "updated"
		   });			
		addAnnotation
		  (propertyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PropertyType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getPropertyType_Field(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field"
		   });			
		addAnnotation
		  (getPropertyType_Mandatory(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mandatory"
		   });			
		addAnnotation
		  (getPropertyType_Method(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "method"
		   });			
		addAnnotation
		  (getPropertyType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });			
		addAnnotation
		  (getPropertyType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });			
		addAnnotation
		  (getPropertyType_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });			
		addAnnotation
		  (providesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ProvidesType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getProvidesType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:0"
		   });			
		addAnnotation
		  (getProvidesType_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getProvidesType_Controller(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "controller",
			 "namespace", "##targetNamespace",
			 "group", "#group:0"
		   });			
		addAnnotation
		  (getProvidesType_PostRegistration(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "post-registration"
		   });			
		addAnnotation
		  (getProvidesType_PostUnregistration(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "post-unregistration"
		   });			
		addAnnotation
		  (getProvidesType_Specifications(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "specifications"
		   });			
		addAnnotation
		  (getProvidesType_Strategy(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "strategy"
		   });			
		addAnnotation
		  (requiresTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RequiresType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRequiresType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:7"
		   });			
		addAnnotation
		  (getRequiresType_Callback(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "callback",
			 "namespace", "##targetNamespace",
			 "group", "#group:7"
		   });			
		addAnnotation
		  (getRequiresType_DefaultImplementation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default-implementation"
		   });			
		addAnnotation
		  (getRequiresType_Field(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field"
		   });			
		addAnnotation
		  (getRequiresType_From(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "from"
		   });			
		addAnnotation
		  (getRequiresType_Nullable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "nullable"
		   });			
		addAnnotation
		  (getRequiresType_Proxy(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "proxy"
		   });		
		addAnnotation
		  (getRequiresType_Scope(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "scope"
		   });		
		addAnnotation
		  (rootElementTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RootElementType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (scopeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "scope_._type"
		   });		
		addAnnotation
		  (scopeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "scope_._type:Object",
			 "baseType", "scope_._type"
		   });			
		addAnnotation
		  (serviceControllerTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceControllerType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getServiceControllerType_Field(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "field"
		   });			
		addAnnotation
		  (getServiceControllerType_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });		
		addAnnotation
		  (serviceDependencyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceDependencyType",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getServiceDependencyType_Aggregate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "aggregate"
		   });			
		addAnnotation
		  (getServiceDependencyType_Comparator(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "comparator"
		   });			
		addAnnotation
		  (getServiceDependencyType_Filter(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "filter"
		   });			
		addAnnotation
		  (getServiceDependencyType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });			
		addAnnotation
		  (getServiceDependencyType_Optional(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "optional"
		   });			
		addAnnotation
		  (getServiceDependencyType_Policy(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "policy"
		   });			
		addAnnotation
		  (getServiceDependencyType_Specification(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "specification"
		   });			
		addAnnotation
		  (transitionTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "transition_._type"
		   });		
		addAnnotation
		  (transitionTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "transition_._type:Object",
			 "baseType", "transition_._type"
		   });		
		addAnnotation
		  (typeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "type_._type"
		   });		
		addAnnotation
		  (typeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "type_._type:Object",
			 "baseType", "type_._type"
		   });
	}

} //FelixPackageImpl
