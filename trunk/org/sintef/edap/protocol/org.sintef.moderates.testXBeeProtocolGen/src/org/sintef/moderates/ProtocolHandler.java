package org.sintef.moderates;

public interface ProtocolHandler {
	public void register(ProtocolHandler handler);
	public void receiveMsg(byte[] msg);
}
