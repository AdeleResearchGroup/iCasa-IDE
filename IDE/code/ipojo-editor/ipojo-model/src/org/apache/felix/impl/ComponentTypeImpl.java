/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import java.util.Collection;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.ControllerType;
import org.apache.felix.FelixPackage;
import org.apache.felix.PropertiesType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;

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
 * An implementation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getCallback <em>Callback</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getProvides <em>Provides</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getController <em>Controller</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#isArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getFactoryMethod <em>Factory Method</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#isImmediate <em>Immediate</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#isPublic <em>Public</em>}</li>
 *   <li>{@link org.apache.felix.impl.ComponentTypeImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentTypeImpl extends EObjectImpl implements ComponentType {
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
	 * The default value of the '{@link #isArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ARCHITECTURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isArchitecture() <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isArchitecture()
	 * @generated
	 * @ordered
	 */
	protected boolean architecture = ARCHITECTURE_EDEFAULT;

	/**
	 * This is true if the Architecture attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean architectureESet;

	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFactoryMethod() <em>Factory Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactoryMethod() <em>Factory Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactoryMethod()
	 * @generated
	 * @ordered
	 */
	protected String factoryMethod = FACTORY_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #isImmediate() <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IMMEDIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isImmediate() <em>Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isImmediate()
	 * @generated
	 * @ordered
	 */
	protected boolean immediate = IMMEDIATE_EDEFAULT;

	/**
	 * This is true if the Immediate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean immediateESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PUBLIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPublic() <em>Public</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPublic()
	 * @generated
	 * @ordered
	 */
	protected boolean public_ = PUBLIC_EDEFAULT;

	/**
	 * This is true if the Public attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean publicESet;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FelixPackage.Literals.COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, FelixPackage.COMPONENT_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CallbackType> getCallback() {
		return getGroup().list(FelixPackage.Literals.COMPONENT_TYPE__CALLBACK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidesType> getProvides() {
		return getGroup().list(FelixPackage.Literals.COMPONENT_TYPE__PROVIDES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiresType> getRequires() {
		return getGroup().list(FelixPackage.Literals.COMPONENT_TYPE__REQUIRES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertiesType> getProperties() {
		return getGroup().list(FelixPackage.Literals.COMPONENT_TYPE__PROPERTIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControllerType> getController() {
		return getGroup().list(FelixPackage.Literals.COMPONENT_TYPE__CONTROLLER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(FelixPackage.Literals.COMPONENT_TYPE__ANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isArchitecture() {
		return architecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArchitecture(boolean newArchitecture) {
		boolean oldArchitecture = architecture;
		architecture = newArchitecture;
		boolean oldArchitectureESet = architectureESet;
		architectureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__ARCHITECTURE, oldArchitecture, architecture, !oldArchitectureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetArchitecture() {
		boolean oldArchitecture = architecture;
		boolean oldArchitectureESet = architectureESet;
		architecture = ARCHITECTURE_EDEFAULT;
		architectureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.COMPONENT_TYPE__ARCHITECTURE, oldArchitecture, ARCHITECTURE_EDEFAULT, oldArchitectureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetArchitecture() {
		return architectureESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__CLASSNAME, oldClassname, classname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactoryMethod() {
		return factoryMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactoryMethod(String newFactoryMethod) {
		String oldFactoryMethod = factoryMethod;
		factoryMethod = newFactoryMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__FACTORY_METHOD, oldFactoryMethod, factoryMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isImmediate() {
		return immediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediate(boolean newImmediate) {
		boolean oldImmediate = immediate;
		immediate = newImmediate;
		boolean oldImmediateESet = immediateESet;
		immediateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__IMMEDIATE, oldImmediate, immediate, !oldImmediateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImmediate() {
		boolean oldImmediate = immediate;
		boolean oldImmediateESet = immediateESet;
		immediate = IMMEDIATE_EDEFAULT;
		immediateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.COMPONENT_TYPE__IMMEDIATE, oldImmediate, IMMEDIATE_EDEFAULT, oldImmediateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImmediate() {
		return immediateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPublic() {
		return public_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublic(boolean newPublic) {
		boolean oldPublic = public_;
		public_ = newPublic;
		boolean oldPublicESet = publicESet;
		publicESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__PUBLIC, oldPublic, public_, !oldPublicESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPublic() {
		boolean oldPublic = public_;
		boolean oldPublicESet = publicESet;
		public_ = PUBLIC_EDEFAULT;
		publicESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, FelixPackage.COMPONENT_TYPE__PUBLIC, oldPublic, PUBLIC_EDEFAULT, oldPublicESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPublic() {
		return publicESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FelixPackage.COMPONENT_TYPE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FelixPackage.COMPONENT_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case FelixPackage.COMPONENT_TYPE__CALLBACK:
				return ((InternalEList<?>)getCallback()).basicRemove(otherEnd, msgs);
			case FelixPackage.COMPONENT_TYPE__PROVIDES:
				return ((InternalEList<?>)getProvides()).basicRemove(otherEnd, msgs);
			case FelixPackage.COMPONENT_TYPE__REQUIRES:
				return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
			case FelixPackage.COMPONENT_TYPE__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case FelixPackage.COMPONENT_TYPE__CONTROLLER:
				return ((InternalEList<?>)getController()).basicRemove(otherEnd, msgs);
			case FelixPackage.COMPONENT_TYPE__ANY:
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
			case FelixPackage.COMPONENT_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case FelixPackage.COMPONENT_TYPE__CALLBACK:
				return getCallback();
			case FelixPackage.COMPONENT_TYPE__PROVIDES:
				return getProvides();
			case FelixPackage.COMPONENT_TYPE__REQUIRES:
				return getRequires();
			case FelixPackage.COMPONENT_TYPE__PROPERTIES:
				return getProperties();
			case FelixPackage.COMPONENT_TYPE__CONTROLLER:
				return getController();
			case FelixPackage.COMPONENT_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case FelixPackage.COMPONENT_TYPE__ARCHITECTURE:
				return isArchitecture();
			case FelixPackage.COMPONENT_TYPE__CLASSNAME:
				return getClassname();
			case FelixPackage.COMPONENT_TYPE__FACTORY_METHOD:
				return getFactoryMethod();
			case FelixPackage.COMPONENT_TYPE__IMMEDIATE:
				return isImmediate();
			case FelixPackage.COMPONENT_TYPE__NAME:
				return getName();
			case FelixPackage.COMPONENT_TYPE__PUBLIC:
				return isPublic();
			case FelixPackage.COMPONENT_TYPE__VERSION:
				return getVersion();
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
			case FelixPackage.COMPONENT_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__CALLBACK:
				getCallback().clear();
				getCallback().addAll((Collection<? extends CallbackType>)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__PROVIDES:
				getProvides().clear();
				getProvides().addAll((Collection<? extends ProvidesType>)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends RequiresType>)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends PropertiesType>)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__CONTROLLER:
				getController().clear();
				getController().addAll((Collection<? extends ControllerType>)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__ARCHITECTURE:
				setArchitecture((Boolean)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__CLASSNAME:
				setClassname((String)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__FACTORY_METHOD:
				setFactoryMethod((String)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__IMMEDIATE:
				setImmediate((Boolean)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__NAME:
				setName((String)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__PUBLIC:
				setPublic((Boolean)newValue);
				return;
			case FelixPackage.COMPONENT_TYPE__VERSION:
				setVersion((String)newValue);
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
			case FelixPackage.COMPONENT_TYPE__GROUP:
				getGroup().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__CALLBACK:
				getCallback().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__PROVIDES:
				getProvides().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__REQUIRES:
				getRequires().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__PROPERTIES:
				getProperties().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__CONTROLLER:
				getController().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__ANY:
				getAny().clear();
				return;
			case FelixPackage.COMPONENT_TYPE__ARCHITECTURE:
				unsetArchitecture();
				return;
			case FelixPackage.COMPONENT_TYPE__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case FelixPackage.COMPONENT_TYPE__FACTORY_METHOD:
				setFactoryMethod(FACTORY_METHOD_EDEFAULT);
				return;
			case FelixPackage.COMPONENT_TYPE__IMMEDIATE:
				unsetImmediate();
				return;
			case FelixPackage.COMPONENT_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FelixPackage.COMPONENT_TYPE__PUBLIC:
				unsetPublic();
				return;
			case FelixPackage.COMPONENT_TYPE__VERSION:
				setVersion(VERSION_EDEFAULT);
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
			case FelixPackage.COMPONENT_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case FelixPackage.COMPONENT_TYPE__CALLBACK:
				return !getCallback().isEmpty();
			case FelixPackage.COMPONENT_TYPE__PROVIDES:
				return !getProvides().isEmpty();
			case FelixPackage.COMPONENT_TYPE__REQUIRES:
				return !getRequires().isEmpty();
			case FelixPackage.COMPONENT_TYPE__PROPERTIES:
				return !getProperties().isEmpty();
			case FelixPackage.COMPONENT_TYPE__CONTROLLER:
				return !getController().isEmpty();
			case FelixPackage.COMPONENT_TYPE__ANY:
				return !getAny().isEmpty();
			case FelixPackage.COMPONENT_TYPE__ARCHITECTURE:
				return isSetArchitecture();
			case FelixPackage.COMPONENT_TYPE__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case FelixPackage.COMPONENT_TYPE__FACTORY_METHOD:
				return FACTORY_METHOD_EDEFAULT == null ? factoryMethod != null : !FACTORY_METHOD_EDEFAULT.equals(factoryMethod);
			case FelixPackage.COMPONENT_TYPE__IMMEDIATE:
				return isSetImmediate();
			case FelixPackage.COMPONENT_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FelixPackage.COMPONENT_TYPE__PUBLIC:
				return isSetPublic();
			case FelixPackage.COMPONENT_TYPE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
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
		result.append(", architecture: ");
		if (architectureESet) result.append(architecture); else result.append("<unset>");
		result.append(", classname: ");
		result.append(classname);
		result.append(", factoryMethod: ");
		result.append(factoryMethod);
		result.append(", immediate: ");
		if (immediateESet) result.append(immediate); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", public: ");
		if (publicESet) result.append(public_); else result.append("<unset>");
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

} //ComponentTypeImpl
