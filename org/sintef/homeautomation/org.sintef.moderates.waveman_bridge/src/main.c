#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include <inttypes.h>
#include <stdlib.h>
#include <string.h>

#include "timer.h"
#include "USART.h"
#include "waveman.h"
#include "LED.h"


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

// format the data in a string : "S=hh.c H=hhh% T=-tt.tC ID=iii"
// the size of msg should be at least 30
void ESICSensorRcv_format(uint8_t sensor, uint16_t temperature, uint8_t humidity, char* msg) {
	uint8_t idx = 0;
	msg[idx++] = 'S'; msg[idx++] = '=';
	itoa(sensor >> 4, msg+idx,10);
	while(msg[idx] != '\0') idx++;
	msg[idx++] = '.';
	itoa((sensor >> 2) & 0x03, msg+idx,10);
	while(msg[idx] != '\0') idx++;

	msg[idx++] = ' ';
	msg[idx++] = 'H';msg[idx++] = '=';
	itoa(humidity, msg+idx,10);
	while(msg[idx] != '\0') idx++;
	msg[idx++] = '%';

	int10_to_ascii(temperature, " T=", msg+idx);
	while(msg[idx] != '\0') idx++;
	msg[idx++] = 'C';

	msg[idx++] = '\0';
}

void USART_transmit_Hex8(int value) {
	static const char hex[] = "0123456789ABCDEF";
	USART_send_character(hex[(value>>4) & 0x0f] );
	USART_send_character(hex[value & 0x0f] );
}

/*
SIGNAL(SIG_OUTPUT_COMPARE1A)
{
   pool_timer();
}
*/
void init() {

	/*
	TIMSK |= (1 << TOIE0);
	TCCR1A = 0x00; 	// we are using the normal up counter mode
	TCCR1B = 0x01; 	// feed timer by system clock... here assumed 8 MHz
	*//*
	   OCR1A = 8000; // to have interrupt every 1 ms at 8MHz
	   TCCR1A = 0x00;  //Timer counter control register
	   TCCR1B = (0 << WGM13)|(1 << WGM12)|(0 << CS12)|(0 << CS11)|(1 << CS10); // WGM1=4, prescale at 1024
	   TIMSK1 |= (1 << OCIE1A); //Set bit 6 in TIMSK to enable Timer 1 compare interrupt.
*/
	init_USART();
	init_timer();
	init_waveman();
	init_LED();
}

void recieve_esic(uint8_t sensor, uint16_t temperature, uint8_t humidity) {
	char buffer[25];
	ESICSensorRcv_format(sensor, temperature, humidity, buffer);
	USART_send_message(buffer);
	USART_send_character(0x0D);
	USART_send_character(0x0A);
}

void recieve_waveman(uint8_t home, uint8_t channel, uint8_t command) {

	USART_send_message("EVT src=");
	USART_transmit_Hex8( (home << 4) + channel);
	USART_send_message(" cmd=");
	USART_transmit_Hex8(command);
	USART_send_character(0x0D);
	USART_send_character(0x0A);

	if (home == 0 && channel == 3 && command == 0x0E) {
		sendWavemanCommand(0x00, 0x00, 0x00);
	}
	else if (home == 0 && channel == 3 && command == 0x00) {
		sendWavemanCommand(0x00, 0x00, 0x0E);
	}
}

void recieve_char(char c) {

	LED_send_light_on(1);
	if (c == 'o') {
		sendWavemanCommand(0x00, 0x00, 0x0E);
	}
	else if (c == 'p') {
		sendWavemanCommand(0x00, 0x00, 0x00);
	}
	else USART_send_message("Error\n");
	LED_send_light_off(1);
}

void timeout(int id) {
	USART_send_character('.');
	timer_send_start(0, 1000);
	LED_send_toggle(2);
}

int main(void)
{
	
	init(); // initialize IO pins and timer
	register_receive_esic_listener(&recieve_esic);
	register_receive_waveman_listener(&recieve_waveman);
	register_USART_receive_byte_listener(&recieve_char);
	register_timer_receive_timeout_listener(&timeout);
	sei(); // Globally enable all interrupts

	LED_send_light_on(1);
	//LED_send_light_on(2);

	timer_send_start(0, 1000);

	while(1) {
		pool_USART();
		poll_waveman();
	}
	
}
