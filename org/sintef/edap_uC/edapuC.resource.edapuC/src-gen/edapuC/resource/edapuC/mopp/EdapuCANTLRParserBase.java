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

public abstract class EdapuCANTLRParserBase extends org.antlr.runtime3_2_0.Parser implements edapuC.resource.edapuC.IEdapuCTextParser {
	
	public EdapuCANTLRParserBase(org.antlr.runtime3_2_0.TokenStream input) {
		super(input);
	}
	
	public EdapuCANTLRParserBase(org.antlr.runtime3_2_0.TokenStream input, org.antlr.runtime3_2_0.RecognizerSharedState state) {
		super(input, state);
	}
	
}
