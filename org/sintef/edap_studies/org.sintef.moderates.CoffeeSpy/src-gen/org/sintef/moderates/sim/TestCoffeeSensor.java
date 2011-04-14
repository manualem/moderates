package org.sintef.moderates.sim;

import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController;
import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController2;

public class TestCoffeeSensor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveCoffeeSensorDataController controller1 = new InteractiveCoffeeSensorDataController();
		InteractiveCoffeeSensorDataController2 controller2 = new InteractiveCoffeeSensorDataController2();
		controller1.register(controller2);
		controller2.register(controller1);
	}
}