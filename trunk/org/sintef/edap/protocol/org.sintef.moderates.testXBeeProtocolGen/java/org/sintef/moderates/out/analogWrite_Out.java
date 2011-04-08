package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class analogWrite_Out extends OutgoingRemoteArduinoMessage {
	
	public analogWrite_Out(byte pin, byte value) {
		setCommandID(RemoteArduinoProtocol.ANALOG_WRITE);
		setByteValue(pin);
		setByteValue(value);
	}

}