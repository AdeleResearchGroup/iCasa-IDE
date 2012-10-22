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
 * A representation of the model object '<em><b>Ipojo Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * iPOJO top level element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.IpojoType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.IpojoType#getHandler <em>Handler</em>}</li>
 *   <li>{@link org.apache.felix.IpojoType#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.apache.felix.IpojoType#getComponent <em>Component</em>}</li>
 *   <li>{@link org.apache.felix.IpojoType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getIpojoType()
 * @model extendedMetaData="name='ipojo_._type' kind='elementOnly'"
 * @generated
 */
public interface IpojoType extends EObject {
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
	 * @see org.apache.felix.FelixPackage#getIpojoType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Handler</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.HandlerType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The handler declarations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Handler</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getIpojoType_Handler()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='handler' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<HandlerType> getHandler();

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.InstanceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The instance declarations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getIpojoType_Instance()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='instance' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<InstanceType> getInstance();

	/**
	 * Returns the value of the '<em><b>Component</b></em>' containment reference list.
	 * The list contents are of type {@link org.apache.felix.ComponentType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The component type declarations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Component</em>' containment reference list.
	 * @see org.apache.felix.FelixPackage#getIpojoType_Component()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component' namespace='##targetNamespace' group='#group:0'"
	 * @generated
	 */
	EList<ComponentType> getComponent();

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
	 * @see org.apache.felix.FelixPackage#getIpojoType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':4' processing='lax' group='#group:0'"
	 * @generated
	 */
	FeatureMap getAny();

} // IpojoType
