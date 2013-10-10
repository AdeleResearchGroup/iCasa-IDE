/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.apache.felix.util;

import java.util.Map;

import org.apache.felix.FelixPackage;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FelixXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FelixXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		FelixPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the FelixResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new FelixResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new FelixResourceFactoryImpl());
		}
		return registrations;
	}

} //FelixXMLProcessor
