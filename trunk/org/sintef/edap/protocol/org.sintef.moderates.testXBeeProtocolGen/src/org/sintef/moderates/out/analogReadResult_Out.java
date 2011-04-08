package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class analogReadResult_Out extends OutgoingRemoteArduinoMessage {
	
	public analogReadResult_Out(short value) {
		setCommandID(RemoteArduinoProtocol.ANALOG_READ_RESULT);
		setShortValue(value);
	}

}