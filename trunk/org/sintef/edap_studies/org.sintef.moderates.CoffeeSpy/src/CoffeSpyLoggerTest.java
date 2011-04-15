import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController;
import org.sintef.moderates.sim.InteractiveCoffeeSensorDataControllerClient;


public class CoffeSpyLoggerTest {

	/**
	 * @param args
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
