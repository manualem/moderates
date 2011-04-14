package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class ping extends CoffeeSensorProtocolPacket {

	
	public ping() {
		setCommandID(CoffeeSensorProtocol.PING);
	}
	
	public ping(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "ping:";
		return myString;
	}

}