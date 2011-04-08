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

public class InteractiveCurrentSensorDataGUI {
	
	private static boolean init = false;
	
	private static JFrame frame;
	private static JTextPane screen;
	
	//Attributes related to currentData
	public static JButton sendButtoncurrentData;
	public static JTextField fieldcurrentData_sensorMax;
	public static JTextField fieldcurrentData_current;
	public static JTextField fieldcurrentData_eff_current;
		
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
		sendButtoncurrentData.addActionListener(l);
		sendButtonpong.addActionListener(l);
	}
	
	public static void init(){
		if (!init) {
			init = true;
		
			frame = new JFrame("Interactive CurrentSensor Data Simulator");
			frame.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0,3,0,3);
			
			//GUI related to currentData
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("currentData"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createcurrentDataPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtoncurrentData = createSendButton("currentData");
			frame.add(sendButtoncurrentData, c);
			
			//GUI related to pong
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("pong"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createpongPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtonpong = createSendButton("pong");
			frame.add(sendButtonpong, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 2;
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
	
	public static JPanel createcurrentDataPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelsensorMax = new JLabel();
		labelsensorMax.setText("sensorMax");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labelsensorMax, c);
 		
 		fieldcurrentData_sensorMax = new JTextField();
		fieldcurrentData_sensorMax.setText("sensorMax");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldcurrentData_sensorMax, c);
 		

		JLabel labelcurrent = new JLabel();
		labelcurrent.setText("current");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labelcurrent, c);
 		
 		fieldcurrentData_current = new JTextField();
		fieldcurrentData_current.setText("current");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldcurrentData_current, c);
 		

		JLabel labeleff_current = new JLabel();
		labeleff_current.setText("eff_current");
 		c.gridx = 0;
		c.gridy = 2;
 		panel.add(labeleff_current, c);
 		
 		fieldcurrentData_eff_current = new JTextField();
		fieldcurrentData_eff_current.setText("eff_current");
 		c.gridx = 1;
		c.gridy = 2;
 		panel.add(fieldcurrentData_eff_current, c);
 		

			
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
		Style receivestartStyle = doc.addStyle("receivestartStyle", def);
        StyleConstants.setForeground(receivestartStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivestopStyle = doc.addStyle("receivestopStyle", def);
        StyleConstants.setForeground(receivestopStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivepingStyle = doc.addStyle("receivepingStyle", def);
        StyleConstants.setForeground(receivepingStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }
}