package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class subscribeTemperatureChange extends CoffeeSensorProtocolPacket {

	
	public subscribeTemperatureChange() {
		setCommandID(CoffeeSensorProtocol.SUBSCRIBE_TEMPERATURE_CHANGE);
	}
	
	public subscribeTemperatureChange(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "subscribeTemperatureChange:";
		return myString;
	}

}