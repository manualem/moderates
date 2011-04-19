package org.sintef.moderates.observer;

public interface RemoteArduinoObserver {
	public void receiveMsg(byte[] msg);
}
