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
 * A representation of the model object '<em><b>Service Dependency Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.ServiceDependencyType#isAggregate <em>Aggregate</em>}</li>
 *   <li>{@link org.apache.felix.ServiceDependencyType#getComparator <em>Comparator</em>}</li>
 *   <li>{@link org.apache.felix.ServiceDependencyType#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.apache.felix.ServiceDependencyType#getId <em>Id</em>}</li>
 *   <li>{@link org.apache.felix.ServiceDependencyType#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.apache.felix.ServiceDependencyType#getPolicy <em>Policy</em>}</li>
 *   <li>{@link org.apache.felix.ServiceDependencyType#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getServiceDependencyType()
 * @model extendedMetaData="name='ServiceDependencyType' kind='empty'"
 * @generated
 */
public interface ServiceDependencyType extends EObject {
	/**
	 * Returns the value of the '<em><b>Aggregate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the service dependency cardinality.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aggregate</em>' attribute.
	 * @see #isSetAggregate()
	 * @see #unsetAggregate()
	 * @see #setAggregate(boolean)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Aggregate()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='aggregate'"
	 * @generated
	 */
	boolean isAggregate();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#isAggregate <em>Aggregate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregate</em>' attribute.
	 * @see #isSetAggregate()
	 * @see #unsetAggregate()
	 * @see #isAggregate()
	 * @generated
	 */
	void setAggregate(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.ServiceDependencyType#isAggregate <em>Aggregate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAggregate()
	 * @see #isAggregate()
	 * @see #setAggregate(boolean)
	 * @generated
	 */
	void unsetAggregate();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.ServiceDependencyType#isAggregate <em>Aggregate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Aggregate</em>' attribute is set.
	 * @see #unsetAggregate()
	 * @see #isAggregate()
	 * @see #setAggregate(boolean)
	 * @generated
	 */
	boolean isSetAggregate();

	/**
	 * Returns the value of the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The comparator attribute allows specifying the class used to compare
	 *           providers. This class must implemented the java.util.Comparator class and must support the
	 *           comparison of service references.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Comparator</em>' attribute.
	 * @see #setComparator(String)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Comparator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='comparator'"
	 * @generated
	 */
	String getComparator();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#getComparator <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparator</em>' attribute.
	 * @see #getComparator()
	 * @generated
	 */
	void setComparator(String value);

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * LDAP filter used to filter providers
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see #setFilter(String)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Filter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='filter'"
	 * @generated
	 */
	String getFilter();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * id of the service dependency. The id allows to indentify and to refert to
	 *           this dependency.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the service dependency optionality
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #isSetOptional()
	 * @see #unsetOptional()
	 * @see #setOptional(boolean)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Optional()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='optional'"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isSetOptional()
	 * @see #unsetOptional()
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.ServiceDependencyType#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOptional()
	 * @see #isOptional()
	 * @see #setOptional(boolean)
	 * @generated
	 */
	void unsetOptional();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.ServiceDependencyType#isOptional <em>Optional</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Optional</em>' attribute is set.
	 * @see #unsetOptional()
	 * @see #isOptional()
	 * @see #setOptional(boolean)
	 * @generated
	 */
	boolean isSetOptional();

	/**
	 * Returns the value of the '<em><b>Policy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.apache.felix.PolicyType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the binding policy of the dependency. Three policies are supported.
	 *           The dynamic policy supports service providers dynamism. The static policy freezes the
	 *           provider set as soon as the dependency is used. The dynamic-priority policy is an
	 *           extension of the dynamic policy, but providers are ranked.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Policy</em>' attribute.
	 * @see org.apache.felix.PolicyType
	 * @see #isSetPolicy()
	 * @see #unsetPolicy()
	 * @see #setPolicy(PolicyType)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Policy()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='policy'"
	 * @generated
	 */
	PolicyType getPolicy();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Policy</em>' attribute.
	 * @see org.apache.felix.PolicyType
	 * @see #isSetPolicy()
	 * @see #unsetPolicy()
	 * @see #getPolicy()
	 * @generated
	 */
	void setPolicy(PolicyType value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.ServiceDependencyType#getPolicy <em>Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPolicy()
	 * @see #getPolicy()
	 * @see #setPolicy(PolicyType)
	 * @generated
	 */
	void unsetPolicy();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.ServiceDependencyType#getPolicy <em>Policy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Policy</em>' attribute is set.
	 * @see #unsetPolicy()
	 * @see #getPolicy()
	 * @see #setPolicy(PolicyType)
	 * @generated
	 */
	boolean isSetPolicy();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The specification describing the required service type. This attribute is
	 *           needed only when using aggregate dependencies with field injection and when the type of
	 *           this field is a list, vector, collection and set.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification</em>' attribute.
	 * @see #setSpecification(String)
	 * @see org.apache.felix.FelixPackage#getServiceDependencyType_Specification()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='specification'"
	 * @generated
	 */
	String getSpecification();

	/**
	 * Sets the value of the '{@link org.apache.felix.ServiceDependencyType#getSpecification <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' attribute.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(String value);

} // ServiceDependencyType
