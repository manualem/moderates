package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class ping_Out extends OutgoingRemoteArduinoMessage {
	
	public ping_Out() {
		setCommandID(RemoteArduinoProtocol.PING);
	}

}