
// ensure this library description is only included once
#ifndef CurrentSensor_h
#define CurrentSensor_h

// include types & constants of Wiring core API
#include "WConstants.h"
#undef abs
#undef round

#include <inttypes.h>

// include the Xbee lib
#include "../XBee/XBee.h"


// Operations which implements the logic to execute when messages are received.
extern void receivestart();
extern void receivestop();
extern void receiveping();

class CurrentSensor
{
  public:
	// Constructor which takes the address of the target XBee as parameter
    CurrentSensor(uint32_t, uint32_t);
	// Standard init and pool operations to be called in setup and loop
	void init_CurrentSensor();
	void poll_CurrentSensor();
	// Operations for sending all messages
    void sendcurrentData(uint16_t sensorMax, uint16_t current, uint16_t eff_current);
    void sendpong();

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
