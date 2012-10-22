/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * iPOJO Core XML-Schema. This grammars models iPOJO descriptor using core
 *       features. It provides several extensibility mechanism in order to compose this schema with
 *       external handlers and other component implementation type such as
 *       compositions.
 * <!-- end-model-doc -->
 * @see org.apache.felix.FelixFactory
 * @model kind="package"
 * @generated
 */
public interface FelixPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "felix";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.apache.felix.ipojo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "felix";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FelixPackage eINSTANCE = org.apache.felix.impl.FelixPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.CallbackTypeImpl <em>Callback Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.CallbackTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getCallbackType()
	 * @generated
	 */
	int CALLBACK_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLBACK_TYPE__METHOD = 0;

	/**
	 * The feature id for the '<em><b>Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLBACK_TYPE__TRANSITION = 1;

	/**
	 * The number of structural features of the '<em>Callback Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLBACK_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.ComponentTypeImpl <em>Component Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.ComponentTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getComponentType()
	 * @generated
	 */
	int COMPONENT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Callback</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__CALLBACK = 1;

	/**
	 * The feature id for the '<em><b>Provides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__PROVIDES = 2;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__REQUIRES = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__PROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__CONTROLLER = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ANY = 6;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__ARCHITECTURE = 7;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__CLASSNAME = 8;

	/**
	 * The feature id for the '<em><b>Factory Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__FACTORY_METHOD = 9;

	/**
	 * The feature id for the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__IMMEDIATE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__NAME = 11;

	/**
	 * The feature id for the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__PUBLIC = 12;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE__VERSION = 13;

	/**
	 * The number of structural features of the '<em>Component Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_TYPE_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.ControllerTypeImpl <em>Controller Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.ControllerTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getControllerType()
	 * @generated
	 */
	int CONTROLLER_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE__FIELD = 0;

	/**
	 * The number of structural features of the '<em>Controller Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.DependencyCallbackTypeImpl <em>Dependency Callback Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.DependencyCallbackTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getDependencyCallbackType()
	 * @generated
	 */
	int DEPENDENCY_CALLBACK_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CALLBACK_TYPE__METHOD = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CALLBACK_TYPE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Dependency Callback Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CALLBACK_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.DocumentRootImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Callback</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CALLBACK = 3;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__COMPONENT = 4;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__CONTROLLER = 5;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__HANDLER = 6;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Ipojo</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__IPOJO = 8;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROPERTIES = 9;

	/**
	 * The feature id for the '<em><b>Provides</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROVIDES = 10;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__REQUIRES = 11;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.RootElementTypeImpl <em>Root Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.RootElementTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getRootElementType()
	 * @generated
	 */
	int ROOT_ELEMENT_TYPE = 13;

	/**
	 * The number of structural features of the '<em>Root Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_ELEMENT_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.HandlerTypeImpl <em>Handler Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.HandlerTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getHandlerType()
	 * @generated
	 */
	int HANDLER_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__GROUP = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__ANY = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__ARCHITECTURE = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__CLASSNAME = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__LEVEL = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__NAME = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE__NAMESPACE = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Handler Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDLER_TYPE_FEATURE_COUNT = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.InstancePropertyTypeImpl <em>Instance Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.InstancePropertyTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getInstancePropertyType()
	 * @generated
	 */
	int INSTANCE_PROPERTY_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PROPERTY_TYPE__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PROPERTY_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PROPERTY_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PROPERTY_TYPE__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Instance Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_PROPERTY_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.InstanceTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getInstanceType()
	 * @generated
	 */
	int INSTANCE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE__GROUP = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE__PROPERTY = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE__COMPONENT = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE__NAME = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE__VERSION = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Instance Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_TYPE_FEATURE_COUNT = ROOT_ELEMENT_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.IpojoTypeImpl <em>Ipojo Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.IpojoTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getIpojoType()
	 * @generated
	 */
	int IPOJO_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOJO_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Handler</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOJO_TYPE__HANDLER = 1;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOJO_TYPE__INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOJO_TYPE__COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOJO_TYPE__ANY = 4;

	/**
	 * The number of structural features of the '<em>Ipojo Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IPOJO_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.PropertiesTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getPropertiesType()
	 * @generated
	 */
	int PROPERTIES_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Pid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__PID = 2;

	/**
	 * The feature id for the '<em><b>Propagation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__PROPAGATION = 3;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE__UPDATED = 4;

	/**
	 * The number of structural features of the '<em>Properties Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_TYPE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.PropertyTypeImpl <em>Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.PropertyTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__FIELD = 0;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__MANDATORY = 1;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__METHOD = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__VALUE = 5;

	/**
	 * The number of structural features of the '<em>Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.ProvidesTypeImpl <em>Provides Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.ProvidesTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getProvidesType()
	 * @generated
	 */
	int PROVIDES_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__GROUP = 0;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__CONTROLLER = 2;

	/**
	 * The feature id for the '<em><b>Post Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__POST_REGISTRATION = 3;

	/**
	 * The feature id for the '<em><b>Post Unregistration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__POST_UNREGISTRATION = 4;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__SPECIFICATIONS = 5;

	/**
	 * The feature id for the '<em><b>Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE__STRATEGY = 6;

	/**
	 * The number of structural features of the '<em>Provides Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROVIDES_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.ServiceDependencyTypeImpl <em>Service Dependency Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.ServiceDependencyTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getServiceDependencyType()
	 * @generated
	 */
	int SERVICE_DEPENDENCY_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Aggregate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__AGGREGATE = 0;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__COMPARATOR = 1;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__FILTER = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__ID = 3;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__OPTIONAL = 4;

	/**
	 * The feature id for the '<em><b>Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__POLICY = 5;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE__SPECIFICATION = 6;

	/**
	 * The number of structural features of the '<em>Service Dependency Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.RequiresTypeImpl <em>Requires Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.RequiresTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getRequiresType()
	 * @generated
	 */
	int REQUIRES_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Aggregate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__AGGREGATE = SERVICE_DEPENDENCY_TYPE__AGGREGATE;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__COMPARATOR = SERVICE_DEPENDENCY_TYPE__COMPARATOR;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__FILTER = SERVICE_DEPENDENCY_TYPE__FILTER;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__ID = SERVICE_DEPENDENCY_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__OPTIONAL = SERVICE_DEPENDENCY_TYPE__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__POLICY = SERVICE_DEPENDENCY_TYPE__POLICY;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__SPECIFICATION = SERVICE_DEPENDENCY_TYPE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__GROUP = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Callback</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__CALLBACK = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__DEFAULT_IMPLEMENTATION = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__FIELD = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__FROM = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__NULLABLE = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__PROXY = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE__SCOPE = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Requires Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRES_TYPE_FEATURE_COUNT = SERVICE_DEPENDENCY_TYPE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.apache.felix.impl.ServiceControllerTypeImpl <em>Service Controller Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.impl.ServiceControllerTypeImpl
	 * @see org.apache.felix.impl.FelixPackageImpl#getServiceControllerType()
	 * @generated
	 */
	int SERVICE_CONTROLLER_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTROLLER_TYPE__FIELD = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTROLLER_TYPE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Service Controller Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_CONTROLLER_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.apache.felix.PolicyType <em>Policy Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.PolicyType
	 * @see org.apache.felix.impl.FelixPackageImpl#getPolicyType()
	 * @generated
	 */
	int POLICY_TYPE = 16;

	/**
	 * The meta object id for the '{@link org.apache.felix.ScopeType <em>Scope Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.ScopeType
	 * @see org.apache.felix.impl.FelixPackageImpl#getScopeType()
	 * @generated
	 */
	int SCOPE_TYPE = 17;

	/**
	 * The meta object id for the '{@link org.apache.felix.TransitionType <em>Transition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.TransitionType
	 * @see org.apache.felix.impl.FelixPackageImpl#getTransitionType()
	 * @generated
	 */
	int TRANSITION_TYPE = 18;

	/**
	 * The meta object id for the '{@link org.apache.felix.TypeType <em>Type Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.TypeType
	 * @see org.apache.felix.impl.FelixPackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 19;

	/**
	 * The meta object id for the '<em>Policy Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.PolicyType
	 * @see org.apache.felix.impl.FelixPackageImpl#getPolicyTypeObject()
	 * @generated
	 */
	int POLICY_TYPE_OBJECT = 20;

	/**
	 * The meta object id for the '<em>Scope Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.ScopeType
	 * @see org.apache.felix.impl.FelixPackageImpl#getScopeTypeObject()
	 * @generated
	 */
	int SCOPE_TYPE_OBJECT = 21;

	/**
	 * The meta object id for the '<em>Transition Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.TransitionType
	 * @see org.apache.felix.impl.FelixPackageImpl#getTransitionTypeObject()
	 * @generated
	 */
	int TRANSITION_TYPE_OBJECT = 22;

	/**
	 * The meta object id for the '<em>Type Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.apache.felix.TypeType
	 * @see org.apache.felix.impl.FelixPackageImpl#getTypeTypeObject()
	 * @generated
	 */
	int TYPE_TYPE_OBJECT = 23;


	/**
	 * Returns the meta object for class '{@link org.apache.felix.CallbackType <em>Callback Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Callback Type</em>'.
	 * @see org.apache.felix.CallbackType
	 * @generated
	 */
	EClass getCallbackType();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.CallbackType#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see org.apache.felix.CallbackType#getMethod()
	 * @see #getCallbackType()
	 * @generated
	 */
	EAttribute getCallbackType_Method();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.CallbackType#getTransition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition</em>'.
	 * @see org.apache.felix.CallbackType#getTransition()
	 * @see #getCallbackType()
	 * @generated
	 */
	EAttribute getCallbackType_Transition();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.ComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Type</em>'.
	 * @see org.apache.felix.ComponentType
	 * @generated
	 */
	EClass getComponentType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.ComponentType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.ComponentType#getGroup()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ComponentType#getCallback <em>Callback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Callback</em>'.
	 * @see org.apache.felix.ComponentType#getCallback()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Callback();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ComponentType#getProvides <em>Provides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provides</em>'.
	 * @see org.apache.felix.ComponentType#getProvides()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Provides();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ComponentType#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Requires</em>'.
	 * @see org.apache.felix.ComponentType#getRequires()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Requires();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ComponentType#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.apache.felix.ComponentType#getProperties()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ComponentType#getController <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controller</em>'.
	 * @see org.apache.felix.ComponentType#getController()
	 * @see #getComponentType()
	 * @generated
	 */
	EReference getComponentType_Controller();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.ComponentType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.apache.felix.ComponentType#getAny()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#isArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Architecture</em>'.
	 * @see org.apache.felix.ComponentType#isArchitecture()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Architecture();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.apache.felix.ComponentType#getClassname()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Classname();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#getFactoryMethod <em>Factory Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Factory Method</em>'.
	 * @see org.apache.felix.ComponentType#getFactoryMethod()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_FactoryMethod();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#isImmediate <em>Immediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediate</em>'.
	 * @see org.apache.felix.ComponentType#isImmediate()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Immediate();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.felix.ComponentType#getName()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#isPublic <em>Public</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public</em>'.
	 * @see org.apache.felix.ComponentType#isPublic()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Public();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ComponentType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.apache.felix.ComponentType#getVersion()
	 * @see #getComponentType()
	 * @generated
	 */
	EAttribute getComponentType_Version();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.ControllerType <em>Controller Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Controller Type</em>'.
	 * @see org.apache.felix.ControllerType
	 * @generated
	 */
	EClass getControllerType();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ControllerType#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.apache.felix.ControllerType#getField()
	 * @see #getControllerType()
	 * @generated
	 */
	EAttribute getControllerType_Field();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.DependencyCallbackType <em>Dependency Callback Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Callback Type</em>'.
	 * @see org.apache.felix.DependencyCallbackType
	 * @generated
	 */
	EClass getDependencyCallbackType();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.DependencyCallbackType#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see org.apache.felix.DependencyCallbackType#getMethod()
	 * @see #getDependencyCallbackType()
	 * @generated
	 */
	EAttribute getDependencyCallbackType_Method();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.DependencyCallbackType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.apache.felix.DependencyCallbackType#getType()
	 * @see #getDependencyCallbackType()
	 * @generated
	 */
	EAttribute getDependencyCallbackType_Type();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.apache.felix.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.apache.felix.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.apache.felix.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.apache.felix.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.apache.felix.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.apache.felix.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getCallback <em>Callback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Callback</em>'.
	 * @see org.apache.felix.DocumentRoot#getCallback()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Callback();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component</em>'.
	 * @see org.apache.felix.DocumentRoot#getComponent()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Component();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getController <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Controller</em>'.
	 * @see org.apache.felix.DocumentRoot#getController()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Controller();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Handler</em>'.
	 * @see org.apache.felix.DocumentRoot#getHandler()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Handler();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Instance</em>'.
	 * @see org.apache.felix.DocumentRoot#getInstance()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Instance();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getIpojo <em>Ipojo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ipojo</em>'.
	 * @see org.apache.felix.DocumentRoot#getIpojo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Ipojo();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see org.apache.felix.DocumentRoot#getProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getProvides <em>Provides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Provides</em>'.
	 * @see org.apache.felix.DocumentRoot#getProvides()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Provides();

	/**
	 * Returns the meta object for the containment reference '{@link org.apache.felix.DocumentRoot#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Requires</em>'.
	 * @see org.apache.felix.DocumentRoot#getRequires()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Requires();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.HandlerType <em>Handler Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handler Type</em>'.
	 * @see org.apache.felix.HandlerType
	 * @generated
	 */
	EClass getHandlerType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.HandlerType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.HandlerType#getGroup()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Group();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.HandlerType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.apache.felix.HandlerType#getAny()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.HandlerType#isArchitecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Architecture</em>'.
	 * @see org.apache.felix.HandlerType#isArchitecture()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Architecture();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.HandlerType#getClassname <em>Classname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classname</em>'.
	 * @see org.apache.felix.HandlerType#getClassname()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Classname();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.HandlerType#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.apache.felix.HandlerType#getLevel()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Level();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.HandlerType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.felix.HandlerType#getName()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.HandlerType#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.apache.felix.HandlerType#getNamespace()
	 * @see #getHandlerType()
	 * @generated
	 */
	EAttribute getHandlerType_Namespace();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.InstancePropertyType <em>Instance Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Property Type</em>'.
	 * @see org.apache.felix.InstancePropertyType
	 * @generated
	 */
	EClass getInstancePropertyType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.InstancePropertyType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.apache.felix.InstancePropertyType#getProperty()
	 * @see #getInstancePropertyType()
	 * @generated
	 */
	EReference getInstancePropertyType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.InstancePropertyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.felix.InstancePropertyType#getName()
	 * @see #getInstancePropertyType()
	 * @generated
	 */
	EAttribute getInstancePropertyType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.InstancePropertyType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.apache.felix.InstancePropertyType#getType()
	 * @see #getInstancePropertyType()
	 * @generated
	 */
	EAttribute getInstancePropertyType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.InstancePropertyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.apache.felix.InstancePropertyType#getValue()
	 * @see #getInstancePropertyType()
	 * @generated
	 */
	EAttribute getInstancePropertyType_Value();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.InstanceType <em>Instance Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Type</em>'.
	 * @see org.apache.felix.InstanceType
	 * @generated
	 */
	EClass getInstanceType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.InstanceType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.InstanceType#getGroup()
	 * @see #getInstanceType()
	 * @generated
	 */
	EAttribute getInstanceType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.InstanceType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.apache.felix.InstanceType#getProperty()
	 * @see #getInstanceType()
	 * @generated
	 */
	EReference getInstanceType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.InstanceType#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component</em>'.
	 * @see org.apache.felix.InstanceType#getComponent()
	 * @see #getInstanceType()
	 * @generated
	 */
	EAttribute getInstanceType_Component();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.InstanceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.felix.InstanceType#getName()
	 * @see #getInstanceType()
	 * @generated
	 */
	EAttribute getInstanceType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.InstanceType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.apache.felix.InstanceType#getVersion()
	 * @see #getInstanceType()
	 * @generated
	 */
	EAttribute getInstanceType_Version();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.IpojoType <em>Ipojo Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ipojo Type</em>'.
	 * @see org.apache.felix.IpojoType
	 * @generated
	 */
	EClass getIpojoType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.IpojoType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.IpojoType#getGroup()
	 * @see #getIpojoType()
	 * @generated
	 */
	EAttribute getIpojoType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.IpojoType#getHandler <em>Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Handler</em>'.
	 * @see org.apache.felix.IpojoType#getHandler()
	 * @see #getIpojoType()
	 * @generated
	 */
	EReference getIpojoType_Handler();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.IpojoType#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance</em>'.
	 * @see org.apache.felix.IpojoType#getInstance()
	 * @see #getIpojoType()
	 * @generated
	 */
	EReference getIpojoType_Instance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.IpojoType#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component</em>'.
	 * @see org.apache.felix.IpojoType#getComponent()
	 * @see #getIpojoType()
	 * @generated
	 */
	EReference getIpojoType_Component();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.IpojoType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.apache.felix.IpojoType#getAny()
	 * @see #getIpojoType()
	 * @generated
	 */
	EAttribute getIpojoType_Any();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.PropertiesType <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties Type</em>'.
	 * @see org.apache.felix.PropertiesType
	 * @generated
	 */
	EClass getPropertiesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.PropertiesType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.PropertiesType#getGroup()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.PropertiesType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.apache.felix.PropertiesType#getProperty()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EReference getPropertiesType_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertiesType#getPid <em>Pid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pid</em>'.
	 * @see org.apache.felix.PropertiesType#getPid()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_Pid();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertiesType#isPropagation <em>Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagation</em>'.
	 * @see org.apache.felix.PropertiesType#isPropagation()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_Propagation();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertiesType#getUpdated <em>Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated</em>'.
	 * @see org.apache.felix.PropertiesType#getUpdated()
	 * @see #getPropertiesType()
	 * @generated
	 */
	EAttribute getPropertiesType_Updated();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Type</em>'.
	 * @see org.apache.felix.PropertyType
	 * @generated
	 */
	EClass getPropertyType();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertyType#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.apache.felix.PropertyType#getField()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Field();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertyType#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see org.apache.felix.PropertyType#isMandatory()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Mandatory();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertyType#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see org.apache.felix.PropertyType#getMethod()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Method();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.apache.felix.PropertyType#getName()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertyType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.apache.felix.PropertyType#getType()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.PropertyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.apache.felix.PropertyType#getValue()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Value();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.ProvidesType <em>Provides Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Provides Type</em>'.
	 * @see org.apache.felix.ProvidesType
	 * @generated
	 */
	EClass getProvidesType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.ProvidesType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.ProvidesType#getGroup()
	 * @see #getProvidesType()
	 * @generated
	 */
	EAttribute getProvidesType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ProvidesType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.apache.felix.ProvidesType#getProperty()
	 * @see #getProvidesType()
	 * @generated
	 */
	EReference getProvidesType_Property();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.ProvidesType#getController <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controller</em>'.
	 * @see org.apache.felix.ProvidesType#getController()
	 * @see #getProvidesType()
	 * @generated
	 */
	EReference getProvidesType_Controller();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ProvidesType#getPostRegistration <em>Post Registration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Registration</em>'.
	 * @see org.apache.felix.ProvidesType#getPostRegistration()
	 * @see #getProvidesType()
	 * @generated
	 */
	EAttribute getProvidesType_PostRegistration();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ProvidesType#getPostUnregistration <em>Post Unregistration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Unregistration</em>'.
	 * @see org.apache.felix.ProvidesType#getPostUnregistration()
	 * @see #getProvidesType()
	 * @generated
	 */
	EAttribute getProvidesType_PostUnregistration();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ProvidesType#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specifications</em>'.
	 * @see org.apache.felix.ProvidesType#getSpecifications()
	 * @see #getProvidesType()
	 * @generated
	 */
	EAttribute getProvidesType_Specifications();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ProvidesType#getStrategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strategy</em>'.
	 * @see org.apache.felix.ProvidesType#getStrategy()
	 * @see #getProvidesType()
	 * @generated
	 */
	EAttribute getProvidesType_Strategy();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.RequiresType <em>Requires Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requires Type</em>'.
	 * @see org.apache.felix.RequiresType
	 * @generated
	 */
	EClass getRequiresType();

	/**
	 * Returns the meta object for the attribute list '{@link org.apache.felix.RequiresType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see org.apache.felix.RequiresType#getGroup()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link org.apache.felix.RequiresType#getCallback <em>Callback</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Callback</em>'.
	 * @see org.apache.felix.RequiresType#getCallback()
	 * @see #getRequiresType()
	 * @generated
	 */
	EReference getRequiresType_Callback();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.RequiresType#getDefaultImplementation <em>Default Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Implementation</em>'.
	 * @see org.apache.felix.RequiresType#getDefaultImplementation()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_DefaultImplementation();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.RequiresType#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.apache.felix.RequiresType#getField()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_Field();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.RequiresType#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see org.apache.felix.RequiresType#getFrom()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_From();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.RequiresType#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see org.apache.felix.RequiresType#isNullable()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_Nullable();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.RequiresType#isProxy <em>Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy</em>'.
	 * @see org.apache.felix.RequiresType#isProxy()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_Proxy();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.RequiresType#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see org.apache.felix.RequiresType#getScope()
	 * @see #getRequiresType()
	 * @generated
	 */
	EAttribute getRequiresType_Scope();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.RootElementType <em>Root Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Element Type</em>'.
	 * @see org.apache.felix.RootElementType
	 * @generated
	 */
	EClass getRootElementType();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.ServiceControllerType <em>Service Controller Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Controller Type</em>'.
	 * @see org.apache.felix.ServiceControllerType
	 * @generated
	 */
	EClass getServiceControllerType();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceControllerType#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field</em>'.
	 * @see org.apache.felix.ServiceControllerType#getField()
	 * @see #getServiceControllerType()
	 * @generated
	 */
	EAttribute getServiceControllerType_Field();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceControllerType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.apache.felix.ServiceControllerType#getValue()
	 * @see #getServiceControllerType()
	 * @generated
	 */
	EAttribute getServiceControllerType_Value();

	/**
	 * Returns the meta object for class '{@link org.apache.felix.ServiceDependencyType <em>Service Dependency Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Dependency Type</em>'.
	 * @see org.apache.felix.ServiceDependencyType
	 * @generated
	 */
	EClass getServiceDependencyType();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#isAggregate <em>Aggregate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregate</em>'.
	 * @see org.apache.felix.ServiceDependencyType#isAggregate()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Aggregate();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#getComparator <em>Comparator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comparator</em>'.
	 * @see org.apache.felix.ServiceDependencyType#getComparator()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Comparator();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.apache.felix.ServiceDependencyType#getFilter()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.apache.felix.ServiceDependencyType#getId()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.apache.felix.ServiceDependencyType#isOptional()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Optional();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#getPolicy <em>Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Policy</em>'.
	 * @see org.apache.felix.ServiceDependencyType#getPolicy()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Policy();

	/**
	 * Returns the meta object for the attribute '{@link org.apache.felix.ServiceDependencyType#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see org.apache.felix.ServiceDependencyType#getSpecification()
	 * @see #getServiceDependencyType()
	 * @generated
	 */
	EAttribute getServiceDependencyType_Specification();

	/**
	 * Returns the meta object for enum '{@link org.apache.felix.PolicyType <em>Policy Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Policy Type</em>'.
	 * @see org.apache.felix.PolicyType
	 * @generated
	 */
	EEnum getPolicyType();

	/**
	 * Returns the meta object for enum '{@link org.apache.felix.ScopeType <em>Scope Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scope Type</em>'.
	 * @see org.apache.felix.ScopeType
	 * @generated
	 */
	EEnum getScopeType();

	/**
	 * Returns the meta object for enum '{@link org.apache.felix.TransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Type</em>'.
	 * @see org.apache.felix.TransitionType
	 * @generated
	 */
	EEnum getTransitionType();

	/**
	 * Returns the meta object for enum '{@link org.apache.felix.TypeType <em>Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Type</em>'.
	 * @see org.apache.felix.TypeType
	 * @generated
	 */
	EEnum getTypeType();

	/**
	 * Returns the meta object for data type '{@link org.apache.felix.PolicyType <em>Policy Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Policy Type Object</em>'.
	 * @see org.apache.felix.PolicyType
	 * @model instanceClass="org.apache.felix.PolicyType"
	 *        extendedMetaData="name='policy_._type:Object' baseType='policy_._type'"
	 * @generated
	 */
	EDataType getPolicyTypeObject();

	/**
	 * Returns the meta object for data type '{@link org.apache.felix.ScopeType <em>Scope Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Scope Type Object</em>'.
	 * @see org.apache.felix.ScopeType
	 * @model instanceClass="org.apache.felix.ScopeType"
	 *        extendedMetaData="name='scope_._type:Object' baseType='scope_._type'"
	 * @generated
	 */
	EDataType getScopeTypeObject();

	/**
	 * Returns the meta object for data type '{@link org.apache.felix.TransitionType <em>Transition Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Transition Type Object</em>'.
	 * @see org.apache.felix.TransitionType
	 * @model instanceClass="org.apache.felix.TransitionType"
	 *        extendedMetaData="name='transition_._type:Object' baseType='transition_._type'"
	 * @generated
	 */
	EDataType getTransitionTypeObject();

	/**
	 * Returns the meta object for data type '{@link org.apache.felix.TypeType <em>Type Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Type Object</em>'.
	 * @see org.apache.felix.TypeType
	 * @model instanceClass="org.apache.felix.TypeType"
	 *        extendedMetaData="name='type_._type:Object' baseType='type_._type'"
	 * @generated
	 */
	EDataType getTypeTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FelixFactory getFelixFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.CallbackTypeImpl <em>Callback Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.CallbackTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getCallbackType()
		 * @generated
		 */
		EClass CALLBACK_TYPE = eINSTANCE.getCallbackType();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLBACK_TYPE__METHOD = eINSTANCE.getCallbackType_Method();

		/**
		 * The meta object literal for the '<em><b>Transition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CALLBACK_TYPE__TRANSITION = eINSTANCE.getCallbackType_Transition();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.ComponentTypeImpl <em>Component Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.ComponentTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getComponentType()
		 * @generated
		 */
		EClass COMPONENT_TYPE = eINSTANCE.getComponentType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__GROUP = eINSTANCE.getComponentType_Group();

		/**
		 * The meta object literal for the '<em><b>Callback</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__CALLBACK = eINSTANCE.getComponentType_Callback();

		/**
		 * The meta object literal for the '<em><b>Provides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__PROVIDES = eINSTANCE.getComponentType_Provides();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__REQUIRES = eINSTANCE.getComponentType_Requires();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__PROPERTIES = eINSTANCE.getComponentType_Properties();

		/**
		 * The meta object literal for the '<em><b>Controller</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_TYPE__CONTROLLER = eINSTANCE.getComponentType_Controller();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__ANY = eINSTANCE.getComponentType_Any();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__ARCHITECTURE = eINSTANCE.getComponentType_Architecture();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__CLASSNAME = eINSTANCE.getComponentType_Classname();

		/**
		 * The meta object literal for the '<em><b>Factory Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__FACTORY_METHOD = eINSTANCE.getComponentType_FactoryMethod();

		/**
		 * The meta object literal for the '<em><b>Immediate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__IMMEDIATE = eINSTANCE.getComponentType_Immediate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__NAME = eINSTANCE.getComponentType_Name();

		/**
		 * The meta object literal for the '<em><b>Public</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__PUBLIC = eINSTANCE.getComponentType_Public();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_TYPE__VERSION = eINSTANCE.getComponentType_Version();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.ControllerTypeImpl <em>Controller Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.ControllerTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getControllerType()
		 * @generated
		 */
		EClass CONTROLLER_TYPE = eINSTANCE.getControllerType();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROLLER_TYPE__FIELD = eINSTANCE.getControllerType_Field();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.DependencyCallbackTypeImpl <em>Dependency Callback Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.DependencyCallbackTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getDependencyCallbackType()
		 * @generated
		 */
		EClass DEPENDENCY_CALLBACK_TYPE = eINSTANCE.getDependencyCallbackType();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_CALLBACK_TYPE__METHOD = eINSTANCE.getDependencyCallbackType_Method();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_CALLBACK_TYPE__TYPE = eINSTANCE.getDependencyCallbackType_Type();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.DocumentRootImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Callback</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CALLBACK = eINSTANCE.getDocumentRoot_Callback();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__COMPONENT = eINSTANCE.getDocumentRoot_Component();

		/**
		 * The meta object literal for the '<em><b>Controller</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__CONTROLLER = eINSTANCE.getDocumentRoot_Controller();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__HANDLER = eINSTANCE.getDocumentRoot_Handler();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__INSTANCE = eINSTANCE.getDocumentRoot_Instance();

		/**
		 * The meta object literal for the '<em><b>Ipojo</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__IPOJO = eINSTANCE.getDocumentRoot_Ipojo();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROPERTIES = eINSTANCE.getDocumentRoot_Properties();

		/**
		 * The meta object literal for the '<em><b>Provides</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROVIDES = eINSTANCE.getDocumentRoot_Provides();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__REQUIRES = eINSTANCE.getDocumentRoot_Requires();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.HandlerTypeImpl <em>Handler Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.HandlerTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getHandlerType()
		 * @generated
		 */
		EClass HANDLER_TYPE = eINSTANCE.getHandlerType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__GROUP = eINSTANCE.getHandlerType_Group();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__ANY = eINSTANCE.getHandlerType_Any();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__ARCHITECTURE = eINSTANCE.getHandlerType_Architecture();

		/**
		 * The meta object literal for the '<em><b>Classname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__CLASSNAME = eINSTANCE.getHandlerType_Classname();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__LEVEL = eINSTANCE.getHandlerType_Level();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__NAME = eINSTANCE.getHandlerType_Name();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDLER_TYPE__NAMESPACE = eINSTANCE.getHandlerType_Namespace();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.InstancePropertyTypeImpl <em>Instance Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.InstancePropertyTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getInstancePropertyType()
		 * @generated
		 */
		EClass INSTANCE_PROPERTY_TYPE = eINSTANCE.getInstancePropertyType();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_PROPERTY_TYPE__PROPERTY = eINSTANCE.getInstancePropertyType_Property();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_PROPERTY_TYPE__NAME = eINSTANCE.getInstancePropertyType_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_PROPERTY_TYPE__TYPE = eINSTANCE.getInstancePropertyType_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_PROPERTY_TYPE__VALUE = eINSTANCE.getInstancePropertyType_Value();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.InstanceTypeImpl <em>Instance Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.InstanceTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getInstanceType()
		 * @generated
		 */
		EClass INSTANCE_TYPE = eINSTANCE.getInstanceType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_TYPE__GROUP = eINSTANCE.getInstanceType_Group();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_TYPE__PROPERTY = eINSTANCE.getInstanceType_Property();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_TYPE__COMPONENT = eINSTANCE.getInstanceType_Component();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_TYPE__NAME = eINSTANCE.getInstanceType_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_TYPE__VERSION = eINSTANCE.getInstanceType_Version();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.IpojoTypeImpl <em>Ipojo Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.IpojoTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getIpojoType()
		 * @generated
		 */
		EClass IPOJO_TYPE = eINSTANCE.getIpojoType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPOJO_TYPE__GROUP = eINSTANCE.getIpojoType_Group();

		/**
		 * The meta object literal for the '<em><b>Handler</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPOJO_TYPE__HANDLER = eINSTANCE.getIpojoType_Handler();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPOJO_TYPE__INSTANCE = eINSTANCE.getIpojoType_Instance();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IPOJO_TYPE__COMPONENT = eINSTANCE.getIpojoType_Component();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IPOJO_TYPE__ANY = eINSTANCE.getIpojoType_Any();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.PropertiesTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getPropertiesType()
		 * @generated
		 */
		EClass PROPERTIES_TYPE = eINSTANCE.getPropertiesType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__GROUP = eINSTANCE.getPropertiesType_Group();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTIES_TYPE__PROPERTY = eINSTANCE.getPropertiesType_Property();

		/**
		 * The meta object literal for the '<em><b>Pid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__PID = eINSTANCE.getPropertiesType_Pid();

		/**
		 * The meta object literal for the '<em><b>Propagation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__PROPAGATION = eINSTANCE.getPropertiesType_Propagation();

		/**
		 * The meta object literal for the '<em><b>Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_TYPE__UPDATED = eINSTANCE.getPropertiesType_Updated();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.PropertyTypeImpl <em>Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.PropertyTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getPropertyType()
		 * @generated
		 */
		EClass PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__FIELD = eINSTANCE.getPropertyType_Field();

		/**
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__MANDATORY = eINSTANCE.getPropertyType_Mandatory();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__METHOD = eINSTANCE.getPropertyType_Method();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__NAME = eINSTANCE.getPropertyType_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__TYPE = eINSTANCE.getPropertyType_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__VALUE = eINSTANCE.getPropertyType_Value();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.ProvidesTypeImpl <em>Provides Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.ProvidesTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getProvidesType()
		 * @generated
		 */
		EClass PROVIDES_TYPE = eINSTANCE.getProvidesType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDES_TYPE__GROUP = eINSTANCE.getProvidesType_Group();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDES_TYPE__PROPERTY = eINSTANCE.getProvidesType_Property();

		/**
		 * The meta object literal for the '<em><b>Controller</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROVIDES_TYPE__CONTROLLER = eINSTANCE.getProvidesType_Controller();

		/**
		 * The meta object literal for the '<em><b>Post Registration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDES_TYPE__POST_REGISTRATION = eINSTANCE.getProvidesType_PostRegistration();

		/**
		 * The meta object literal for the '<em><b>Post Unregistration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDES_TYPE__POST_UNREGISTRATION = eINSTANCE.getProvidesType_PostUnregistration();

		/**
		 * The meta object literal for the '<em><b>Specifications</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDES_TYPE__SPECIFICATIONS = eINSTANCE.getProvidesType_Specifications();

		/**
		 * The meta object literal for the '<em><b>Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROVIDES_TYPE__STRATEGY = eINSTANCE.getProvidesType_Strategy();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.RequiresTypeImpl <em>Requires Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.RequiresTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getRequiresType()
		 * @generated
		 */
		EClass REQUIRES_TYPE = eINSTANCE.getRequiresType();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__GROUP = eINSTANCE.getRequiresType_Group();

		/**
		 * The meta object literal for the '<em><b>Callback</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIRES_TYPE__CALLBACK = eINSTANCE.getRequiresType_Callback();

		/**
		 * The meta object literal for the '<em><b>Default Implementation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__DEFAULT_IMPLEMENTATION = eINSTANCE.getRequiresType_DefaultImplementation();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__FIELD = eINSTANCE.getRequiresType_Field();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__FROM = eINSTANCE.getRequiresType_From();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__NULLABLE = eINSTANCE.getRequiresType_Nullable();

		/**
		 * The meta object literal for the '<em><b>Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__PROXY = eINSTANCE.getRequiresType_Proxy();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRES_TYPE__SCOPE = eINSTANCE.getRequiresType_Scope();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.RootElementTypeImpl <em>Root Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.RootElementTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getRootElementType()
		 * @generated
		 */
		EClass ROOT_ELEMENT_TYPE = eINSTANCE.getRootElementType();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.ServiceControllerTypeImpl <em>Service Controller Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.ServiceControllerTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getServiceControllerType()
		 * @generated
		 */
		EClass SERVICE_CONTROLLER_TYPE = eINSTANCE.getServiceControllerType();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CONTROLLER_TYPE__FIELD = eINSTANCE.getServiceControllerType_Field();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_CONTROLLER_TYPE__VALUE = eINSTANCE.getServiceControllerType_Value();

		/**
		 * The meta object literal for the '{@link org.apache.felix.impl.ServiceDependencyTypeImpl <em>Service Dependency Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.impl.ServiceDependencyTypeImpl
		 * @see org.apache.felix.impl.FelixPackageImpl#getServiceDependencyType()
		 * @generated
		 */
		EClass SERVICE_DEPENDENCY_TYPE = eINSTANCE.getServiceDependencyType();

		/**
		 * The meta object literal for the '<em><b>Aggregate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__AGGREGATE = eINSTANCE.getServiceDependencyType_Aggregate();

		/**
		 * The meta object literal for the '<em><b>Comparator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__COMPARATOR = eINSTANCE.getServiceDependencyType_Comparator();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__FILTER = eINSTANCE.getServiceDependencyType_Filter();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__ID = eINSTANCE.getServiceDependencyType_Id();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__OPTIONAL = eINSTANCE.getServiceDependencyType_Optional();

		/**
		 * The meta object literal for the '<em><b>Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__POLICY = eINSTANCE.getServiceDependencyType_Policy();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_DEPENDENCY_TYPE__SPECIFICATION = eINSTANCE.getServiceDependencyType_Specification();

		/**
		 * The meta object literal for the '{@link org.apache.felix.PolicyType <em>Policy Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.PolicyType
		 * @see org.apache.felix.impl.FelixPackageImpl#getPolicyType()
		 * @generated
		 */
		EEnum POLICY_TYPE = eINSTANCE.getPolicyType();

		/**
		 * The meta object literal for the '{@link org.apache.felix.ScopeType <em>Scope Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.ScopeType
		 * @see org.apache.felix.impl.FelixPackageImpl#getScopeType()
		 * @generated
		 */
		EEnum SCOPE_TYPE = eINSTANCE.getScopeType();

		/**
		 * The meta object literal for the '{@link org.apache.felix.TransitionType <em>Transition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.TransitionType
		 * @see org.apache.felix.impl.FelixPackageImpl#getTransitionType()
		 * @generated
		 */
		EEnum TRANSITION_TYPE = eINSTANCE.getTransitionType();

		/**
		 * The meta object literal for the '{@link org.apache.felix.TypeType <em>Type Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.TypeType
		 * @see org.apache.felix.impl.FelixPackageImpl#getTypeType()
		 * @generated
		 */
		EEnum TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '<em>Policy Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.PolicyType
		 * @see org.apache.felix.impl.FelixPackageImpl#getPolicyTypeObject()
		 * @generated
		 */
		EDataType POLICY_TYPE_OBJECT = eINSTANCE.getPolicyTypeObject();

		/**
		 * The meta object literal for the '<em>Scope Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.ScopeType
		 * @see org.apache.felix.impl.FelixPackageImpl#getScopeTypeObject()
		 * @generated
		 */
		EDataType SCOPE_TYPE_OBJECT = eINSTANCE.getScopeTypeObject();

		/**
		 * The meta object literal for the '<em>Transition Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.TransitionType
		 * @see org.apache.felix.impl.FelixPackageImpl#getTransitionTypeObject()
		 * @generated
		 */
		EDataType TRANSITION_TYPE_OBJECT = eINSTANCE.getTransitionTypeObject();

		/**
		 * The meta object literal for the '<em>Type Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.apache.felix.TypeType
		 * @see org.apache.felix.impl.FelixPackageImpl#getTypeTypeObject()
		 * @generated
		 */
		EDataType TYPE_TYPE_OBJECT = eINSTANCE.getTypeTypeObject();

	}

} //FelixPackage
