package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class displayText_Out extends OutgoingBrickLCDSensorMessage {
	
	public displayText_Out(short line, String msg) {
		setCommandID(BrickLCDSensorProtocol.DISPLAY_TEXT);
		setShortValue(line);
		setStringValue(msg);
	}

}