/**
 * Copyright (c) 2008 Andrew Rapp. All rights reserved.
 *  
 * This file is part of XBee-API.
 *  
 * XBee-API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *  
 * XBee-API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *  
 * You should have received a copy of the GNU General Public License
 * along with XBee-API.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.sintef.moderates.xbee;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeAddress16;
import com.rapplogic.xbee.api.XBeeAddress64;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.api.zigbee.ZNetTxRequest;
import com.rapplogic.xbee.api.zigbee.ZNetTxStatusResponse;
import com.rapplogic.xbee.util.ByteUtils;


public class ZNetSenderExample {

	private final static Logger log = Logger.getLogger(ZNetSenderExample.class);
	
	private ZNetSenderExample() throws XBeeException {
		
		XBee xbee = new XBee();
		
		try {
			// replace with your com port and baud rate. this is the com port of my coordinator
			//xbee.open("COM5", 9600);
			// my coordinator com/baud
			xbee.open("COM17", 9600);
			// my end device
//			xbee.open("/dev/tty.usbserial-A6005uPi", 9600);
			
			// replace with end device's 64-bit address (SH + SL)
//			XBeeAddress64 addr64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x0a, 0x3e, 0x02);
			// my other remote
			XBeeAddress64 addr64 = new XBeeAddress64(0, 0x13, 0xa2, 0, 0x40, 0x33, 0x1D, 0xC3);
			 
			// create an array of arbitrary data to send
			int[] payload = new int[] { 0, 0, 0, 0, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			
			// first request we just send 64-bit address.  we get 16-bit network address with status response
			ZNetTxRequest request = new ZNetTxRequest(addr64, payload);
			
			System.out.println("zb request is " + request.getXBeePacket().getPacket());
			
			System.out.println("sending tx " + request);
			
			while (true) {
				log.info("request packet bytes (base 16) " + ByteUtils.toBase16(request.getXBeePacket().getPacket()));
				
				long start = System.currentTimeMillis();
				//log.info("sending tx packet: " + request.toString());
				
				try {
					ZNetTxStatusResponse response = (ZNetTxStatusResponse) xbee.sendSynchronous(request, 10000);
					// update frame id for next request
					request.setFrameId(xbee.getNextFrameId());
					
					log.info("received response " + response);
					
					//log.debug("status response bytes:" + ByteUtils.toBase16(response.getPacketBytes()));

					if (response.getDeliveryStatus() == ZNetTxStatusResponse.DeliveryStatus.SUCCESS) {
						// the packet was successfully delivered
						if (response.getRemoteAddress16().equals(XBeeAddress16.ZNET_BROADCAST)) {
							// specify 16-bit address for faster routing?.. really only need to do this when it changes
							request.setDestAddr16(response.getRemoteAddress16());
						}							
					} else {
						// packet failed.  log error
						// it's easy to create this error by unplugging/powering off your remote xbee.  when doing so I get: packet failed due to error: ADDRESS_NOT_FOUND  
						log.error("packet failed due to error: " + response.getDeliveryStatus());
					}
					
					// I get the following message: Response in 75, Delivery status is SUCCESS, 16-bit address is 0x08 0xe5, retry count is 0, discovery status is SUCCESS 
					log.info("Response in " + (System.currentTimeMillis() - start) + ", Delivery status is " + response.getDeliveryStatus() + ", 16-bit address is " + ByteUtils.toBase16(response.getRemoteAddress16().getAddress()) + ", retry count is " +  response.getRetryCount() + ", discovery status is " + response.getDeliveryStatus());					
				} catch (XBeeTimeoutException e) {
					log.warn("request timed out");
				}
	
				try {
					// wait a bit then send another packet
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}


		} finally {
			xbee.close();
		}
	}
	
	public static void main(String[] args) throws XBeeException, InterruptedException  {
		PropertyConfigurator.configure("log4j.properties");
		new ZNetSenderExample();
	}
}
