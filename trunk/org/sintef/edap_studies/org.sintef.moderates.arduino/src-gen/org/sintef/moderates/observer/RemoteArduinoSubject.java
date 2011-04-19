package org.sintef.moderates.observer;

public interface RemoteArduinoSubject {
	public void register(RemoteArduinoObserver observer);
	public void unregister(RemoteArduinoObserver observer);
}
