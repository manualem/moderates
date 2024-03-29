
/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : USARTSensor 
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
 
#include "USART.h" 
#include "MSP430Sensor.h" 
#include "Timer.h" 
#include "LED.h" 

/******************************************************************************
 *                      CODE FROM THE GLOBALS TEMPLATE
 ******************************************************************************/


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
#define EDAP_STATE_USARTSENSOR_0 0	// fixed
#define EDAP_STATE_INIT_2 2
#define EDAP_STATE_RUNNING_1 1
#define EDAP_STATE_WAITFORCMD_3 3
#define EDAP_STATE_MESURETEMPERATURE_4 4
#define EDAP_STATE_MESUREVOLTAGE_5 5

// Static variable to store the current state of the state machines and composites
static int EDAP_STATE_USARTSENSOR_0_Current_State[2];

/******************************************************************************
 *                          PROTOTYPES DECLARATION
 ******************************************************************************/

// Prototypes for Entry actions
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_INIT_2_On_Entry();
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_RUNNING_1_On_Entry();
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Entry();
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_MESURETEMPERATURE_4_On_Entry();
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_MESUREVOLTAGE_5_On_Entry();

// Prototypes for Exit actions
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Exit();

// Prototypes for Events handlers
void EDAP_STATE_USARTSENSOR_0_receive_byte_Event_Handler(char b);
void EDAP_STATE_USARTSENSOR_0_voltage_value_Event_Handler(int v);
void EDAP_STATE_USARTSENSOR_0_temperature_value_Event_Handler(int v);
void EDAP_STATE_USARTSENSOR_0_timeout_Event_Handler(int timer_id);

/******************************************************************************
 *                    IMPLEMENTATION OF ENTRY AND EXIT
 ******************************************************************************/
 
// Entry actions
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_RUNNING_1_On_Entry() {
	EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] = EDAP_STATE_WAITFORCMD_3; // no history
	
	EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Entry();
}
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_INIT_2_On_Entry() {
	{
Timer_send_start(1, 10000);
LED_send_light_on(1);
LED_send_light_on(2);
USART_send_transmit("Initializing sensor...");
}
}
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Entry() {
	{
USART_send_transmit("
Waiting for command (h = help)");
LED_send_light_off(1);
}
}
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_MESURETEMPERATURE_4_On_Entry() {
	MSP430Sensor_send_mesure_temperature();
}
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_MESUREVOLTAGE_5_On_Entry() {
	MSP430Sensor_send_mesure_voltage();
}

// Exit actions
void EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Exit(){
	LED_send_light_on(1);
}

 /******************************************************************************
 *                    IMPLEMENTATION OF EVENT HANDLING
 ******************************************************************************/
 
void EDAP_STATE_USARTSENSOR_0_receive_byte_Event_Handler(char b){
	if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] == EDAP_STATE_WAITFORCMD_3 &&
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_RUNNING_1 &&
		b == 'h' ) {
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Exit();
		{
USART_send_transmit("t - Retrive Temperature");
USART_send_transmit("v - Retrive Voltage");
USART_send_transmit("h - Show Command List");
USART_send_transmit("r - Reset Sensor");
}
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Entry();
		return; // The event has been consumed
	}
	if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_RUNNING_1 &&
		b == 'r' ) {
		
		USART_send_transmit("Reset!");
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] = EDAP_STATE_INIT_2; // change state
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_INIT_2_On_Entry();
		return; // The event has been consumed
	}
if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] == EDAP_STATE_WAITFORCMD_3 &&
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_RUNNING_1 &&
		b == 't' ) {
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Exit();
		
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] = EDAP_STATE_MESURETEMPERATURE_4; // change state
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_MESURETEMPERATURE_4_On_Entry();
		return; // The event has been consumed
	}
if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] == EDAP_STATE_WAITFORCMD_3 &&
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_RUNNING_1 &&
		b == 'v' ) {
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Exit();
		
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] = EDAP_STATE_MESUREVOLTAGE_5; // change state
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_MESUREVOLTAGE_5_On_Entry();
		return; // The event has been consumed
	}
}
void EDAP_STATE_USARTSENSOR_0_voltage_value_Event_Handler(int v){
		if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] == EDAP_STATE_MESUREVOLTAGE_5 &&
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_RUNNING_1 ) {
		
		{
char outbuf[10];
int10_to_ascii(v,"V=", outbuf);
USART_send_transmit(outbuf);
}
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] = EDAP_STATE_WAITFORCMD_3; // change state
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Entry();
		return; // The event has been consumed
	}
}
void EDAP_STATE_USARTSENSOR_0_temperature_value_Event_Handler(int v){
		if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] == EDAP_STATE_MESURETEMPERATURE_4 &&
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_RUNNING_1 ) {
		
		{
char outbuf[10];
int10_to_ascii(v,"T=", outbuf);
USART_send_transmit(outbuf);
}
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_RUNNING_1] = EDAP_STATE_WAITFORCMD_3; // change state
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_WAITFORCMD_3_On_Entry();
		return; // The event has been consumed
	}
}
void EDAP_STATE_USARTSENSOR_0_timeout_Event_Handler(int timer_id){
		if ( EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] == EDAP_STATE_INIT_2 &&
		timer_id == 1 ) {
		
		{
LED_send_light_off(1);
LED_send_light_on(2);
}
		EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] = EDAP_STATE_RUNNING_1; // change state
		EDAP_STATE_USARTSENSOR_0_EDAP_STATE_RUNNING_1_On_Entry();
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
	init_USART();
	
	// register state machine event handlers
	register_USART_receive_receive_byte_listener(EDAP_STATE_USARTSENSOR_0_receive_byte_Event_Handler);
	register_MSP430Sensor_receive_voltage_value_listener(EDAP_STATE_USARTSENSOR_0_voltage_value_Event_Handler);
	register_MSP430Sensor_receive_temperature_value_listener(EDAP_STATE_USARTSENSOR_0_temperature_value_Event_Handler);
	register_Timer_receive_timeout_listener(EDAP_STATE_USARTSENSOR_0_timeout_Event_Handler);

	// Initialize state machine
	EDAP_STATE_USARTSENSOR_0_Current_State[EDAP_STATE_USARTSENSOR_0] = EDAP_STATE_INIT_2; // Set the initial state
	EDAP_STATE_USARTSENSOR_0_EDAP_STATE_INIT_2_On_Entry();
	
	__enable_interrupt();  // IMPORTANT :-)
	
	while(1) {
		int i;
		
	// some sort of polling delay
	for(i=50000; i>0; i--) __no_operation();

		// poll the drivers
		poll_MSP430Sensor();
		poll_Timer();
		poll_USART();
	}
}
