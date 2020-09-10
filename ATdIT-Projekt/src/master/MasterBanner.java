package master;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import screens.Login;

public class MasterBanner extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 100;
	
	JButton back;
	JButton logout;
	
	
	public MasterBanner() {

		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		this.setBackground(Color.GREEN);
		
		back = new JButton("Zurück");
		logout = new JButton("Ausloggen");
		
		this.add(back);
		this.add(logout);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fenster.lastContent();
			}
			
		});
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenster.reset();
			}
		});
		
	}

}
