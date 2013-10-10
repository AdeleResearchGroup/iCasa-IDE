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
 * A representation of the model object '<em><b>Provides Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Provided service(s) description.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.ProvidesType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.ProvidesType#getProperty <em>Property</em>}</li>
 *   <li>{@link org.apache.felix.ProvidesType#getController <em>Controller</em>}</li>
 *   <li>{@link org.apache.felix.ProvidesType#getPostRegistration <em>Post Registration</em>}</li>
 *   <li>{@link org.apache.felix.ProvidesType#getPostUnregistration <em>Post Unregistration</em>}</li>
 *   <li>{@link org.apache.felix.ProvidesType#getSpecifications <em>Specifications</em>}</li>
 *   <li>{@link org.apache.felix.ProvidesType#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getProvidesType()
 * @model extendedMetaData="name='ProvidesType' kind='elementOnly'"
 * @generated
 */
public interface ProvidesType extends EObject {
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
	 * @see org.apache.felix.FelixPackage#getProvidesType_Group()
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
	 * List of service specific properties.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getProvidesType_Property()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='property' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<PropertyType> getProperty();

	/**
	 * Returns the value of the '<em><b>Controller</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.ServiceControllerType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Service Controller impacting the current provided
	 *               service
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Controller</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getProvidesType_Controller()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='controller' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<ServiceControllerType> getController();

	/**
	 * Returns the value of the '<em><b>Post Registration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines a callback called after the service registration. The callback takes a ServiceReference
	 *         as parameter
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Registration</em>' attribute.
	 * @see #setPostRegistration(String)
	 * @see org.apache.felix.FelixPackage#getProvidesType_PostRegistration()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='post-registration'"
	 * @generated
	 */
	String getPostRegistration();

	/**
	 * Sets the value of the '{@link org.apache.felix.ProvidesType#getPostRegistration <em>Post Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Registration</em>' attribute.
	 * @see #getPostRegistration()
	 * @generated
	 */
	void setPostRegistration(String value);

	/**
	 * Returns the value of the '<em><b>Post Unregistration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines a callback called after the service unregistration. The callback takes a ServiceReference
	 *         as parameter
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Unregistration</em>' attribute.
	 * @see #setPostUnregistration(String)
	 * @see org.apache.felix.FelixPackage#getProvidesType_PostUnregistration()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='post-unregistration'"
	 * @generated
	 */
	String getPostUnregistration();

	/**
	 * Sets the value of the '{@link org.apache.felix.ProvidesType#getPostUnregistration <em>Post Unregistration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Unregistration</em>' attribute.
	 * @see #getPostUnregistration()
	 * @generated
	 */
	void setPostUnregistration(String value);

	/**
	 * Returns the value of the '<em><b>Specifications</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The list of service specifications (i.e. interfaces) to expose. By
	 *           default, all interfaces implemented by the component implementation class are
	 *           published.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specifications</em>' attribute.
	 * @see #setSpecifications(String)
	 * @see org.apache.felix.FelixPackage#getProvidesType_Specifications()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='specifications'"
	 * @generated
	 */
	String getSpecifications();

	/**
	 * Sets the value of the '{@link org.apache.felix.ProvidesType#getSpecifications <em>Specifications</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specifications</em>' attribute.
	 * @see #getSpecifications()
	 * @generated
	 */
	void setSpecifications(String value);

	/**
	 * Returns the value of the '<em><b>Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * POJO creation strategy. By default, the POJO object is created once
	 *           (singleton). If the factory is set to "SERVICE", the creation policy follows the OSGi
	 *           service factory policy (one object object per asking bundle). INSTANCE allows creating one
	 *           different POJO object per asking instance. Finally, a custom strategy can be used by
	 *           specifying the qualified name of the class extending CreationPolicy
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Strategy</em>' attribute.
	 * @see #setStrategy(String)
	 * @see org.apache.felix.FelixPackage#getProvidesType_Strategy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='strategy'"
	 * @generated
	 */
	String getStrategy();

	/**
	 * Sets the value of the '{@link org.apache.felix.ProvidesType#getStrategy <em>Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy</em>' attribute.
	 * @see #getStrategy()
	 * @generated
	 */
	void setStrategy(String value);

} // ProvidesType
