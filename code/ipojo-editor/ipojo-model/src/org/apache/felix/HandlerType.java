/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Handler Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Description of the handler.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.apache.felix.HandlerType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.HandlerType#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.felix.HandlerType#isArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.apache.felix.HandlerType#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.apache.felix.HandlerType#getLevel <em>Level</em>}</li>
 *   <li>{@link org.apache.felix.HandlerType#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.felix.HandlerType#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.apache.felix.FelixPackage#getHandlerType()
 * @model extendedMetaData="name='HandlerType' kind='elementOnly'"
 * @generated
 */
public interface HandlerType extends RootElementType {
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
	 * @see org.apache.felix.FelixPackage#getHandlerType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

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
	 * @see org.apache.felix.FelixPackage#getHandlerType_Any()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='elementWildcard' wildcards='##any' name=':1' processing='skip' group='#group:0'"
	 * @generated
	 */
	FeatureMap getAny();

	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enables or disables the architecture exposition. By default, the
	 *               architecture is not exposed. This allows handler introspection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see #isSetArchitecture()
	 * @see #unsetArchitecture()
	 * @see #setArchitecture(boolean)
	 * @see org.apache.felix.FelixPackage#getHandlerType_Architecture()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='architecture'"
	 * @generated
	 */
	boolean isArchitecture();

	/**
	 * Sets the value of the '{@link org.apache.felix.HandlerType#isArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see #isSetArchitecture()
	 * @see #unsetArchitecture()
	 * @see #isArchitecture()
	 * @generated
	 */
	void setArchitecture(boolean value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.HandlerType#isArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArchitecture()
	 * @see #isArchitecture()
	 * @see #setArchitecture(boolean)
	 * @generated
	 */
	void unsetArchitecture();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.HandlerType#isArchitecture <em>Architecture</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Architecture</em>' attribute is set.
	 * @see #unsetArchitecture()
	 * @see #isArchitecture()
	 * @see #setArchitecture(boolean)
	 * @generated
	 */
	boolean isSetArchitecture();

	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The implementation class of the handler. The specified class must
	 *               implement (direcly or not) the "org.apache.felix.ipojo.Handler"
	 *               interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.apache.felix.FelixPackage#getHandlerType_Classname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='classname'"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.apache.felix.HandlerType#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The start level of the handler.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #setLevel(int)
	 * @see org.apache.felix.FelixPackage#getHandlerType_Level()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='level'"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link org.apache.felix.HandlerType#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Unsets the value of the '{@link org.apache.felix.HandlerType#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link org.apache.felix.HandlerType#getLevel <em>Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Level</em>' attribute is set.
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	boolean isSetLevel();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the handler.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.apache.felix.FelixPackage#getHandlerType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.apache.felix.HandlerType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The XML namespace of the handler.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.apache.felix.FelixPackage#getHandlerType_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='namespace'"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.apache.felix.HandlerType#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

} // HandlerType
