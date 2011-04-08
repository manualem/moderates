// include core Wiring API
#include "WProgram.h"

// include this library's description file
#include "CurrentSensor.h"

// include the Xbee lib
#include "../XBee/XBee.h"

// Constructor /////////////////////////////////////////////////////////////////
CurrentSensor::CurrentSensor(uint32_t addr_h, uint32_t addr_l) {
	xbee = XBee();
	addr64 = XBeeAddress64(addr_h, addr_l);
	zbTx = ZBTxRequest(addr64, payload, sizeof(payload));
	txStatus = ZBTxStatusResponse();
	rx = ZBRxResponse();
}

// Public Methods //////////////////////////////////////////////////////////////
void CurrentSensor::init_CurrentSensor(void) {	
	xbee.begin(9600);
}

void CurrentSensor::poll_CurrentSensor(void) {	
	 // Look for incomming XBEE messages
  xbee.readPacket();
  if (xbee.getResponse().isAvailable()) { // We got a message
    if (xbee.getResponse().getApiId() == ZB_RX_RESPONSE) { // it is a ZB message
        xbee.getResponse().getZBRxResponse(rx);
        parseIncommingMessage(rx.getData());
    }
  }
}

void CurrentSensor::sendcurrentData(uint16_t sensorMax, uint16_t current, uint16_t eff_current) {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 6; // length of the params
   payload[4] = 4; // command code
   // set params here
   payload[5] = sensorMax >> 8 & 0x00ff; payload[6] = sensorMax & 0x00ff;
   payload[7] = current >> 8 & 0x00ff; payload[8] = current & 0x00ff;
   payload[9] = eff_current >> 8 & 0x00ff; payload[10] = eff_current & 0x00ff;
   // send the message
   xbee.send(zbTx);
}
void CurrentSensor::sendpong() {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 0; // length of the params
   payload[4] = 67; // command code
   // set params here
   // send the message
   xbee.send(zbTx);
}

// Private Methods /////////////////////////////////////////////////////////////
void CurrentSensor::parseIncommingMessage(uint8_t data[])
{
	switch(data[4]) // command code
  {
   case 2: receivestart(); break;
   case 3: receivestop(); break;
   case 66: receiveping(); break;
   default: break; 
  }
}
