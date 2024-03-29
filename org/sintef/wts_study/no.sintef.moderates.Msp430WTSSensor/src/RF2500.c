/*
 * Generated using the EDAP MDE Framework (C)SINTEF
 *
 *     ****    DO NOT EDIT THIS FILE    ****
 *
 * Application : RF2500 
 *    Platform : Texas Instruments MSP430 Microcontroller
 *        Date : ???
 *      Author : SINTEF
 *     License : EPL
 */
 #include  "msp430x22x4.h"

#include "RF2500.h"

// Implemetation of void globals_RF2500()

#include <stdint.h>
#include <io.h>
#include <string.h>

/****************************************************************
 *        From hardware.h
 ***************************************************************/

#define	BN_P1_LEDRED	0
#define	BN_P1_LEDGREEN	1
#define	BN_P1_NSWITCH	2

#define	BN_P2_CC2500_GDO2	7
#define	BN_P2_CC2500_GDO0	6

#define	BN_P3_CC2500_CSN	0
#define	BN_P3_CC2500_MOSI		1
#define	BN_P3_CC2500_MISO		2
#define	BN_P3_CC2500_CLK	3
#define	BN_P3_TXD0		4
#define	BN_P3_RXD0		5

#define	BM_P1_DEFDIR	(1<<BN_P1_LEDRED|1<<BN_P1_LEDGREEN)
#define	BM_P1_DEFSTATE	(0)
#define	BM_P1_DEFPULLUP	(1<<BN_P1_NSWITCH)
#define	BM_P1_DEFPULLDOWN	(0)

#define	BM_P2_DEFDIR	(0)
#define	BM_P2_DEFSTATE	(0)
#define	BM_P2_DEFPULLUP	(0)
#define	BM_P2_DEFPULLDOWN	(0)

#define	BM_P3_DEFDIR	(1<<BN_P3_CC2500_CSN|1<<BN_P3_CC2500_MOSI|1<<BN_P3_CC2500_CLK|1<<BN_P3_TXD0)
#define	BM_P3_DEFSTATE	(1<<BN_P3_CC2500_CSN|1<<BN_P3_TXD0)


#define	LED_RED_SET(enable)	(enable)?(P1OUT|=1<<BN_P1_LEDRED):(P1OUT&=~(1<<BN_P1_LEDRED))
#define	LED_GREEN_SET(enable)	(enable)?(P1OUT|=1<<BN_P1_LEDGREEN):(P1OUT&=~(1<<BN_P1_LEDGREEN))

#define	LED_RED_TOGGLE()	P1OUT^=1<<BN_P1_LEDRED
#define	LED_GREEN_TOGGLE()	P1OUT^=1<<BN_P1_LEDGREEN

#define	RADIO_CS_SET(enable)	do { if (enable) P3OUT&=~(1<<BN_P3_CC2500_CSN); else P3OUT|=1<<BN_P3_CC2500_CSN; } while(0)

/****************************************************************
 *        From cc2500_regs.h
 ***************************************************************/
 
 /* configuration registers */
