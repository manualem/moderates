package org.sintef.moderates.observer;

public interface RemoteArduinoClientObserver {
	public void receiveMsg(byte[] msg);
}
