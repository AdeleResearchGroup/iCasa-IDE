/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import java.util.Collection;

import org.apache.felix.FelixPackage;
import org.apache.felix.PropertyType;
import org.apache.felix.ProvidesType;
import org.apache.felix.ServiceControllerType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Provides Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getController <em>Controller</em>}</li>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getPostRegistration <em>Post Registration</em>}</li>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getPostUnregistration <em>Post Unregistration</em>}</li>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getSpecifications <em>Specifications</em>}</li>
 *   <li>{@link org.apache.felix.impl.ProvidesTypeImpl#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidesTypeImpl extends EObjectImpl implements ProvidesType {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getPostRegistration() <em>Post Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostRegistration()
	 * @generated
	 * @ordered
	 */
	protected static final String POST_REGISTRATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostRegistration() <em>Post Registration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostRegistration()
	 * @generated
	 * @ordered
	 */
	protected String postRegistration = POST_REGISTRATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostUnregistration() <em>Post Unregistration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostUnregistration()
	 * @generated
	 * @ordered
	 */
	protected static final String POST_UNREGISTRATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostUnregistration() <em>Post Unregistration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostUnregistration()
	 * @generated
	 * @ordered
	 */
	protected String postUnregistration = POST_UNREGISTRATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpecifications() <em>Specifications</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifications()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecifications() <em>Specifications</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifications()
	 * @generated
	 * @ordered
	 */
	protected String specifications = SPECIFICATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStrategy() <em>Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final String STRATEGY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStrategy() <em>Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrategy()
	 * @generated
	 * @ordered
	 */
	protected String strategy = STRATEGY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidesTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FelixPackage.Literals.PROVIDES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FelixPackage.PROVIDES_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyType> getProperty() {
		return getGroup().list(FelixPackage.Literals.PROVIDES_TYPE__PROPERTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceControllerType> getController() {
		return getGroup().list(FelixPackage.Literals.PROVIDES_TYPE__CONTROLLER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostRegistration() {
		return postRegistration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostRegistration(String newPostRegistration) {
		String oldPostRegistration = postRegistration;
		postRegistration = newPostRegistration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.PROVIDES_TYPE__POST_REGISTRATION, oldPostRegistration, postRegistration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostUnregistration() {
		return postUnregistration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostUnregistration(String newPostUnregistration) {
		String oldPostUnregistration = postUnregistration;
		postUnregistration = newPostUnregistration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.PROVIDES_TYPE__POST_UNREGISTRATION, oldPostUnregistration, postUnregistration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecifications() {
		return specifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecifications(String newSpecifications) {
		String oldSpecifications = specifications;
		specifications = newSpecifications;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.PROVIDES_TYPE__SPECIFICATIONS, oldSpecifications, specifications));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStrategy() {
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrategy(String newStrategy) {
		String oldStrategy = strategy;
		strategy = newStrategy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.PROVIDES_TYPE__STRATEGY, oldStrategy, strategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FelixPackage.PROVIDES_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FelixPackage.PROVIDES_TYPE__PROPERTY:
				return ((InternalEList<?>)getProperty()).basicRemove(otherEnd, msgs);
			case FelixPackage.PROVIDES_TYPE__CONTROLLER:
				return ((InternalEList<?>)getController()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FelixPackage.PROVIDES_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FelixPackage.PROVIDES_TYPE__PROPERTY:
				return getProperty();
			case FelixPackage.PROVIDES_TYPE__CONTROLLER:
				return getController();
			case FelixPackage.PROVIDES_TYPE__POST_REGISTRATION:
				return getPostRegistration();
			case FelixPackage.PROVIDES_TYPE__POST_UNREGISTRATION:
				return getPostUnregistration();
			case FelixPackage.PROVIDES_TYPE__SPECIFICATIONS:
				return getSpecifications();
			case FelixPackage.PROVIDES_TYPE__STRATEGY:
				return getStrategy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FelixPackage.PROVIDES_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FelixPackage.PROVIDES_TYPE__PROPERTY:
				getProperty().clear();
				getProperty().addAll((Collection<? extends PropertyType>)newValue);
				return;
			case FelixPackage.PROVIDES_TYPE__CONTROLLER:
				getController().clear();
				getController().addAll((Collection<? extends ServiceControllerType>)newValue);
				return;
			case FelixPackage.PROVIDES_TYPE__POST_REGISTRATION:
				setPostRegistration((String)newValue);
				return;
			case FelixPackage.PROVIDES_TYPE__POST_UNREGISTRATION:
				setPostUnregistration((String)newValue);
				return;
			case FelixPackage.PROVIDES_TYPE__SPECIFICATIONS:
				setSpecifications((String)newValue);
				return;
			case FelixPackage.PROVIDES_TYPE__STRATEGY:
				setStrategy((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FelixPackage.PROVIDES_TYPE__GROUP:
				getGroup().clear();
				return;
			case FelixPackage.PROVIDES_TYPE__PROPERTY:
				getProperty().clear();
				return;
			case FelixPackage.PROVIDES_TYPE__CONTROLLER:
				getController().clear();
				return;
			case FelixPackage.PROVIDES_TYPE__POST_REGISTRATION:
				setPostRegistration(POST_REGISTRATION_EDEFAULT);
				return;
			case FelixPackage.PROVIDES_TYPE__POST_UNREGISTRATION:
				setPostUnregistration(POST_UNREGISTRATION_EDEFAULT);
				return;
			case FelixPackage.PROVIDES_TYPE__SPECIFICATIONS:
				setSpecifications(SPECIFICATIONS_EDEFAULT);
				return;
			case FelixPackage.PROVIDES_TYPE__STRATEGY:
				setStrategy(STRATEGY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FelixPackage.PROVIDES_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case FelixPackage.PROVIDES_TYPE__PROPERTY:
				return !getProperty().isEmpty();
			case FelixPackage.PROVIDES_TYPE__CONTROLLER:
				return !getController().isEmpty();
			case FelixPackage.PROVIDES_TYPE__POST_REGISTRATION:
				return POST_REGISTRATION_EDEFAULT == null ? postRegistration != null : !POST_REGISTRATION_EDEFAULT.equals(postRegistration);
			case FelixPackage.PROVIDES_TYPE__POST_UNREGISTRATION:
				return POST_UNREGISTRATION_EDEFAULT == null ? postUnregistration != null : !POST_UNREGISTRATION_EDEFAULT.equals(postUnregistration);
			case FelixPackage.PROVIDES_TYPE__SPECIFICATIONS:
				return SPECIFICATIONS_EDEFAULT == null ? specifications != null : !SPECIFICATIONS_EDEFAULT.equals(specifications);
			case FelixPackage.PROVIDES_TYPE__STRATEGY:
				return STRATEGY_EDEFAULT == null ? strategy != null : !STRATEGY_EDEFAULT.equals(strategy);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (group: ");
		result.append(group);
		result.append(", postRegistration: ");
		result.append(postRegistration);
		result.append(", postUnregistration: ");
		result.append(postUnregistration);
		result.append(", specifications: ");
		result.append(specifications);
		result.append(", strategy: ");
		result.append(strategy);
		result.append(')');
		return result.toString();
	}

} //ProvidesTypeImpl
