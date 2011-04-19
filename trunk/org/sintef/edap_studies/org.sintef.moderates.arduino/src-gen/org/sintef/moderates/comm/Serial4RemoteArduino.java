package org.sintef.moderates.comm;

import org.sintef.moderates.observer.RemoteArduinoClientObserver;
import org.sintef.moderates.observer.RemoteArduinoObserver;
import org.sintef.moderates.observer.RemoteArduinoSubject;
import org.sintef.moderates.sim.InteractiveRemoteArduinoDataControllerClient;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class Serial4RemoteArduino implements RemoteArduinoClientObserver, RemoteArduinoSubject {

	public static final byte START_BYTE = 0x12;
	public static final byte STOP_BYTE = 0x13;
	public static final byte ESCAPE_BYTE = 0x7D;
	
	protected String port;
	protected SerialPort serialPort;

	public Serial4RemoteArduino(String port) {
		this.port = port;
		connect(port);
	}
	
	void connect ( String portName )
    {
        try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			if ( portIdentifier.isCurrentlyOwned() )
			{
			    System.err.println("Error: Port " + portName + " is currently in use");
			}
			else
			{
			    CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
			    
			    if ( commPort instanceof SerialPort )
			    {
			        SerialPort serialPort = (SerialPort) commPort;
			        serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
			        
			        InputStream in = serialPort.getInputStream();
			        OutputStream out = serialPort.getOutputStream();
			                       
			        this.out = out;
			        
			        serialPort.addEventListener(new SerialReader(in));
			        serialPort.notifyOnDataAvailable(true);

			    }
			    else
			    {
			        System.err.println("Error: Port " + portName + " is not a valid serial port.");
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void close() {
		if (serialPort != null) {
			serialPort.notifyOnDataAvailable(false);
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/* ***********************************************************************
	 * Implementation of the CoffeeSensorClientObserver interface. 
	 * The receiveMsg method gets called with packets to send.
	 *************************************************************************/
	@Override
	public void receiveMsg(byte[] msg) {
		sendData(msg);
	}
	
	/* ***********************************************************************
	 * Implementation of the CoffeeSensorSubject interface. 
	 * The CoffeeSensor Observers get notified for each incoming packet.
	 *************************************************************************/
	Set<RemoteArduinoObserver> observers = new HashSet<RemoteArduinoObserver>();

	@Override
	public void register(RemoteArduinoObserver observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(RemoteArduinoObserver observer) {
		observers.remove(observer);
	}

	/* ***********************************************************************
	 * Serial Port data send operation
	 *************************************************************************/
	protected OutputStream out;
	protected void sendData(byte[] payload) {
		try {
			// send the start byte
			out.write((int)START_BYTE);
			// send data
			for(int i=0; i<payload.length; i++) {
				// escape special bytes
				if(payload[i] == START_BYTE || payload[i] == STOP_BYTE || payload[i] == ESCAPE_BYTE) {
					out.write((int)ESCAPE_BYTE);
				}
				out.write((int)payload[i]);
			}
			// send the stop byte
			out.write((int)STOP_BYTE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ***********************************************************************
	 * Serial Port Listener - reads packets from the serial line and
	 * notifies listeners of incoming packets
	 *************************************************************************/
	public class SerialReader implements SerialPortEventListener 
    {
		public static final int RCV_WAIT = 0;
	    public static final int RCV_MSG = 1;
	    public static final int RCV_ESC = 2;
		
		protected InputStream in;
        private byte[] buffer = new byte[256];
        protected int buffer_idx = 0;
        
        protected int state = RCV_WAIT;
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void serialEvent(SerialPortEvent arg0) {
            
        	byte data;
          
            try
            {
                while ( ( data = (byte)in.read()) > -1 )
                {
                	// we got a byte from the serial port
                	if (state == RCV_WAIT) { // it should be a start byte or we just ignore it
                		if (data == START_BYTE)  {
                			state = RCV_MSG;
                			buffer_idx = 0;
                		}
                	}
                	else if (state == RCV_MSG) {
                		if (data == ESCAPE_BYTE) {
                			state = RCV_ESC;
                		}
                		else if (data == STOP_BYTE) {
                			// We got a complete frame
                			byte[] packet = new byte[buffer_idx];
                			for (int i = 0; i<buffer_idx; i++) packet[i] = buffer[i];
                			for(RemoteArduinoObserver o : observers) {
            					o.receiveMsg(packet);
            				}
                			state = RCV_WAIT;
                		}
                		else if (data == START_BYTE) {
                			// Should not happen but we reset just in case
                			state = RCV_MSG;
                			buffer_idx = 0;
                		}
                		else { // it is just a byte to store
                			buffer[buffer_idx] = data;
                			buffer_idx++;
                		}
                	}
                	else if (state == RCV_ESC) {
                		// Store the byte without looking at it
                		buffer[buffer_idx] = data;
            			buffer_idx++;
            			state = RCV_MSG;
                	}
                }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }             
        }
    }
	
	/* ***********************************************************************
	 * Serial port utilities: listing
	 *************************************************************************/
	
	/**
     * @return    A HashSet containing the CommPortIdentifier for all serial ports that are not currently being used.
     */
    public static HashSet<CommPortIdentifier> getAvailableSerialPorts() {
        HashSet<CommPortIdentifier> h = new HashSet<CommPortIdentifier>();
        Enumeration thePorts = CommPortIdentifier.getPortIdentifiers();
        while (thePorts.hasMoreElements()) {
            CommPortIdentifier com = (CommPortIdentifier) thePorts.nextElement();
            switch (com.getPortType()) {
            case CommPortIdentifier.PORT_SERIAL:
                try {
                    CommPort thePort = com.open("CommUtil", 50);
                    thePort.close();
                    h.add(com);
                } catch (PortInUseException e) {
                    System.out.println("Port, "  + com.getName() + ", is in use.");
                } catch (Exception e) {
                    System.err.println("Failed to open port " +  com.getName());
                    e.printStackTrace();
                }
            }
        }
        return h;
    }
	
	/* ***********************************************************************
	 * Main
	 *************************************************************************/
	public static void main(String[] args) {
		Serial4RemoteArduino device = null;
		try {
			// TODO: Change this with the actual port of your arduino
			device = new Serial4RemoteArduino("COM21");
			InteractiveRemoteArduinoDataControllerClient controller2 = new InteractiveRemoteArduinoDataControllerClient();
			device.register(controller2);
			controller2.register(device);
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			device.close();
		}	
	}
}