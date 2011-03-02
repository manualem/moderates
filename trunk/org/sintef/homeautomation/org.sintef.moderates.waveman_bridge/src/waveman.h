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

void sendWavemanCommand(uint8_t id, uint8_t command);
void waveman_add_binding(uint8_t src_id, uint8_t src_cmd, uint8_t tgt_id, uint8_t tgt_cmd);
void waveman_remove_binding(uint8_t src_id, uint8_t src_cmd, uint8_t tgt_id, uint8_t tgt_cmd);
void waveman_clear_bindings();
void waveman_list_bindings();

void register_receive_waveman_listener(void(*listener)(uint8_t, uint8_t));

void register_receive_esic_listener(void(*listener)(uint8_t, int16_t, uint8_t));

#endif /* WAVEMAN_H_ */
