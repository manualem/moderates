package no.sintef.moderates.btspp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;

public class BTSPPServiceImpl extends IBTSPPService.Stub implements Runnable {
	
	protected BTSPPService service;
	
	/***************************************************************************
	 *                             Singleton
	 ***************************************************************************/
	private static BTSPPServiceImpl instance = null;
	public static BTSPPServiceImpl getInstance(BTSPPService service) {
		if (instance == null) instance = new BTSPPServiceImpl(service);
		else instance.service = service;
		return instance;
	}
	protected BTSPPServiceImpl(BTSPPService service) {
		this.service = service;
	}
	
	/***************************************************************************
	 *              Implementation of the interface
	 ***************************************************************************/
	@Override
	public String getStatus() throws RemoteException {
		if (isConnected()) return "Connected";
		else return "Not Connected";
	}
	@Override
	public String getLog() throws RemoteException {
		return log.toString();
	}
	@Override
	public void clearLog() throws RemoteException {
		log = new StringBuffer();
	}
	@Override
	public void connect(String deviceAddr) throws RemoteException {
		if (isConnected()) {
			writeLogEntry("Bluetooth connection is already active");
		}
		else {
			this.DevAddr = deviceAddr;
			new Thread(this).start();
		}
	}
	@Override
	public void disconnect() throws RemoteException {
		stop = true;
	}
	@Override
	public boolean isConnected() throws RemoteException {
		return connected;
	}
	@Override
	public void send(String msg) throws RemoteException {
		if (out == null) {
			writeLogEntry("Sending failed: not connected.");
			return;
		}
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(out));
		try {
			w.write(msg);
			w.flush();
			//writeLogEntry("Sent :" + msg);
		} catch (IOException e) {
			writeLogEntry(e.getClass() + " : " + e.getMessage());
			close();
		}
	}
	
	/***************************************************************************
	 *              Bluetooth connection
	 ***************************************************************************/

	protected String DevAddr = "0A:07:08:0A:25:31";
	
	protected BluetoothAdapter bluetoothAdapter;
	protected BluetoothDevice device;
	protected BluetoothSocket socket;
	
	protected InputStream in;
	protected OutputStream out;
	
	protected boolean stop = false;
	protected boolean connected = false;
	
	protected StringBuffer log = new StringBuffer();

	protected StringBuffer buffer;
	
	public void run() {
		
		Looper.prepare();
		
		try {
			connected = true;

			writeLogEntry("Connecting..."); 
			
			bt_connect();
			
			if (in != null && out != null) {
				writeLogEntry("Connection established sucessfully.");
				
				service.showNotification("Bluetooth connected", R.drawable.btspps_bt_red_yg);
				
				Intent char_intent;
				Intent line_intent;
				
				buffer = new StringBuffer();
				
				while(!stop) {
					
					if (in.available() > 0) {
						int c = in.read();
						
						// Broadcast the received data
						char_intent = new Intent(BTSPPService.BROADCAST_CHAR_RECEPTION);
						char_intent.putExtra("data", ((char)c));
						service.sendBroadcast(char_intent);
						
						if ((c == 13 || c == 10) && buffer.length() > 0) { // correspond to "end of line" (\n) 
							line_intent = new Intent(BTSPPService.BROADCAST_LINE_RECEPTION);
							line_intent.putExtra("data", buffer.toString() + "\n");
							service.sendBroadcast(line_intent);
							buffer = new StringBuffer();
						}
						else {
							buffer.append((char)c);
						}
					}
					else {
						Thread.sleep(100);
					}
				}
			}
			else {
				writeLogEntry("Connection failed."); 
			}
			
		} catch (IOException e) {
			writeLogEntry(e.getClass() + " : " + e.getMessage());
		} catch (InterruptedException e) {
			writeLogEntry(e.getClass() + " : " + e.getMessage());
		}
		catch (Throwable e) {
			Toast.makeText(service, e.getClass() + " : " + e.getMessage(), 5);
		}
		finally {
			connected = false;
			close();
		}
	}	
	
	public void bt_connect() {
		
		stop = false;
		
  	  // Get local Bluetooth adapter
      bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

      // If the adapter is null, then Bluetooth is not supported
      if (bluetoothAdapter == null) {
      	writeLogEntry("No Bluetooth adapter found.");
      	return;
      }
      
      device = bluetoothAdapter.getRemoteDevice(DevAddr);
      
      writeLogEntry("Device Name: " + device.getName());
      
      
      writeLogEntry("Creating Socket..."); 
      
      try {
    	//BluetoothSocket socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
		Method m = device.getClass().getMethod("createRfcommSocket", new Class[] { int.class });
		  socket = (BluetoothSocket)m.invoke(device, Integer.valueOf(1));
	  } catch (Exception e) {
		  writeLogEntry(e.getClass() + " : " + e.getMessage());
	  } 
      
      writeLogEntry("Connecting Socket..."); 
      
      try {
    	  socket.connect();
    	  in = socket.getInputStream();
    	  out = socket.getOutputStream();
	  } catch (IOException e) {
		  writeLogEntry(e.getClass() + " : " + e.getMessage());
	  }
	}
	
	protected void close() {
		 stop = true;
		 
		 service.showNotification("Bluetooth connection closed", R.drawable.btspps_inactive);
		 
		 writeLogEntry("Closing bluetooth socket...");
		 
		 if (socket == null) return;
		 
		 try {
			 socket.close();
		} catch (IOException e) {writeLogEntry(e.getClass() + " : " + e.getMessage());}

		writeLogEntry("Closed.");
	}
	
	 protected void writeLogEntry(String msg) {
		log.append(msg + "\n");
		Intent m = new Intent(BTSPPService.BROADCAST_STATUS);
		m.putExtra("status", msg);
		service.sendBroadcast(m);
	 }
}
