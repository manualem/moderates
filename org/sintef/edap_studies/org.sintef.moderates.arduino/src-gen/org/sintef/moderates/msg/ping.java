package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class ping extends RemoteArduinoProtocolPacket {

	
	public ping() {
		setCommandID(RemoteArduinoProtocol.PING);
	}
	
	public ping(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handleping(this);
	}

	@Override
	public String toString(){
		String myString = "ping:";
		return myString;
	}

}