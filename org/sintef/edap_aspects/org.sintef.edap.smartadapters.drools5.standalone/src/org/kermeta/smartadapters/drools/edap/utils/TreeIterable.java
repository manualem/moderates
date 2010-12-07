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
package org.kermeta.smartadapters.drools.edap.utils;

import java.util.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

public class TreeIterable<EObject> implements Iterable<EObject>{
	TreeIterator<EObject> wrapper;
	public TreeIterable(TreeIterator<EObject> o ) {
		wrapper = o;
	}
	
	public Iterator<EObject> iterator() {
		return wrapper;
	}

}
