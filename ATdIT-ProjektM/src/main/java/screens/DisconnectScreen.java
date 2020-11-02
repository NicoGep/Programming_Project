package screens;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

import master.Body;

@SuppressWarnings("serial")
public class DisconnectScreen extends Body {
	
	JLabel label;
	
	public DisconnectScreen() {
		
//		this.setBounds(0, 0, 450, 800);
		this.setBackground(new Color(250, 250, 250, 200));
		this.setOpaque(true);
		
		label = new JLabel("Keine Verbindung. Versuche Verbindung wiederherzustellen.");
		
		
		this.add(label);
		
//		label.setLocation(100, 100);
		
		this.addMouseListener(new MouseAdapter() {
			
		});

		this.setVisible(true);
	}

}