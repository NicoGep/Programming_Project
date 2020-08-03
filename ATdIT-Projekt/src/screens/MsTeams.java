package screens;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;

import funktionen.Funktion;
import master.MasterScreen;

public class MsTeams extends MasterScreen {
	
	JButton button;
	
	public MsTeams() {

		this.setBackground(Color.cyan);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Test");
		
		button.addActionListener(new Funktion());
		
	}

}
