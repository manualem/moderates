package org.sintef.moderates.sim;

import org.sintef.moderates.CoffeeSensorProtocol;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class InteractiveCoffeeSensorDataGUI2 implements ActionListener {
	
	private static boolean init = false;
	
	private static final InteractiveCoffeeSensorDataGUI2 _this = new InteractiveCoffeeSensorDataGUI2();
	
	public static ProtocolHandler handler;
	
	private static JFrame frame;
	private static JTextPane screen;
	private static JButton clearButton;
	private static JButton logOwnEventsButton;
	
	//Attributes related to GetTemperature
	public static JButton sendButtonGetTemperature;
		
	//Attributes related to GetDistance
	public static JButton sendButtonGetDistance;
		
	//Attributes related to GetLight
	public static JButton sendButtonGetLight;
		
	//Attributes related to subscribeMotion
	public static JButton sendButtonsubscribeMotion;
		
	//Attributes related to unsubscribeMotion
	public static JButton sendButtonunsubscribeMotion;
		
	//Attributes related to subscribeLightChange
	public static JButton sendButtonsubscribeLightChange;
		
	//Attributes related to unsubscribeLightChange
	public static JButton sendButtonunsubscribeLightChange;
		
	//Attributes related to subscribeTemperatureChange
	public static JButton sendButtonsubscribeTemperatureChange;
		
	//Attributes related to unsubscribeTemperatureChange
	public static JButton sendButtonunsubscribeTemperatureChange;
		
	//Attributes related to subscribeRawData
	public static JButton sendButtonsubscribeRawData;
	public static JTextField fieldsubscribeRawData_interval;
		
	//Attributes related to getRawData
	public static JButton sendButtongetRawData;
		
	//Attributes related to ping
	public static JButton sendButtonping;
		

	public static void print(String id, String data){
		try {
        	StyledDocument doc = screen.getStyledDocument();
            doc.insertString(doc.getLength(), formatForPrint(data), doc.getStyle("receive"+id+"Style"));
            screen.setCaretPosition(doc.getLength());
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
	}
		
	public static void addListener(ActionListener l){
		sendButtonGetTemperature.addActionListener(l);
		sendButtonGetDistance.addActionListener(l);
		sendButtonGetLight.addActionListener(l);
		sendButtonsubscribeMotion.addActionListener(l);
		sendButtonunsubscribeMotion.addActionListener(l);
		sendButtonsubscribeLightChange.addActionListener(l);
		sendButtonunsubscribeLightChange.addActionListener(l);
		sendButtonsubscribeTemperatureChange.addActionListener(l);
		sendButtonunsubscribeTemperatureChange.addActionListener(l);
		sendButtonsubscribeRawData.addActionListener(l);
		sendButtongetRawData.addActionListener(l);
		sendButtonping.addActionListener(l);
	}
	
	public static void init(){
		if (!init) {
			init = true;
			
			clearButton = new JButton("Clear Console");
			logOwnEventsButton = new JButton("Log Own Events (Click to Activate)");
			frame = new JFrame("Interactive CoffeeSensor Data Simulator");
			frame.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0,3,0,3);
			
			//GUI related to GetTemperature
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("GetTemperature"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createGetTemperaturePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtonGetTemperature = createSendButton("GetTemperature");
			frame.add(sendButtonGetTemperature, c);
			
			//GUI related to GetDistance
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("GetDistance"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createGetDistancePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtonGetDistance = createSendButton("GetDistance");
			frame.add(sendButtonGetDistance, c);
			
			//GUI related to GetLight
			c.gridy = 0;
	 		c.gridx = 2;
			frame.add(createLabel("GetLight"), c);
			
			c.gridy = 1;
	 		c.gridx = 2;
			frame.add(createGetLightPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 2;
	 		sendButtonGetLight = createSendButton("GetLight");
			frame.add(sendButtonGetLight, c);
			
			//GUI related to subscribeMotion
			c.gridy = 0;
	 		c.gridx = 3;
			frame.add(createLabel("subscribeMotion"), c);
			
			c.gridy = 1;
	 		c.gridx = 3;
			frame.add(createsubscribeMotionPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 3;
	 		sendButtonsubscribeMotion = createSendButton("subscribeMotion");
			frame.add(sendButtonsubscribeMotion, c);
			
			//GUI related to unsubscribeMotion
			c.gridy = 0;
	 		c.gridx = 4;
			frame.add(createLabel("unsubscribeMotion"), c);
			
			c.gridy = 1;
	 		c.gridx = 4;
			frame.add(createunsubscribeMotionPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 4;
	 		sendButtonunsubscribeMotion = createSendButton("unsubscribeMotion");
			frame.add(sendButtonunsubscribeMotion, c);
			
			//GUI related to subscribeLightChange
			c.gridy = 0;
	 		c.gridx = 5;
			frame.add(createLabel("subscribeLightChange"), c);
			
			c.gridy = 1;
	 		c.gridx = 5;
			frame.add(createsubscribeLightChangePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 5;
	 		sendButtonsubscribeLightChange = createSendButton("subscribeLightChange");
			frame.add(sendButtonsubscribeLightChange, c);
			
			//GUI related to unsubscribeLightChange
			c.gridy = 0;
	 		c.gridx = 6;
			frame.add(createLabel("unsubscribeLightChange"), c);
			
			c.gridy = 1;
	 		c.gridx = 6;
			frame.add(createunsubscribeLightChangePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 6;
	 		sendButtonunsubscribeLightChange = createSendButton("unsubscribeLightChange");
			frame.add(sendButtonunsubscribeLightChange, c);
			
			//GUI related to subscribeTemperatureChange
			c.gridy = 0;
	 		c.gridx = 7;
			frame.add(createLabel("subscribeTemperatureChange"), c);
			
			c.gridy = 1;
	 		c.gridx = 7;
			frame.add(createsubscribeTemperatureChangePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 7;
	 		sendButtonsubscribeTemperatureChange = createSendButton("subscribeTemperatureChange");
			frame.add(sendButtonsubscribeTemperatureChange, c);
			
			//GUI related to unsubscribeTemperatureChange
			c.gridy = 0;
	 		c.gridx = 8;
			frame.add(createLabel("unsubscribeTemperatureChange"), c);
			
			c.gridy = 1;
	 		c.gridx = 8;
			frame.add(createunsubscribeTemperatureChangePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 8;
	 		sendButtonunsubscribeTemperatureChange = createSendButton("unsubscribeTemperatureChange");
			frame.add(sendButtonunsubscribeTemperatureChange, c);
			
			//GUI related to subscribeRawData
			c.gridy = 0;
	 		c.gridx = 9;
			frame.add(createLabel("subscribeRawData"), c);
			
			c.gridy = 1;
	 		c.gridx = 9;
			frame.add(createsubscribeRawDataPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 9;
	 		sendButtonsubscribeRawData = createSendButton("subscribeRawData");
			frame.add(sendButtonsubscribeRawData, c);
			
			//GUI related to getRawData
			c.gridy = 0;
	 		c.gridx = 10;
			frame.add(createLabel("getRawData"), c);
			
			c.gridy = 1;
	 		c.gridx = 10;
			frame.add(creategetRawDataPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 10;
	 		sendButtongetRawData = createSendButton("getRawData");
			frame.add(sendButtongetRawData, c);
			
			//GUI related to ping
			c.gridy = 0;
	 		c.gridx = 11;
			frame.add(createLabel("ping"), c);
			
			c.gridy = 1;
	 		c.gridx = 11;
			frame.add(createpingPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 11;
	 		sendButtonping = createSendButton("ping");
			frame.add(sendButtonping, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 12;
			frame.add(createJTextPane(), c);
			
			c.gridy = 4;
			frame.add(clearButton, c);
			
			c.gridy = 5;
			frame.add(logOwnEventsButton, c);
			
			frame.pack();
			clearButton.addActionListener(_this);
			logOwnEventsButton.addActionListener(_this);
			frame.setVisible(true);
		}
	}
	
	public static JLabel createLabel(String name){
		return new JLabel(name);
	}
	
	public static JButton createSendButton(String name){
		return new JButton("send");
	}
	
	public static JPanel createGetTemperaturePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createGetDistancePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createGetLightPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createsubscribeMotionPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createunsubscribeMotionPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createsubscribeLightChangePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createunsubscribeLightChangePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createsubscribeTemperatureChangePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createunsubscribeTemperatureChangePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createsubscribeRawDataPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelinterval = new JLabel();
		labelinterval.setText("interval");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelinterval, c);
 		fieldsubscribeRawData_interval = new JTextField();
		fieldsubscribeRawData_interval.setText("interval");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldsubscribeRawData_interval, c);
			
		return panel;	
	}
	
	public static JPanel creategetRawDataPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createpingPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	
		
	public static JScrollPane createJTextPane(){
		screen = new JTextPane();
        screen.setFocusable(false);
        screen.setEditable(false);
        screen.setAutoscrolls(true);
  
  		JScrollPane editorScrollPane = new JScrollPane(screen);
		editorScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(480, 240));
		editorScrollPane.setMinimumSize(new Dimension(320, 160));
        
        StyledDocument doc = screen.getStyledDocument();
        Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
            
        Random rnd = new Random();
		Style receiveTemperatureValueStyle = doc.addStyle("receiveTemperatureValueStyle", def);
        StyleConstants.setForeground(receiveTemperatureValueStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveDistanceValueStyle = doc.addStyle("receiveDistanceValueStyle", def);
        StyleConstants.setForeground(receiveDistanceValueStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveLightValueStyle = doc.addStyle("receiveLightValueStyle", def);
        StyleConstants.setForeground(receiveLightValueStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveapproachingMotionStyle = doc.addStyle("receiveapproachingMotionStyle", def);
        StyleConstants.setForeground(receiveapproachingMotionStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveleavingMotionStyle = doc.addStyle("receiveleavingMotionStyle", def);
        StyleConstants.setForeground(receiveleavingMotionStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivelightONStyle = doc.addStyle("receivelightONStyle", def);
        StyleConstants.setForeground(receivelightONStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivelightOFFStyle = doc.addStyle("receivelightOFFStyle", def);
        StyleConstants.setForeground(receivelightOFFStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivetemperatureIncreaseStyle = doc.addStyle("receivetemperatureIncreaseStyle", def);
        StyleConstants.setForeground(receivetemperatureIncreaseStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivetemperatureDecreaseStyle = doc.addStyle("receivetemperatureDecreaseStyle", def);
        StyleConstants.setForeground(receivetemperatureDecreaseStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiverawDataStyle = doc.addStyle("receiverawDataStyle", def);
        StyleConstants.setForeground(receiverawDataStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivepongStyle = doc.addStyle("receivepongStyle", def);
        StyleConstants.setForeground(receivepongStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clearButton){
			screen.setText("");
		} else if (ae.getSource() == logOwnEventsButton) {
			if (logOwnEventsButton.getText().equals("Log Own Events (Click to Activate)")){
				logOwnEventsButton.setText("Log Own Events (Click to De-activate)");
				handler.register(handler);
			} else {
				logOwnEventsButton.setText("Log Own Events (Click to Activate)");
				handler.unregister(handler);				
			}
		}
	}     
}