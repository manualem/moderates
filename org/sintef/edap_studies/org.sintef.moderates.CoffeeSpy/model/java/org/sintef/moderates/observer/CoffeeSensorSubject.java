package org.sintef.moderates.observer;

public interface CoffeeSensorSubject {
	public void register(CoffeeSensorObserver observer);
	public void unregister(CoffeeSensorObserver observer);
}
