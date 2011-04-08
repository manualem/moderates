package org.sintef.moderates.xbee;

import org.apache.log4j.PropertyConfigurator;
//import org.sintef.moderates.sim.InteractiveBrickLCDSensorDataController2;
//import org.sintef.moderates.sim.InteractiveCoffeeSensorDataController;
import org.sintef.moderates.RemoteArduinoProtocol;
import org.sintef.moderates.RemoteArduinoProtocolPacket;
import org.sintef.moderates.in.IncomingRemoteArduinoMessage;
import org.sintef.moderates.sim.InteractiveRemoteArduinoDataController;
import org.sintef.moderates.sim.InteractiveRemoteArduinoDataController2;
import org.sintef.moderates.sim.ProtocolHandler;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.ZNetRxResponse;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.util.ByteUtils;

public class Test1 implements Runnable, ProtocolHandler {

	// The physical adress of the device
	protected XBeeAddress64 addr64;
	protected XBee xbee;
	
	protected ProtocolHandler dataController;
	
	public ProtocolHandler getDataController() {
		return dataController;
	}

	public void setDataController(ProtocolHandler dataController) {
		this.dataController = dataController;
	}

	public Test1(XBee local_xbee, XBeeAddress64 remote_addr64) {
		this.addr64 = remote_addr64;
		this.xbee = local_xbee;
		new Thread(this).start();
	}
	
	@Override
	public void register(ProtocolHandler handler) {
		// TODO Auto-generated method stub
		
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
				IncomingRemoteArduinoMessage data = RemoteArduinoProtocol.createMessageForIncomingPacket(response);
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
			xbee.open("COM18", 9600);
			
			Test1 device = new Test1(xbee, new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x33, 0x1D, 0xC6));
		
			
			RemoteArduinoProtocolPacket p = RemoteArduinoProtocol.createpinMode((byte)4, (byte)1);
			device.sendData(p.getPacket());
			
			
			while (true) {
				
				//System.out.println("Sending ping...");
				//device.sendData(ping);
				
				try {
					
					p = RemoteArduinoProtocol.createdigitalWrite((byte)4, (byte)0);
					device.sendData(p.getPacket());
					
					// wait a bit then send another packet
					Thread.sleep(1000);
					
					p = RemoteArduinoProtocol.createdigitalWrite((byte)4, (byte)1);
					device.sendData(p.getPacket());
					
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
}
