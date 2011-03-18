package org.sintef.moderates;

public class setDigital_Out extends OutgoingBrickLCDSensorMessage {
	
	public setDigital_Out(short pin, short direction) {
		setCommandID(BrickLCDSensorProtocol.SET_DIGITAL);
		setShortValue(pin);
		setShortValue(direction);
	}

}