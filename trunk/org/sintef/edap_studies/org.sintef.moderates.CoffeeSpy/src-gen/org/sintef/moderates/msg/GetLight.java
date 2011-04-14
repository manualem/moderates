package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class GetLight extends CoffeeSensorProtocolPacket {

	
	public GetLight() {
		setCommandID(CoffeeSensorProtocol.GET_LIGHT);
	}
	
	public GetLight(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "GetLight:";
		return myString;
	}

}