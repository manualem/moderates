package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class pinMode_Out extends OutgoingRemoteArduinoMessage {
	
	public pinMode_Out(byte pin, byte mode) {
		setCommandID(RemoteArduinoProtocol.PIN_MODE);
		setByteValue(pin);
		setByteValue(mode);
	}

}