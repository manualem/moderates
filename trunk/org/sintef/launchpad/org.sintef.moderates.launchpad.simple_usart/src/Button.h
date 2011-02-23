#include <io.h>
#include <signal.h>

#ifndef BUTTON_H_
#define BUTTON_H_

void init_Button();
void poll_Button();


void register_Button_receive_press_listener(void(*listener)(int));
void register_Button_receive_release_listener(void(*listener)(int));

#endif /* BUTTON_H_ */
