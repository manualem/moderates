/*******************************************************************************
 * Copyright (c) 2010 SINTEF
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SINTEF - initial API and implementation
 ******************************************************************************/
package edapuC.resource.edapuC.analysis;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

import edap.Component;
import edap.Device;
import edap.EdapModel;
import edap.Message;
import edap.resource.edap.analysis.helper.EDAPHelpers;
import edapuC.UCDevice;
import edapuC.UCGenerator;

public class UCGeneratorHelpers {

	public static ArrayList<Message> findMessages(String id, UCDevice d) {
		ArrayList<Message> result = new ArrayList<Message>();
		for (Message m : d.getDevice().getReceives()) {
			if (m.getName().startsWith(id)) result.add(m);
		}
		return result;
	}
	
	
	public static UCGenerator findRootUCGenerator(EObject object) {
		EObject container = object.eContainer();
		if (container != null) {
			return findRootUCGenerator(container);
		} else {
			return (UCGenerator)object;
		}
	}
	
	public static ArrayList<Device> resolveDevice(String id, UCGenerator g) {
		ArrayList<Device> result = new ArrayList<Device>();
		for (EdapModel m : getAllEdapModels(g)) {
			for (Component c : EDAPHelpers.getAllComponents(m)) {
				if (c instanceof Device && c.getName().startsWith(id))
					result.add((Device)c);
			}
		}
		return result;
	}
	
	public static ArrayList<Component> resolveComponent(String id, UCGenerator g) {
		ArrayList<Component> result = new ArrayList<Component>();
		for (EdapModel m : getAllEdapModels(g)) {
			for (Component c : EDAPHelpers.getAllComponents(m)) {
				if (c.getName().startsWith(id))
					result.add(c);
			}
		}
		return result;
	}
	
	public static ArrayList<EdapModel> getAllEdapModels(UCGenerator g) {
		ArrayList<EdapModel> models = new ArrayList<EdapModel>();
		for (EdapModel m : g.getEdap()) {
			for(EdapModel mo : EDAPHelpers.allEdapModels(m)) {
				if (!models.contains(mo)) models.add(mo);
			}
		}
		return models;
	}
}
