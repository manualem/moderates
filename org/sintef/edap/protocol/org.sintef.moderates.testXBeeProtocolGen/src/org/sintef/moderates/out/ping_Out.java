package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class ping_Out extends OutgoingBrickLCDSensorMessage {
	
	public ping_Out() {
		setCommandID(BrickLCDSensorProtocol.PING);
	}

}