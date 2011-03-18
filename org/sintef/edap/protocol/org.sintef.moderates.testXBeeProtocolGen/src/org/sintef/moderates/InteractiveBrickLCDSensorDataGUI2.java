package org.sintef.moderates;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
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

public class InteractiveBrickLCDSensorDataGUI2 {
	
	private static boolean init = false;
	
	private static JFrame frame;
	private static JTextPane screen;
	
	//Attributes related to analogValue
	public static JButton sendButtonanalogValue;
	public static JTextField fieldanalogValue_pin;
	public static JTextField fieldanalogValue_val;
		
	//Attributes related to digitalValue
	public static JButton sendButtondigitalValue;
	public static JTextField fielddigitalValue_pin;
	public static JTextField fielddigitalValue_val;
		
	//Attributes related to pong
	public static JButton sendButtonpong;
		

	public static void print(String id, String data){
		try {
        	StyledDocument doc = screen.getStyledDocument();
            doc.insertString(doc.getLength(), formatForPrint(data), doc.getStyle("receive"+id+"Style"));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
	}
		
	public static void addListener(ActionListener l){
		sendButtonanalogValue.addActionListener(l);
		sendButtondigitalValue.addActionListener(l);
		sendButtonpong.addActionListener(l);
	}
	
	public static void init(){
		if (!init) {
			init = true;
		
			frame = new JFrame("Interactive BrickLCDSensor Data Simulator");
			frame.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0,3,0,3);
			
			//GUI related to analogValue
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("analogValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createanalogValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtonanalogValue = createSendButton("analogValue");
			frame.add(sendButtonanalogValue, c);
			
			//GUI related to digitalValue
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("digitalValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createdigitalValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtondigitalValue = createSendButton("digitalValue");
			frame.add(sendButtondigitalValue, c);
			
			//GUI related to pong
			c.gridy = 0;
	 		c.gridx = 2;
			frame.add(createLabel("pong"), c);
			
			c.gridy = 1;
	 		c.gridx = 2;
			frame.add(createpongPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 2;
	 		sendButtonpong = createSendButton("pong");
			frame.add(sendButtonpong, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 3;
			frame.add(createJTextPane(), c);
			
			frame.pack();
			frame.setVisible(true);
		}
	}
	
	public static JLabel createLabel(String name){
		return new JLabel(name);
	}
	
	public static JButton createSendButton(String name){
		return new JButton("send");
	}
	
	public static JPanel createanalogValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldanalogValue_pin = new JTextField();
		fieldanalogValue_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldanalogValue_pin, c);
 		

		JLabel labelval = new JLabel();
		labelval.setText("val");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelval, c);
 		
 		fieldanalogValue_val = new JTextField();
		fieldanalogValue_val.setText("val");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldanalogValue_val, c);
 		

			
		return panel;	
	}
	
	public static JPanel createdigitalValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fielddigitalValue_pin = new JTextField();
		fielddigitalValue_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fielddigitalValue_pin, c);
 		

		JLabel labelval = new JLabel();
		labelval.setText("val");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelval, c);
 		
 		fielddigitalValue_val = new JTextField();
		fielddigitalValue_val.setText("val");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fielddigitalValue_val, c);
 		

			
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
		Style receivedisplayTextStyle = doc.addStyle("receivedisplayTextStyle", def);
        StyleConstants.setForeground(receivedisplayTextStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receiveclearTextStyle = doc.addStyle("receiveclearTextStyle", def);
        StyleConstants.setForeground(receiveclearTextStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivereadAllAnalogStyle = doc.addStyle("receivereadAllAnalogStyle", def);
        StyleConstants.setForeground(receivereadAllAnalogStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivereadAnalogStyle = doc.addStyle("receivereadAnalogStyle", def);
        StyleConstants.setForeground(receivereadAnalogStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivesetDigitalStyle = doc.addStyle("receivesetDigitalStyle", def);
        StyleConstants.setForeground(receivesetDigitalStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivesetValueStyle = doc.addStyle("receivesetValueStyle", def);
        StyleConstants.setForeground(receivesetValueStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivegetValueStyle = doc.addStyle("receivegetValueStyle", def);
        StyleConstants.setForeground(receivegetValueStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivepingStyle = doc.addStyle("receivepingStyle", def);
        StyleConstants.setForeground(receivepingStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }
}