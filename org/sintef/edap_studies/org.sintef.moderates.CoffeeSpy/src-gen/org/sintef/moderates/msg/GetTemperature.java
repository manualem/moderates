package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class GetTemperature extends CoffeeSensorProtocolPacket {

	
	public GetTemperature() {
		setCommandID(CoffeeSensorProtocol.GET_TEMPERATURE);
	}
	
	public GetTemperature(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "GetTemperature:";
		return myString;
	}

}