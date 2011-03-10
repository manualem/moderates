/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sintef.moderates.rxtx;

/**
 *
 * @author moderates
 */
public interface RxTxDevice {
    public void push(Object msg);

    public void restartSerialReader();
}