#define MRFI_CC2500_SPI_REG_IOCFG2       0x00      /*  IOCFG2   - GDO2 output pin configuration  */
#define MRFI_CC2500_SPI_REG_IOCFG1       0x01      /*  IOCFG1   - GDO1 output pin configuration  */
#define MRFI_CC2500_SPI_REG_IOCFG0       0x02      /*  IOCFG1   - GDO0 output pin configuration  */
#define MRFI_CC2500_SPI_REG_FIFOTHR      0x03      /*  FIFOTHR  - RX FIFO and TX FIFO thresholds */
#define MRFI_CC2500_SPI_REG_SYNC1        0x04      /*  SYNC1    - Sync word, high byte */
#define MRFI_CC2500_SPI_REG_SYNC0        0x05      /*  SYNC0    - Sync word, low byte */
#define MRFI_CC2500_SPI_REG_PKTLEN       0x06      /*  PKTLEN   - Packet length */
#define MRFI_CC2500_SPI_REG_PKTCTRL1     0x07      /*  PKTCTRL1 - Packet automation control */
#define MRFI_CC2500_SPI_REG_PKTCTRL0     0x08      /*  PKTCTRL0 - Packet automation control */
#define MRFI_CC2500_SPI_REG_ADDR         0x09      /*  ADDR     - Device address */
#define MRFI_CC2500_SPI_REG_CHANNR       0x0A      /*  CHANNR   - Channel number */
#define MRFI_CC2500_SPI_REG_FSCTRL1      0x0B      /*  FSCTRL1  - Frequency synthesizer control */
#define MRFI_CC2500_SPI_REG_FSCTRL0      0x0C      /*  FSCTRL0  - Frequency synthesizer control */
#define MRFI_CC2500_SPI_REG_FREQ2        0x0D      /*  FREQ2    - Frequency control word, high byte */
#define MRFI_CC2500_SPI_REG_FREQ1        0x0E      /*  FREQ1    - Frequency control word, middle byte */
#define MRFI_CC2500_SPI_REG_FREQ0        0x0F      /*  FREQ0    - Frequency control word, low byte */
#define MRFI_CC2500_SPI_REG_MDMCFG4      0x10      /*  MDMCFG4  - Modem configuration */
#define MRFI_CC2500_SPI_REG_MDMCFG3      0x11      /*  MDMCFG3  - Modem configuration */
#define MRFI_CC2500_SPI_REG_MDMCFG2      0x12      /*  MDMCFG2  - Modem configuration */
#define MRFI_CC2500_SPI_REG_MDMCFG1      0x13      /*  MDMCFG1  - Modem configuration */
#define MRFI_CC2500_SPI_REG_MDMCFG0      0x14      /*  MDMCFG0  - Modem configuration */
#define MRFI_CC2500_SPI_REG_DEVIATN      0x15      /*  DEVIATN  - Modem deviation setting */
#define MRFI_CC2500_SPI_REG_MCSM2        0x16      /*  MCSM2    - Main Radio Control State Machine configuration */
#define MRFI_CC2500_SPI_REG_MCSM1        0x17      /*  MCSM1    - Main Radio Control State Machine configuration */
#define MRFI_CC2500_SPI_REG_MCSM0        0x18      /*  MCSM0    - Main Radio Control State Machine configuration */
#define MRFI_CC2500_SPI_REG_FOCCFG       0x19      /*  FOCCFG   - Frequency Offset Compensation configuration */
#define MRFI_CC2500_SPI_REG_BSCFG        0x1A      /*  BSCFG    - Bit Synchronization configuration */
#define MRFI_CC2500_SPI_REG_AGCCTRL2     0x1B      /*  AGCCTRL2 - AGC control */
#define MRFI_CC2500_SPI_REG_AGCCTRL1     0x1C      /*  AGCCTRL1 - AGC control */
#define MRFI_CC2500_SPI_REG_AGCCTRL0     0x1D      /*  AGCCTRL0 - AGC control */
#define MRFI_CC2500_SPI_REG_WOREVT1      0x1E      /*  WOREVT1  - High byte Event0 timeout */
#define MRFI_CC2500_SPI_REG_WOREVT0      0x1F      /*  WOREVT0  - Low byte Event0 timeout */
#define MRFI_CC2500_SPI_REG_WORCTRL      0x20      /*  WORCTRL  - Wake On Radio control */
#define MRFI_CC2500_SPI_REG_FREND1       0x21      /*  FREND1   - Front end RX configuration */
#define MRFI_CC2500_SPI_REG_FREND0       0x22      /*  FREDN0   - Front end TX configuration */
#define MRFI_CC2500_SPI_REG_FSCAL3       0x23      /*  FSCAL3   - Frequency synthesizer calibration */
#define MRFI_CC2500_SPI_REG_FSCAL2       0x24      /*  FSCAL2   - Frequency synthesizer calibration */
#define MRFI_CC2500_SPI_REG_FSCAL1       0x25      /*  FSCAL1   - Frequency synthesizer calibration */
#define MRFI_CC2500_SPI_REG_FSCAL0       0x26      /*  FSCAL0   - Frequency synthesizer calibration */
#define MRFI_CC2500_SPI_REG_RCCTRL1      0x27      /*  RCCTRL1  - RC oscillator configuration */
#define MRFI_CC2500_SPI_REG_RCCTRL0      0x28      /*  RCCTRL0  - RC oscillator configuration */
#define MRFI_CC2500_SPI_REG_FSTEST       0x29      /*  FSTEST   - Frequency synthesizer calibration control */
#define MRFI_CC2500_SPI_REG_PTEST        0x2A      /*  PTEST    - Production test */
#define MRFI_CC2500_SPI_REG_AGCTEST      0x2B      /*  AGCTEST  - AGC test */
#define MRFI_CC2500_SPI_REG_TEST2        0x2C      /*  TEST2    - Various test settings */
#define MRFI_CC2500_SPI_REG_TEST1        0x2D      /*  TEST1    - Various test settings */
#define MRFI_CC2500_SPI_REG_TEST0        0x2E      /*  TEST0    - Various test settings */

