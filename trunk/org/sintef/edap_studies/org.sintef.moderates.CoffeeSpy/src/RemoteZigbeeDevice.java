

import java.util.HashSet;
import java.util.Set;

import org.sintef.moderates.observer.CoffeeSensorClientObserver;
import org.sintef.moderates.observer.CoffeeSensorClientSubject;
import org.sintef.moderates.observer.CoffeeSensorObserver;
import org.sintef.moderates.observer.CoffeeSensorSubject;
import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController;
import org.sintef.moderates.sim.InteractiveCoffeeSensorDataControllerClient;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.util.ByteUtils;

public class RemoteZigbeeDevice implements Runnable, CoffeeSensorClientObserver, CoffeeSensorSubject {

	// The physical adress of the device
	protected XBeeAddress64 addr64;
	protected XBee xbee;
	
	
	
	public RemoteZigbeeDevice(XBee local_xbee, XBeeAddress64 remote_addr64) {
		this.addr64 = remote_addr64;
		this.xbee = local_xbee;
		new Thread(this).start();
	}

	@Override
	public void receiveMsg(byte[] msg) {
		sendData(msg);
	}
	
	protected void sendData(byte[] payload) {
		int[] data = new int[payload.length];
		for(int i=0; i<data.length; i++) {
			data[i] = (int)payload[i];
			//System.out.println("data[" + i + "] = " + data[i]);
		}
		ZNetTxRequest request = new ZNetTxRequest(addr64, data);
		try {
			xbee.sendSynchronous(request, 500);
		} catch (XBeeTimeoutException e) {
			e.printStackTrace();
		} catch (XBeeException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {

		try {
			// wait a bit then send another packet
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		while (true) {
			byte[] response;
			response = receiveData();
			if (response != null) {
				// notify
				for(CoffeeSensorObserver o : observers) {
					o.receiveMsg(response);
				}
				
			}
			try {
				// wait a bit then send another packet
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	
	}
	
	protected byte[] receiveData() {
		XBeeResponse response;
		try {
			response = xbee.getResponse();
			if (response.getApiId() == ApiId.ZNET_RX_RESPONSE) {
				ZNetRxResponse rx = (ZNetRxResponse) response;
				byte[] data = new byte[rx.getData().length];
				for(int i=0; i<data.length; i++) {
					data[i] = (byte)rx.getData()[i];
				}
				System.out.println("Incoming message: " + ByteUtils.toBase10(rx.getData()));
				return data;
			}
		} catch (XBeeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) throws XBeeException, InterruptedException  {
		XBee xbee = new XBee();
		try {
			xbee.open("COM17", 9600);
			
			//RemoteZigbeeDevice device = new RemoteZigbeeDevice(xbee, new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x33, 0x1D, 0xC3));
			//RemoteZigbeeDevice device = new RemoteZigbeeDevice(xbee, new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x33, 0x1D, 0xC6));
			RemoteZigbeeDevice device = new RemoteZigbeeDevice(xbee, new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x3D, 0xDA, 0x5E));
			//InteractiveBrickLCDSensorDataController2 controller2 = new InteractiveBrickLCDSensorDataController2();
			InteractiveCoffeeSensorDataControllerClient controller2 = new InteractiveCoffeeSensorDataControllerClient();
			device.register(controller2);
			controller2.register(device);
			
			
			
			byte[] ping = new byte[] { 0, 0, 0, 0, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			
			while (true) {
				
				//System.out.println("Sending ping...");
				//device.sendData(ping);
				
				try {
					// wait a bit then send another packet
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			xbee.close();
		}
	}

	Set<CoffeeSensorObserver> observers = new HashSet<CoffeeSensorObserver>();
	
	@Override
	public void register(CoffeeSensorObserver observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(CoffeeSensorObserver observer) {
		observers.remove(observer);
	}
}
