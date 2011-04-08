package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class analogRead_Out extends OutgoingRemoteArduinoMessage {
	
	public analogRead_Out(byte pin) {
		setCommandID(RemoteArduinoProtocol.ANALOG_READ);
		setByteValue(pin);
	}

}