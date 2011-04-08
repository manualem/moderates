package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class start_Out extends OutgoingCurrentSensorMessage {
	
	public start_Out() {
		setCommandID(CurrentSensorProtocol.START);
	}

}