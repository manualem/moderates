package smartadapters4MODERATES.resource.edap_aspect.analysis.utils;

import org.eclipse.emf.ecore.EObject;

import edap_relaxed.*;
import smartadapters4MODERATES.*;
import smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBackgroundParsingListener;
import smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFragment;
import smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult;
import smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource;
import smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectEObjectUtil;

public class IntraPatternResolverDelegate<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	//public final static java.lang.String NAME_FEATURE = "name";
	
	public EObject getParentPModel(EObject obj) {
		EObject result = obj;
		while ( result instanceof AspectModelElement && result.eContainer() != null) {
			result = result.eContainer();
		}
		return result;
	}
	
	
	// This standard implementation searches the tree for objects of the 
	// correct type with a name attribute matching the identifier.
	public void resolve(java.lang.String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IEdap_aspectReferenceResolveResult<ReferenceType> result) {
		try {
			org.eclipse.emf.ecore.EClass type = reference.getEReferenceType();
			org.eclipse.emf.ecore.EObject root = getParentPModel(container);
			// first check whether the root element matches
			boolean continueSearch = checkElement(root, type, identifier, resolveFuzzy, result);
			if (!continueSearch) {
				return;
			}
			// then check the contents
			for (java.util.Iterator<org.eclipse.emf.ecore.EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
				org.eclipse.emf.ecore.EObject element = iterator.next();
				continueSearch = checkElement(element, type, identifier, resolveFuzzy, result);
				if (!continueSearch) {
					return;
				}
			}
		} catch (java.lang.RuntimeException rte) {
			// catch exception here to prevent EMF proxy resolution from swallowing it
			rte.printStackTrace();
		}
	}
	
	private boolean checkElement(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EClass type, java.lang.String identifier, boolean resolveFuzzy, IEdap_aspectReferenceResolveResult<ReferenceType> result) {
		if (element.eIsProxy()) {
			return true;
		}
		
		boolean hasCorrectType = hasCorrectType(element, type.getInstanceClass());
		if (!hasCorrectType) {
			return true;
		}
		
		String match1 = matches(element, identifier, resolveFuzzy, "name");
		if (match1 != null) {
			result.addMapping(match1, cast(element));
			if (!resolveFuzzy) {
				return false;
			}
		}

		
		String match2 = matches(element, identifier, resolveFuzzy, "pid");
		if (match2 == null) {
			return true;
		}
		// we can safely cast 'element' to 'ReferenceType' here,
		// because we've checked the type of 'element' against
		// the type of the reference. unfortunately the compiler
		// does not know that this is sufficient, so we must call
		// cast(), which is not type safe by itself.
		result.addMapping(match2, cast(element));
		if (!resolveFuzzy) {
			return false;
		}
		
		
		return true;
	}
	
	// This method encapsulates an unchecked cast from EObject to
	// ReferenceType. We can not do this cast strictly type safe,
	// because type parameters are erased by compilation. Thus, an
	// instanceof check can not be performed at runtime.
	@SuppressWarnings("unchecked")	
	private ReferenceType cast(org.eclipse.emf.ecore.EObject element) {
		return (ReferenceType) element;
	}
	
	protected java.lang.String produceDeResolveErrorMessage(org.eclipse.emf.ecore.EObject refObject, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, IEdap_aspectTextResource resource) {
		java.lang.String msg = getClass().getSimpleName() + ": " + reference.getEType().getName() + " \"" + refObject.toString() + "\" not de-resolveable";
		return msg;
	}
	
	public java.lang.String deResolve(ReferenceType element, ContainerType container, org.eclipse.emf.ecore.EReference reference) {
		String result = getName(element, "name");
		if (result == null || result.trim().equals(""))
			result = getName(element, "pid");
		if (result == null || result.trim().equals(""))
			result = "?";
		return result;
	}
	
	private java.lang.String matches(org.eclipse.emf.ecore.EObject element, java.lang.String identifier, boolean matchFuzzy, String name_feature) {
		// first check for attributes that have set the ID flag to true
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = element.eClass().getEStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
				org.eclipse.emf.ecore.EAttribute attribute = (org.eclipse.emf.ecore.EAttribute) feature;
				if (attribute.isID()) {
					java.lang.Object attributeValue = element.eGet(attribute);
					java.lang.String match = matches(identifier, attributeValue, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
		}
		
		// then check for an attribute that is called 'name'
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(name_feature);
		if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			java.lang.Object attributeValue = element.eGet(nameAttr);
			return matches(identifier, attributeValue, matchFuzzy);
		} else {
			//try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute stringAttribute : element.eClass().getEAllAttributes()) {
				if (stringAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					java.lang.Object attributeValue = element.eGet(stringAttribute);
					java.lang.String match = matches(identifier, attributeValue, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
			
			for (org.eclipse.emf.ecore.EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(name_feature) && o.getEParameters().size() == 0 ) {
					java.lang.String result = (java.lang.String) Edap_aspectEObjectUtil.invokeOperation(element, o);
					java.lang.String match = matches(identifier, result, matchFuzzy);
					if (match != null) {
						return match;
					}
				}
			}
		}
		return null;
	}
	
	private java.lang.String matches(java.lang.String identifier, java.lang.Object attributeValue, boolean matchFuzzy) {
		if (attributeValue != null && attributeValue instanceof java.lang.String) {
			java.lang.String name = (java.lang.String) attributeValue;
			if (name.startsWith(identifier) && matchFuzzy) {
				return name;
			}
			if (name.equals(identifier)) {
				return identifier;
			}
		}
		return null;
	}
	
	private java.lang.String getName(ReferenceType element, String name_feature) {
		org.eclipse.emf.ecore.EStructuralFeature nameAttr = element.eClass().getEStructuralFeature(name_feature);
		if(element.eIsProxy()) {
			java.lang.String fragment = ((org.eclipse.emf.ecore.InternalEObject) element).eProxyURI().fragment();
			if (fragment != null && fragment.startsWith(IEdap_aspectContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
				fragment = fragment.substring(IEdap_aspectContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
				fragment = fragment.substring(fragment.indexOf("_") + 1);
			}
			return fragment;
		}
		else if (nameAttr instanceof org.eclipse.emf.ecore.EAttribute) {
			return (java.lang.String) element.eGet(nameAttr);
		} else {
			//try any other string attribute found
			for (org.eclipse.emf.ecore.EAttribute strAttribute : element.eClass().getEAllAttributes()) {
				if (!strAttribute.isMany() &&				strAttribute.getEType().getInstanceClassName().equals(java.lang.String.class.getName())) {
					return (java.lang.String) element.eGet(strAttribute);
				}
			}
			for (org.eclipse.emf.ecore.EOperation o : element.eClass().getEAllOperations()) {
				if (o.getName().toLowerCase().endsWith(name_feature) && o.getEParameters().size() == 0 ) {
					java.lang.String result = (java.lang.String) Edap_aspectEObjectUtil.invokeOperation(element, o);
					if (result != null) {
						return result;
					}
				}
			}
		}
		return null;
	}
	
	private boolean hasCorrectType(org.eclipse.emf.ecore.EObject element, Class<?> expectedTypeClass) {
		return expectedTypeClass.isInstance(element);
	}
}
