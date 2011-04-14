package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class unsubscribeMotion extends CoffeeSensorProtocolPacket {

	
	public unsubscribeMotion() {
		setCommandID(CoffeeSensorProtocol.UNSUBSCRIBE_MOTION);
	}
	
	public unsubscribeMotion(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "unsubscribeMotion:";
		return myString;
	}

}