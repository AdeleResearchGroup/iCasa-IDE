/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies the lifecycle controller of a component, which allows to validate
 *         or invalidate component instances.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.ControllerType#getField <em>Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getControllerType()
 * @model extendedMetaData="name='ControllerType' kind='empty'"
 * @generated
 */
public interface ControllerType extends EObject {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the component lifecycle controller field. The type of the
	 *           specified field must be boolean. Setting the value of the specified field to "true" means
	 *           the validation of the component instance while setting it to "false" means the
	 *           invalidation of the component instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Field</em>' attribute.
	 * @see #setField(String)
	 * @see org.apache.felix.FelixPackage#getControllerType_Field()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='field'"
	 * @generated
	 */
	String getField();

	/**
	 * Sets the value of the '{@link org.apache.felix.ControllerType#getField <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' attribute.
	 * @see #getField()
	 * @generated
	 */
	void setField(String value);

} // ControllerType
