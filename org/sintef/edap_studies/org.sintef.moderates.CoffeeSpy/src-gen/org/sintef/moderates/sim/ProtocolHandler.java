package org.sintef.moderates.sim;

public interface ProtocolHandler {
	public void register(ProtocolHandler handler);
	public void unregister(ProtocolHandler handler);
	public void receiveMsg(byte[] msg);
}
