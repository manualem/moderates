package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class ping_Out extends OutgoingCurrentSensorMessage {
	
	public ping_Out() {
		setCommandID(CurrentSensorProtocol.PING);
	}

}