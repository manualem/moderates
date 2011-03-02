/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class EdapAttributeValueProvider {
	
	public Object[] getDefaultValues(org.eclipse.emf.ecore.EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + edap.resource.edap.util.EdapStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}