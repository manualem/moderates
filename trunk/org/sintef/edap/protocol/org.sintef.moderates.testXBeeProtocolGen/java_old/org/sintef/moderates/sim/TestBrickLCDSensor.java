package org.sintef.moderates.sim;

import org.sintef.moderates.sim.InteractiveBrickLCDSensorDataController;
import org.sintef.moderates.sim.InteractiveBrickLCDSensorDataController2;

public class TestBrickLCDSensor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveBrickLCDSensorDataController controller1 = new InteractiveBrickLCDSensorDataController();
		InteractiveBrickLCDSensorDataController2 controller2 = new InteractiveBrickLCDSensorDataController2();
		controller1.register(controller2);
		controller2.register(controller1);
	}

}