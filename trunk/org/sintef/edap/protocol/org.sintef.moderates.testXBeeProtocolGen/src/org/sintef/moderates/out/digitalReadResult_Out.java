package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class digitalReadResult_Out extends OutgoingRemoteArduinoMessage {
	
	public digitalReadResult_Out(byte value) {
		setCommandID(RemoteArduinoProtocol.DIGITAL_READ_RESULT);
		setByteValue(value);
	}

}