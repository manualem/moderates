/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sintef.moderates.management;

import com.google.gdata.client.Query;
import com.google.gdata.client.calendar.CalendarQuery;
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.calendar.CalendarEventEntry;
import com.google.gdata.data.calendar.CalendarEventFeed;
import com.google.gdata.data.extensions.When;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

/**
 * This Kevoree component is largely inspired by the samples provided by Google.
 * It periodically reads the Google Calendar of the user and register events to the system
 * No write or update of the Calendar.
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Requires({
    @RequiredPort(name = "scheduleToSystem", type = PortType.SERVICE, className = IEventScheduler.class)
})
@DictionaryType({
    @DictionaryAttribute(name = "userName", defaultValue = "moderates.9012@gmail.com", optional = false),
    @DictionaryAttribute(name = "userPassword", defaultValue = "thingmlrules", optional = false),
    @DictionaryAttribute(name = "delay", defaultValue = "300000", optional = false)
})
/*
//Not OSGi-compliant...
@ThirdParties({
    @ThirdParty(name = "gdata-core-1.0", url = "mvn:http://mandubian-mvn.googlecode.com/svn/trunk/mandubian-mvn/repository!com.google.gdata/gdata-core-1.0/"),
    @ThirdParty(name = "gdata-calendar-2.0", url = "mvn:http://mandubian-mvn.googlecode.com/svn/trunk/mandubian-mvn/repository!com.google.gdata/gdata-calendar-2.0/"),
    @ThirdParty(name = "gdata-client-1.0", url = "mvn:http://mandubian-mvn.googlecode.com/svn/trunk/mandubian-mvn/repository!com.google.gdata/gdata-client-1.0/")
})*/
@Library(name = "MODERATES::Management")
@ComponentType
public class GCalendarComponent extends AbstractComponentType /*implements IEventScheduler*/ {

    // The base URL for a user's calendar metafeed (needs a username appended).
    private static final String METAFEED_URL_BASE = "https://www.google.com/calendar/feeds/";
    // The string to add to the user's metafeedUrl to access the event feed for
    // their primary calendar.
    private static final String EVENT_FEED_URL_SUFFIX = "/private/full";
    // The URL for the event feed of the specified user's primary calendar.
    // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/private/full)
    private URL eventFeedUrl = null;

    private String userName;
    private String userPassword;
    private CalendarService myService;
    private long delay;
    private Timer timer;

    @Start
    public void start() {
        userName = "moderates.9012@gmail.com";//(String)this.getDictionary().get("userName");
        userPassword = "thingmlrules";//(String)this.getDictionary().get("userPassword");
        delay = 300000;//Long.parseLong((String)this.getDictionary().get("delay"));

        myService = new CalendarService("Kevoree_GCalendarComponent");

        // Create the necessary URL objects.
        try {
            eventFeedUrl = new URL(METAFEED_URL_BASE + userName + EVENT_FEED_URL_SUFFIX);
        } catch (MalformedURLException e) {
            // Bad URL
            Logger.getLogger(GCalendarComponent.class.getName()).log(Level.SEVERE, "Uh oh - you've got an invalid URL.", e);
            return;
        }

        try {
            myService.setUserCredentials(userName, userPassword);
        } catch (ServiceException e) {
            // Server side error
            Logger.getLogger(GCalendarComponent.class.getName()).log(Level.SEVERE, "The server had a problem handling your request.", e);
        }

        timer = new Timer();
        timer.scheduleAtFixedRate(new GCalendarWatcher(this), 250, delay);
    }

    @Update
    public void update() {
        delay = Long.parseLong((String)this.getDictionary().get("delay"));
    }

    @Stop
    public void stop() {
        this.timer.purge();
        this.timer.cancel();
    }

    /**
     * Returns the CalendarEventFeed matching a full-text query.
     *
     * @param query The text for which to query.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server.
     */
    private CalendarEventFeed fullTextQuery(String query)
            throws ServiceException, IOException {
        Query myQuery = new Query(eventFeedUrl);
        myQuery.setFullTextQuery(query);

        CalendarEventFeed resultFeed = myService.query(myQuery, CalendarEventFeed.class);

        return resultFeed;
    }

    /**
     * Returns the CalendarEventFeed in a specified date/time range.
     *
     * @param startTime Start time (inclusive) of events to print.
     * @param endTime End time (exclusive) of events to print.
     * @throws ServiceException If the service is unable to handle the request.
     * @throws IOException Error communicating with the server.
     */
    private CalendarEventFeed dateRangeQuery(DateTime startTime, DateTime endTime)
            throws ServiceException, IOException {
        CalendarQuery myQuery = new CalendarQuery(eventFeedUrl);
        myQuery.setMinimumStartTime(startTime);
        myQuery.setMaximumStartTime(endTime);

        // Send the request and receive the response:
        CalendarEventFeed resultFeed = myService.query(myQuery,
                CalendarEventFeed.class);

        return resultFeed;
    }

    /**
     * Instantiates a CalendarService object and uses the command line arguments
     * to authenticate. The CalendarService object is used to demonstrate
     * interactions with the Calendar data API's event feed.
     *
     * @param args Must be length 2 and contain a valid username/password
     */
    public static void main(String[] args) {
        GCalendarComponent gCalComp = new GCalendarComponent();
        gCalComp.getDictionary().put("userName", "moderates.9012@gmail.com");
        gCalComp.getDictionary().put("userPassword", "thingmlrules");
        gCalComp.getDictionary().put("delay", "60000");

        gCalComp.start();
    }

    private class GCalendarWatcher extends TimerTask {

        GCalendarComponent gCal;

        public GCalendarWatcher(GCalendarComponent gCal) {
            this.gCal = gCal;
        }

        @Override
        public void run() {
            try {
                StringBuffer logBuffer = new StringBuffer();

                Date startDate = new Date(System.currentTimeMillis() - 10*delay/*(4 * 60 * 60 * 1000)*/);
                DateTime start = new DateTime(startDate);

                Date stopDate = new Date(System.currentTimeMillis() + 25*delay/*(4 * 60 * 60 * 1000)*/);
                DateTime stop = new DateTime(stopDate);

                CalendarEventFeed cef = gCal.dateRangeQuery(start, stop);
                logBuffer.append("Daemon> Events from " + start.toString() + " to " + stop.toString() + ":");
                for (int i = 0; i < cef.getEntries().size(); i++) {
                    CalendarEventEntry entry = cef.getEntries().get(i);
                    logBuffer.append("\t" + entry.getTitle().getPlainText() + " id=" + entry.getId());
                    for (When when : entry.getTimes()) {
                        logBuffer.append("\t\t from " + when.getStartTime().toUiString() + " to " + when.getEndTime().toUiString());
                        scheduleToSystem(when.getStartTime().toUiString(), entry.getTitle().getPlainText(), entry.getId());
                    }
                }
                Logger.getLogger(GCalendarWatcher.class.getName()).log(Level.INFO, logBuffer.toString());

            } catch (ServiceException ex) {
                Logger.getLogger(GCalendarComponent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GCalendarComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void scheduleToSystem(String at, String msg, String id) {
        if (this.isPortBinded("scheduleToSystem")) {
            Logger.getLogger(GCalendarComponent.class.getName()).log(Level.INFO, "scheduling "+msg+" into the system at "+at);
            this.getPortByName("scheduleToSystem", IEventScheduler.class).scheduleAt(at, msg, id);
        }
    }
}