/* status registers */
#define MRFI_CC2500_SPI_REG_PARTNUM      0x30      /*  PARTNUM    - Chip ID */
#define MRFI_CC2500_SPI_REG_VERSION      0x31      /*  VERSION    - Chip ID */
#define MRFI_CC2500_SPI_REG_FREQEST      0x32      /*  FREQEST    ÃÂÃÂÃÂÃÂ± Frequency Offset Estimate from demodulator */
#define MRFI_CC2500_SPI_REG_LQI          0x33      /*  LQI        ÃÂÃÂÃÂÃÂ± Demodulator estimate for Link Quality */
#define MRFI_CC2500_SPI_REG_RSSI         0x34      /*  RSSI       ÃÂÃÂÃÂÃÂ± Received signal strength indication */
#define MRFI_CC2500_SPI_REG_MARCSTATE    0x35      /*  MARCSTATE  ÃÂÃÂÃÂÃÂ± Main Radio Control State Machine state */
#define MRFI_CC2500_SPI_REG_WORTIME1     0x36      /*  WORTIME1   ÃÂÃÂÃÂÃÂ± High byte of WOR time */
#define MRFI_CC2500_SPI_REG_WORTIME0     0x37      /*  WORTIME0   ÃÂÃÂÃÂÃÂ± Low byte of WOR time */
#define MRFI_CC2500_SPI_REG_PKTSTATUS    0x38      /*  PKTSTATUS  ÃÂÃÂÃÂÃÂ± Current GDOx status and packet status */
#define MRFI_CC2500_SPI_REG_VCO_VC_DAC   0x39      /*  VCO_VC_DAC ÃÂÃÂÃÂÃÂ± Current setting from PLL calibration module */
#define MRFI_CC2500_SPI_REG_TXBYTES      0x3A      /*  TXBYTES    ÃÂÃÂÃÂÃÂ± Underflow and number of bytes */
#define MRFI_CC2500_SPI_REG_RXBYTES      0x3B      /*  RXBYTES    ÃÂÃÂÃÂÃÂ± Overflow and number of bytes */
                                                                                                                                                 
/* burst write registers */
#define MRFI_CC2500_SPI_REG_PATABLE      0x3E      /*  PATABLE - PA control settings table */
#define MRFI_CC2500_SPI_REG_TXFIFO       0x3F      /*  TXFIFO  - Transmit FIFO */
#define MRFI_CC2500_SPI_REG_RXFIFO       0x3F      /*  RXFIFO  - Receive FIFO */

