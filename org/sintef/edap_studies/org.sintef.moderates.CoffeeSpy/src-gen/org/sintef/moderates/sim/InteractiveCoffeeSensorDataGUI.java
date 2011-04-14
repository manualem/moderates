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

public class InteractiveCoffeeSensorDataGUI implements ActionListener {
	
	private static boolean init = false;
	
	private static final InteractiveCoffeeSensorDataGUI _this = new InteractiveCoffeeSensorDataGUI();
	
	public static ProtocolHandler handler;
	
	private static JFrame frame;
	private static JTextPane screen;
	private static JButton clearButton;
	private static JButton logOwnEventsButton;
	
	//Attributes related to TemperatureValue
	public static JButton sendButtonTemperatureValue;
	public static JTextField fieldTemperatureValue_v;
		
	//Attributes related to DistanceValue
	public static JButton sendButtonDistanceValue;
	public static JTextField fieldDistanceValue_v;
		
	//Attributes related to LightValue
	public static JButton sendButtonLightValue;
	public static JTextField fieldLightValue_v;
		
	//Attributes related to approachingMotion
	public static JButton sendButtonapproachingMotion;
		
	//Attributes related to leavingMotion
	public static JButton sendButtonleavingMotion;
	public static JTextField fieldleavingMotion_minimalDist;
		
	//Attributes related to lightON
	public static JButton sendButtonlightON;
		
	//Attributes related to lightOFF
	public static JButton sendButtonlightOFF;
		
	//Attributes related to temperatureIncrease
	public static JButton sendButtontemperatureIncrease;
	public static JTextField fieldtemperatureIncrease_before;
	public static JTextField fieldtemperatureIncrease_current;
		
	//Attributes related to temperatureDecrease
	public static JButton sendButtontemperatureDecrease;
	public static JTextField fieldtemperatureDecrease_before;
	public static JTextField fieldtemperatureDecrease_current;
		
	//Attributes related to rawData
	public static JButton sendButtonrawData;
	public static JTextField fieldrawData_temp;
	public static JTextField fieldrawData_dist;
	public static JTextField fieldrawData_light;
		
	//Attributes related to pong
	public static JButton sendButtonpong;
		

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
		sendButtonTemperatureValue.addActionListener(l);
		sendButtonDistanceValue.addActionListener(l);
		sendButtonLightValue.addActionListener(l);
		sendButtonapproachingMotion.addActionListener(l);
		sendButtonleavingMotion.addActionListener(l);
		sendButtonlightON.addActionListener(l);
		sendButtonlightOFF.addActionListener(l);
		sendButtontemperatureIncrease.addActionListener(l);
		sendButtontemperatureDecrease.addActionListener(l);
		sendButtonrawData.addActionListener(l);
		sendButtonpong.addActionListener(l);
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
			
