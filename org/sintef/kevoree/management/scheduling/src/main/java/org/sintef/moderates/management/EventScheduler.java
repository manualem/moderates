/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sintef.moderates.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    @RequiredPort(name = "notify", type = PortType.MESSAGE)
})
@Provides({
    @ProvidedPort(name = "schedule", type = PortType.SERVICE, async = false, className = IEventScheduler.class)
})
@DictionaryType({
    @DictionaryAttribute(name = "dateFormat", defaultValue = "yyyy-MM-dd HH:mm", optional = false)
})
@Library(name = "MODERATES::Management")
@ComponentType
public class EventScheduler extends AbstractComponentType implements IEventScheduler {

    private Timer timer;
    private SimpleDateFormat dateFormat;
    private Map<String, TimerTask> map;

    public EventScheduler() {
        this.timer = new Timer();
        this.map = new HashMap<String, TimerTask>();
    }

    @Start
    public void start() {
        String dateFormatString = (String) this.getDictionary().get("dateFormat");
        this.dateFormat = new SimpleDateFormat(dateFormatString);
    }

    @Stop
    public void stop() {
        this.timer.purge();
        this.timer.cancel();
    }

    @Update
    public void update(){

    }

    private boolean existsTask(String id) {
        return map.containsKey(id);
    }

    private boolean hasBeenUpdated(String id, String at) {
        if (existsTask(id)) {
            try {
                Date newDate = this.dateFormat.parse(at);
                TimerTask task = map.get(id);
                //we consider that a task has been updated if its scheduled time has varied for more than 1 minute.
                if (newDate.getTime() - task.scheduledExecutionTime() > 1000*60 || newDate.getTime() - task.scheduledExecutionTime() < 1000*60) {
                    return true;
                } else {
                    return false;
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    @Port(name = "schedule", method = "scheduleIn")
    public void scheduleIn(Object in, String msg, String id) {
        if (!existsTask(id)) {
            EventSchedulerTask task = new EventSchedulerTask(this, msg, id);
            timer.schedule(task, (Long)in);
            map.put(id, task);
        }
    }

    @Override
    @Port(name = "schedule", method = "scheduleAt")
    public void scheduleAt(String at, String msg, String id) {
        try {
            if (!existsTask(id)) {
                EventSchedulerTask task = new EventSchedulerTask(this, msg, id);
                timer.schedule(task, this.dateFormat.parse(at));
                map.put(id, task);
            }
        } catch (ParseException ex) {
            Logger.getLogger(EventScheduler.class.getName()).log(Level.WARNING, "Expected date format is ");
            Logger.getLogger(EventScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @Port(name = "schedule", method = "scheduleInRec")
    public void scheduleInRec(Object in, String msg, String id) {
        if (!existsTask(id)) {
            EventSchedulerTask task = new EventSchedulerTask(this, msg, id);
            timer.schedule(task, (Long)in, (Long)in);
            map.put(id, task);
        }
    }

    @Override
    @Port(name = "schedule", method = "scheduleAtRec")
    public void scheduleAtRec(String at, String msg, Object period, String id) {
        try {
            if (!existsTask(id)) {
                EventSchedulerTask task = new EventSchedulerTask(this, msg, id);
                timer.scheduleAtFixedRate(task, this.dateFormat.parse(at), (Long)period);
                map.put(id, task);
            }
        } catch (ParseException ex) {
            Logger.getLogger(EventScheduler.class.getName()).log(Level.WARNING, "Expected date format is ");
            Logger.getLogger(EventScheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void notify(String msg) {
        if (this.isPortBinded("notify")) {
            Logger.getLogger(EventScheduler.class.getName()).log(Level.INFO, "notifying: " + msg);
            this.getPortByName("notify", MessagePort.class).process(msg);
        }
    }

    private class EventSchedulerTask extends TimerTask {

        private EventScheduler es;
        private String msg;
        private String id;

        public EventSchedulerTask(EventScheduler es, String msg, String id) {
            this.es = es;
            this.msg = msg;
        }

        @Override
        public void run() {
            es.notify(msg);
            es.map.remove(id);
        }
    }
}
