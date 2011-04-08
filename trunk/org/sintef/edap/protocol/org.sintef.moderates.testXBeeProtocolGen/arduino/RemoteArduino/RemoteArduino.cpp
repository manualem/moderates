// include core Wiring API
#include "WProgram.h"

// include this library's description file
#include "RemoteArduino.h"

// include the Xbee lib
#include "../XBee/XBee.h"

// Constructor /////////////////////////////////////////////////////////////////
RemoteArduino::RemoteArduino(uint32_t addr_h, uint32_t addr_l) {
	xbee = XBee();
	addr64 = XBeeAddress64(addr_h, addr_l);
	zbTx = ZBTxRequest(addr64, payload, sizeof(payload));
	txStatus = ZBTxStatusResponse();
	rx = ZBRxResponse();
}

// Public Methods //////////////////////////////////////////////////////////////
void RemoteArduino::init_RemoteArduino(void) {	
	xbee.begin(9600);
}

void RemoteArduino::poll_RemoteArduino(void) {	
	 // Look for incomming XBEE messages
  xbee.readPacket();
  if (xbee.getResponse().isAvailable()) { // We got a message
    if (xbee.getResponse().getApiId() == ZB_RX_RESPONSE) { // it is a ZB message
        xbee.getResponse().getZBRxResponse(rx);
        parseIncommingMessage(rx.getData());
    }
  }
}

void RemoteArduino::senddigitalReadResult(uint8_t value) {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 1; // length of the params
   payload[4] = 5; // command code
   // set params here
   payload[5] = value;
   // send the message
   xbee.send(zbTx);
}
void RemoteArduino::sendanalogReadResult(uint16_t value) {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 2; // length of the params
   payload[4] = 8; // command code
   // set params here
   payload[5] = value >> 8 & 0x00ff; payload[6] = value & 0x00ff;
   // send the message
   xbee.send(zbTx);
}
void RemoteArduino::sendpong() {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 0; // length of the params
   payload[4] = 67; // command code
   // set params here
   // send the message
   xbee.send(zbTx);
}
void RemoteArduino::sendinterruptNotification(uint8_t interrupt) {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 1; // length of the params
   payload[4] = 23; // command code
   // set params here
   payload[5] = interrupt;
   // send the message
   xbee.send(zbTx);
}

// Private Methods /////////////////////////////////////////////////////////////
void RemoteArduino::parseIncommingMessage(uint8_t data[])
{
	switch(data[4]) // command code
  {
   case 2: receivepinMode(data[5], data[6]); break;
   case 4: receivedigitalRead(data[5]); break;
   case 3: receivedigitalWrite(data[5], data[6]); break;
   case 6: receiveanalogReference(data[5]); break;
   case 7: receiveanalogRead(data[5]); break;
   case 9: receiveanalogWrite(data[5], data[6]); break;
   case 66: receiveping(); break;
   case 21: receiveattachInterrupt(data[5], data[6]); break;
   case 22: receivedetachInterrupt(data[5]); break;
   default: break; 
  }
}
