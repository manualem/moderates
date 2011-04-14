package org.sintef.moderates.observer;

public interface CoffeeSensorClientSubject {
	public void register(CoffeeSensorClientObserver observer);
	public void unregister(CoffeeSensorClientObserver observer);
}
