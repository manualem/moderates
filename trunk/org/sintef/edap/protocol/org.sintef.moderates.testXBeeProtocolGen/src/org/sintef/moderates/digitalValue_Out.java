package org.sintef.moderates;

public class digitalValue_Out extends OutgoingBrickLCDSensorMessage {
	
	public digitalValue_Out(short pin, short val) {
		setCommandID(BrickLCDSensorProtocol.DIGITAL_VALUE);
		setShortValue(pin);
		setShortValue(val);
	}

}