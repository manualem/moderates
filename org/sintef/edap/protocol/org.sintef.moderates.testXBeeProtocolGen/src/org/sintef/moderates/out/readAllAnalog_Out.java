package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class readAllAnalog_Out extends OutgoingBrickLCDSensorMessage {
	
	public readAllAnalog_Out() {
		setCommandID(BrickLCDSensorProtocol.READ_ALL_ANALOG);
	}

}