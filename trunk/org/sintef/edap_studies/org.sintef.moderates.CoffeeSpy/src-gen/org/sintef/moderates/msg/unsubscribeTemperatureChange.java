package org.sintef.moderates.msg;

import org.sintef.moderates.*;

import java.nio.ByteBuffer;

public class unsubscribeTemperatureChange extends CoffeeSensorProtocolPacket {

	
	public unsubscribeTemperatureChange() {
		setCommandID(CoffeeSensorProtocol.UNSUBSCRIBE_TEMPERATURE_CHANGE);
	}
	
	public unsubscribeTemperatureChange(byte[] packet) {
		setPacketData(packet);
		int position = 5;
		
	}

	@Override
	public String toString(){
		String myString = "unsubscribeTemperatureChange:";
		return myString;
	}

}