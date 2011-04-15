import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController;
import org.sintef.moderates.sim.InteractiveCoffeeSensorDataControllerClient;


public class CoffeSpyLoggerTest {

	/**
	 * 1/Launch
	 * 2/Do some ping -> pong
	 * 3/Someone approaches from the coffee machine. We can see that a subscription to the raw data is sent
	 * 4/Send some raw data. They are "logged" (printed in the console "CoffeeSpyLogger: ...")
	 * 5/The person leaves the coffee machine.
	 * 6/Raw data are still logged during 5 second if no new approach is detected.
	 */
	public static void main(String[] args) {
		InteractiveCoffeeSensorDataControllerClient controller2 = new InteractiveCoffeeSensorDataControllerClient();
		InteractiveCoffeeSensorDataController controller = new InteractiveCoffeeSensorDataController();
		controller2.register(controller);
		controller.register(controller2);
		
		CoffeeSpyLogger logger = new CoffeeSpyLogger(controller2, controller, 5000);
		controller.register(logger);
	}

}
