/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requires Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Description of component services requirements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.RequiresType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#getCallback <em>Callback</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#getDefaultImplementation <em>Default Implementation</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#getField <em>Field</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#getFrom <em>From</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#isProxy <em>Proxy</em>}</li>
 *   <li>{@link org.apache.felix.RequiresType#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getRequiresType()
 * @model extendedMetaData="name='RequiresType' kind='elementOnly'"
 * @generated
 */
public interface RequiresType extends ServiceDependencyType {
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
	 * @see org.apache.felix.FelixPackage#getRequiresType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:7'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Callback</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.DependencyCallbackType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Service requirement method invocation description. Here can be
	 *                 specified a bind method called when a service appears and an unbind method called
	 *                 when a service disappears.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Callback</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getRequiresType_Callback()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='callback' namespace='##targetNamespace' group='#group:7'"
	 * @generated
	 */
	EList<DependencyCallbackType> getCallback();

	/**
	 * Returns the value of the '<em><b>Default Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the default implementation class for an optional service
	 *               dependency. If no providers are found, iPOJO creates an instance of the
	 *               default-implementation (nullary constructor) and injects it. The given class must
	 *               implement the required service interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Implementation</em>' attribute.
	 * @see #setDefaultImplementation(String)
	 * @see org.apache.felix.FelixPackage#getRequiresType_DefaultImplementation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='default-implementation'"
	 * @generated
	 */
	String getDefaultImplementation();

	/**
	 * Sets the value of the '{@link org.apache.felix.RequiresType#getDefaultImplementation <em>Default Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Implementation</em>' attribute.
	 * @see #getDefaultImplementation()
	 * @generated
	 */
	void setDefaultImplementation(String value);

	/**
	 * Returns the value of the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the field representing the service dependency in the
	 *               implementation class.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Field</em>' attribute.
	 * @see #setField(String)
	 * @see org.apache.felix.FelixPackage#getRequiresType_Field()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='field'"
	 * @generated
	 */
	String getField();

	/**
	 * Sets the value of the '{@link org.apache.felix.RequiresType#getField <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' attribute.
	 * @see #getField()
	 * @generated
	 */
	void setField(String value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specific service provider. The dependency can only be fulfilled by the
	 *               component with the matching name, or by the service with a matching
	 *               PID.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(String)
	 * @see org.apache.felix.FelixPackage#getRequiresType_From()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='from'"
	 * @generated
	 */
	String getFrom();

	/**
	 * Sets the value of the '{@link org.apache.felix.RequiresType#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(String value);

	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enable or disable the Nullable pattern on optional service
	 *               dependencies. By default, Nullable pattern is enabled. If disabled, iPOJO will inject
	 *               null instead of a Nullable object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #isSetNullable()
	 * @see #unsetNullable()
	 * @see #setNullable(boolean)
	 * @see org.apache.felix.FelixPackage#getRequiresType_Nullable()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='nullable'"
	 * @generated
	 */
	boolean isNullable();

	/**
	 * Sets the value of the '{@link org.apache.felix.RequiresType#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isSetNullable()
	 * @see #unsetNullable()
	 * @see #isNullable()
	 * @generated
	 */
	void setNullable(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.RequiresType#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNullable()
	 * @see #isNullable()
	 * @see #setNullable(boolean)
	 * @generated
	 */
	void unsetNullable();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.RequiresType#isNullable <em>Nullable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nullable</em>' attribute is set.
	 * @see #unsetNullable()
	 * @see #isNullable()
	 * @see #setNullable(boolean)
	 * @generated
	 */
	boolean isSetNullable();

	/**
	 * Returns the value of the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enables or Disable the proxy injection (on field
	 *               injection)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Proxy</em>' attribute.
	 * @see #isSetProxy()
	 * @see #unsetProxy()
	 * @see #setProxy(boolean)
	 * @see org.apache.felix.FelixPackage#getRequiresType_Proxy()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='proxy'"
	 * @generated
	 */
	boolean isProxy();

	/**
	 * Sets the value of the '{@link org.apache.felix.RequiresType#isProxy <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy</em>' attribute.
	 * @see #isSetProxy()
	 * @see #unsetProxy()
	 * @see #isProxy()
	 * @generated
	 */
	void setProxy(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.RequiresType#isProxy <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProxy()
	 * @see #isProxy()
	 * @see #setProxy(boolean)
	 * @generated
	 */
	void unsetProxy();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.RequiresType#isProxy <em>Proxy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Proxy</em>' attribute is set.
	 * @see #unsetProxy()
	 * @see #isProxy()
	 * @see #setProxy(boolean)
	 * @generated
	 */
	boolean isSetProxy();

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.apache.felix.ScopeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see org.apache.felix.ScopeType
	 * @see #isSetScope()
	 * @see #unsetScope()
	 * @see #setScope(ScopeType)
	 * @see org.apache.felix.FelixPackage#getRequiresType_Scope()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='scope'"
	 * @generated
	 */
	ScopeType getScope();

	/**
	 * Sets the value of the '{@link org.apache.felix.RequiresType#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see org.apache.felix.ScopeType
	 * @see #isSetScope()
	 * @see #unsetScope()
	 * @see #getScope()
	 * @generated
	 */
	void setScope(ScopeType value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.RequiresType#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScope()
	 * @see #getScope()
	 * @see #setScope(ScopeType)
	 * @generated
	 */
	void unsetScope();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.RequiresType#getScope <em>Scope</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scope</em>' attribute is set.
	 * @see #unsetScope()
	 * @see #getScope()
	 * @see #setScope(ScopeType)
	 * @generated
	 */
	boolean isSetScope();

} // RequiresType
