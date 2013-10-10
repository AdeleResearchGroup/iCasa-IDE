/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import org.apache.felix.FelixPackage;
import org.apache.felix.PolicyType;
import org.apache.felix.ServiceDependencyType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Dependency Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#isAggregate <em>Aggregate</em>}</li>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#getComparator <em>Comparator</em>}</li>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#getPolicy <em>Policy</em>}</li>
 *   <li>{@link org.apache.felix.impl.ServiceDependencyTypeImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceDependencyTypeImpl extends EObjectImpl implements ServiceDependencyType {
	/**
	 * The default value of the '{@link #isAggregate() <em>Aggregate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAggregate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AGGREGATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAggregate() <em>Aggregate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAggregate()
	 * @generated
	 * @ordered
	 */
	protected boolean aggregate = AGGREGATE_EDEFAULT;

	/**
	 * This is true if the Aggregate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean aggregateESet;

	/**
	 * The default value of the '{@link #getComparator() <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPARATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComparator() <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparator()
	 * @generated
	 * @ordered
	 */
	protected String comparator = COMPARATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected String filter = FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * This is true if the Optional attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean optionalESet;

	/**
	 * The default value of the '{@link #getPolicy() <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final PolicyType POLICY_EDEFAULT = PolicyType.DYNAMIC;

	/**
	 * The cached value of the '{@link #getPolicy() <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPolicy()
	 * @generated
	 * @ordered
	 */
	protected PolicyType policy = POLICY_EDEFAULT;

	/**
	 * This is true if the Policy attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean policyESet;

	/**
	 * The default value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected String specification = SPECIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceDependencyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FelixPackage.Literals.SERVICE_DEPENDENCY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAggregate() {
		return aggregate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregate(boolean newAggregate) {
		boolean oldAggregate = aggregate;
		aggregate = newAggregate;
		boolean oldAggregateESet = aggregateESet;
		aggregateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__AGGREGATE, oldAggregate, aggregate, !oldAggregateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAggregate() {
		boolean oldAggregate = aggregate;
		boolean oldAggregateESet = aggregateESet;
		aggregate = AGGREGATE_EDEFAULT;
		aggregateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.SERVICE_DEPENDENCY_TYPE__AGGREGATE, oldAggregate, AGGREGATE_EDEFAULT, oldAggregateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAggregate() {
		return aggregateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComparator() {
		return comparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComparator(String newComparator) {
		String oldComparator = comparator;
		comparator = newComparator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__COMPARATOR, oldComparator, comparator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(String newFilter) {
		String oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__FILTER, oldFilter, filter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		boolean oldOptionalESet = optionalESet;
		optionalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__OPTIONAL, oldOptional, optional, !oldOptionalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOptional() {
		boolean oldOptional = optional;
		boolean oldOptionalESet = optionalESet;
		optional = OPTIONAL_EDEFAULT;
		optionalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.SERVICE_DEPENDENCY_TYPE__OPTIONAL, oldOptional, OPTIONAL_EDEFAULT, oldOptionalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOptional() {
		return optionalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PolicyType getPolicy() {
		return policy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPolicy(PolicyType newPolicy) {
		PolicyType oldPolicy = policy;
		policy = newPolicy == null ? POLICY_EDEFAULT : newPolicy;
		boolean oldPolicyESet = policyESet;
		policyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__POLICY, oldPolicy, policy, !oldPolicyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPolicy() {
		PolicyType oldPolicy = policy;
		boolean oldPolicyESet = policyESet;
		policy = POLICY_EDEFAULT;
		policyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.SERVICE_DEPENDENCY_TYPE__POLICY, oldPolicy, POLICY_EDEFAULT, oldPolicyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPolicy() {
		return policyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(String newSpecification) {
		String oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.SERVICE_DEPENDENCY_TYPE__SPECIFICATION, oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__AGGREGATE:
				return isAggregate();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__COMPARATOR:
				return getComparator();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__FILTER:
				return getFilter();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__ID:
				return getId();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__OPTIONAL:
				return isOptional();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__POLICY:
				return getPolicy();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__SPECIFICATION:
				return getSpecification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__AGGREGATE:
				setAggregate((Boolean)newValue);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__COMPARATOR:
				setComparator((String)newValue);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__FILTER:
				setFilter((String)newValue);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__ID:
				setId((String)newValue);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__OPTIONAL:
				setOptional((Boolean)newValue);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__POLICY:
				setPolicy((PolicyType)newValue);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__SPECIFICATION:
				setSpecification((String)newValue);
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
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__AGGREGATE:
				unsetAggregate();
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__COMPARATOR:
				setComparator(COMPARATOR_EDEFAULT);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__FILTER:
				setFilter(FILTER_EDEFAULT);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__OPTIONAL:
				unsetOptional();
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__POLICY:
				unsetPolicy();
				return;
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__SPECIFICATION:
				setSpecification(SPECIFICATION_EDEFAULT);
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
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__AGGREGATE:
				return isSetAggregate();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__COMPARATOR:
				return COMPARATOR_EDEFAULT == null ? comparator != null : !COMPARATOR_EDEFAULT.equals(comparator);
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__FILTER:
				return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__OPTIONAL:
				return isSetOptional();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__POLICY:
				return isSetPolicy();
			case FelixPackage.SERVICE_DEPENDENCY_TYPE__SPECIFICATION:
				return SPECIFICATION_EDEFAULT == null ? specification != null : !SPECIFICATION_EDEFAULT.equals(specification);
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
		result.append(" (aggregate: ");
		if (aggregateESet) result.append(aggregate); else result.append("<unset>");
		result.append(", comparator: ");
		result.append(comparator);
		result.append(", filter: ");
		result.append(filter);
		result.append(", id: ");
		result.append(id);
		result.append(", optional: ");
		if (optionalESet) result.append(optional); else result.append("<unset>");
		result.append(", policy: ");
		if (policyESet) result.append(policy); else result.append("<unset>");
		result.append(", specification: ");
		result.append(specification);
		result.append(')');
		return result.toString();
	}

} //ServiceDependencyTypeImpl
