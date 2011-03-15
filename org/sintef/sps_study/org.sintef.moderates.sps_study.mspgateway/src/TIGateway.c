
/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : TIGateway 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"


#include  "msp430x22x4.h"
#include <signal.h>
#include <stdlib.h>
#include <string.h>



/******************************************************************************
 *                           INCLUDE THE DEVICES
 ******************************************************************************/
 
#include "LED.h" 
#include "Timer.h" 
#include "RF2500.h" 
#include "USART.h" 

/******************************************************************************
 *                      CODE FROM THE GLOBALS TEMPLATE
 ******************************************************************************/



static int sensor_cpt = 0;
static char buf[32];

/****************************************************************
 *  Numbers formating utilities
 ****************************************************************/
// convert a integer which is representing a float times 10 into a string
// e.g 674 becomes "67.4" (the integer may not be larger that 10000)
void int10_to_ascii(int inum,const char *prefixstr,char *outbuf){
	unsigned char i,l,j,minus;
	char chbuf[7];
	minus=0;
	j=0;
	if (inum<0){
		minus=1;
		inum=inum * -1;
	}
	while(inum>9 && j<7){
		// zero is ascii 48:
		chbuf[j]=(char)48+ inum-((inum/10)*10);
		inum=inum/10;
		j++;
	}
	chbuf[j]=(char)48+inum; // most significant digit
	// now reverse the order in outbuf and put a "." in there
	i=0;
	l=0;
	while(prefixstr[i]){
		outbuf[i]=prefixstr[i];
		i++;
	}
	if(minus){
		outbuf[i]='-';
		i++;
	}
	while(j>0){
		outbuf[i]=chbuf[j];
		j--;
		i++;
		l++;
	}
	// inum is less than 10, should be something like "0.inum"
	if (l==0){
		outbuf[i]='0';
		i++;
	}
	outbuf[i]='.';
	i++;
	outbuf[i]=chbuf[j];
	i++;
	outbuf[i]='\0';
}



/******************************************************************************
 *                            STATES DECLARATION
 ******************************************************************************/
// Define all the states and their IDs
#define EDAP_STATE_TIGATEWAY_0 0	// fixed
#define EDAP_STATE_INIT_2 2
#define EDAP_STATE_ACTIVE_1 1
#define EDAP_STATE_WAITING_3 3

// Static variable to store the current state of the state machines and composites
static int EDAP_STATE_TIGATEWAY_0_Current_State[2];

/******************************************************************************
 *                          PROTOTYPES DECLARATION
 ******************************************************************************/

// Prototypes for Entry actions
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_INIT_2_On_Entry();
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_ACTIVE_1_On_Entry();
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Entry();

// Prototypes for Exit actions
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Exit();

// Prototypes for Events handlers
void EDAP_STATE_TIGATEWAY_0_timeout_Event_Handler(int timer_id);
void EDAP_STATE_TIGATEWAY_0_receive_Event_Handler(int addr, char * msg, int msglen, int rssi, int lqi);

/******************************************************************************
 *                    IMPLEMENTATION OF ENTRY AND EXIT
 ******************************************************************************/
 
// Entry actions
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_ACTIVE_1_On_Entry() {
	EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_ACTIVE_1] = EDAP_STATE_WAITING_3; // no history
	
	EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Entry();
}
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_INIT_2_On_Entry() {
	{
Timer_send_start(1, 1000);
LED_send_light_on(1);
LED_send_light_on(2);
RF2500_send_set_address(1);
RF2500_send_set_channel(7);
}
}
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Entry() {
	{
LED_send_light_on(2);
}
}

// Exit actions
void EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Exit(){
	{
LED_send_light_off(2);
}
}

 /******************************************************************************
 *                    IMPLEMENTATION OF EVENT HANDLING
 ******************************************************************************/
 
void EDAP_STATE_TIGATEWAY_0_timeout_Event_Handler(int timer_id){
		if ( EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_TIGATEWAY_0] == EDAP_STATE_INIT_2 &&
		timer_id == 1 ) {
		
		{
LED_send_light_off(1);
LED_send_light_off(2);
}
		EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_TIGATEWAY_0] = EDAP_STATE_ACTIVE_1; // change state
		EDAP_STATE_TIGATEWAY_0_EDAP_STATE_ACTIVE_1_On_Entry();
		return; // The event has been consumed
	}
}
void EDAP_STATE_TIGATEWAY_0_receive_Event_Handler(int addr, char * msg, int msglen, int rssi, int lqi){
	if ( EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_ACTIVE_1] == EDAP_STATE_WAITING_3 &&
		EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_TIGATEWAY_0] == EDAP_STATE_ACTIVE_1 &&
		msg[0] != 127 ) {
		EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Exit();
		{
LED_send_light_on(1);
uint16_t v;
uint8_t idx = 0;
itoa(msg[0], buf+idx,10);
while(buf[idx] != 0) idx++;
buf[idx++] = ':';
v = ((unsigned char)msg[3]) + (msg[4]<<8);
int10_to_ascii(v, "T=", buf+idx);
while(buf[idx] != 0) idx++;
buf[idx++] = ' ';
v = msg[7] + (msg[8]<<8);
int10_to_ascii(v, "V=", buf+idx);
while(buf[idx] != 0) idx++;
buf[idx++] = 0x0A;
buf[idx++] = 0x0D;
buf[idx++] = 0x00;
USART_send_transmit(buf);
LED_send_light_off(1);
}
		EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Entry();
		return; // The event has been consumed
	}
if ( EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_ACTIVE_1] == EDAP_STATE_WAITING_3 &&
		EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_TIGATEWAY_0] == EDAP_STATE_ACTIVE_1 &&
		msg[0] == 127 ) {
		EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Exit();
		{
LED_send_light_on(1);
buf[0] = 126;
buf[1] = ++sensor_cpt;
buf[2] = 0x0;
USART_send_transmit_hexdump(buf, 10);
RF2500_send_transmit(0, buf);
LED_send_light_off(1);
}
		EDAP_STATE_TIGATEWAY_0_EDAP_STATE_WAITING_3_On_Entry();
		return; // The event has been consumed
	}
	}

 /******************************************************************************
 *                        INITIALISATION AND MAIN
 ******************************************************************************/

int main () {


	int i;
	// Stop watchdog timer
	WDTCTL = WDTPW + WDTHOLD;
	
	// Set the clock
	BCSCTL1 = CALBC1_8MHZ;
	DCOCTL = CALDCO_8MHZ;
	BCSCTL3 |= LFXT1S_2;
	

	
	// initialize devices
	init_LED();
	init_Timer();
	init_RF2500();
	init_USART();
	
	// register state machine event handlers
	register_Timer_receive_timeout_listener(EDAP_STATE_TIGATEWAY_0_timeout_Event_Handler);
	register_RF2500_receive_receive_listener(EDAP_STATE_TIGATEWAY_0_receive_Event_Handler);

	// Initialize state machine
	EDAP_STATE_TIGATEWAY_0_Current_State[EDAP_STATE_TIGATEWAY_0] = EDAP_STATE_INIT_2; // Set the initial state
	EDAP_STATE_TIGATEWAY_0_EDAP_STATE_INIT_2_On_Entry();
	
	__enable_interrupt();  // IMPORTANT :-)
	
	while(1) {
		int i;
		
	// some sort of polling delay
	for(i=50000; i>0; i--) __no_operation();

		// poll the drivers
		poll_Timer();
		poll_RF2500();
		poll_USART();
	}
}