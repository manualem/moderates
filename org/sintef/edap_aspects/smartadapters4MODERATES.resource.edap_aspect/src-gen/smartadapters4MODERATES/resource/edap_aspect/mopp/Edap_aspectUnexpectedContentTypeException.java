/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectOptions.RESOURCE_CONTEN
 * T_TYPE
 */
public class Edap_aspectUnexpectedContentTypeException extends org.antlr.runtime3_2_0.RecognitionException{
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  Edap_aspectUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
