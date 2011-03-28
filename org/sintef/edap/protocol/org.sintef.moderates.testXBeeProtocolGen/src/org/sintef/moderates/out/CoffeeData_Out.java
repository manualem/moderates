package org.sintef.moderates.out;

import org.sintef.moderates.*;

public class CoffeeData_Out extends OutgoingCoffeeSensorMessage {
	
	public CoffeeData_Out(short temp, short dist, short light) {
		setCommandID(CoffeeSensorProtocol.COFFEE_DATA);
		setShortValue(temp);
		setShortValue(dist);
		setShortValue(light);
	}

}