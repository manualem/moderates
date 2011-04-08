// include core Wiring API
#include "WProgram.h"

// include this library's description file
#include "BrickLCDSensor.h"

// include the Xbee lib
#include "../XBee/XBee.h"

// Constructor /////////////////////////////////////////////////////////////////
BrickLCDSensor::BrickLCDSensor(uint32_t addr_h, uint32_t addr_l) {
	xbee = XBee();
	addr64 = XBeeAddress64(addr_h, addr_l);
	zbTx = ZBTxRequest(addr64, payload, sizeof(payload));
	txStatus = ZBTxStatusResponse();
	rx = ZBRxResponse();
}

// Public Methods //////////////////////////////////////////////////////////////
void BrickLCDSensor::init_BrickLCDSensor(void) {	
	xbee.begin(9600);
}

void BrickLCDSensor::poll_BrickLCDSensor(void) {	
	 // Look for incomming XBEE messages
  xbee.readPacket();
  if (xbee.getResponse().isAvailable()) { // We got a message
    if (xbee.getResponse().getApiId() == ZB_RX_RESPONSE) { // it is a ZB message
        xbee.getResponse().getZBRxResponse(rx);
        parseIncommingMessage(rx.getData());
    }
  }
}

void BrickLCDSensor::sendanalogValue(uint16_t pin, uint16_t val) {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 4; // length of the params
   payload[4] = 5; // command code
   // set params here
   payload[5] = pin >> 8 & 0x00ff; payload[6] = pin & 0x00ff;
   payload[7] = val >> 8 & 0x00ff; payload[8] = val & 0x00ff;
   // send the message
   xbee.send(zbTx);
}
void BrickLCDSensor::senddigitalValue(uint16_t pin, uint16_t val) {
   payload[0] = 0x01; // source addr (not used)
   payload[1] = 0xff; // target addr (not used)
   payload[2] = 0x00; // frame num (not used)
   payload[3] = 4; // length of the params
   payload[4] = 9; // command code
   // set params here
   payload[5] = pin >> 8 & 0x00ff; payload[6] = pin & 0x00ff;
   payload[7] = val >> 8 & 0x00ff; payload[8] = val & 0x00ff;
   // send the message
   xbee.send(zbTx);
}
void BrickLCDSensor::sendpong() {
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
void BrickLCDSensor::parseIncommingMessage(uint8_t data[])
{
	switch(data[4]) // command code
  {
   case 1: receivedisplayText((data[5] << 8) + data[6], (char *)&data[7]); break;
   case 2: receiveclearText(); break;
   case 3: receivereadAllAnalog(); break;
   case 4: receivereadAnalog((data[5] << 8) + data[6]); break;
   case 6: receivesetDigital((data[5] << 8) + data[6], (data[7] << 8) + data[8]); break;
   case 7: receivesetValue((data[5] << 8) + data[6], (data[7] << 8) + data[8]); break;
   case 8: receivegetValue((data[5] << 8) + data[6]); break;
   case 66: receiveping(); break;
   default: break; 
  }
}
