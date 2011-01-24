/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import java.util.ArrayList;

import org.sintef.edap.EDAPHelpers;

import edap.Component;
import edap.EdapModel;
import edap.Message;

public class ComponentReceivesReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Component, edap.Message> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Component, edap.Message> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Component, edap.Message>();
	
	public void resolve(java.lang.String identifier, edap.Component container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Message> result) {
		EdapModel root = EDAPHelpers.findRoot(container);
		ArrayList<Component> checked = new ArrayList<Component>();
		ArrayList<EdapModel> checkedModels = new ArrayList<EdapModel>();
		checkReceivedMessages(container, 
				identifier, 
				resolveFuzzy,
				true,
				result);	
		checked.add(container);
		checkModelComponents (root, identifier, resolveFuzzy, checked, checkedModels, result);
	}
	
	protected void checkModelComponents (EdapModel m, 
			String id, 
			boolean fuzzy, 
			ArrayList<Component> checked,
			ArrayList<EdapModel> checkedModels,
			final edap.resource.edap.IEdapReferenceResolveResult<edap.Message> result) {
		
		ArrayList<Component> allComps = EDAPHelpers.getAllComponents(m);
		
		for(Component c : allComps) {
			if (!checked.contains(c)) {
				checked.add(c);
				checkReceivedMessages(c, 
						id, 
						fuzzy,
						false,
						result);				
			}
		}
		
		checkedModels.add(m);
		for (EdapModel imported : m.getImports()) {
			if (!(checkedModels.contains(imported)))
				checkModelComponents (imported, id, fuzzy, checked, checkedModels, result);						
		}
	}
	
	
	/**
	 * 
	 * @param owner
	 * @param id
	 */
	protected void checkReceivedMessages (edap.Component owner, 
			String id, 
			boolean fuzzy,
			boolean isOwner,
			final edap.resource.edap.IEdapReferenceResolveResult<edap.Message> result) {
		
		String lookFor = "";
		for (Message m : owner.getMessages()) {
			if (isOwner) {
				lookFor = m.getName();
			} else {
				lookFor = m.getName();
			}
			if (fuzzy && lookFor.startsWith(id)) {
				result.addMapping(lookFor, m);
			} else if (lookFor.equalsIgnoreCase(id)) {
				result.addMapping(lookFor, m);
			}
		}
	}
	
	public java.lang.String deResolve(edap.Message element, edap.Component container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
