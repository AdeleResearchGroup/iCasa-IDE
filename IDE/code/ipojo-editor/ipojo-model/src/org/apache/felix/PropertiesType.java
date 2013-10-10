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
 * A representation of the model object '<em><b>Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * List of component, instance or service properties. This field will receive
 *         the property value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.PropertiesType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.PropertiesType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.apache.felix.PropertiesType#getPid <em>Pid</em>}</li>
 *   <li>{@link org.apache.felix.PropertiesType#isPropagation <em>Propagation</em>}</li>
 *   <li>{@link org.apache.felix.PropertiesType#getUpdated <em>Updated</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getPropertiesType()
 * @model extendedMetaData="name='PropertiesType' kind='elementOnly'"
 * @generated
 */
public interface PropertiesType extends EObject {
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
	 * @see org.apache.felix.FelixPackage#getPropertiesType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.PropertyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of properties.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getPropertiesType_Property()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<PropertyType> getProperty();

	/**
	 * Returns the value of the '<em><b>Pid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unique identifier used to reconfigure components properties (via Managed
	 *           Services) with the Configuration Admin.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pid</em>' attribute.
	 * @see #setPid(String)
	 * @see org.apache.felix.FelixPackage#getPropertiesType_Pid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='pid'"
	 * @generated
	 */
	String getPid();

	/**
	 * Sets the value of the '{@link org.apache.felix.PropertiesType#getPid <em>Pid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pid</em>' attribute.
	 * @see #getPid()
	 * @generated
	 */
	void setPid(String value);

	/**
	 * Returns the value of the '<em><b>Propagation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Propagation of the component properties to the provided services. If this
	 *           parameter is set to "true", each time properties are reconfigured, they are propagated to
	 *           each service published by the component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Propagation</em>' attribute.
	 * @see #isSetPropagation()
	 * @see #unsetPropagation()
	 * @see #setPropagation(boolean)
	 * @see org.apache.felix.FelixPackage#getPropertiesType_Propagation()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='propagation'"
	 * @generated
	 */
	boolean isPropagation();

	/**
	 * Sets the value of the '{@link org.apache.felix.PropertiesType#isPropagation <em>Propagation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagation</em>' attribute.
	 * @see #isSetPropagation()
	 * @see #unsetPropagation()
	 * @see #isPropagation()
	 * @generated
	 */
	void setPropagation(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.PropertiesType#isPropagation <em>Propagation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPropagation()
	 * @see #isPropagation()
	 * @see #setPropagation(boolean)
	 * @generated
	 */
	void unsetPropagation();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.PropertiesType#isPropagation <em>Propagation</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Propagation</em>' attribute is set.
	 * @see #unsetPropagation()
	 * @see #isPropagation()
	 * @see #setPropagation(boolean)
	 * @generated
	 */
	boolean isSetPropagation();

	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Method called when a reconfiguration is done
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(String)
	 * @see org.apache.felix.FelixPackage#getPropertiesType_Updated()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='updated'"
	 * @generated
	 */
	String getUpdated();

	/**
	 * Sets the value of the '{@link org.apache.felix.PropertiesType#getUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #getUpdated()
	 * @generated
	 */
	void setUpdated(String value);

} // PropertiesType
