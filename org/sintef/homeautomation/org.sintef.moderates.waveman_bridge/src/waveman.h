/*
 * waveman.h
 *
 *  Created on: 24. feb. 2011
 *      Author: ffl
 */

#include <avr/io.h>
#include <inttypes.h>

#ifndef WAVEMAN_H_
#define WAVEMAN_H_

void init_waveman();
void poll_waveman();

void sendWavemanCommand(uint8_t house, uint8_t channel, uint8_t command);

void register_receive_waveman_listener(void(*listener)(uint8_t, uint8_t, uint8_t));

void register_receive_esic_listener(void(*listener)(uint8_t, int16_t, uint8_t));

#endif /* WAVEMAN_H_ */
