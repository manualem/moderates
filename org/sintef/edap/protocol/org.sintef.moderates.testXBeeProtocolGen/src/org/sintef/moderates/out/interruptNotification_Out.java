package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class interruptNotification_Out extends OutgoingRemoteArduinoMessage {
	
	public interruptNotification_Out(byte interrupt) {
		setCommandID(RemoteArduinoProtocol.INTERRUPT_NOTIFICATION);
		setByteValue(interrupt);
	}

}