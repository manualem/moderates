package org.sintef.moderates.sim;

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
	
	//Attributes related to displayText
	public static JButton sendButtondisplayText;
	public static JTextField fielddisplayText_line;
	public static JTextField fielddisplayText_msg;
		
	//Attributes related to clearText
	public static JButton sendButtonclearText;
		
	//Attributes related to readAllAnalog
	public static JButton sendButtonreadAllAnalog;
		
	//Attributes related to readAnalog
	public static JButton sendButtonreadAnalog;
	public static JTextField fieldreadAnalog_pin;
		
	//Attributes related to setDigital
	public static JButton sendButtonsetDigital;
	public static JTextField fieldsetDigital_pin;
	public static JTextField fieldsetDigital_direction;
		
	//Attributes related to setValue
	public static JButton sendButtonsetValue;
	public static JTextField fieldsetValue_pin;
	public static JTextField fieldsetValue_val;
		
	//Attributes related to getValue
	public static JButton sendButtongetValue;
	public static JTextField fieldgetValue_pin;
		
	//Attributes related to ping
	public static JButton sendButtonping;
		

	public static void print(String id, String data){
		try {
        	StyledDocument doc = screen.getStyledDocument();
            doc.insertString(doc.getLength(), formatForPrint(data), doc.getStyle("receive"+id+"Style"));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
	}
		
	public static void addListener(ActionListener l){
		sendButtondisplayText.addActionListener(l);
		sendButtonclearText.addActionListener(l);
		sendButtonreadAllAnalog.addActionListener(l);
		sendButtonreadAnalog.addActionListener(l);
		sendButtonsetDigital.addActionListener(l);
		sendButtonsetValue.addActionListener(l);
		sendButtongetValue.addActionListener(l);
		sendButtonping.addActionListener(l);
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
			
			//GUI related to displayText
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("displayText"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createdisplayTextPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtondisplayText = createSendButton("displayText");
			frame.add(sendButtondisplayText, c);
			
			//GUI related to clearText
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("clearText"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createclearTextPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtonclearText = createSendButton("clearText");
			frame.add(sendButtonclearText, c);
			
			//GUI related to readAllAnalog
			c.gridy = 0;
	 		c.gridx = 2;
			frame.add(createLabel("readAllAnalog"), c);
			
			c.gridy = 1;
	 		c.gridx = 2;
			frame.add(createreadAllAnalogPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 2;
	 		sendButtonreadAllAnalog = createSendButton("readAllAnalog");
			frame.add(sendButtonreadAllAnalog, c);
			
			//GUI related to readAnalog
			c.gridy = 0;
	 		c.gridx = 3;
			frame.add(createLabel("readAnalog"), c);
			
			c.gridy = 1;
	 		c.gridx = 3;
			frame.add(createreadAnalogPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 3;
	 		sendButtonreadAnalog = createSendButton("readAnalog");
			frame.add(sendButtonreadAnalog, c);
			
			//GUI related to setDigital
			c.gridy = 0;
	 		c.gridx = 4;
			frame.add(createLabel("setDigital"), c);
			
			c.gridy = 1;
	 		c.gridx = 4;
			frame.add(createsetDigitalPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 4;
	 		sendButtonsetDigital = createSendButton("setDigital");
			frame.add(sendButtonsetDigital, c);
			
			//GUI related to setValue
			c.gridy = 0;
	 		c.gridx = 5;
			frame.add(createLabel("setValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 5;
			frame.add(createsetValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 5;
	 		sendButtonsetValue = createSendButton("setValue");
			frame.add(sendButtonsetValue, c);
			
			//GUI related to getValue
			c.gridy = 0;
	 		c.gridx = 6;
			frame.add(createLabel("getValue"), c);
			
			c.gridy = 1;
	 		c.gridx = 6;
			frame.add(creategetValuePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 6;
	 		sendButtongetValue = createSendButton("getValue");
			frame.add(sendButtongetValue, c);
			
			//GUI related to ping
			c.gridy = 0;
	 		c.gridx = 7;
			frame.add(createLabel("ping"), c);
			
			c.gridy = 1;
	 		c.gridx = 7;
			frame.add(createpingPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 7;
	 		sendButtonping = createSendButton("ping");
			frame.add(sendButtonping, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 8;
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
	
	public static JPanel createdisplayTextPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelline = new JLabel();
		labelline.setText("line");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelline, c);
 		
 		fielddisplayText_line = new JTextField();
		fielddisplayText_line.setText("line");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fielddisplayText_line, c);
 		

		JLabel labelmsg = new JLabel();
		labelmsg.setText("msg");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelmsg, c);
 		
 		fielddisplayText_msg = new JTextField();
		fielddisplayText_msg.setText("msg");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fielddisplayText_msg, c);
 		

			
		return panel;	
	}
	
	public static JPanel createclearTextPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createreadAllAnalogPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createreadAnalogPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldreadAnalog_pin = new JTextField();
		fieldreadAnalog_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldreadAnalog_pin, c);
 		

			
		return panel;	
	}
	
	public static JPanel createsetDigitalPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldsetDigital_pin = new JTextField();
		fieldsetDigital_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldsetDigital_pin, c);
 		

		JLabel labeldirection = new JLabel();
		labeldirection.setText("direction");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labeldirection, c);
 		
 		fieldsetDigital_direction = new JTextField();
		fieldsetDigital_direction.setText("direction");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldsetDigital_direction, c);
 		

			
		return panel;	
	}
	
	public static JPanel createsetValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldsetValue_pin = new JTextField();
		fieldsetValue_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldsetValue_pin, c);
 		

		JLabel labelval = new JLabel();
		labelval.setText("val");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelval, c);
 		
 		fieldsetValue_val = new JTextField();
		fieldsetValue_val.setText("val");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldsetValue_val, c);
 		

			
		return panel;	
	}
	
	public static JPanel creategetValuePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldgetValue_pin = new JTextField();
		fieldgetValue_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldgetValue_pin, c);
 		

			
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
		Style receiveanalogValueStyle = doc.addStyle("receiveanalogValueStyle", def);
        StyleConstants.setForeground(receiveanalogValueStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivedigitalValueStyle = doc.addStyle("receivedigitalValueStyle", def);
        StyleConstants.setForeground(receivedigitalValueStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivepongStyle = doc.addStyle("receivepongStyle", def);
        StyleConstants.setForeground(receivepongStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }
}