			//GUI related to TemperatureValue
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("TemperatureValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createTemperatureValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtonTemperatureValue = createSendButton("TemperatureValue");
			frame.add(sendButtonTemperatureValue, c);
			
			//GUI related to DistanceValue
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("DistanceValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createDistanceValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtonDistanceValue = createSendButton("DistanceValue");
			frame.add(sendButtonDistanceValue, c);
			
			//GUI related to LightValue
			c.gridy = 0;
	 		c.gridx = 2;
			frame.add(createLabel("LightValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 2;
			frame.add(createLightValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 2;
	 		sendButtonLightValue = createSendButton("LightValue");
			frame.add(sendButtonLightValue, c);
			
			//GUI related to approachingMotion
			c.gridy = 0;
	 		c.gridx = 3;
			frame.add(createLabel("approachingMotion"), c);
			
			c.gridy = 1;
	 		c.gridx = 3;
			frame.add(createapproachingMotionPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 3;
	 		sendButtonapproachingMotion = createSendButton("approachingMotion");
			frame.add(sendButtonapproachingMotion, c);
			
			//GUI related to leavingMotion
			c.gridy = 0;
	 		c.gridx = 4;
			frame.add(createLabel("leavingMotion"), c);
			
			c.gridy = 1;
	 		c.gridx = 4;
			frame.add(createleavingMotionPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 4;
	 		sendButtonleavingMotion = createSendButton("leavingMotion");
			frame.add(sendButtonleavingMotion, c);
			
			//GUI related to lightON
			c.gridy = 0;
	 		c.gridx = 5;
			frame.add(createLabel("lightON"), c);
			
			c.gridy = 1;
	 		c.gridx = 5;
			frame.add(createlightONPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 5;
	 		sendButtonlightON = createSendButton("lightON");
			frame.add(sendButtonlightON, c);
			
			//GUI related to lightOFF
			c.gridy = 0;
	 		c.gridx = 6;
			frame.add(createLabel("lightOFF"), c);
			
			c.gridy = 1;
	 		c.gridx = 6;
			frame.add(createlightOFFPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 6;
	 		sendButtonlightOFF = createSendButton("lightOFF");
			frame.add(sendButtonlightOFF, c);
			
			//GUI related to temperatureIncrease
			c.gridy = 0;
	 		c.gridx = 7;
			frame.add(createLabel("temperatureIncrease"), c);
			
			c.gridy = 1;
	 		c.gridx = 7;
			frame.add(createtemperatureIncreasePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 7;
	 		sendButtontemperatureIncrease = createSendButton("temperatureIncrease");
			frame.add(sendButtontemperatureIncrease, c);
			
			//GUI related to temperatureDecrease
			c.gridy = 0;
	 		c.gridx = 8;
			frame.add(createLabel("temperatureDecrease"), c);
			
			c.gridy = 1;
	 		c.gridx = 8;
			frame.add(createtemperatureDecreasePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 8;
	 		sendButtontemperatureDecrease = createSendButton("temperatureDecrease");
			frame.add(sendButtontemperatureDecrease, c);
			
			//GUI related to rawData
			c.gridy = 0;
	 		c.gridx = 9;
			frame.add(createLabel("rawData"), c);
			
			c.gridy = 1;
	 		c.gridx = 9;
			frame.add(createrawDataPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 9;
	 		sendButtonrawData = createSendButton("rawData");
			frame.add(sendButtonrawData, c);
			
			//GUI related to pong
			c.gridy = 0;
	 		c.gridx = 10;
			frame.add(createLabel("pong"), c);
			
			c.gridy = 1;
	 		c.gridx = 10;
			frame.add(createpongPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 10;
	 		sendButtonpong = createSendButton("pong");
			frame.add(sendButtonpong, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 11;
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
	
	public static JPanel createTemperatureValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelv = new JLabel();
		labelv.setText("v");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelv, c);
 		fieldTemperatureValue_v = new JTextField();
		fieldTemperatureValue_v.setText("v");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldTemperatureValue_v, c);
			
		return panel;	
	}
	
	public static JPanel createDistanceValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelv = new JLabel();
		labelv.setText("v");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelv, c);
 		fieldDistanceValue_v = new JTextField();
		fieldDistanceValue_v.setText("v");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldDistanceValue_v, c);
			
		return panel;	
	}
	
	public static JPanel createLightValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelv = new JLabel();
		labelv.setText("v");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelv, c);
 		fieldLightValue_v = new JTextField();
		fieldLightValue_v.setText("v");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldLightValue_v, c);
			
		return panel;	
	}
	
	public static JPanel createapproachingMotionPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createleavingMotionPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelminimalDist = new JLabel();
		labelminimalDist.setText("minimalDist");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelminimalDist, c);
 		fieldleavingMotion_minimalDist = new JTextField();
		fieldleavingMotion_minimalDist.setText("minimalDist");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldleavingMotion_minimalDist, c);
			
		return panel;	
	}
	
	public static JPanel createlightONPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createlightOFFPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createtemperatureIncreasePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelbefore = new JLabel();
		labelbefore.setText("before");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelbefore, c);
 		fieldtemperatureIncrease_before = new JTextField();
		fieldtemperatureIncrease_before.setText("before");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldtemperatureIncrease_before, c);
		JLabel labelcurrent = new JLabel();
		labelcurrent.setText("current");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelcurrent, c);
 		fieldtemperatureIncrease_current = new JTextField();
		fieldtemperatureIncrease_current.setText("current");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldtemperatureIncrease_current, c);
			
		return panel;	
	}
	
	public static JPanel createtemperatureDecreasePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelbefore = new JLabel();
		labelbefore.setText("before");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelbefore, c);
 		fieldtemperatureDecrease_before = new JTextField();
		fieldtemperatureDecrease_before.setText("before");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldtemperatureDecrease_before, c);
		JLabel labelcurrent = new JLabel();
		labelcurrent.setText("current");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelcurrent, c);
 		fieldtemperatureDecrease_current = new JTextField();
		fieldtemperatureDecrease_current.setText("current");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldtemperatureDecrease_current, c);
			
		return panel;	
	}
	
	public static JPanel createrawDataPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labeltemp = new JLabel();
		labeltemp.setText("temp");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labeltemp, c);
 		fieldrawData_temp = new JTextField();
		fieldrawData_temp.setText("temp");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldrawData_temp, c);
		JLabel labeldist = new JLabel();
		labeldist.setText("dist");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labeldist, c);
 		fieldrawData_dist = new JTextField();
		fieldrawData_dist.setText("dist");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldrawData_dist, c);
		JLabel labellight = new JLabel();
		labellight.setText("light");
 		c.gridx = 0;
		c.gridy = 2;
 		panel.add(labellight, c);
 		fieldrawData_light = new JTextField();
		fieldrawData_light.setText("light");
 		c.gridx = 1;
		c.gridy = 2;
 		panel.add(fieldrawData_light, c);
			
		return panel;	
	}
	
	public static JPanel createpongPanel(){

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
		Style receiveGetTemperatureStyle = doc.addStyle("receiveGetTemperatureStyle", def);
        StyleConstants.setForeground(receiveGetTemperatureStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveGetDistanceStyle = doc.addStyle("receiveGetDistanceStyle", def);
        StyleConstants.setForeground(receiveGetDistanceStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveGetLightStyle = doc.addStyle("receiveGetLightStyle", def);
        StyleConstants.setForeground(receiveGetLightStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivesubscribeMotionStyle = doc.addStyle("receivesubscribeMotionStyle", def);
        StyleConstants.setForeground(receivesubscribeMotionStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveunsubscribeMotionStyle = doc.addStyle("receiveunsubscribeMotionStyle", def);
        StyleConstants.setForeground(receiveunsubscribeMotionStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivesubscribeLightChangeStyle = doc.addStyle("receivesubscribeLightChangeStyle", def);
        StyleConstants.setForeground(receivesubscribeLightChangeStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveunsubscribeLightChangeStyle = doc.addStyle("receiveunsubscribeLightChangeStyle", def);
        StyleConstants.setForeground(receiveunsubscribeLightChangeStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivesubscribeTemperatureChangeStyle = doc.addStyle("receivesubscribeTemperatureChangeStyle", def);
        StyleConstants.setForeground(receivesubscribeTemperatureChangeStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveunsubscribeTemperatureChangeStyle = doc.addStyle("receiveunsubscribeTemperatureChangeStyle", def);
        StyleConstants.setForeground(receiveunsubscribeTemperatureChangeStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivesubscribeRawDataStyle = doc.addStyle("receivesubscribeRawDataStyle", def);
        StyleConstants.setForeground(receivesubscribeRawDataStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivegetRawDataStyle = doc.addStyle("receivegetRawDataStyle", def);
        StyleConstants.setForeground(receivegetRawDataStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivepingStyle = doc.addStyle("receivepingStyle", def);
        StyleConstants.setForeground(receivepingStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
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