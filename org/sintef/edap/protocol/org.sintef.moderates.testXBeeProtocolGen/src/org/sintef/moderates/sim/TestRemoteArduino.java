package org.sintef.moderates.sim;

import org.sintef.moderates.sim.InteractiveRemoteArduinoDataController;
import org.sintef.moderates.sim.InteractiveRemoteArduinoDataController2;

public class TestRemoteArduino {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveRemoteArduinoDataController controller1 = new InteractiveRemoteArduinoDataController();
		InteractiveRemoteArduinoDataController2 controller2 = new InteractiveRemoteArduinoDataController2();
		controller1.register(controller2);
		controller2.register(controller1);
	}

}