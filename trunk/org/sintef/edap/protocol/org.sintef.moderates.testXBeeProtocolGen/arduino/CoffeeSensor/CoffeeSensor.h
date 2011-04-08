
// ensure this library description is only included once
#ifndef CoffeeSensor_h
#define CoffeeSensor_h

// include types & constants of Wiring core API
#include "WConstants.h"
#undef abs
#undef round

#include <inttypes.h>

// include the Xbee lib
#include "../XBee/XBee.h"

// Operations which implements the logic to execute when messages are received.
extern void receiveCoffeeData(uint16_t temp, uint16_t dist, uint16_t light);

class CoffeeSensor
{
  public:
	// Constructor which takes the address of the target XBee as parameter
    CoffeeSensor(uint32_t, uint32_t);
	// Standard init and pool operations to be called in setup and loop
	void init_CoffeeSensor();
	void poll_CoffeeSensor();
	// Operations for sending all messages

  private:
	// the address of the target XBee
	XBee xbee;
	XBeeAddress64 addr64;
	ZBTxRequest zbTx;
	ZBTxStatusResponse txStatus;
	ZBRxResponse rx;
	uint8_t payload[16];
	// private operation which parses incomming message and calls
	// the corresponding exten functions
    void parseIncommingMessage(uint8_t data[]);
};

#endif
