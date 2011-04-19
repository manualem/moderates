package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class pong extends RemoteArduinoProtocolPacket {

	
	public pong() {
		setCommandID(RemoteArduinoProtocol.PONG);
	}
	
	public pong(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}
	
	@Override
	public void acceptMessage(RemoteArduinoMessageHandler v) {
		v.handlepong(this);
	}

	@Override
	public String toString(){
		String myString = "pong:";
		return myString;
	}

}