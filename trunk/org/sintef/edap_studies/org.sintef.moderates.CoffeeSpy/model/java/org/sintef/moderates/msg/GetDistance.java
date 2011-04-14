package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class GetDistance extends CoffeeSensorProtocolPacket {

	
	public GetDistance() {
		setCommandID(CoffeeSensorProtocol.GET_DISTANCE);
	}
	
	public GetDistance(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "GetDistance:";
		return myString;
	}

}