package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class digitalRead_Out extends OutgoingRemoteArduinoMessage {
	
	public digitalRead_Out(byte pin) {
		setCommandID(RemoteArduinoProtocol.DIGITAL_READ);
		setByteValue(pin);
	}

}