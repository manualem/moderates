import java.util.Timer;
import java.util.TimerTask;

import org.sintef.moderates.CoffeeSensorProtocol;
import org.sintef.moderates.FixedSizePacket;
import org.sintef.moderates.msg.approachingMotion;
import org.sintef.moderates.msg.leavingMotion;
import org.sintef.moderates.msg.rawData;
import org.sintef.moderates.observer.CoffeeSensorClientObserver;
import org.sintef.moderates.observer.CoffeeSensorClientSubject;
import org.sintef.moderates.observer.CoffeeSensorObserver;


public class CoffeeSpyLogger implements CoffeeSensorObserver, CoffeeSensorClientSubject {

	private boolean isActive;
	private boolean isLogActive;
	private long delay;

	private CoffeeSensorClientObserver csco;

	private Timer timer;

	public CoffeeSpyLogger(CoffeeSensorClientObserver csco, long delay){
		this.delay = delay;
		timer = new Timer();
		register(csco);
		this.isLogActive = false;
	}

	public void suspendLog() {
		isActive = false;
		timer.schedule(new Timeout(this), delay);
	}

	private void doSuspendLog() {
		if (!isActive){
			isLogActive = false;
			FixedSizePacket msg = CoffeeSensorProtocol.createunsubscribeRawData();
			csco.receiveMsg(msg.getPacket());
		}
	}

	public void startLog() {
		if (!isActive){
			isActive = true;
			if (!isLogActive){
				isLogActive = true;
				FixedSizePacket msg = CoffeeSensorProtocol.createsubscribeRawData((short) 250);
				csco.receiveMsg(msg.getPacket());
			}
		}
	}

	@Override
	public void receiveMsg(byte[] msg) {
		FixedSizePacket m = CoffeeSensorProtocol.createMessageFromPacket(msg);
		if (m instanceof rawData) {
			if(isLogActive){
				System.out.println("------------------------------------");
				System.out.println("CoffeeSpyLogger: "+m);
				System.out.println("------------------------------------");
			}
		} else if (m instanceof approachingMotion) {
			startLog();
		} else if (m instanceof leavingMotion) {
			suspendLog();
		}
	}

	private class Timeout extends TimerTask {

		private CoffeeSpyLogger logger;

		public Timeout(CoffeeSpyLogger logger){
			this.logger = logger;
		}

		@Override
		public void run() {
			logger.doSuspendLog();
		}
	}

	@Override
	public void register(CoffeeSensorClientObserver observer) {
		this.csco = observer;

	}

	@Override
	public void unregister(CoffeeSensorClientObserver observer) {
		this.csco = null;
	}
}
