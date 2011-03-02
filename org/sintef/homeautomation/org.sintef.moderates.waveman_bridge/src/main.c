#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include <inttypes.h>
#include <stdlib.h>
#include <string.h>

#include "timer.h"
#include "USART.h"
#include "waveman.h"


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
	msg[idx++] = 'E'; msg[idx++] = 'S';
	msg[idx++] = 'I'; msg[idx++] = 'C';
	msg[idx++] = ' ';
	itoa(sensor >> 4, msg+idx,10);
	while(msg[idx] != '\0') idx++;
	msg[idx++] = '.';
	itoa(((sensor >> 2) & 0x03)+1, msg+idx,10);
	while(msg[idx] != '\0') idx++;

	int10_to_ascii(temperature, " ", msg+idx);
	while(msg[idx] != '\0') idx++;

	msg[idx++] = ' ';
	itoa(humidity, msg+idx,10);
	while(msg[idx] != '\0') idx++;
	msg[idx++] = '\0';
}

uint8_t parse_hex_char(char c) {
	if (c >= '0' && c <= '9') return c-48;
	if (c >= 'A' && c <= 'F') return c-55;
	if (c >= 'a' && c <= 'f') return c-87;
	return 0xFF;
}

uint8_t parse_8_bit_hex_char(char c1, char c2) {
	return (parse_hex_char(c1)<<4) + parse_hex_char(c2);
}

int8_t parse_wm_command(char * cmd) {
	// WMB CL
	// WMB LS
	// WMB AD HH HH HH HH
	// WMB RM HH HH HH HH
	// WMB SD HH HH
	uint8_t src_id, src_cmd, dst_id, dst_cmd;
	uint8_t tmp;

	if (cmd[0] != 'W') return -1;
	if (cmd[1] != 'M') return -1;
	if (cmd[2] != 'B') return -1;
	if (cmd[3] != ' ') return -1;
	if (cmd[4] == 'C') { // should be a clear
		if (cmd[5] != 'L') return -1;
		else waveman_clear_bindings();
	}
	else if (cmd[4] == 'L') { // should be a clear
		if (cmd[5] != 'S') return -1;
		else waveman_list_bindings();
	}
	else if (cmd[4] == 'A' || cmd[4] == 'R' || cmd[4] == 'S') { // should be a add or remove
		if (cmd[5] != 'D' && cmd[5] != 'M' && cmd[5] != 'D') return -1;
		if (cmd[6] != ' ') return -1;

		src_id = parse_hex_char(cmd[7]);
		if (src_id == 0xFF) return -1;
		tmp = parse_hex_char(cmd[8]);
		if (tmp == 0xFF) return -1;
		src_id = (src_id << 4) + tmp;

		if (cmd[9] != ' ') return -1;

		src_cmd = parse_hex_char(cmd[10]);
		if (src_cmd == 0xFF) return -1;
		tmp = parse_hex_char(cmd[11]);
		if (tmp == 0xFF) return -1;
		src_cmd = (src_cmd << 4) + tmp;

		if (cmd[4] == 'S' && cmd[5] == 'D') { // It is a send
			sendWavemanCommand(src_id, src_cmd);
			return 0;
		}

		if (cmd[12] != ' ') return -1;

		dst_id = parse_hex_char(cmd[13]);
		if (dst_id == 0xFF) return -1;
		tmp = parse_hex_char(cmd[14]);
		if (tmp == 0xFF) return -1;
		dst_id = (dst_id << 4) + tmp;

		if (cmd[15] != ' ') return -1;

		dst_cmd = parse_hex_char(cmd[16]);
		if (dst_cmd == 0xFF) return -1;
		tmp = parse_hex_char(cmd[17]);
		if (tmp == 0xFF) return -1;
		dst_cmd = (dst_cmd << 4) + tmp;

		if (cmd[4] == 'A' && cmd[5] == 'D') { // It is an add
			waveman_add_binding(src_id, src_cmd, dst_id, dst_cmd);
		}
		else if (cmd[4] == 'R' && cmd[5] == 'M') { // It is a remove
			waveman_remove_binding(src_id, src_cmd, dst_id, dst_cmd);
		}
		else return -1;
	}
	else return -1;

	return 0; // It went ok
}

// WMB AD F0 0E 20 0E

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
}

void recieve_esic(uint8_t sensor, uint16_t temperature, uint8_t humidity) {
	char buffer[25];
	ESICSensorRcv_format(sensor, temperature, humidity, buffer);
	USART_send_message(buffer);
	USART_send_character(0x0D);
	USART_send_character(0x0A);
}

void recieve_waveman(uint8_t id, uint8_t command) {

	USART_send_message("WM ");
	USART_transmit_Hex8( id );
	USART_send_message(" ");
	USART_transmit_Hex8(command);
	USART_send_character(0x0D);
	USART_send_character(0x0A);

}

void recieve_char(char c) {

}

void recieve_msg(char * msg) {
	if (parse_wm_command(msg) < 0) {
		USART_send_message("DBG Bad command: ");
	}
	else {
		USART_send_message("DBG OK: ");
	}
	USART_send_message(msg);
	USART_send_character(0x0D);
	USART_send_character(0x0A);
}

void timeout(int id) {
	USART_send_character('.');
	timer_send_start(0, 1000);
}

int main(void)
{
	
	init(); // initialize IO pins and timer
	register_receive_esic_listener(&recieve_esic);
	register_receive_waveman_listener(&recieve_waveman);
	register_USART_receive_byte_listener(&recieve_char);
	register_USART_receive_msg_listener(&recieve_msg);
	register_timer_receive_timeout_listener(&timeout);
	sei(); // Globally enable all interrupts

	timer_send_start(0, 1000);

	waveman_add_binding(0xF1, 0x0E, 0x10, 0x0E);
	waveman_add_binding(0xF1, 0x00, 0x10, 0x00);

	while(1) {
		pool_USART();
		poll_waveman();
	}
	
}
