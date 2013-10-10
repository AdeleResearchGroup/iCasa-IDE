/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.impl;

import org.apache.felix.CallbackType;
import org.apache.felix.ComponentType;
import org.apache.felix.ControllerType;
import org.apache.felix.DocumentRoot;
import org.apache.felix.FelixPackage;
import org.apache.felix.HandlerType;
import org.apache.felix.InstanceType;
import org.apache.felix.IpojoType;
import org.apache.felix.PropertiesType;
import org.apache.felix.ProvidesType;
import org.apache.felix.RequiresType;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getCallback <em>Callback</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getController <em>Controller</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getHandler <em>Handler</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getIpojo <em>Ipojo</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getProvides <em>Provides</em>}</li>
 *   <li>{@link org.apache.felix.impl.DocumentRootImpl#getRequires <em>Requires</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FelixPackage.Literals.DOCUMENT_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, FelixPackage.DOCUMENT_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FelixPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, FelixPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallbackType getCallback() {
		return (CallbackType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__CALLBACK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallback(CallbackType newCallback, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__CALLBACK, newCallback, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallback(CallbackType newCallback) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__CALLBACK, newCallback);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentType getComponent() {
		return (ComponentType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponent(ComponentType newComponent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__COMPONENT, newComponent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(ComponentType newComponent) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__COMPONENT, newComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControllerType getController() {
		return (ControllerType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__CONTROLLER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetController(ControllerType newController, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__CONTROLLER, newController, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setController(ControllerType newController) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__CONTROLLER, newController);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HandlerType getHandler() {
		return (HandlerType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__HANDLER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHandler(HandlerType newHandler, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__HANDLER, newHandler, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandler(HandlerType newHandler) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__HANDLER, newHandler);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceType getInstance() {
		return (InstanceType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__INSTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstance(InstanceType newInstance, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__INSTANCE, newInstance, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstance(InstanceType newInstance) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__INSTANCE, newInstance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpojoType getIpojo() {
		return (IpojoType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__IPOJO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIpojo(IpojoType newIpojo, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__IPOJO, newIpojo, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIpojo(IpojoType newIpojo) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__IPOJO, newIpojo);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesType getProperties() {
		return (PropertiesType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(PropertiesType newProperties, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__PROPERTIES, newProperties, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(PropertiesType newProperties) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__PROPERTIES, newProperties);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProvidesType getProvides() {
		return (ProvidesType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__PROVIDES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProvides(ProvidesType newProvides, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__PROVIDES, newProvides, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvides(ProvidesType newProvides) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__PROVIDES, newProvides);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiresType getRequires() {
		return (RequiresType)getMixed().get(FelixPackage.Literals.DOCUMENT_ROOT__REQUIRES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequires(RequiresType newRequires, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(FelixPackage.Literals.DOCUMENT_ROOT__REQUIRES, newRequires, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequires(RequiresType newRequires) {
		((FeatureMap.Internal)getMixed()).set(FelixPackage.Literals.DOCUMENT_ROOT__REQUIRES, newRequires);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FelixPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case FelixPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case FelixPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case FelixPackage.DOCUMENT_ROOT__CALLBACK:
				return basicSetCallback(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__COMPONENT:
				return basicSetComponent(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__CONTROLLER:
				return basicSetController(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__HANDLER:
				return basicSetHandler(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__INSTANCE:
				return basicSetInstance(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__IPOJO:
				return basicSetIpojo(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__PROPERTIES:
				return basicSetProperties(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__PROVIDES:
				return basicSetProvides(null, msgs);
			case FelixPackage.DOCUMENT_ROOT__REQUIRES:
				return basicSetRequires(null, msgs);
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
			case FelixPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case FelixPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case FelixPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case FelixPackage.DOCUMENT_ROOT__CALLBACK:
				return getCallback();
			case FelixPackage.DOCUMENT_ROOT__COMPONENT:
				return getComponent();
			case FelixPackage.DOCUMENT_ROOT__CONTROLLER:
				return getController();
			case FelixPackage.DOCUMENT_ROOT__HANDLER:
				return getHandler();
			case FelixPackage.DOCUMENT_ROOT__INSTANCE:
				return getInstance();
			case FelixPackage.DOCUMENT_ROOT__IPOJO:
				return getIpojo();
			case FelixPackage.DOCUMENT_ROOT__PROPERTIES:
				return getProperties();
			case FelixPackage.DOCUMENT_ROOT__PROVIDES:
				return getProvides();
			case FelixPackage.DOCUMENT_ROOT__REQUIRES:
				return getRequires();
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
			case FelixPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__CALLBACK:
				setCallback((CallbackType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__COMPONENT:
				setComponent((ComponentType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__CONTROLLER:
				setController((ControllerType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__HANDLER:
				setHandler((HandlerType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__INSTANCE:
				setInstance((InstanceType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__IPOJO:
				setIpojo((IpojoType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__PROPERTIES:
				setProperties((PropertiesType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__PROVIDES:
				setProvides((ProvidesType)newValue);
				return;
			case FelixPackage.DOCUMENT_ROOT__REQUIRES:
				setRequires((RequiresType)newValue);
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
			case FelixPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case FelixPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case FelixPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case FelixPackage.DOCUMENT_ROOT__CALLBACK:
				setCallback((CallbackType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__COMPONENT:
				setComponent((ComponentType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__CONTROLLER:
				setController((ControllerType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__HANDLER:
				setHandler((HandlerType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__INSTANCE:
				setInstance((InstanceType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__IPOJO:
				setIpojo((IpojoType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__PROPERTIES:
				setProperties((PropertiesType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__PROVIDES:
				setProvides((ProvidesType)null);
				return;
			case FelixPackage.DOCUMENT_ROOT__REQUIRES:
				setRequires((RequiresType)null);
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
			case FelixPackage.DOCUMENT_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case FelixPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case FelixPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case FelixPackage.DOCUMENT_ROOT__CALLBACK:
				return getCallback() != null;
			case FelixPackage.DOCUMENT_ROOT__COMPONENT:
				return getComponent() != null;
			case FelixPackage.DOCUMENT_ROOT__CONTROLLER:
				return getController() != null;
			case FelixPackage.DOCUMENT_ROOT__HANDLER:
				return getHandler() != null;
			case FelixPackage.DOCUMENT_ROOT__INSTANCE:
				return getInstance() != null;
			case FelixPackage.DOCUMENT_ROOT__IPOJO:
				return getIpojo() != null;
			case FelixPackage.DOCUMENT_ROOT__PROPERTIES:
				return getProperties() != null;
			case FelixPackage.DOCUMENT_ROOT__PROVIDES:
				return getProvides() != null;
			case FelixPackage.DOCUMENT_ROOT__REQUIRES:
				return getRequires() != null;
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
		result.append(" (mixed: ");
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
