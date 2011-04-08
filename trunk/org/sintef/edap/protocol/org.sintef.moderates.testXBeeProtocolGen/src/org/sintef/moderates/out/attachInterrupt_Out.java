package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class attachInterrupt_Out extends OutgoingRemoteArduinoMessage {
	
	public attachInterrupt_Out(byte interrupt, byte mode) {
		setCommandID(RemoteArduinoProtocol.ATTACH_INTERRUPT);
		setByteValue(interrupt);
		setByteValue(mode);
	}

}