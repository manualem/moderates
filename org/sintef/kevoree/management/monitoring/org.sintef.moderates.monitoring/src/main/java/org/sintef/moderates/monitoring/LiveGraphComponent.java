package org.sintef.moderates.monitoring;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.LiveGraph.dataFile.write.DataStreamWriter;
import org.LiveGraph.dataFile.write.DataStreamWriterFactory;

import org.kevoree.annotation.*;

/**
 * This Kevoree components uses LiveGraph to monitor data
 * based on a CSV file. See http://www.live-graph.org/
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@DictionaryType({
    @DictionaryAttribute(name = "headers", optional = false),
    @DictionaryAttribute(name = "separator", defaultValue = ";", optional = false)
})
@ComponentType
public class LiveGraphComponent extends AbstractMonitorComponent {

    private DataStreamWriter out;
    File f;

    @Start
    public void start() {

        try {
            this.separator = (String) this.getDictionary().get("separator");
            this.headers = ((String) this.getDictionary().get("headers")).split(separator);

            String modifier = "";
            int id = getID();
            if (id != -1) {
                modifier = "#" + headers[id].split("=")[1];
            }
            f = File.createTempFile("monitor" + modifier + "_", ".dat");
            Logger.getLogger(LiveGraphComponent.class.getName()).log(Level.INFO, "Log to file: " + f.getAbsolutePath());

            out = DataStreamWriterFactory.createDataWriter(f, true); //lg.updateInvoker().startMemoryStreamMode();
            out.setSeparator(separator);
            // Add a file description line:
            out.writeFileInfo("LiveGraph monitoring file.");
            // Set-up the data series:
            for (int i = 0; i < headers.length; i++) {
                if (i == id) {
                    out.addDataSeries(headers[i].split("=")[0] + modifier);
                } else {
                    out.addDataSeries(headers[i] + modifier);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LiveGraphComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Stop
    public void stop() {
        out.close();
        //lg.disposeGUIAndExit();
    }

    @Override
    protected void doLog(String entry[]) {
        for (int i = 0; i < entry.length; i++) {
            Double v = null;
            try {
                v = Double.parseDouble(entry[i]);
            } catch (NumberFormatException nfe) {
                v = new Double(0);
            }
            out.setDataValue(v);
        }
        out.writeDataSet();
        Logger.getLogger(LiveGraphComponent.class.getName()).log(Level.INFO, "Writting file" + f.getAbsolutePath());
    }

    private int getID() {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].startsWith("ID=")) {
                return i;
            }
        }
        return -1;
    }
}
