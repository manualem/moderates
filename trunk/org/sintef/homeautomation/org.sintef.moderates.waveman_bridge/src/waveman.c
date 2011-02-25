/*
 * waveman.c
 *
 *  Created on: 24. feb. 2011
 *      Author: ffl
 */

#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include <inttypes.h>

#include "waveman.h"

#define DBG PB0
#define RFRX PD3
#define RFTX PB2

void (*receive_waveman_listener)(uint8_t, uint8_t, uint8_t) = 0x0;
void register_receive_waveman_listener(void(*listener)(uint8_t, uint8_t, uint8_t)){
	receive_waveman_listener = listener;
}
void receive_waveman(uint8_t house, uint8_t channel, uint8_t command) {
	if (receive_waveman_listener != 0) receive_waveman_listener(house, channel, command);
}

void (*receive_esic_listener)(uint8_t, int16_t, uint8_t) = 0x0;
void register_receive_esic_listener(void(*listener)(uint8_t, int16_t, uint8_t)){
	receive_esic_listener = listener;
}
void receive_esic(uint8_t sensor, int16_t temperature, uint8_t humidity) {
	if (receive_esic_listener != 0) receive_esic_listener(sensor, temperature, humidity);
}

volatile uint8_t counter = 0;

SIGNAL (SIG_OUTPUT_COMPARE0A) // 1 interrupt every 2O us at 8MHz
{
	//TCNT0 = 195;
	PORTB ^=(1<<DBG); // For debug: This pin should read as 25 kHz
	counter++;
}

typedef struct {
	uint8_t sensor;
	uint8_t humidity;
	int16_t temperature;
	uint8_t stamp;
} ESICSensorData;

typedef struct {
	uint8_t home;
	uint8_t channel;
	int16_t command;
} WavemanCommand;


// data used by the interrupt routine only
volatile uint8_t state = 0;
volatile uint8_t last = 0;
volatile uint8_t data[4];

// Data shared by the interrupt routine and the pooling
volatile ESICSensorData last_data;
volatile uint8_t data_ready = 0;

// data used by the interrupt routine only
volatile uint8_t wstate = 0;
volatile uint8_t wbstate = 0;
volatile uint8_t wdata[2];
volatile uint8_t wprev_data[2];

// Data shared by the interrupt routine and the pooling
volatile uint8_t wdata_ready = 0;
volatile WavemanCommand wlast_data;

// Use INT1 as RF 433 input pin and Timer1 for intervals.
ISR( INT1_vect ) {

	uint16_t tick;

   tick=TCNT1;

   if (tick < 20) return; // ignore very short pulses (debouncing)
   TCNT1=0; // clear timer

   if (wstate == 0) {
	   wdata[0] = 0x00;
	   wdata[1] = 0x00;
	   wbstate = 0x00;
   }

   if (tick > 1050 && tick < 1550) // this is a 1.30ms interval
   {

	   if (wstate == 1) wstate = 2; // The second part of the "start"
	   else if (wstate >= 2) { // receiving DATA

		   if (wbstate == 0x00) wbstate = 0x11;
		   else if (wbstate == 0x01) wbstate = 0x02;
		   else if (wbstate == 0x03) {
			   // we have received a 0
			   wstate++;
			   wbstate = 0x00;
		   }
		   else if (wbstate == 0x13) {
			   // we have received a 1
			   int8_t idx = 13 - wstate; // 11 .. 0
			   wdata[idx/8] |= 1 << ( 7 - idx%8 );
			   wstate++;
			   wbstate = 0x00;
		   }
		   else {
			   // This is invalid
			   wstate = 0;
			   return;
		   }
	   }
	   else {
		   // This is invalid
		   wstate = 0;
		   return;
	   }
   }
   else if (tick > 300 && tick < 540) // this is a 0.42ms interval
   {
	   if (wstate == 0) wstate = 1; // The first part of the "start"
	   else if (wstate >= 2) { // Receiving DATA
		   if (wbstate == 0x00) wbstate = 0x01;
			   else if (wbstate == 0x11) wbstate = 0x12;
			   else if (wbstate == 0x02) {
				   wbstate = 0x03;
				   if (wstate == 13) { // Last bit of the frame is a 0
					   wstate++;
				   }
			   }
			   else if (wbstate == 0x12) {
				   wbstate = 0x13;
				   if (wstate == 13) { // Last bit of the frame is a 1
					   wdata[0] |= 1 << 7;
					   wstate++;
				   }
			   }
			   else {
				   // This is invalid
				   wstate = 0;
				   return;
			   }
	   }
	   else {
		   // This is invalid
		   wstate = 0;
		   return;
	   }
   }
   else // Any other interval is invalid
   {
	   wstate = 0;
   }

   if (wstate > 13) { // We got a complete frame

	   if (wprev_data[0] == wdata[0] && wprev_data[1] == wdata[1]) {
		   if (!wdata_ready) { // drop the frame if the previous one is still there
			   wlast_data.home = wdata[1] >> 4;
			   wlast_data.channel = wdata[0] & 0x0F;
			   wlast_data.command = wdata[0] >> 4;
			   wdata_ready = 1;
		   }
	   }

	   wprev_data[0] = wdata[0];
	   wprev_data[1] = wdata[1];

	   wstate = 0;
   }

   /*
   if (state == 0) { // reset data
	   data[0] = 0;
	   data[1] = 0;
	   data[2] = 0;
	   data[3] = 0;
	   last = 0;
   }

   if (tick > 700 && tick < 1300) // this is a 1ms interval
   {
	   if (state == 0) state++; // go to state 1 when a 1 ms interval is detected
	   // stay in state 1 and consume an arbitrary number of 1ms interval until a 2ms interval -> state 2
	   else if (state == 2) state = 0; // we expoect a second 2ms interval
	   else if (state > 2 && state < 31){ // acquire data
		   if (last == 0) {
			   int8_t idx = 30 - state; // 27 .. 0
			   data[idx/8] |= 1 << (idx%8);
			   last = 1;
		   }
		   else {
			   state++;
			   last = 0;
		   }
	   }
   }
   else if (tick > 1700 && tick < 2300) // this is a 2ms interval
   {
	   if (state > 0 && state < 31) state ++;
	   else state = 0;
   }
   else state = 0;// this is an invalid interval reset.

   if (state > 30) { // we have received a complete frame
	   state = 0;

	   PORTC ^= 1<<PC5; // toggle the Green LED

	   if (data_ready == 0) { // Do not store data if the previous is still there

		   // populate the data structure
		   last_data.sensor = (data[3] << 4) | (data[2] >> 4);
		   last_data.humidity = ((data[2] & 0x0F) << 4) | ( data[1] >> 4 );
		   last_data.temperature = ((data[1] & 0x0F) << 4) | ( data[0] >> 4 );
		   last_data.temperature =  (last_data.temperature - 50) * 10 + ((data[0] & 0x0F)*10)/16;

		   // check that the data is valid
		   if (    last_data.sensor != 0 &&
				   last_data.humidity < 100 &&
				   last_data.temperature > -500 &&
				   last_data.temperature < 650) {
			   data_ready = 1; // signal that a new data is available
		   }
	   }
   }
   */
}


