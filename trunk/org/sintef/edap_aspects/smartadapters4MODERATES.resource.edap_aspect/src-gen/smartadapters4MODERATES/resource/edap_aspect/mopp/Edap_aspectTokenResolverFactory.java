/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectTokenResolverFactory implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolverFactory {
	
	private java.util.Map<String, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver> featureName2CollectInTokenResolver;
	private static smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver defaultResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver();
	
	public Edap_aspectTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver>();
		registerTokenResolver("ANNOTATION", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectANNOTATIONTokenResolver());
		registerTokenResolver("STRING_LITERAL", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectSTRING_LITERALTokenResolver());
		registerTokenResolver("STRING_EXT", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectSTRING_EXTTokenResolver());
		registerTokenResolver("T_MULTICAST", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectT_MULTICASTTokenResolver());
		registerTokenResolver("T_READONLY", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectT_READONLYTokenResolver());
		registerTokenResolver("T_ASPECT", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectT_ASPECTTokenResolver());
		registerTokenResolver("T_SINGLETON", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectT_SINGLETONTokenResolver());
		registerTokenResolver("MULTIPLICITY", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectMULTIPLICITYTokenResolver());
		registerTokenResolver("TXTID", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectTXTIDTokenResolver());
		registerTokenResolver("TEXT", new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectTEXTTokenResolver());
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver internalCreateResolver(java.util.Map<String, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver> resolverMap, String key, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
