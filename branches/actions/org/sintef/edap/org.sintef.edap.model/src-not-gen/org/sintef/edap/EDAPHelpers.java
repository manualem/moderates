package org.sintef.edap;

import java.util.ArrayList;

import javax.swing.tree.VariableHeightLayoutCache;

import org.eclipse.emf.ecore.EObject;

import edap.*;

public class EDAPHelpers {
	
	public static TypeChecker typerchecker = new TypeChecker();
	
	
	
	
	public static Type getExpressionType(Expression exp) {
		return typerchecker.computeTypeOf(exp);
	}
	
	/*
	public static Component getTargetType(PropertyNavigation pnav) {
		ComponentReference cref = (ComponentReference)pnav.eContainer();
		int idx = cref.getPropertyNavigations().indexOf(pnav);
		if (idx == 0) return cref.getComponent();
		else {
			PropertyNavigation prev = cref.getPropertyNavigations().get(idx-1);
			Type t = prev.getProperty().getType();
			if (t instanceof Component) return (Component)t;
		}
		return null;
	}
	
	*/
	
	public static ArrayList<EdapModel> allEdapModels(EdapModel model) {
		ArrayList<EdapModel> result = new ArrayList<EdapModel>();
		result.add(model);
		for ( EdapModel m : model.getImports()) result.addAll(allEdapModels(m));
		return result;
	}
	
	public static Property findProperty(State state, String name) {
		State s = state;
		while (s != null) {
			for (Property p : s.getProperties()) {
				if (p.getName().equals(name)) {
					return p;
				}
			}
			if (s.eContainer() instanceof State) s = (State)s.eContainer();
			else s = null;
		}
		return null;
	}
	
	public static ArrayList<Property> allProperties(State state, String name) {
		ArrayList<Property> result = new ArrayList<Property>();
		
		State s = state;
		while (s != null) {
			for (Property p : s.getProperties()) {
				if (p.getName().startsWith(name)) {
					result.add(p);
				}
			}
			if (s.eContainer() instanceof State) s = (State)s.eContainer();
			else s = null;
		}
		return result;
	}
	
	public static State findContainingState(EObject object) {
		
		if (object instanceof State) return (State)object;
		else {
			EObject container = object.eContainer();
			if (container != null) {
				return findContainingState(container);
			} 
			else {
				return null;
			}
		}
	}
	
public static Component findContainingComponent(EObject object) {
		
		if (object instanceof Component) return (Component)object;
		else {
			EObject container = object.eContainer();
			if (container != null) {
				return findContainingComponent(container);
			} 
			else {
				return null;
			}
		}
	}
	
	public static EdapModel findRoot(EObject object) {
		EObject container = object.eContainer();
		if (container != null) {
			return findRoot(container);
		} else {
			return (EdapModel)object;
		}
	}
	
	public static Type findType(String name, EdapModel model) {
		for (EdapModel m : allEdapModels(model)) {
			for (Type t : m.getTypes()) {
				if (t.getName().equals(name)) return t;
			}
		}
		return null;
	}
	
	public static ArrayList<Type> allType(String name, EdapModel model) {
		ArrayList<Type> result = new ArrayList<Type>();
		for (EdapModel m : allEdapModels(model)) {
			for (Type t : m.getTypes()) {
				if (t.getName().startsWith(name) && !result.contains(t)) result.add(t);
				
				if (t instanceof Component) {
					addRecursiveTypes(result, name, (Component)t);
				}
			}
		}
		return result;
	}
	
	protected static void addRecursiveTypes (ArrayList<Type> result, String name, Component t) {
		if (t instanceof Component) {
			for (Component contained : ((Component) t).getCompositeComponent()) {
				if (contained.getName().startsWith(name) && !result.contains(contained)) result.add(contained);
				addRecursiveTypes (result, name, contained);
			}
		}
	}	
	
	public static Message findMessage(String device, String name, EdapModel model) {
		Message result = null;
		Component comp = findComponent(device, model);
		if (comp != null) {
		
			for (Message m : comp.getMessages()) {
				if (m.getName().equals(name)) {
					result = m;
					break;
				}
			}
		}
		return result;
	}
	
	public static ArrayList<Message> allMessage(String component, String name, EdapModel model) {
		ArrayList<Message> result = new ArrayList<Message>();
		
		Component comp = findComponent(component, model);
		
		if (comp != null) {
		
			for (Message m : comp.getMessages()) {
				if (m.getName().startsWith(name)) {
					result.add(m);
				}
			}
		}
		return result;
	}
	
	public static Component findComponent(String name, EdapModel model) {
		Component result = null;
		for (Component d : getAllComponents(model)) {
			if (d.getName().equals(name)) {
				result = d;
				break;
			}
		}
		return result;
	}
	
	public static ArrayList<Component>  allComponents(String name, EdapModel model) {
		ArrayList<Component>  result = new ArrayList<Component>();
		for (Component d : getAllComponents(model)) {
			if (d.getName().startsWith(name)) {
				result.add(d);
			}
		}
		return result;
	}
	
	public static ArrayList<Component>  allComponentsExact(String name, EdapModel model) {
		ArrayList<Component>  result = new ArrayList<Component>();
		for (Component d : getAllComponents(model)) {
			if (d.getName().equals(name)) {
				result.add(d);
			}
		}
		return result;
	}
	
	
	public static ArrayList<Component> getAllComponents(EdapModel model) {
		ArrayList<Component> result = new ArrayList<Component>();
		for (Type t : model.getTypes()) {
			if (t instanceof Component) 
				result.addAll(getAllSubcomponents((Component)t));
		}
		return result;
	}
	
	public static ArrayList<Component> getAllSubcomponents(Component c) {
		ArrayList<Component> result = new ArrayList<Component>();
		result.add(c);
		for(Component comp : c.getCompositeComponent()) result.addAll(getAllSubcomponents(comp));
		return result;
	}
	
}
