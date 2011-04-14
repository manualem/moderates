package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class lightON extends CoffeeSensorProtocolPacket {

	
	public lightON() {
		setCommandID(CoffeeSensorProtocol.LIGHT_ON);
	}
	
	public lightON(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "lightON:";
		return myString;
	}

}