package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class approachingMotion extends CoffeeSensorProtocolPacket {

	
	public approachingMotion() {
		setCommandID(CoffeeSensorProtocol.APPROACHING_MOTION);
	}
	
	public approachingMotion(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "approachingMotion:";
		return myString;
	}

}