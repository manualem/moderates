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

public class InteractiveRemoteArduinoDataGUI2 {
	
	private static boolean init = false;
	
	private static JFrame frame;
	private static JTextPane screen;
	
	//Attributes related to pinMode
	public static JButton sendButtonpinMode;
	public static JTextField fieldpinMode_pin;
	public static JTextField fieldpinMode_mode;
		
	//Attributes related to digitalRead
	public static JButton sendButtondigitalRead;
	public static JTextField fielddigitalRead_pin;
		
	//Attributes related to digitalWrite
	public static JButton sendButtondigitalWrite;
	public static JTextField fielddigitalWrite_pin;
	public static JTextField fielddigitalWrite_value;
		
	//Attributes related to analogReference
	public static JButton sendButtonanalogReference;
	public static JTextField fieldanalogReference_type;
		
	//Attributes related to analogRead
	public static JButton sendButtonanalogRead;
	public static JTextField fieldanalogRead_pin;
		
	//Attributes related to analogWrite
	public static JButton sendButtonanalogWrite;
	public static JTextField fieldanalogWrite_pin;
	public static JTextField fieldanalogWrite_value;
		
	//Attributes related to ping
	public static JButton sendButtonping;
		
	//Attributes related to attachInterrupt
	public static JButton sendButtonattachInterrupt;
	public static JTextField fieldattachInterrupt_interrupt;
	public static JTextField fieldattachInterrupt_mode;
		
	//Attributes related to detachInterrupt
	public static JButton sendButtondetachInterrupt;
	public static JTextField fielddetachInterrupt_interrupt;
		