/* command strobe registers */
#define MRFI_CC2500_SPI_STROBE_SRES      0x30      /*  SRES    - Reset chip. */
#define MRFI_CC2500_SPI_STROBE_SFSTXON   0x31      /*  SFSTXON - Enable and calibrate frequency synthesizer. */
#define MRFI_CC2500_SPI_STROBE_SXOFF     0x32      /*  SXOFF   - Turn off crystal oscillator. */
#define MRFI_CC2500_SPI_STROBE_SCAL      0x33      /*  SCAL    - Calibrate frequency synthesizer and turn it off. */
#define MRFI_CC2500_SPI_STROBE_SRX       0x34      /*  SRX     - Enable RX. Perform calibration if enabled. */
#define MRFI_CC2500_SPI_STROBE_STX       0x35      /*  STX     - Enable TX. If in RX state, only enable TX if CCA passes. */
#define MRFI_CC2500_SPI_STROBE_SIDLE     0x36      /*  SIDLE   - Exit RX / TX, turn off frequency synthesizer. */
#define MRFI_CC2500_SPI_STROBE_SRSVD     0x37      /*  SRVSD   - Reserved.  Do not use. */
#define MRFI_CC2500_SPI_STROBE_SWOR      0x38      /*  SWOR    - Start automatic RX polling sequence (Wake-on-Radio) */
#define MRFI_CC2500_SPI_STROBE_SPWD      0x39      /*  SPWD    - Enter power down mode when CSn goes high. */
#define MRFI_CC2500_SPI_STROBE_SFRX      0x3A      /*  SFRX    - Flush the RX FIFO buffer. */
#define MRFI_CC2500_SPI_STROBE_SFTX      0x3B      /*  SFTX    - Flush the TX FIFO buffer. */
#define MRFI_CC2500_SPI_STROBE_SWORRST   0x3C      /*  SWORRST - Reset real time clock. */
#define MRFI_CC2500_SPI_STROBE_SNOP      0x3D      /*  SNOP    - No operation. Returns status byte. */

/****************************************************************
 *        From hal_spi_radio.h
 ***************************************************************/
 
 #define SPI_WRITE_BYTE(x)                do { IFG2 &= ~UCB0RXIFG;  UCB0TXBUF = x; } while(0)
#define SPI_READ_BYTE()                  UCB0RXBUF
#define SPI_WAIT_DONE()                  while(!(IFG2 & UCB0RXIFG));
 

/****************************************************************
 *        From smartrf_CC2500.h
 ***************************************************************/
#define SMARTRF_RADIO_CC2500


#define SMARTRF_SETTING_FSCTRL1    0x07
#define SMARTRF_SETTING_FSCTRL0    0x00
#define SMARTRF_SETTING_FREQ2      0x5D
#define SMARTRF_SETTING_FREQ1      0x93
#define SMARTRF_SETTING_FREQ0      0xB1
#define SMARTRF_SETTING_MDMCFG4    0x2D
#define SMARTRF_SETTING_MDMCFG3    0x3B
#define SMARTRF_SETTING_MDMCFG2    0x73
#define SMARTRF_SETTING_MDMCFG1    0x22
#define SMARTRF_SETTING_MDMCFG0    0xF8
#define SMARTRF_SETTING_DEVIATN    0x01
#define SMARTRF_SETTING_FREND1     0xB6
#define SMARTRF_SETTING_FREND0     0x10
#define SMARTRF_SETTING_MCSM0      0x18
#define SMARTRF_SETTING_FOCCFG     0x1D
#define SMARTRF_SETTING_BSCFG      0x1C
#define SMARTRF_SETTING_AGCCTRL2   0xC7
#define SMARTRF_SETTING_AGCCTRL1   0x00
#define SMARTRF_SETTING_AGCCTRL0   0xB0
#define SMARTRF_SETTING_FSCAL3     0xEA
#define SMARTRF_SETTING_FSCAL2     0x0A
#define SMARTRF_SETTING_FSCAL1     0x00
#define SMARTRF_SETTING_FSCAL0     0x11
#define SMARTRF_SETTING_FSTEST     0x59
#define SMARTRF_SETTING_TEST2      0x88
#define SMARTRF_SETTING_TEST1      0x31
#define SMARTRF_SETTING_TEST0      0x0B
#define SMARTRF_SETTING_FIFOTHR    0x07
#define SMARTRF_SETTING_IOCFG0D    0x06


