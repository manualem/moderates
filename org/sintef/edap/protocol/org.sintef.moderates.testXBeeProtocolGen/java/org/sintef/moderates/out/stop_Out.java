package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class stop_Out extends OutgoingCurrentSensorMessage {
	
	public stop_Out() {
		setCommandID(CurrentSensorProtocol.STOP);
	}

}