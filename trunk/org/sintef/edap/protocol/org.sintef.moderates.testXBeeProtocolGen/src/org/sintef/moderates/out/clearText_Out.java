package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class clearText_Out extends OutgoingBrickLCDSensorMessage {
	
	public clearText_Out() {
		setCommandID(BrickLCDSensorProtocol.CLEAR_TEXT);
	}

}