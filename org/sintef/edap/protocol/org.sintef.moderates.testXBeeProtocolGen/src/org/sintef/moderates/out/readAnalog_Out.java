package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class readAnalog_Out extends OutgoingBrickLCDSensorMessage {
	
	public readAnalog_Out(short pin) {
		setCommandID(BrickLCDSensorProtocol.READ_ANALOG);
		setShortValue(pin);
	}

}