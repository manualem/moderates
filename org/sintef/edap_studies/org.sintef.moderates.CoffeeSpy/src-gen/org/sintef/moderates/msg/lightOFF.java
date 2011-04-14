package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class lightOFF extends CoffeeSensorProtocolPacket {

	
	public lightOFF() {
		setCommandID(CoffeeSensorProtocol.LIGHT_OFF);
	}
	
	public lightOFF(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "lightOFF:";
		return myString;
	}

}