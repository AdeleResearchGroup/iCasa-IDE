/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Declares an atomic (i.e. primitive) component type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.ComponentType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getCallback <em>Callback</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getProvides <em>Provides</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getController <em>Controller</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#isArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getFactoryMethod <em>Factory Method</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#isImmediate <em>Immediate</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#isPublic <em>Public</em>}</li>
 *   <li>{@link org.apache.felix.ComponentType#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getComponentType()
 * @model extendedMetaData="name='ComponentType' kind='elementOnly'"
 * @generated
 */
public interface ComponentType extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Callback</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.CallbackType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the method(s) to invoke when the component's state
	 *             changes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Callback</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Callback()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='callback' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<CallbackType> getCallback();

	/**
	 * Returns the value of the '<em><b>Provides</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.ProvidesType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates the component provided service(s). By default, all implemented
	 *             interfaces are published.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Provides</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Provides()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='provides' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<ProvidesType> getProvides();

	/**
	 * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.RequiresType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates the service requirements of the component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Requires</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Requires()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='requires' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<RequiresType> getRequires();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.PropertiesType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Describes the properties of the component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Properties()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='properties' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<PropertiesType> getProperties();

	/**
	 * Returns the value of the '<em><b>Controller</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.ControllerType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Lifecycle controller for this component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Controller</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Controller()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='controller' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<ControllerType> getController();

	/**
	 * Returns the value of the '<em><b>Any</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute list.
	 * @see org.apache.felix.FelixPackage#getComponentType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':6' processing='lax' group='#group:0'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enables or disables the architecture exposition. By default, the
	 *           architecture is exposed. This allows instance introspection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see #isSetArchitecture()
	 * @see #unsetArchitecture()
	 * @see #setArchitecture(boolean)
	 * @see org.apache.felix.FelixPackage#getComponentType_Architecture()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='architecture'"
	 * @generated
	 */
	boolean isArchitecture();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#isArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see #isSetArchitecture()
	 * @see #unsetArchitecture()
	 * @see #isArchitecture()
	 * @generated
	 */
	void setArchitecture(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.ComponentType#isArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArchitecture()
	 * @see #isArchitecture()
	 * @see #setArchitecture(boolean)
	 * @generated
	 */
	void unsetArchitecture();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.ComponentType#isArchitecture <em>Architecture</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Architecture</em>' attribute is set.
	 * @see #unsetArchitecture()
	 * @see #isArchitecture()
	 * @see #setArchitecture(boolean)
	 * @generated
	 */
	boolean isSetArchitecture();

	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the implementation class of the component
	 *           type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.apache.felix.FelixPackage#getComponentType_Classname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='classname'"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Factory Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Factory method called to create POJO objects instead of the constructor.
	 *           The specified method must be a static method of the implementation class returning an
	 *           instance of this implementation class. The factory method can receive the bundle context
	 *           in argument.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Factory Method</em>' attribute.
	 * @see #setFactoryMethod(String)
	 * @see org.apache.felix.FelixPackage#getComponentType_FactoryMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='factory-method'"
	 * @generated
	 */
	String getFactoryMethod();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#getFactoryMethod <em>Factory Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory Method</em>' attribute.
	 * @see #getFactoryMethod()
	 * @generated
	 */
	void setFactoryMethod(String value);

	/**
	 * Returns the value of the '<em><b>Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates the object of the component implementation type as soon as the
	 *           component instance becomes valid. The default value is "true" if the component doesn't
	 *           provide any service, "false" otherwise.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Immediate</em>' attribute.
	 * @see #isSetImmediate()
	 * @see #unsetImmediate()
	 * @see #setImmediate(boolean)
	 * @see org.apache.felix.FelixPackage#getComponentType_Immediate()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='immediate'"
	 * @generated
	 */
	boolean isImmediate();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#isImmediate <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediate</em>' attribute.
	 * @see #isSetImmediate()
	 * @see #unsetImmediate()
	 * @see #isImmediate()
	 * @generated
	 */
	void setImmediate(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.ComponentType#isImmediate <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetImmediate()
	 * @see #isImmediate()
	 * @see #setImmediate(boolean)
	 * @generated
	 */
	void unsetImmediate();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.ComponentType#isImmediate <em>Immediate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Immediate</em>' attribute is set.
	 * @see #unsetImmediate()
	 * @see #isImmediate()
	 * @see #setImmediate(boolean)
	 * @generated
	 */
	boolean isSetImmediate();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the name of the component type. This name is used to identify
	 *           the factory attached to this type. If not specified, the factory name is the
	 *           implementation class name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.apache.felix.FelixPackage#getComponentType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Public</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines if the component type is public or private. A public factory
	 *           (default) can be used from any bundles.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Public</em>' attribute.
	 * @see #isSetPublic()
	 * @see #unsetPublic()
	 * @see #setPublic(boolean)
	 * @see org.apache.felix.FelixPackage#getComponentType_Public()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='public'"
	 * @generated
	 */
	boolean isPublic();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#isPublic <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public</em>' attribute.
	 * @see #isSetPublic()
	 * @see #unsetPublic()
	 * @see #isPublic()
	 * @generated
	 */
	void setPublic(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.ComponentType#isPublic <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPublic()
	 * @see #isPublic()
	 * @see #setPublic(boolean)
	 * @generated
	 */
	void unsetPublic();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.ComponentType#isPublic <em>Public</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Public</em>' attribute is set.
	 * @see #unsetPublic()
	 * @see #isPublic()
	 * @see #setPublic(boolean)
	 * @generated
	 */
	boolean isSetPublic();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Set the version of this component type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.apache.felix.FelixPackage#getComponentType_Version()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='version'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.apache.felix.ComponentType#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // ComponentType
