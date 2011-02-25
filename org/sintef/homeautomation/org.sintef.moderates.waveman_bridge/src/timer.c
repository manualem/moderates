/* Powered by EDAP */

#include <avr/io.h>
#include <util/delay.h>
#include <inttypes.h>
#include <avr/interrupt.h>
#include <stdlib.h>
#include "timer.h"

volatile long cpt;
volatile long timeouts[MAX_TIMERS];

void timer_send_start(int timer_id, int delay) {
	timeouts[timer_id] = cpt + delay;
}

void timer_send_cancel(int timer_id) {
	timeouts[timer_id] = 0;
}

void (*timer_receive_timeout_listener)(int) = 0x0;
void register_timer_receive_timeout_listener(void(*listener)(int)) {
	timer_receive_timeout_listener = listener;
}
void timer_receive_timeout(int timer_id) {
	if (timer_receive_timeout_listener != 0) timer_receive_timeout_listener(timer_id);
}

void init_timer() {
	uint8_t i;
	cpt = 0;
	for(i=0; i<MAX_TIMERS; i++) timeouts[i] = 0;
}
void pool_timer(){
	uint8_t i;
		uint8_t active = 0;
		for(i=0; i<MAX_TIMERS; i++) {
			if (timeouts[i] != 0) {
				active = 1;
				if (timeouts[i] <= cpt) {
					timeouts[i] = 0;
					timer_receive_timeout(i);
				}
			}
		}
		if (active)	cpt++;
		else cpt = 0;
}
