package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class currentData_Out extends OutgoingCurrentSensorMessage {
	
	public currentData_Out(short sensorMax, short current, short eff_current) {
		setCommandID(CurrentSensorProtocol.CURRENT_DATA);
		setShortValue(sensorMax);
		setShortValue(current);
		setShortValue(eff_current);
	}

}