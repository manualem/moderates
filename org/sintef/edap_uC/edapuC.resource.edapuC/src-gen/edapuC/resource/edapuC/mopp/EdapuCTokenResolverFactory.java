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

public class EdapuCTokenResolverFactory implements edapuC.resource.edapuC.IEdapuCTokenResolverFactory {
	
	private java.util.Map<String, edapuC.resource.edapuC.IEdapuCTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, edapuC.resource.edapuC.IEdapuCTokenResolver> featureName2CollectInTokenResolver;
	private static edapuC.resource.edapuC.IEdapuCTokenResolver defaultResolver = new edapuC.resource.edapuC.analysis.EdapuCDefaultTokenResolver();
	
	public EdapuCTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, edapuC.resource.edapuC.IEdapuCTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, edapuC.resource.edapuC.IEdapuCTokenResolver>();
		registerTokenResolver("STRING_LITERAL", new edapuC.resource.edapuC.analysis.EdapuCSTRING_LITERALTokenResolver());
		registerTokenResolver("TEMPLATE", new edapuC.resource.edapuC.analysis.EdapuCTEMPLATETokenResolver());
		registerTokenResolver("GENERATOR", new edapuC.resource.edapuC.analysis.EdapuCGENERATORTokenResolver());
		registerTokenResolver("TEXT", new edapuC.resource.edapuC.analysis.EdapuCTEXTTokenResolver());
	}
	
	public edapuC.resource.edapuC.IEdapuCTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public edapuC.resource.edapuC.IEdapuCTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, edapuC.resource.edapuC.IEdapuCTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, edapuC.resource.edapuC.IEdapuCTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected edapuC.resource.edapuC.IEdapuCTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private edapuC.resource.edapuC.IEdapuCTokenResolver internalCreateResolver(java.util.Map<String, edapuC.resource.edapuC.IEdapuCTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, edapuC.resource.edapuC.IEdapuCTokenResolver> resolverMap, String key, edapuC.resource.edapuC.IEdapuCTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
