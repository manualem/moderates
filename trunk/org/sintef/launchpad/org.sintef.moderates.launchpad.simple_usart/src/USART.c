//#include <msp430x20x2.h>
#include <io.h>
#include <signal.h>

#include "USART.h"

// Implemetation of void globals_USART()

#include <signal.h>

//-----------------------------------------------------------------------------
// Implementation of the USART interupt routine (Enqueue received characters)
//-----------------------------------------------------------------------------
#define UART_TXD   0x02                     // TXD on P1.1 (Timer0_A.OUT0)
#define UART_RXD   0x04                     // RXD on P1.2 (Timer0_A.CCI1A)
#define UART_TBIT_DIV_2     (1000000 / (9600 * 2))
#define UART_TBIT           (1000000 / 9600)

#define TAIV_TACCR1 (0x0002) /* TACCR1_CCIFG */ // CCR1 capture interrupt

unsigned int txData;                        // UART internal variable for TX
unsigned char rxbuf;
unsigned char rxhasdata;

// Timer_A UART - Transmit Interrupt Handler
interrupt (TIMERA0_VECTOR) Timer_A0_ISR(void)
{
    static unsigned char txBitCnt = 10;

    TACCR0 += UART_TBIT;                    // Add Offset to CCRx
    if (txBitCnt == 0) {                    // All bits TXed?
        TACCTL0 &= ~CCIE;                   // All bits TXed, disable interrupt
        txBitCnt = 10;                      // Re-load bit counter
    }
    else {
        if (txData & 0x01) {
          TACCTL0 &= ~OUTMOD2;              // TX Mark '1'
        }
        else {
          TACCTL0 |= OUTMOD2;               // TX Space '0'
        }
        txData >>= 1;
        txBitCnt--;
    }
}

// Timer_A UART - Receive Interrupt Handler
interrupt (TIMERA1_VECTOR) Timer_A1_ISR(void)
{
    static unsigned char rxBitCnt = 8;
    static unsigned char rxData = 0;

    if(TAIV ==  TAIV_TACCR1) {      // CCR1 capture interrupt
            TACCR1 += UART_TBIT;                 // Add Offset to CCRx
            if (TACCTL1 & CAP) {                 // Capture mode = start bit edge
                TACCTL1 &= ~CAP;                 // Switch capture to compare mode
                TACCR1 += UART_TBIT_DIV_2;       // Point CCRx to middle of D0
            }
            else {
                rxData >>= 1;
                if (TACCTL1 & SCCI) {            // Get bit waiting in receive latch
                    rxData |= 0x80;
                }
                rxBitCnt--;
                if (rxBitCnt == 0) {             // All bits RXed?
                	rxbuf = rxData;
                	rxhasdata = 1;
                   // P1OUT ^= 0x01;
                    rxBitCnt = 8;                // Re-load bit counter
                    TACCTL1 = SCS + CM1 + CAP + CCIE;              // Switch compare to capture mode
                    //__bic_SR_register_on_exit(LPM0_bits);  // Clear LPM0 bits from 0(SR)
                }
            }
   }
}

void (*USART_receive_receive_byte_listener)(char) = 0x0;
void register_USART_receive_receive_byte_listener(void(*listener)(char)) {
	USART_receive_receive_byte_listener = listener;
}
void USART_receive_receive_byte(char b) {
	if (USART_receive_receive_byte_listener != 0) USART_receive_receive_byte_listener(b);
}

void init_USART() {
	TACCTL0 = OUT;                          // Set TXD Idle as Mark = '1'
	TACCTL1 = SCS + CM1 + CAP + CCIE;       // Sync, Neg Edge, Capture, Int
	TACTL = TASSEL_2 + MC_2;                // SMCLK, start in continuous mode

}
void poll_USART(){
	if (rxhasdata) {
		USART_receive_receive_byte(rxbuf);
		rxhasdata = 0;
	}
}

void USART_send_transmit(char * msg) {
	while (*msg) {
		USART_send_transmit_byte(*msg++);
	    }
}

void USART_send_transmit_byte(char b) {
	while (TACCTL0 & CCIE);                 // Ensure last char got TX'd
	    TACCR0 = TAR;                           // Current state of TA counter
	    TACCR0 += UART_TBIT;                    // One bit time till first bit
	    TACCTL0 = OUTMOD0 + CCIE;               // Set TXD on EQU0, Int
	    txData = b;                          // Load global variable
	    txData |= 0x100;                        // Add mark stop bit to TXData
	    txData <<= 1;                           // Add space start bit
}
