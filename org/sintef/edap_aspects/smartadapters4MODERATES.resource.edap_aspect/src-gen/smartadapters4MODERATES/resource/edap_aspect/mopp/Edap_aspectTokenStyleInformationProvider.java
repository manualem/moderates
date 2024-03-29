/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectTokenStyleInformationProvider {
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("TEXT".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x00, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("T_MULTICAST".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("T_READONLY".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x00, 0xaa, 0x33}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x00, 0xaa, 0x33}, null, false, false, false, false);
		}
		if ("ANNOTATION".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, true, false, false, false);
		}
		if ("STRING_LITERAL".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, false, false, false, false);
		}
		if ("device".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("datatype".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("enumeration".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("T_ASPECT".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("T_SINGLETON".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("sends".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("receives".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("STRING_EXT".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, false, false, false, false);
		}
		if ("state".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("composite".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("statechart".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("component".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("event".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eventref".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("guard".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("action".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("on".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("entry".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("exit".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("send".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("transition".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("init".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("connector".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("port".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("import".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("(".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if (")".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("{".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("}".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("[".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("]".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("aspect".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("pointcut".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("advice".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("strategies".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("protocol".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("global".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("per".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("role".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("elements".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("set".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("initial".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("substate".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("outgoing".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("incoming".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("properties".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("target".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("source".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("element".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("annotations".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("block".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("actions".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("model".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("message".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("simulator".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("for".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("property".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("dictionary".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("broadcast".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("create".equals(tokenName)) {
			return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		return null;
	}
	
}
