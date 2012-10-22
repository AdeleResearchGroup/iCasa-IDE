/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import java.util.Collection;

import org.apache.felix.DependencyCallbackType;
import org.apache.felix.FelixPackage;
import org.apache.felix.RequiresType;
import org.apache.felix.ScopeType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requires Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#getCallback <em>Callback</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#getDefaultImplementation <em>Default Implementation</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#getField <em>Field</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#isNullable <em>Nullable</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#isProxy <em>Proxy</em>}</li>
 *   <li>{@link org.apache.felix.impl.RequiresTypeImpl#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequiresTypeImpl extends ServiceDependencyTypeImpl implements RequiresType {
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
	 * The default value of the '{@link #getDefaultImplementation() <em>Default Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultImplementation()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_IMPLEMENTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultImplementation() <em>Default Implementation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultImplementation()
	 * @generated
	 * @ordered
	 */
	protected String defaultImplementation = DEFAULT_IMPLEMENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getField() <em>Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField()
	 * @generated
	 * @ordered
	 */
	protected String field = FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected String from = FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * This is true if the Nullable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean nullableESet;

	/**
	 * The default value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProxy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROXY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProxy()
	 * @generated
	 * @ordered
	 */
	protected boolean proxy = PROXY_EDEFAULT;

	/**
	 * This is true if the Proxy attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean proxyESet;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeType SCOPE_EDEFAULT = ScopeType.GLOBAL;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeType scope = SCOPE_EDEFAULT;

	/**
	 * This is true if the Scope attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean scopeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiresTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FelixPackage.Literals.REQUIRES_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FelixPackage.REQUIRES_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DependencyCallbackType> getCallback() {
		return getGroup().list(FelixPackage.Literals.REQUIRES_TYPE__CALLBACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultImplementation() {
		return defaultImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultImplementation(String newDefaultImplementation) {
		String oldDefaultImplementation = defaultImplementation;
		defaultImplementation = newDefaultImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.REQUIRES_TYPE__DEFAULT_IMPLEMENTATION, oldDefaultImplementation, defaultImplementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getField() {
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField(String newField) {
		String oldField = field;
		field = newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.REQUIRES_TYPE__FIELD, oldField, field));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(String newFrom) {
		String oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.REQUIRES_TYPE__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		boolean oldNullableESet = nullableESet;
		nullableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.REQUIRES_TYPE__NULLABLE, oldNullable, nullable, !oldNullableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNullable() {
		boolean oldNullable = nullable;
		boolean oldNullableESet = nullableESet;
		nullable = NULLABLE_EDEFAULT;
		nullableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.REQUIRES_TYPE__NULLABLE, oldNullable, NULLABLE_EDEFAULT, oldNullableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNullable() {
		return nullableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProxy() {
		return proxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxy(boolean newProxy) {
		boolean oldProxy = proxy;
		proxy = newProxy;
		boolean oldProxyESet = proxyESet;
		proxyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.REQUIRES_TYPE__PROXY, oldProxy, proxy, !oldProxyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProxy() {
		boolean oldProxy = proxy;
		boolean oldProxyESet = proxyESet;
		proxy = PROXY_EDEFAULT;
		proxyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.REQUIRES_TYPE__PROXY, oldProxy, PROXY_EDEFAULT, oldProxyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProxy() {
		return proxyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(ScopeType newScope) {
		ScopeType oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		boolean oldScopeESet = scopeESet;
		scopeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.REQUIRES_TYPE__SCOPE, oldScope, scope, !oldScopeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetScope() {
		ScopeType oldScope = scope;
		boolean oldScopeESet = scopeESet;
		scope = SCOPE_EDEFAULT;
		scopeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.REQUIRES_TYPE__SCOPE, oldScope, SCOPE_EDEFAULT, oldScopeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetScope() {
		return scopeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FelixPackage.REQUIRES_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FelixPackage.REQUIRES_TYPE__CALLBACK:
				return ((InternalEList<?>)getCallback()).basicRemove(otherEnd, msgs);
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
			case FelixPackage.REQUIRES_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FelixPackage.REQUIRES_TYPE__CALLBACK:
				return getCallback();
			case FelixPackage.REQUIRES_TYPE__DEFAULT_IMPLEMENTATION:
				return getDefaultImplementation();
			case FelixPackage.REQUIRES_TYPE__FIELD:
				return getField();
			case FelixPackage.REQUIRES_TYPE__FROM:
				return getFrom();
			case FelixPackage.REQUIRES_TYPE__NULLABLE:
				return isNullable();
			case FelixPackage.REQUIRES_TYPE__PROXY:
				return isProxy();
			case FelixPackage.REQUIRES_TYPE__SCOPE:
				return getScope();
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
			case FelixPackage.REQUIRES_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__CALLBACK:
				getCallback().clear();
				getCallback().addAll((Collection<? extends DependencyCallbackType>)newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__DEFAULT_IMPLEMENTATION:
				setDefaultImplementation((String)newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__FIELD:
				setField((String)newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__FROM:
				setFrom((String)newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__NULLABLE:
				setNullable((Boolean)newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__PROXY:
				setProxy((Boolean)newValue);
				return;
			case FelixPackage.REQUIRES_TYPE__SCOPE:
				setScope((ScopeType)newValue);
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
			case FelixPackage.REQUIRES_TYPE__GROUP:
				getGroup().clear();
				return;
			case FelixPackage.REQUIRES_TYPE__CALLBACK:
				getCallback().clear();
				return;
			case FelixPackage.REQUIRES_TYPE__DEFAULT_IMPLEMENTATION:
				setDefaultImplementation(DEFAULT_IMPLEMENTATION_EDEFAULT);
				return;
			case FelixPackage.REQUIRES_TYPE__FIELD:
				setField(FIELD_EDEFAULT);
				return;
			case FelixPackage.REQUIRES_TYPE__FROM:
				setFrom(FROM_EDEFAULT);
				return;
			case FelixPackage.REQUIRES_TYPE__NULLABLE:
				unsetNullable();
				return;
			case FelixPackage.REQUIRES_TYPE__PROXY:
				unsetProxy();
				return;
			case FelixPackage.REQUIRES_TYPE__SCOPE:
				unsetScope();
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
			case FelixPackage.REQUIRES_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case FelixPackage.REQUIRES_TYPE__CALLBACK:
				return !getCallback().isEmpty();
			case FelixPackage.REQUIRES_TYPE__DEFAULT_IMPLEMENTATION:
				return DEFAULT_IMPLEMENTATION_EDEFAULT == null ? defaultImplementation != null : !DEFAULT_IMPLEMENTATION_EDEFAULT.equals(defaultImplementation);
			case FelixPackage.REQUIRES_TYPE__FIELD:
				return FIELD_EDEFAULT == null ? field != null : !FIELD_EDEFAULT.equals(field);
			case FelixPackage.REQUIRES_TYPE__FROM:
				return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals(from);
			case FelixPackage.REQUIRES_TYPE__NULLABLE:
				return isSetNullable();
			case FelixPackage.REQUIRES_TYPE__PROXY:
				return isSetProxy();
			case FelixPackage.REQUIRES_TYPE__SCOPE:
				return isSetScope();
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
		result.append(", defaultImplementation: ");
		result.append(defaultImplementation);
		result.append(", field: ");
		result.append(field);
		result.append(", from: ");
		result.append(from);
		result.append(", nullable: ");
		if (nullableESet) result.append(nullable); else result.append("<unset>");
		result.append(", proxy: ");
		if (proxyESet) result.append(proxy); else result.append("<unset>");
		result.append(", scope: ");
		if (scopeESet) result.append(scope); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //RequiresTypeImpl
