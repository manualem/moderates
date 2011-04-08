// include core Wiring API
#include "WProgram.h"

// include this library's description file
#include "CoffeeSensor.h"

// include the Xbee lib
#include "../XBee/XBee.h"

// Constructor /////////////////////////////////////////////////////////////////
CoffeeSensor::CoffeeSensor(uint32_t addr_h, uint32_t addr_l) {
	xbee = XBee();
	addr64 = XBeeAddress64(addr_h, addr_l);
	zbTx = ZBTxRequest(addr64, payload, sizeof(payload));
	txStatus = ZBTxStatusResponse();
	rx = ZBRxResponse();
}

// Public Methods //////////////////////////////////////////////////////////////
void CoffeeSensor::init_CoffeeSensor(void) {	
	xbee.begin(9600);
}

void CoffeeSensor::poll_CoffeeSensor(void) {	
	 // Look for incomming XBEE messages
  xbee.readPacket();
  if (xbee.getResponse().isAvailable()) { // We got a message
    if (xbee.getResponse().getApiId() == ZB_RX_RESPONSE) { // it is a ZB message
        xbee.getResponse().getZBRxResponse(rx);
        parseIncommingMessage(rx.getData());
    }
  }
}


// Private Methods /////////////////////////////////////////////////////////////
void CoffeeSensor::parseIncommingMessage(uint8_t data[])
{
	switch(data[4]) // command code
  {
   case 33: receiveCoffeeData((data[5] << 8) + data[6], (data[7] << 8) + data[8], (data[9] << 8) + data[10]); break;
   default: break; 
  }
}
