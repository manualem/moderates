package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class digitalWrite_Out extends OutgoingRemoteArduinoMessage {
	
	public digitalWrite_Out(byte pin, byte value) {
		setCommandID(RemoteArduinoProtocol.DIGITAL_WRITE);
		setByteValue(pin);
		setByteValue(value);
	}

}