#define SMARTRF_SETTING_PKTLEN           0x0E

#define SMARTRF_SETTING_PKTCTRL1         0x04
#define SMARTRF_SETTING_PKTCTRL0         0x44
#define SMARTRF_SETTING_ADDR             0x00
#define SMARTRF_SETTING_CHANNR           0x00

#define SMARTRF_SETTING_IOCFG2           0x29
#define SMARTRF_SETTING_IOCFG1           0x2E
#define SMARTRF_SETTING_IOCFG0           0x06

#define SMARTRF_SETTING_MCSM2            0x07
#define SMARTRF_SETTING_MCSM1            0x30
#define SMARTRF_SETTING_MCSM0            0x18

/****************************************************************
 *        From hal_radio.h
 ***************************************************************/

struct hal_radio_packet // fixed 16 bytes packet
{
	uint8_t src_addr;
	uint8_t dst_addr;
	uint8_t frame;
	uint8_t length;
	uint8_t data[10];
	uint8_t rssi;
	uint8_t lqi;
};


/****************************************************************
 *        From hal_spi_radio.c
 ***************************************************************/
 
 void hal_spi_init()
{
	UCB0CTL1 = UCSWRST;
	UCB0CTL1 = UCSWRST | UCSSEL1;
	UCB0CTL0 = UCCKPH | UCMSB | UCMST | UCSYNC;
	UCB0BR0  = 2;
	UCB0BR1  = 0;
	P3SEL |= 1<<BN_P3_CC2500_CLK|1<<BN_P3_CC2500_MOSI|1<<BN_P3_CC2500_MISO;
	UCB0CTL1 &= ~UCSWRST;
}

#define DUMMY_BYTE                  0xDB
#define READ_BIT                    0x80
#define BURST_BIT                   0x40

uint8_t hal_spi_radio_cmdStrobe( uint8_t addr )
{
	if (!(addr>=0x30 && addr<=0x3D))
		return -1;
	RADIO_CS_SET(0);
	RADIO_CS_SET(1);
	SPI_WRITE_BYTE( addr );
	SPI_WAIT_DONE();
	uint8_t status = SPI_READ_BYTE();
	RADIO_CS_SET(0);
	return status;
}

static uint8_t hal_spi_radio_register( uint8_t addr, uint8_t value )
{
	RADIO_CS_SET(0);
	RADIO_CS_SET(1);
	SPI_WRITE_BYTE( addr );
	SPI_WAIT_DONE();
	SPI_WRITE_BYTE( value );
	SPI_WAIT_DONE();
	uint8_t retVal = SPI_READ_BYTE();
	RADIO_CS_SET(0);
	return retVal;
}

static void hal_spi_radio_fifo( uint8_t addr, uint8_t* pData, uint8_t len )
{
	if (len==0)
		return;
	if (!(addr & BURST_BIT))
		return;
	RADIO_CS_SET(0);
	RADIO_CS_SET(1);
	SPI_WRITE_BYTE( addr );
	SPI_WAIT_DONE();
	for( ; len>0 ; --len, ++pData ) {
		SPI_WRITE_BYTE( *pData );
		SPI_WAIT_DONE();
		if (addr & READ_BIT)
			*pData = SPI_READ_BYTE();
	}
	RADIO_CS_SET(0);
}


