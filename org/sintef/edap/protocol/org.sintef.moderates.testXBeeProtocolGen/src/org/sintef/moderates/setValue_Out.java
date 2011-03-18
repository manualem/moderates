package org.sintef.moderates;

public class setValue_Out extends OutgoingBrickLCDSensorMessage {
	
	public setValue_Out(short pin, short val) {
		setCommandID(BrickLCDSensorProtocol.SET_VALUE);
		setShortValue(pin);
		setShortValue(val);
	}

}