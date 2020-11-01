package master;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;



/** Class for the MasterBanner to have uniform screens
 * 
 * @author Group 3
 *
 */
@SuppressWarnings("serial")
public class MasterBanner extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 100;
	
	JButton backButton;
	JButton logoutButton;
	
	JLabel nameLabel;
	private final ResourceBundle STRING_TEXT;
	
	/**
	 * Constructor to create a general construct
	 * @param backButton : JButton
	 * @param logout : JButton
	 */
	public MasterBanner() {

		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		this.setBackground(Color.GREEN);
		
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/master/MasterBanner/masterbanner");
		
		backButton = new JButton(STRING_TEXT.getString("back"));
		logoutButton = new JButton(STRING_TEXT.getString("log_out"));
		nameLabel = new JLabel();
		
//		nameLabel.setText("Hallo " + Benutzer.getName());
		
		this.add(backButton);
		this.add(logoutButton);
		this.add(nameLabel);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window.lastContent();
			}
			
		});
		
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window.reset();
			}
		});
		
	}

}
