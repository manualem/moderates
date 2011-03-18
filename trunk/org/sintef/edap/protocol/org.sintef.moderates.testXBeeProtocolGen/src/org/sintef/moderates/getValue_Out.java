package org.sintef.moderates;

public class getValue_Out extends OutgoingBrickLCDSensorMessage {
	
	public getValue_Out(short pin) {
		setCommandID(BrickLCDSensorProtocol.GET_VALUE);
		setShortValue(pin);
	}

}