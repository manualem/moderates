package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class pong_Out extends OutgoingRemoteArduinoMessage {
	
	public pong_Out() {
		setCommandID(RemoteArduinoProtocol.PONG);
	}

}