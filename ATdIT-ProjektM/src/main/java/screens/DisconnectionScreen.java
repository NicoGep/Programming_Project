package screens;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

import master.Body;

public class DisconnectionScreen extends Body {
	
	JLabel label;
	
	public DisconnectionScreen() {
		
//		this.setBounds(0, 0, 450, 800);
		this.setBackground(new Color(250, 250, 250, 200));
		this.setOpaque(true);
		this.setVisible(true);
		
		label = new JLabel("Keine Verbindung");
		
		
		this.add(label);
		
		label.setLocation(100, 100);
		
		this.addMouseListener(new MouseAdapter() {
			
		});

		this.setVisible(true);
	}

}
