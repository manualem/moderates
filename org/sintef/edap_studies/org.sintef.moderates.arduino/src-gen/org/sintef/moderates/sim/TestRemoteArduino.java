package org.sintef.moderates.sim;

import org.sintef.moderates.sim.InteractiveRemoteArduinoDataController;
import org.sintef.moderates.sim.InteractiveRemoteArduinoDataControllerClient;

public class TestRemoteArduino {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveRemoteArduinoDataController controller1 = new InteractiveRemoteArduinoDataController();
		InteractiveRemoteArduinoDataControllerClient controller2 = new InteractiveRemoteArduinoDataControllerClient();
		controller1.register(controller2);
		controller2.register(controller1);
	}
}