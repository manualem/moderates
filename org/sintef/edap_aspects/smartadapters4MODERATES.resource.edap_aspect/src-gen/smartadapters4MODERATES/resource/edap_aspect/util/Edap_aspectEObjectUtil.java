/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.util;

/**
 * A utility class that can be used to work with EObjects. While many similar
 * methods are provided by EMF's own EcoreUtil class, the missing ones are
 * collected here.
 * 
 * @see org.eclipse.emf.ecore.util.EcoreUtil
 */
public class Edap_aspectEObjectUtil {
	
	public static <T> java.util.Collection<T> getObjectsByType(java.util.Iterator<?> iterator,
	org.eclipse.emf.ecore.EClassifier type) {
		java.util.Collection<T> result = new java.util.ArrayList<T>();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			if (type.isInstance(object)) {
				@SuppressWarnings("unchecked")				
				T t = (T) object;
				result.add(t);
			}
		}
		return result;
	}
	
	public static org.eclipse.emf.ecore.EObject findRootContainer(org.eclipse.emf.ecore.EObject object) {
		org.eclipse.emf.ecore.EObject container = object.eContainer();
		if (container != null) {
			return findRootContainer(container);
		} else {
			return object;
		}
	}
	
	public static Object invokeOperation(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EOperation o) {
		java.lang.reflect.Method method;
		try {
			method = element.getClass().getMethod(o.getName(), new Class[]{});
			if (method != null) {
				Object result = method.invoke(element, new Object[]{});
				return result;
			}
		} catch (SecurityException e) {
			smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPlugin.logError("Exception while matching proxy URI.", e);
		} catch (NoSuchMethodException e) {
			smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalArgumentException e) {
			smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPlugin.logError("Exception while matching proxy URI.", e);
		} catch (IllegalAccessException e) {
			smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPlugin.logError("Exception while matching proxy URI.", e);
		} catch (java.lang.reflect.InvocationTargetException e) {
			smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPlugin.logError("Exception while matching proxy URI.", e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")	
	public static void setFeature(org.eclipse.emf.ecore.EObject object, org.eclipse.emf.ecore.EStructuralFeature eFeature, Object value, boolean clearIfList) {
		int upperBound = eFeature.getUpperBound();
		if (upperBound > 1 || upperBound < 0) {
			Object oldValue = object.eGet(eFeature);
			if (oldValue instanceof java.util.List<?>) {
				java.util.List<Object> list = (java.util.List<Object>) oldValue;
				if (clearIfList) {
					list.clear();
				}
				list.add(value);
			} else {
				assert false;
			}
		} else {
			object.eSet(eFeature, value);
		}
	}
	
}