uint8_t hal_spi_radio_readReg( uint8_t addr )
{
	return hal_spi_radio_register( addr | BURST_BIT | READ_BIT, DUMMY_BYTE );
}

void hal_spi_radio_writeReg( uint8_t addr, uint8_t value )
{
	hal_spi_radio_register( addr, value );
}

void hal_spi_radio_writeTxFifo( const uint8_t* pData, uint8_t len )
{
	hal_spi_radio_fifo( MRFI_CC2500_SPI_REG_TXFIFO | BURST_BIT, (uint8_t*)pData, len );
}

void hal_spi_radio_readRxFifo( uint8_t* pData, uint8_t len )
{
	hal_spi_radio_fifo( MRFI_CC2500_SPI_REG_RXFIFO | BURST_BIT | READ_BIT, pData, len );
}

void hal_spi_radio_writePAtable01( uint8_t pa0, uint8_t pa1 )
{
	uint8_t buf[2] = { pa0, pa1 };
	hal_spi_radio_fifo( MRFI_CC2500_SPI_REG_PATABLE | BURST_BIT, buf, 2 );
}

/****************************************************************
 *        From hal_spi_radio.c
 ***************************************************************/

#define DELAY(x)                   do { uint16_t i; for( i=4*x; i>0; --i ) asm("nop"); } while (0);

volatile uint8_t hal_radio_address = 0;
volatile uint8_t hal_radio_channel = 0;

struct hal_radio_packet rx_packet;

static const uint8_t radio_regs_config[][2] =
{
  { MRFI_CC2500_SPI_REG_IOCFG0,    SMARTRF_SETTING_IOCFG0   },
  { MRFI_CC2500_SPI_REG_IOCFG1,    SMARTRF_SETTING_IOCFG1   },
  { MRFI_CC2500_SPI_REG_IOCFG2,    SMARTRF_SETTING_IOCFG2   },
  { MRFI_CC2500_SPI_REG_MCSM1,     SMARTRF_SETTING_MCSM1    },
  { MRFI_CC2500_SPI_REG_MCSM0,     SMARTRF_SETTING_MCSM0    },
  { MRFI_CC2500_SPI_REG_PKTLEN,    SMARTRF_SETTING_PKTLEN   },
  { MRFI_CC2500_SPI_REG_PKTCTRL0,  SMARTRF_SETTING_PKTCTRL0 },
  { MRFI_CC2500_SPI_REG_PATABLE,   0xFE                     }, // Transmission power to the max
/*  { MRFI_CC2500_SPI_REG_ADDR,      SMARTRF_SETTING_ADDR     }, // device address
  { MRFI_CC2500_SPI_REG_CHANNR,    SMARTRF_SETTING_CHANNR   }, // Select channel
*/  { MRFI_CC2500_SPI_REG_FIFOTHR,   SMARTRF_SETTING_FIFOTHR  },
  { MRFI_CC2500_SPI_REG_FSCTRL1,   SMARTRF_SETTING_FSCTRL1  },
  { MRFI_CC2500_SPI_REG_FSCTRL0,   SMARTRF_SETTING_FSCTRL0  },
  { MRFI_CC2500_SPI_REG_FREQ2,     SMARTRF_SETTING_FREQ2    },
  { MRFI_CC2500_SPI_REG_FREQ1,     SMARTRF_SETTING_FREQ1    },
  { MRFI_CC2500_SPI_REG_FREQ0,     SMARTRF_SETTING_FREQ0    },
  { MRFI_CC2500_SPI_REG_MDMCFG4,   SMARTRF_SETTING_MDMCFG4  },
  { MRFI_CC2500_SPI_REG_MDMCFG3,   SMARTRF_SETTING_MDMCFG3  },
  { MRFI_CC2500_SPI_REG_MDMCFG2,   SMARTRF_SETTING_MDMCFG2  },
  { MRFI_CC2500_SPI_REG_MDMCFG1,   SMARTRF_SETTING_MDMCFG1  },
  { MRFI_CC2500_SPI_REG_MDMCFG0,   SMARTRF_SETTING_MDMCFG0  },
  { MRFI_CC2500_SPI_REG_DEVIATN,   SMARTRF_SETTING_DEVIATN  },
  { MRFI_CC2500_SPI_REG_FOCCFG,    SMARTRF_SETTING_FOCCFG   },
  { MRFI_CC2500_SPI_REG_BSCFG,     SMARTRF_SETTING_BSCFG    },
  { MRFI_CC2500_SPI_REG_AGCCTRL2,  SMARTRF_SETTING_AGCCTRL2 },
  { MRFI_CC2500_SPI_REG_AGCCTRL1,  SMARTRF_SETTING_AGCCTRL1 },
  { MRFI_CC2500_SPI_REG_AGCCTRL0,  SMARTRF_SETTING_AGCCTRL0 },
  { MRFI_CC2500_SPI_REG_FREND1,    SMARTRF_SETTING_FREND1   },
  { MRFI_CC2500_SPI_REG_FREND0,    SMARTRF_SETTING_FREND0   },
  { MRFI_CC2500_SPI_REG_FSCAL3,    SMARTRF_SETTING_FSCAL3   },
  { MRFI_CC2500_SPI_REG_FSCAL2,    SMARTRF_SETTING_FSCAL2   },
  { MRFI_CC2500_SPI_REG_FSCAL1,    SMARTRF_SETTING_FSCAL1   },
  { MRFI_CC2500_SPI_REG_FSCAL0,    SMARTRF_SETTING_FSCAL0   },
  { MRFI_CC2500_SPI_REG_TEST2,     SMARTRF_SETTING_TEST2    },
  { MRFI_CC2500_SPI_REG_TEST1,     SMARTRF_SETTING_TEST1    },
  { MRFI_CC2500_SPI_REG_TEST0,     SMARTRF_SETTING_TEST0    },
};

