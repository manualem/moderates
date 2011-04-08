package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class detachInterrupt_Out extends OutgoingRemoteArduinoMessage {
	
	public detachInterrupt_Out(byte interrupt) {
		setCommandID(RemoteArduinoProtocol.DETACH_INTERRUPT);
		setByteValue(interrupt);
	}

}