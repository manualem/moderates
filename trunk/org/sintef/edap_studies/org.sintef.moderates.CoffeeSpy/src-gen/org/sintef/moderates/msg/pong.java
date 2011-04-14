package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class pong extends CoffeeSensorProtocolPacket {

	
	public pong() {
		setCommandID(CoffeeSensorProtocol.PONG);
	}
	
	public pong(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "pong:";
		return myString;
	}

}