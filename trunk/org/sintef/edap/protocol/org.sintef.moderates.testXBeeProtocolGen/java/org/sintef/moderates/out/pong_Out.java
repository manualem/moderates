package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class pong_Out extends OutgoingCurrentSensorMessage {
	
	public pong_Out() {
		setCommandID(CurrentSensorProtocol.PONG);
	}

}