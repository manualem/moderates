package org.sintef.moderates.observer;

public interface RemoteArduinoClientSubject {
	public void register(RemoteArduinoClientObserver observer);
	public void unregister(RemoteArduinoClientObserver observer);
}
