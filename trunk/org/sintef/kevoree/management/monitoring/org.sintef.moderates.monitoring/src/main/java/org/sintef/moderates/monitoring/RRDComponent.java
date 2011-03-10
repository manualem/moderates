package org.sintef.moderates.monitoring;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jrobin.core.DsDef;
import org.jrobin.core.RrdDb;
import org.jrobin.core.RrdDef;
import org.jrobin.core.RrdException;
import org.jrobin.core.Sample;
import org.jrobin.core.Util;

import org.kevoree.annotation.*;

/**
 * This Kevoree component provides facilities to log numeric values and archive
 * them using JRobin (RRD Tool). This is suited for logging values every X>=1 seconds
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@DictionaryType({
    @DictionaryAttribute(name = "name", optional = false),
    @DictionaryAttribute(name = "headers", optional = false),
    @DictionaryAttribute(name = "separator", optional = false),
    @DictionaryAttribute(name = "type", optional = false),
    @DictionaryAttribute(name = "step", optional = false),
    @DictionaryAttribute(name = "heartbeat", optional = false),
    @DictionaryAttribute(name = "archiveType", optional = false),
    @DictionaryAttribute(name = "archiveStep", optional = false),
    @DictionaryAttribute(name = "archiveRows", optional = false)
})
@ComponentType
public class RRDComponent extends AbstractMonitorComponent {

    private RrdDef monitorConf;
    private RrdDb monitorDB;
    //
    private String name;
    private long step;
    private long heartbeat;
    private String dataSourceType;
    //
    private String archiveType;
    private int archiveSteps;
    private int archiveRows;
    private boolean monitorStarted;

    @Start
    public void start() {
        name = (String) this.getDictionary().get("name");
        separator = (String) this.getDictionary().get("separator");
        headers = ((String) this.getDictionary().get("headers")).split(separator);
        dataSourceType = (String) this.getDictionary().get("type");
        step = Long.parseLong((String) this.getDictionary().get("step"));
        heartbeat = Long.parseLong((String) this.getDictionary().get("heartbeat"));
        archiveType = (String) this.getDictionary().get("archiveType");
        archiveSteps = Integer.parseInt((String) this.getDictionary().get("archiveStep"));
        archiveRows = Integer.parseInt((String) this.getDictionary().get("archiveRows"));

        try {
            if (!checkType()) {
                this.dataSourceType = "COUNTER";
            }

            monitorConf = new RrdDef(this.name + ".rrd", this.step);

            for (int i = 0; i < headers.length; i++) {
                String header = null;
                if (headers[i].contains("=")) {
                    header = headers[i].split("=")[0];
                } else {
                    header = headers[i];
                }

                DsDef datasourceConf = new DsDef(header, this.dataSourceType, this.heartbeat, Double.NaN, Double.NaN);
                monitorConf.addDatasource(datasourceConf);
            }

            if (!checkArchiveType()) {
                this.archiveType = "AVERAGE";
            }

            monitorConf.addArchive(this.archiveType, 0.5, this.archiveSteps, this.archiveRows);
            monitorDB = new RrdDb(monitorConf);

        } catch (IOException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RrdException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Stop
    public void stop() {
        saveToXML();
        monitorStarted = false;
        try {
            monitorDB.close();
        } catch (IOException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkType() {
        return this.dataSourceType.equals("GAUGE") || this.dataSourceType.equals("COUNTER") || this.dataSourceType.equals("DERIVE")
                || this.dataSourceType.equals("ABSOLUTE") || this.dataSourceType.equals("COMPUTE");
    }

    private boolean checkArchiveType() {
        return this.archiveType.equals("AVERAGE") || this.archiveType.equals("MINIMUM")
                || this.archiveType.equals("MAXIMUM") || this.archiveType.equals("LAST");
    }

    @Override
    protected void doLog(String entry[]) {
        if (!monitorStarted) {
            monitorConf.setStartTime(Util.getTime());
            monitorStarted = true;
        }

        try {
            Sample s = null;
            for (int i = 0; i < entry.length; i++) {
                Double v = null;
                try {
                    v = Double.parseDouble(entry[i]);
                } catch (NumberFormatException nfe) {
                    v = new Double(0);
                }

                String header = null;
                if (headers[i].contains("=")) {
                    header = headers[i].split("=")[0];
                } else {
                    header = headers[i];
                }

                s = monitorDB.createSample().setTime(Util.getTime()).setValue(header, v);
                Logger.getLogger(RRDComponent.class.getName()).log(Level.INFO, "Logging: " + header + " = " + v);
            }
            s.update();
        } catch (IOException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RrdException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveToXML() {
        try {
            monitorDB.dumpXml(name + ".xml");
        } catch (IOException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RrdException ex) {
            Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        Random r = new Random();

        RRDComponent monitor = new RRDComponent();
        monitor.getDictionary().put("name", "myCounter");
        monitor.getDictionary().put("headers", "value1 value2");
        monitor.getDictionary().put("separator", " ");
        monitor.getDictionary().put("type", "GAUGE");
        monitor.getDictionary().put("step", "1");
        monitor.getDictionary().put("heartbeat", "5");
        monitor.getDictionary().put("archiveType", "AVERAGE");
        monitor.getDictionary().put("archiveStep", "2");
        monitor.getDictionary().put("archiveRows", "250");
        monitor.start();

        for (int i = 0; i < 15; i++) {
            try {
                //Double j = new Double(i * i);
                monitor.logValue(r.nextDouble() + " " + r.nextDouble());
                Thread.currentThread().sleep(1250);
            } catch (InterruptedException ex) {
                Logger.getLogger(RRDComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        monitor.saveToXML();
    }
}
