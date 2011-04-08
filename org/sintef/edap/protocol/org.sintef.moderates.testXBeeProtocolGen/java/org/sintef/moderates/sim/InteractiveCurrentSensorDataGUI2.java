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

public class InteractiveCurrentSensorDataGUI2 {
	
	private static boolean init = false;
	
	private static JFrame frame;
	private static JTextPane screen;
	
	//Attributes related to start
	public static JButton sendButtonstart;
		
	//Attributes related to stop
	public static JButton sendButtonstop;
		
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
		sendButtonstart.addActionListener(l);
		sendButtonstop.addActionListener(l);
		sendButtonping.addActionListener(l);
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
			
			//GUI related to start
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("start"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createstartPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtonstart = createSendButton("start");
			frame.add(sendButtonstart, c);
			
			//GUI related to stop
			c.gridy = 0;
	 		c.gridx = 1;
			frame.add(createLabel("stop"), c);
			
			c.gridy = 1;
	 		c.gridx = 1;
			frame.add(createstopPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 1;
	 		sendButtonstop = createSendButton("stop");
			frame.add(sendButtonstop, c);
			
			//GUI related to ping
			c.gridy = 0;
	 		c.gridx = 2;
			frame.add(createLabel("ping"), c);
			
			c.gridy = 1;
	 		c.gridx = 2;
			frame.add(createpingPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 2;
	 		sendButtonping = createSendButton("ping");
			frame.add(sendButtonping, c);
			
						
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
	
	public static JPanel createstartPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

			
		return panel;	
	}
	
	public static JPanel createstopPanel(){

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
		Style receivecurrentDataStyle = doc.addStyle("receivecurrentDataStyle", def);
        StyleConstants.setForeground(receivecurrentDataStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
		Style receivepongStyle = doc.addStyle("receivepongStyle", def);
        StyleConstants.setForeground(receivepongStyle, new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));	
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }
}