/*
 * Copyright 2009 OW2 Chameleon
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ow2.chameleon.eclipse.ipojo.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.felix.ipojo.manipulator.store.builder.DefaultManifestBuilder;

/**
 * Extension of the default manifest builder : Import-Package value is now
 * sorted.
 * 
 * Avoids a weird behavior of JDT : when Import-Package value order changes, the
 * project is fully-rebuilt, calling iPOJO Builder again, modifying the
 * Import-Package again, etc.
 * 
 * @author Thomas Calmant
 */
public class SortedManifestBuilder extends DefaultManifestBuilder {

	private List<String> packagesToExport = new ArrayList<String>();	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.felix.ipojo.manipulator.store.builder.DefaultManifestBuilder
	 * #parseHeader(java.lang.String)
	 */
	@Override
	protected Map<String, Map<String, String>> parseHeader(final String aValue) {

		final TreeMap<String, Map<String, String>> sortedResult = new TreeMap<String, Map<String, String>>();
		sortedResult.putAll(super.parseHeader(aValue));
		return sortedResult;
	}
	
	@Override
	public Manifest build(Manifest original) {
	   Manifest newManifest = super.build(original); 
	   Attributes att = original.getMainAttributes();
	   setExports(att);
	   return newManifest;
	}
	
	protected void setExports(Attributes att) {
		 Map<String, Map<String, String>> exports = parseHeader(att.getValue("Export-Package"));
		 
       // Add referred imports from the metadata
       for (int i = 0; i < packagesToExport.size(); i++) {
           String pack = packagesToExport.get(i);
           exports.put(pack, new TreeMap<String, String>());
       }
       
       // Write imports
       if (!exports.isEmpty())
      	 att.putValue("Export-Package", printClauses(exports, "resolution:"));
	}
	
	
   /**
    * Print a standard Map based OSGi header.
    *
    * @param exports : map { name => Map { attribute|directive => value } }
    * @param allowedDirectives list of allowed directives.
    * @return the clauses
    */
   private String printClauses(Map<String, Map<String, String>> exports, String allowedDirectives) {
       StringBuffer sb = new StringBuffer();
       String del = "";

       for (Iterator i = exports.entrySet().iterator(); i.hasNext();) {
           Map.Entry entry = (Map.Entry) i.next();
           String name = (String) entry.getKey();
           Map map = (Map) entry.getValue();
           sb.append(del);
           sb.append(name);

           for (Iterator j = map.entrySet().iterator(); j.hasNext();) {
               Map.Entry entry2 = (Map.Entry) j.next();
               String key = (String) entry2.getKey();

               // Skip directives we do not recognize
               if (key.endsWith(":") && allowedDirectives.indexOf(key) < 0) {
                   continue;
               }

               String value = (String) entry2.getValue();
               sb.append(";");
               sb.append(key);
               sb.append("=");
               boolean dirty = value.indexOf(',') >= 0 || value.indexOf(';') >= 0;
               if (dirty) {
                   sb.append("\"");
               }
               sb.append(value);
               if (dirty) {
                   sb.append("\"");
               }
           }
           del = ", ";
       }
       return sb.toString();
   }
   
   public void addPackageToExport(Set<String> packageNames) {
   	packagesToExport.addAll(packageNames);
  }
	
}