void hal_radio_send_packet( const struct hal_radio_packet* packet ) {
	if (hal_spi_radio_readReg(MRFI_CC2500_SPI_REG_TXBYTES) > 0) DELAY(100);
	hal_spi_radio_writeTxFifo( (uint8_t *)packet, 14 );
	hal_spi_radio_cmdStrobe( MRFI_CC2500_SPI_STROBE_STX );
	while(hal_spi_radio_readReg(MRFI_CC2500_SPI_REG_MARCSTATE) != 1); // wait for transmission to be finished
	hal_spi_radio_cmdStrobe( MRFI_CC2500_SPI_STROBE_SRX ); // Switch the receiver on again
}

int receive_packet( struct hal_radio_packet* packet ) {
	uint8_t rxlen = hal_spi_radio_readReg(MRFI_CC2500_SPI_REG_RXBYTES);

	if (rxlen >= 16) {
		hal_spi_radio_readRxFifo( (uint8_t *) packet, 16 );
		hal_spi_radio_cmdStrobe( MRFI_CC2500_SPI_STROBE_SRX );
		if (packet->lqi & 0x80) { // CRC OK
			return 1; // One packet received
		}
		return 0; // Packet with bad CRC
	}
	else return 0; // No packets

}


void (*RF2500_receive_receive_listener)(int, char *, int, int, int) = 0x0;
void register_RF2500_receive_receive_listener(void(*listener)(int, char *, int, int, int)) {
	RF2500_receive_receive_listener = listener;
}
void RF2500_receive_receive(int addr, char * msg, int msglen, int rssi, int lqi) {
	if (RF2500_receive_receive_listener != 0) RF2500_receive_receive_listener(addr, msg, msglen, rssi, lqi);
}

