/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import java.util.Collection;

import org.apache.felix.ComponentType;
import org.apache.felix.FelixPackage;
import org.apache.felix.HandlerType;
import org.apache.felix.InstanceType;
import org.apache.felix.IpojoType;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ipojo Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.felix.impl.IpojoTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.impl.IpojoTypeImpl#getHandler <em>Handler</em>}</li>
 *   <li>{@link org.apache.felix.impl.IpojoTypeImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.apache.felix.impl.IpojoTypeImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.apache.felix.impl.IpojoTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IpojoTypeImpl extends EObjectImpl implements IpojoType {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IpojoTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FelixPackage.Literals.IPOJO_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FelixPackage.IPOJO_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HandlerType> getHandler() {
		return getGroup().list(FelixPackage.Literals.IPOJO_TYPE__HANDLER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceType> getInstance() {
		return getGroup().list(FelixPackage.Literals.IPOJO_TYPE__INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentType> getComponent() {
		return getGroup().list(FelixPackage.Literals.IPOJO_TYPE__COMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(FelixPackage.Literals.IPOJO_TYPE__ANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FelixPackage.IPOJO_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FelixPackage.IPOJO_TYPE__HANDLER:
				return ((InternalEList<?>)getHandler()).basicRemove(otherEnd, msgs);
			case FelixPackage.IPOJO_TYPE__INSTANCE:
				return ((InternalEList<?>)getInstance()).basicRemove(otherEnd, msgs);
			case FelixPackage.IPOJO_TYPE__COMPONENT:
				return ((InternalEList<?>)getComponent()).basicRemove(otherEnd, msgs);
			case FelixPackage.IPOJO_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
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
			case FelixPackage.IPOJO_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FelixPackage.IPOJO_TYPE__HANDLER:
				return getHandler();
			case FelixPackage.IPOJO_TYPE__INSTANCE:
				return getInstance();
			case FelixPackage.IPOJO_TYPE__COMPONENT:
				return getComponent();
			case FelixPackage.IPOJO_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
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
			case FelixPackage.IPOJO_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FelixPackage.IPOJO_TYPE__HANDLER:
				getHandler().clear();
				getHandler().addAll((Collection<? extends HandlerType>)newValue);
				return;
			case FelixPackage.IPOJO_TYPE__INSTANCE:
				getInstance().clear();
				getInstance().addAll((Collection<? extends InstanceType>)newValue);
				return;
			case FelixPackage.IPOJO_TYPE__COMPONENT:
				getComponent().clear();
				getComponent().addAll((Collection<? extends ComponentType>)newValue);
				return;
			case FelixPackage.IPOJO_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
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
			case FelixPackage.IPOJO_TYPE__GROUP:
				getGroup().clear();
				return;
			case FelixPackage.IPOJO_TYPE__HANDLER:
				getHandler().clear();
				return;
			case FelixPackage.IPOJO_TYPE__INSTANCE:
				getInstance().clear();
				return;
			case FelixPackage.IPOJO_TYPE__COMPONENT:
				getComponent().clear();
				return;
			case FelixPackage.IPOJO_TYPE__ANY:
				getAny().clear();
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
			case FelixPackage.IPOJO_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case FelixPackage.IPOJO_TYPE__HANDLER:
				return !getHandler().isEmpty();
			case FelixPackage.IPOJO_TYPE__INSTANCE:
				return !getInstance().isEmpty();
			case FelixPackage.IPOJO_TYPE__COMPONENT:
				return !getComponent().isEmpty();
			case FelixPackage.IPOJO_TYPE__ANY:
				return !getAny().isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //IpojoTypeImpl
