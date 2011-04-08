package org.sintef.moderates.sim;

import org.sintef.moderates.sim.InteractiveCurrentSensorDataController;
import org.sintef.moderates.sim.InteractiveCurrentSensorDataController2;

public class TestCurrentSensor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveCurrentSensorDataController controller1 = new InteractiveCurrentSensorDataController();
		InteractiveCurrentSensorDataController2 controller2 = new InteractiveCurrentSensorDataController2();
		controller1.register(controller2);
		controller2.register(controller1);
	}

}