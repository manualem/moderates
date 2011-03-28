package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class analogValue_Out extends OutgoingBrickLCDSensorMessage {
	
	public analogValue_Out(short pin, short val) {
		setCommandID(BrickLCDSensorProtocol.ANALOG_VALUE);
		setShortValue(pin);
		setShortValue(val);
	}

}