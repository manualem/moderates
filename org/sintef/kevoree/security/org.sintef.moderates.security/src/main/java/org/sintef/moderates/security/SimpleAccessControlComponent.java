/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sintef.moderates.security;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;

/**
 *
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "output", type = PortType.MESSAGE, async = true)
})
@Provides({
    @ProvidedPort(name = "input", type = PortType.MESSAGE, async = true),
    @ProvidedPort(name = "login", type = PortType.MESSAGE, async = true)
})
@DictionaryType({
    @DictionaryAttribute(name = "id", defaultValue = "", optional = false),
    @DictionaryAttribute(name = "timeout", defaultValue = "120000", optional = false)
})
@Library(name = "MODERATES::Security")
@ComponentType
public class SimpleAccessControlComponent extends AbstractComponentType {

    private boolean accessGranted;
    private String id;
    private long timeout;
    private Timer timer;

    public SimpleAccessControlComponent() {
        this.accessGranted = false;
        this.timer = new Timer();
    }

    @Start
    public void start() {
        this.id = (String) this.getDictionary().get("id");
        this.timeout = Long.parseLong((String) this.getDictionary().get("timeout"));
    }

    @Update
    public void update() {
        this.id = (String) this.getDictionary().get("id");
        this.timeout = Long.parseLong((String) this.getDictionary().get("timeout"));
    }

    @Stop
    public void stop() {
    }

    @Port(name = "input")
    public void receive(Object msg) {
        forward(msg);
    }

    @Port(name = "login")
    public void login(Object msg) {
        if (id.equals(msg)){
            accessGranted = true;
            timer.cancel();
            timer.purge();
            timer.schedule(new Timeout(this), timeout);
        } else {
            accessGranted = false;
        }
    }

    private void forward(Object msg) {
        if (accessGranted && this.isPortBinded("output")) {
            Logger.getLogger(SimpleAccessControlComponent.class.getName()).log(Level.INFO, "Access granted!");
            this.getPortByName("output", MessagePort.class).process(msg);
        }

        if (!accessGranted) {
            Logger.getLogger(SimpleAccessControlComponent.class.getName()).log(Level.WARNING, "Access denied!");
        }
    }

    private class Timeout extends TimerTask {

        private SimpleAccessControlComponent acc;

        public Timeout(SimpleAccessControlComponent acc) {
            this.acc = acc;
        }

        @Override
        public void run() {
            Logger.getLogger(SimpleAccessControlComponent.class.getName()).log(Level.WARNING, "Timeout! Please login again.");
            acc.accessGranted = false;
        }
    }
}