void init_RF2500() {
// Implemetation of void init_RF2500()

// Implemetation of void init_RF2500()

// Init SPI
	
	P1OUT = BM_P1_DEFSTATE | (BM_P1_DEFPULLUP & ~BM_P1_DEFDIR);
	P1REN = BM_P1_DEFPULLUP | BM_P1_DEFPULLDOWN;
	P1DIR = BM_P1_DEFDIR;

	P2SEL = 0;	/*bit 6 and 7 are assigned to crytal by default!*/
	P2OUT = BM_P2_DEFSTATE | (BM_P2_DEFPULLUP & ~BM_P2_DEFDIR);
	P2REN = BM_P2_DEFPULLUP | BM_P2_DEFPULLDOWN;
	P2DIR = BM_P2_DEFDIR;

	P3OUT = BM_P3_DEFSTATE;
	P3DIR = BM_P3_DEFDIR;

	hal_spi_init();

	RADIO_CS_SET(1);
	DELAY(10);
	RADIO_CS_SET(0);
	DELAY(100);
	// pull CSn low and wait for SO to go low
	RADIO_CS_SET(1);
	while (P3IN & (1<<BN_P3_CC2500_MISO));
	SPI_WRITE_BYTE( MRFI_CC2500_SPI_STROBE_SRES );
	SPI_WAIT_DONE();
	while (P3IN & (1<<BN_P3_CC2500_MISO));
	RADIO_CS_SET(0);

	// Test SPI communication
	#define TEST_VALUE 0xA5
	hal_spi_radio_writeReg( MRFI_CC2500_SPI_REG_PKTLEN, TEST_VALUE );
	if (hal_spi_radio_readReg(MRFI_CC2500_SPI_REG_PKTLEN)!=TEST_VALUE) {
		//return 1; // Return 1 if the test failed
	}

	// Configure the radio chip
	uint8_t i;
	for( i=0; i<sizeof(radio_regs_config)/sizeof(radio_regs_config[0]); ++i )
		hal_spi_radio_writeReg( radio_regs_config[i][0], radio_regs_config[i][1] );
	hal_spi_radio_cmdStrobe( MRFI_CC2500_SPI_STROBE_SRX );

	// Configure channel and address of the device
	hal_radio_address = 0;
	hal_radio_channel = 1;
	hal_spi_radio_writeReg(MRFI_CC2500_SPI_REG_ADDR, hal_radio_address);
	hal_spi_radio_writeReg(MRFI_CC2500_SPI_REG_CHANNR, hal_radio_channel);
	//hal_spi_radio_writeReg( MRFI_CC2500_SPI_REG_PKTLEN, 14 );

}
void poll_RF2500(){
// Implemetation of void poll_RF2500()

	if (receive_packet(&rx_packet)) {
		if (rx_packet.dst_addr == 0x00 || rx_packet.dst_addr == 0xFF || rx_packet.dst_addr == hal_radio_address) {
			RF2500_receive_receive(rx_packet.src_addr, rx_packet.data, rx_packet.length, rx_packet.rssi, rx_packet.lqi);
		}
	}

}
void RF2500_send_set_address(int address) {
// Implemetation of void RF2500_send_set_address()

	hal_radio_address = address;
	hal_spi_radio_writeReg(MRFI_CC2500_SPI_REG_ADDR, address);

}
void RF2500_send_set_channel(int channel) {
// Implemetation of void RF2500_send_set_channel()

	hal_radio_channel = channel;
	hal_spi_radio_writeReg(MRFI_CC2500_SPI_REG_CHANNR, channel);

}
void RF2500_send_transmit(int addr, char * msg) {
// Implemetation of void RF2500_send_transmit()

	uint8_t length = strlen(msg);
	if (length > 10) length = 10; // message is just trimmed

	struct hal_radio_packet p = {
				.src_addr = hal_radio_address,
				.dst_addr = addr,
				.frame    = 0x00,
				.length   = length
		};

		memcpy(&p.data, msg, length);

		hal_radio_send_packet( &p );

}
