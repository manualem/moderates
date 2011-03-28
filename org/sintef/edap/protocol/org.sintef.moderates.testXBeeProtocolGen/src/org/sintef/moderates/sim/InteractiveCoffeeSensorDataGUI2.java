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

public class InteractiveCoffeeSensorDataGUI2 {
	
	private static boolean init = false;
	
	private static JFrame frame;
	private static JTextPane screen;
	
	//Attributes related to CoffeeData
	public static JButton sendButtonCoffeeData;
	public static JTextField fieldCoffeeData_temp;
	public static JTextField fieldCoffeeData_dist;
	public static JTextField fieldCoffeeData_light;
		

	public static void print(String id, String data){
		try {
        	StyledDocument doc = screen.getStyledDocument();
            doc.insertString(doc.getLength(), formatForPrint(data), doc.getStyle("receive"+id+"Style"));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
	}
		
	public static void addListener(ActionListener l){
		sendButtonCoffeeData.addActionListener(l);
	}
	
	public static void init(){
		if (!init) {
			init = true;
		
			frame = new JFrame("Interactive CoffeeSensor Data Simulator");
			frame.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			c.gridwidth = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0,3,0,3);
			
			//GUI related to CoffeeData
			c.gridy = 0;
	 		c.gridx = 0;
			frame.add(createLabel("CoffeeData"), c);
			
			c.gridy = 1;
	 		c.gridx = 0;
			frame.add(createCoffeeDataPanel(), c);
			
			c.gridy = 2;
	 		c.gridx = 0;
	 		sendButtonCoffeeData = createSendButton("CoffeeData");
			frame.add(sendButtonCoffeeData, c);
			
						
			c.gridy = 3;
			c.gridx = 0;
			c.gridwidth = 1;
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
	
	public static JPanel createCoffeeDataPanel(){

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		
		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labeltemp = new JLabel();
		labeltemp.setText("temp");
 		c.gridx = 0;
		c.gridy = 0;
 		panel.add(labeltemp, c);
 		
 		fieldCoffeeData_temp = new JTextField();
		fieldCoffeeData_temp.setText("temp");
 		c.gridx = 1;
		c.gridy = 0;
 		panel.add(fieldCoffeeData_temp, c);
 		

		JLabel labeldist = new JLabel();
		labeldist.setText("dist");
 		c.gridx = 0;
		c.gridy = 1;
 		panel.add(labeldist, c);
 		
 		fieldCoffeeData_dist = new JTextField();
		fieldCoffeeData_dist.setText("dist");
 		c.gridx = 1;
		c.gridy = 1;
 		panel.add(fieldCoffeeData_dist, c);
 		

		JLabel labellight = new JLabel();
		labellight.setText("light");
 		c.gridx = 0;
		c.gridy = 2;
 		panel.add(labellight, c);
 		
 		fieldCoffeeData_light = new JTextField();
		fieldCoffeeData_light.setText("light");
 		c.gridx = 1;
		c.gridy = 2;
 		panel.add(fieldCoffeeData_light, c);
 		

			
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
        return editorScrollPane;
	}
	
	private static String formatForPrint(String text) {
            return (text.endsWith("\n") ? text : text + "\n");
    }
}