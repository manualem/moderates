/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

/**
 * The EdapTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class EdapTokenResolverFactory implements edap.resource.edap.IEdapTokenResolverFactory {
	
	private java.util.Map<String, edap.resource.edap.IEdapTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, edap.resource.edap.IEdapTokenResolver> featureName2CollectInTokenResolver;
	private static edap.resource.edap.IEdapTokenResolver defaultResolver = new edap.resource.edap.analysis.EdapDefaultTokenResolver();
	
	public EdapTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, edap.resource.edap.IEdapTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, edap.resource.edap.IEdapTokenResolver>();
		registerTokenResolver("ANNOTATION", new edap.resource.edap.analysis.EdapANNOTATIONTokenResolver());
		registerTokenResolver("BOOLEAN_LITERAL", new edap.resource.edap.analysis.EdapBOOLEAN_LITERALTokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new edap.resource.edap.analysis.EdapINTEGER_LITERALTokenResolver());
		registerTokenResolver("STRING_LITERAL", new edap.resource.edap.analysis.EdapSTRING_LITERALTokenResolver());
		registerTokenResolver("STRING_EXT", new edap.resource.edap.analysis.EdapSTRING_EXTTokenResolver());
		registerTokenResolver("T_MULTICAST", new edap.resource.edap.analysis.EdapT_MULTICASTTokenResolver());
		registerTokenResolver("T_READONLY", new edap.resource.edap.analysis.EdapT_READONLYTokenResolver());
		registerTokenResolver("T_ASPECT", new edap.resource.edap.analysis.EdapT_ASPECTTokenResolver());
		registerTokenResolver("T_SINGLETON", new edap.resource.edap.analysis.EdapT_SINGLETONTokenResolver());
		registerTokenResolver("TEXT", new edap.resource.edap.analysis.EdapTEXTTokenResolver());
	}
	
	public edap.resource.edap.IEdapTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public edap.resource.edap.IEdapTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, edap.resource.edap.IEdapTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, edap.resource.edap.IEdapTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected edap.resource.edap.IEdapTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private edap.resource.edap.IEdapTokenResolver internalCreateResolver(java.util.Map<String, edap.resource.edap.IEdapTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, edap.resource.edap.IEdapTokenResolver> resolverMap, String key, edap.resource.edap.IEdapTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
