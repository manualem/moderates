/* Powered by EDAP */

#include <avr/io.h>
#include <inttypes.h>

#ifndef USART_H_
#define USART_H_

void init_USART();
void pool_USART();

void USART_send_character(char b);
void USART_transmit_Hex8(int value);
void USART_send_message(char * message);


void register_USART_receive_byte_listener(void(*listener)(char));
void register_USART_receive_msg_listener(void(*listener)(char*));

#endif /* USART_H_ */
