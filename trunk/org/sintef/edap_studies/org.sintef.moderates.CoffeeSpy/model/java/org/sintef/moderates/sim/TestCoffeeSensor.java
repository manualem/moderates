package org.sintef.moderates.sim;

import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController;
import org.sintef.moderates.sim.InteractiveCoffeeSensorDataControllerClient;

public class TestCoffeeSensor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveCoffeeSensorDataController controller1 = new InteractiveCoffeeSensorDataController();
		InteractiveCoffeeSensorDataControllerClient controller2 = new InteractiveCoffeeSensorDataControllerClient();
		controller1.register(controller2);
		controller2.register(controller1);
	}
}