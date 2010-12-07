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
 
package edapuC.resource.edapuC.mopp;

public class EdapuCBracketInformationProvider {
	
	public class BracketPair implements edapuC.resource.edapuC.IEdapuCBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<edapuC.resource.edapuC.IEdapuCBracketPair> getBracketPairs() {
		java.util.Collection<edapuC.resource.edapuC.IEdapuCBracketPair> result = new java.util.ArrayList<edapuC.resource.edapuC.IEdapuCBracketPair>();
		result.add(new BracketPair("{", "}", true));
		return result;
	}
	
}
