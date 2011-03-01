/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sintef.moderates.management;

/**
 *
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
interface IEventScheduler {

    public void scheduleIn(Object in, String msg, String id);
    public void scheduleAt(String at, String msg, String id);

    public void scheduleInRec(Object in, String msg, String id);
    public void scheduleAtRec(String at, String msg, Object period, String id);

}
