package master;

import java.awt.Color;
import java.util.ResourceBundle;

import javax.swing.*;

import screens.MenuScreen;

/** Class for the MasterBanner to have uniform screens
 * 
 * @author Group 3
 *
 */
@SuppressWarnings("serial")
public class MasterBanner extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 100;
	
	JButton backButton, logoutButton, menuButton;
	
//	JLabel nameLabel;
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
		menuButton = new JButton("Menü"); //################## Switch auf internationalisierungs-Käse
//		menuButton = new JButton(STRING_TEXT.getString("menu_Screen")); 
		
//		nameLabel = new JLabel();
		
		
		this.add(backButton);
		this.add(logoutButton);
		this.add(menuButton);
//		this.add(nameLabel);
		
		backButton.addActionListener(a -> {
				Window.lastContent();
		});
		
		logoutButton.addActionListener(b -> {
				Window.reset();
		});
		
		menuButton.addActionListener(c -> {
			Window.addToFrame(new MenuScreen());
		});
		
	}

}
