package org.sintef.moderates.comm;

import java.util.HashSet;
import java.util.Set;

import org.sintef.moderates.observer.RemoteArduinoClientObserver;
import org.sintef.moderates.observer.RemoteArduinoObserver;
import org.sintef.moderates.observer.RemoteArduinoSubject;
import org.sintef.moderates.sim.InteractiveRemoteArduinoDataControllerClient;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.util.ByteUtils;

public class ZigBee4RemoteArduino implements Runnable, RemoteArduinoClientObserver, RemoteArduinoSubject {

	// The physical adress of the device
	protected XBeeAddress64 addr64;
	protected XBee xbee;



	public ZigBee4RemoteArduino(XBee local_xbee, XBeeAddress64 remote_addr64) {
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
				for(RemoteArduinoObserver o : observers) {
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
			String port = "COM17"; //to change with the COM port of the ZigBee
			xbee.open(port, 9600);

			ZigBee4RemoteArduino device = new ZigBee4RemoteArduino(xbee, new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x3D, 0xDA, 0x5E));
			InteractiveRemoteArduinoDataControllerClient controller2 = new InteractiveRemoteArduinoDataControllerClient();
			device.register(controller2);
			controller2.register(device);
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			xbee.close();
		}
	}

	Set<RemoteArduinoObserver> observers = new HashSet<RemoteArduinoObserver>();

	@Override
	public void register(RemoteArduinoObserver observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(RemoteArduinoObserver observer) {
		observers.remove(observer);
	}
}