void __sendTXOnOff(uint8_t on, uint8_t off)
{
	PORTB|= _BV(RFTX);
	counter = 0;
	while (counter < on);
	PORTB &= ~_BV(RFTX);
	counter = 0;
	while (counter < off);
}
void (*sendTXOnOff) (uint8_t, uint8_t) = __sendTXOnOff; // To prevent inlining.....

void sendWavemanStart() {
	sendTXOnOff(21, 65);
}

void sendWaveman0() {
	sendTXOnOff(21, 65);
	sendTXOnOff(21, 65);
}
void sendWaveman1() {
	sendTXOnOff(65, 21);
	sendTXOnOff(21, 65);
}

void sendWavemanBits(int bits, int nb_bits) {
	int i;
	for (i = 0; i < nb_bits; i++) {
		if ((1<<i) & bits) sendWaveman1();
		else sendWaveman0();
	}
}

void sendWavemanCommand(uint8_t house, uint8_t channel, uint8_t command) {
	int i;
	for(i=0; i<6; i++) {
		sendWavemanStart();
		sendWavemanBits(house, 4);
		sendWavemanBits(channel, 4);
		sendWavemanBits(command, 4);
		_delay_ms(10);
	}
}

void init_waveman() {

	// Init output pins
	DDRB|= _BV(RFTX); PORTB &= ~_BV(RFTX); // output off
	DDRB|= _BV(DBG); PORTB &= ~_BV(DBG); // output off

	// Timer 0 (8 bits) used to generate 50kHz interruption used by the transmitter.
	TIMSK0 = _BV(OCF0A);  // Enable Interrupt TimerCounter0 Compare Match A (SIG_OUTPUT_COMPARE0A)
	TCCR0A = _BV(WGM01);  // Mode = CTC
	TCCR0B = _BV(CS00);   // Clock/1024, 0.001024 seconds per tick
	OCR0A = 156;          // 0.001024*244 ~= .25 SIG_OUTPUT_COMPARE0A will be triggered 4 times per second.

	// Timer 1 (16 bits) used to count at 1Mhz. Used by the receiver to mesure intervals in micro-seconds
	TCCR1A = 0x00;
	TCCR1B = 0x02; //start Timer1 clk/8 (1MHz)

	// Init input pin and listen for logical changes
	DDRD &= ~_BV(PD3); // input PD2 (INT1)
	EICRA &= ~0x08; EICRA |= 0x04; // Any logical change on INT1 generates an interrupt request
	EIMSK |= 0x02; //INT1 unmased

}

void poll_waveman() {
	if (data_ready) {
		receive_esic(last_data.sensor, last_data.temperature, last_data.humidity);
		data_ready = 0;
	}
	if (wdata_ready) {
		receive_waveman(wlast_data.home, wlast_data.channel, wlast_data.command);
		wdata_ready = 0;
	}
}
