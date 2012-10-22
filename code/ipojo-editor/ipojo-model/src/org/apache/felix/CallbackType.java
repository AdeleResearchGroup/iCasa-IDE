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
 * A representation of the model object '<em><b>Callback Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Lifecycle Callback. Allows a POJO to be notified when the instance becomes
 *         valid or invalid.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.CallbackType#getMethod <em>Method</em>}</li>
 *   <li>{@link org.apache.felix.CallbackType#getTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getCallbackType()
 * @model extendedMetaData="name='CallbackType' kind='empty'"
 * @generated
 */
public interface CallbackType extends EObject {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the method to call on the transition.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see org.apache.felix.FelixPackage#getCallbackType_Method()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='method'"
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link org.apache.felix.CallbackType#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' attribute.
	 * The literals are from the enumeration {@link org.apache.felix.TransitionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the transition when the callback needs to be
	 *           invoked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transition</em>' attribute.
	 * @see org.apache.felix.TransitionType
	 * @see #isSetTransition()
	 * @see #unsetTransition()
	 * @see #setTransition(TransitionType)
	 * @see org.apache.felix.FelixPackage#getCallbackType_Transition()
	 * @model unsettable="true" required="true"
	 *        extendedMetaData="kind='attribute' name='transition'"
	 * @generated
	 */
	TransitionType getTransition();

	/**
	 * Sets the value of the '{@link org.apache.felix.CallbackType#getTransition <em>Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' attribute.
	 * @see org.apache.felix.TransitionType
	 * @see #isSetTransition()
	 * @see #unsetTransition()
	 * @see #getTransition()
	 * @generated
	 */
	void setTransition(TransitionType value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.CallbackType#getTransition <em>Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransition()
	 * @see #getTransition()
	 * @see #setTransition(TransitionType)
	 * @generated
	 */
	void unsetTransition();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.CallbackType#getTransition <em>Transition</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transition</em>' attribute is set.
	 * @see #unsetTransition()
	 * @see #getTransition()
	 * @see #setTransition(TransitionType)
	 * @generated
	 */
	boolean isSetTransition();

} // CallbackType
