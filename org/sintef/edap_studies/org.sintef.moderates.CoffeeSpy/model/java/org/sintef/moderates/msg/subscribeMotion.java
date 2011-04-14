package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class subscribeMotion extends CoffeeSensorProtocolPacket {

	
	public subscribeMotion() {
		setCommandID(CoffeeSensorProtocol.SUBSCRIBE_MOTION);
	}
	
	public subscribeMotion(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "subscribeMotion:";
		return myString;
	}

}