	public static void print(String id, String data){
		try {
        	StyledDocument doc = screen.getStyledDocument();
            doc.insertString(doc.getLength(), formatForPrint(data), doc.getStyle("receive"+id+"Style"));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
	}
		
	public static void addListener(ActionListener l){
		sendButtonpinMode.addActionListener(l);
		sendButtondigitalRead.addActionListener(l);
		sendButtondigitalWrite.addActionListener(l);
		sendButtonanalogReference.addActionListener(l);
		sendButtonanalogRead.addActionListener(l);
		sendButtonanalogWrite.addActionListener(l);
		sendButtonping.addActionListener(l);
		sendButtonattachInterrupt.addActionListener(l);
		sendButtondetachInterrupt.addActionListener(l);
	}
	
	public static void init(){
		if (!init) {
			init = true;
		
			frame = new JFrame("Interactive RemoteArduino Data Simulator");
			frame.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0,3,0,3);
			
			//GUI related to pinMode
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("pinMode"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createpinModePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtonpinMode = createSendButton("pinMode");
			frame.add(sendButtonpinMode, c);
			
			//GUI related to digitalRead
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("digitalRead"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createdigitalReadPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtondigitalRead = createSendButton("digitalRead");
			frame.add(sendButtondigitalRead, c);
			
			//GUI related to digitalWrite
			c.gridy = 0;
	 		c.gridx = 2;
			frame.add(createLabel("digitalWrite"), c);
			
			c.gridy = 1;
	 		c.gridx = 2;
			frame.add(createdigitalWritePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 2;
	 		sendButtondigitalWrite = createSendButton("digitalWrite");
			frame.add(sendButtondigitalWrite, c);
			
			//GUI related to analogReference
			c.gridy = 0;
	 		c.gridx = 3;
			frame.add(createLabel("analogReference"), c);
			
			c.gridy = 1;
	 		c.gridx = 3;
			frame.add(createanalogReferencePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 3;
	 		sendButtonanalogReference = createSendButton("analogReference");
			frame.add(sendButtonanalogReference, c);
			
			//GUI related to analogRead
			c.gridy = 0;
	 		c.gridx = 4;
			frame.add(createLabel("analogRead"), c);
			
			c.gridy = 1;
	 		c.gridx = 4;
			frame.add(createanalogReadPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 4;
	 		sendButtonanalogRead = createSendButton("analogRead");
			frame.add(sendButtonanalogRead, c);
			
			//GUI related to analogWrite
			c.gridy = 0;
	 		c.gridx = 5;
			frame.add(createLabel("analogWrite"), c);
			
			c.gridy = 1;
	 		c.gridx = 5;
			frame.add(createanalogWritePanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 5;
	 		sendButtonanalogWrite = createSendButton("analogWrite");
			frame.add(sendButtonanalogWrite, c);
			
			//GUI related to ping
			c.gridy = 0;
	 		c.gridx = 6;
			frame.add(createLabel("ping"), c);
			
			c.gridy = 1;
	 		c.gridx = 6;
			frame.add(createpingPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 6;
	 		sendButtonping = createSendButton("ping");
			frame.add(sendButtonping, c);
			
			//GUI related to attachInterrupt
			c.gridy = 0;
	 		c.gridx = 7;
			frame.add(createLabel("attachInterrupt"), c);
			
			c.gridy = 1;
	 		c.gridx = 7;
			frame.add(createattachInterruptPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 7;
	 		sendButtonattachInterrupt = createSendButton("attachInterrupt");
			frame.add(sendButtonattachInterrupt, c);
			
			//GUI related to detachInterrupt
			c.gridy = 0;
	 		c.gridx = 8;
			frame.add(createLabel("detachInterrupt"), c);
			
			c.gridy = 1;
	 		c.gridx = 8;
			frame.add(createdetachInterruptPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 8;
	 		sendButtondetachInterrupt = createSendButton("detachInterrupt");
			frame.add(sendButtondetachInterrupt, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 9;
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
	
	public static JPanel createpinModePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldpinMode_pin = new JTextField();
		fieldpinMode_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldpinMode_pin, c);
 		

		JLabel labelmode = new JLabel();
		labelmode.setText("mode");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelmode, c);
 		
 		fieldpinMode_mode = new JTextField();
		fieldpinMode_mode.setText("mode");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldpinMode_mode, c);
 		

			
		return panel;	
	}
	
	public static JPanel createdigitalReadPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fielddigitalRead_pin = new JTextField();
		fielddigitalRead_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fielddigitalRead_pin, c);
 		

			
		return panel;	
	}
	
	public static JPanel createdigitalWritePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fielddigitalWrite_pin = new JTextField();
		fielddigitalWrite_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fielddigitalWrite_pin, c);
 		

		JLabel labelvalue = new JLabel();
		labelvalue.setText("value");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelvalue, c);
 		
 		fielddigitalWrite_value = new JTextField();
		fielddigitalWrite_value.setText("value");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fielddigitalWrite_value, c);
 		

			
		return panel;	
	}
	
	public static JPanel createanalogReferencePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labeltype = new JLabel();
		labeltype.setText("type");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labeltype, c);
 		
 		fieldanalogReference_type = new JTextField();
		fieldanalogReference_type.setText("type");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldanalogReference_type, c);
 		

			
		return panel;	
	}
	
	public static JPanel createanalogReadPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldanalogRead_pin = new JTextField();
		fieldanalogRead_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldanalogRead_pin, c);
 		

			
		return panel;	
	}
	
	public static JPanel createanalogWritePanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelpin = new JLabel();
		labelpin.setText("pin");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelpin, c);
 		
 		fieldanalogWrite_pin = new JTextField();
		fieldanalogWrite_pin.setText("pin");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldanalogWrite_pin, c);
 		

		JLabel labelvalue = new JLabel();
		labelvalue.setText("value");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelvalue, c);
 		
 		fieldanalogWrite_value = new JTextField();
		fieldanalogWrite_value.setText("value");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldanalogWrite_value, c);
 		

			
		return panel;	
	}
	
	public static JPanel createpingPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createattachInterruptPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelinterrupt = new JLabel();
		labelinterrupt.setText("interrupt");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelinterrupt, c);
 		
 		fieldattachInterrupt_interrupt = new JTextField();
		fieldattachInterrupt_interrupt.setText("interrupt");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldattachInterrupt_interrupt, c);
 		

		JLabel labelmode = new JLabel();
		labelmode.setText("mode");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelmode, c);
 		
 		fieldattachInterrupt_mode = new JTextField();
		fieldattachInterrupt_mode.setText("mode");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldattachInterrupt_mode, c);
 		

			
		return panel;	
	}
	
	public static JPanel createdetachInterruptPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelinterrupt = new JLabel();
		labelinterrupt.setText("interrupt");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelinterrupt, c);
 		
 		fielddetachInterrupt_interrupt = new JTextField();
		fielddetachInterrupt_interrupt.setText("interrupt");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fielddetachInterrupt_interrupt, c);
 		

			
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
		Style receivedigitalReadResultStyle = doc.addStyle("receivedigitalReadResultStyle", def);
        StyleConstants.setForeground(receivedigitalReadResultStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receiveanalogReadResultStyle = doc.addStyle("receiveanalogReadResultStyle", def);
        StyleConstants.setForeground(receiveanalogReadResultStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivepongStyle = doc.addStyle("receivepongStyle", def);
        StyleConstants.setForeground(receivepongStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receiveinterruptNotificationStyle = doc.addStyle("receiveinterruptNotificationStyle", def);
        StyleConstants.setForeground(receiveinterruptNotificationStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }
}