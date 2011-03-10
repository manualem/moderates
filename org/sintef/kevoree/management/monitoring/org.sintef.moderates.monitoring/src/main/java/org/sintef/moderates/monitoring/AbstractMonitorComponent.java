/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sintef.moderates.monitoring;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

/**
 *
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Provides({
    @ProvidedPort(name = "logValue", type = PortType.MESSAGE)
})
@Library(name = "MODERATES::Monitoring")
@ComponentFragment
public abstract class AbstractMonitorComponent extends AbstractComponentType {

    protected String headers[];
    protected String separator;

    @Port(name = "logValue", method = "logValue")
    public void logValue(Object value) {
        if (value instanceof String) {
            String entry[] = ((String) value).split(separator);
            if (entry.length == headers.length) {
                if (filter(entry)) {
                   doLog(entry);
                }
            }
        }
    }

    abstract protected void doLog(String entry[]);

    private boolean filter(String entry[]) {
        boolean result = true;
        for (int i = 0; i < entry.length; i++) {
            if (headers[i].contains("=")) {
                result &= entry[i].equals(headers[i].split("=")[1]);
            }
        }
        return result;
    }
}
