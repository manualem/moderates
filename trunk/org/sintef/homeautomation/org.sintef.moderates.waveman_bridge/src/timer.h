/* Powered by EDAP */

#include <avr/io.h>
#include <inttypes.h>

#ifndef TIMER_H_
#define TIMER_H_

#define MAX_TIMERS 5

void init_timer();
void pool_timer();

void timer_send_start(int timer_id, int delay);

void timer_send_cancel(int timer_id);

void register_timer_receive_timeout_listener(void(*listener)(int));

#endif /* TIMER_H_ */
