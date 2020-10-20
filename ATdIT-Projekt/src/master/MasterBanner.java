package master;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import connection.Benutzer;


/** Class for the MasterBanner to have uniform screens
 * 
 * @author Group 3
 *
 */
public class MasterBanner extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 100;
	
	JButton backButton;
	JButton logoutButton;
	
	JLabel nameLabel;
	
	/**
	 * Constructor to create a general construct
	 * @param backButton : JButton
	 * @param logout : JButton
	 */
	public MasterBanner() {

		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		this.setBackground(Color.GREEN);
		
		backButton = new JButton("Zurück");
		logoutButton = new JButton("Ausloggen");
		nameLabel = new JLabel();
		
//		nameLabel.setText("Hallo " + Benutzer.getName());
		
		this.add(backButton);
		this.add(logoutButton);
		this.add(nameLabel);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fenster.lastContent();
			}
			
		});
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Fenster.reset();
			}
		});
		
	}

}
