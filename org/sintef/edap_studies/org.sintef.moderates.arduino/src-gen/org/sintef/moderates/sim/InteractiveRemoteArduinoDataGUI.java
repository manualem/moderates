package org.sintef.moderates.sim;

import org.sintef.moderates.observer.RemoteArduinoObserver;
import org.sintef.moderates.*;

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

public class InteractiveRemoteArduinoDataGUI implements ActionListener {
	
	private static boolean init = false;
	
	private static final InteractiveRemoteArduinoDataGUI _this = new InteractiveRemoteArduinoDataGUI();
	
	public static InteractiveRemoteArduinoDataController handler;
	
	private static JFrame frame;
	private static JTextPane screen;
	private static JButton clearButton;
	private static JButton logOwnEventsButton;
	
	//Attributes related to digitalReadResult
	public static JButton sendButtondigitalReadResult;
	public static JComboBox fielddigitalReadResult_value;
		
	//Attributes related to analogReadResult
	public static JButton sendButtonanalogReadResult;
	public static JTextField fieldanalogReadResult_value;
		
	//Attributes related to pong
	public static JButton sendButtonpong;
		
	//Attributes related to interruptNotification
	public static JButton sendButtoninterruptNotification;
	public static JComboBox fieldinterruptNotification_interrupt;
		

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
		sendButtondigitalReadResult.addActionListener(l);
		sendButtonanalogReadResult.addActionListener(l);
		sendButtonpong.addActionListener(l);
		sendButtoninterruptNotification.addActionListener(l);
	}
	
	public static void init(){
		if (!init) {
			init = true;
			
			clearButton = new JButton("Clear Console");
			logOwnEventsButton = new JButton("Log Own Events (Click to Activate)");
			frame = new JFrame("Interactive RemoteArduino Data Simulator");
			frame.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0,3,0,3);
			
			//GUI related to digitalReadResult
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("digitalReadResult"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createdigitalReadResultPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtondigitalReadResult = createSendButton("digitalReadResult");
			frame.add(sendButtondigitalReadResult, c);
			
			//GUI related to analogReadResult
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("analogReadResult"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createanalogReadResultPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtonanalogReadResult = createSendButton("analogReadResult");
			frame.add(sendButtonanalogReadResult, c);
			
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
			
			//GUI related to interruptNotification
			c.gridy = 0;
	 		c.gridx = 3;
			frame.add(createLabel("interruptNotification"), c);
			
			c.gridy = 1;
	 		c.gridx = 3;
			frame.add(createinterruptNotificationPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 3;
	 		sendButtoninterruptNotification = createSendButton("interruptNotification");
			frame.add(sendButtoninterruptNotification, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 4;
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
	
	public static JPanel createdigitalReadResultPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelvalue = new JLabel();
		labelvalue.setText("value");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelvalue, c);
		DigitalState[] valuesdigitalReadResult_value = {DigitalState.LOW, DigitalState.HIGH};
		fielddigitalReadResult_value = new JComboBox(valuesdigitalReadResult_value);		
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fielddigitalReadResult_value, c);
			
		return panel;	
	}
	
	public static JPanel createanalogReadResultPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelvalue = new JLabel();
		labelvalue.setText("value");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelvalue, c);
 		fieldanalogReadResult_value = new JTextField();
		fieldanalogReadResult_value.setText("value");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldanalogReadResult_value, c);
			
		return panel;	
	}
	
	public static JPanel createpongPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createinterruptNotificationPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelinterrupt = new JLabel();
		labelinterrupt.setText("interrupt");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelinterrupt, c);
		InterruptPin[] valuesinterruptNotification_interrupt = {InterruptPin.PIN_2_INT0, InterruptPin.PIN_3_INT1};
		fieldinterruptNotification_interrupt = new JComboBox(valuesinterruptNotification_interrupt);		
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldinterruptNotification_interrupt, c);
			
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
		Style receivepinModeStyle = doc.addStyle("receivepinModeStyle", def);
        StyleConstants.setForeground(receivepinModeStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivedigitalReadStyle = doc.addStyle("receivedigitalReadStyle", def);
        StyleConstants.setForeground(receivedigitalReadStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivedigitalWriteStyle = doc.addStyle("receivedigitalWriteStyle", def);
        StyleConstants.setForeground(receivedigitalWriteStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveanalogReferenceStyle = doc.addStyle("receiveanalogReferenceStyle", def);
        StyleConstants.setForeground(receiveanalogReferenceStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveanalogReadStyle = doc.addStyle("receiveanalogReadStyle", def);
        StyleConstants.setForeground(receiveanalogReadStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveanalogWriteStyle = doc.addStyle("receiveanalogWriteStyle", def);
        StyleConstants.setForeground(receiveanalogWriteStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivepingStyle = doc.addStyle("receivepingStyle", def);
        StyleConstants.setForeground(receivepingStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receiveattachInterruptStyle = doc.addStyle("receiveattachInterruptStyle", def);
        StyleConstants.setForeground(receiveattachInterruptStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
		Style receivedetachInterruptStyle = doc.addStyle("receivedetachInterruptStyle", def);
        StyleConstants.setForeground(receivedetachInterruptStyle, new Color(rnd.nextInt(176), rnd.nextInt(176), rnd.nextInt(176)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clearButton){
			screen.setText("");
		} /*else if (ae.getSource() == logOwnEventsButton) {
			if (logOwnEventsButton.getText().equals("Log Own Events (Click to Activate)")){
				logOwnEventsButton.setText("Log Own Events (Click to De-activate)");
				handler.register((RemoteArduinoObserver)handler);
			} else {
				logOwnEventsButton.setText("Log Own Events (Click to Activate)");
				handler.unregister((RemoteArduinoObserver)handler);				
			}
		}*/
	}     
}