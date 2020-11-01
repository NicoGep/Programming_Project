package screens;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.*;
import master.Window;
import master.MasterScreen;

/** GUI class for "MenuScreen"
 * 
 * @author group3
 *
 */
@SuppressWarnings("serial")
public class MenuScreen extends MasterScreen {
	
	private final ResourceBundle STRING_TEXT;
	
	/**
	 * constructor for the creating of the menu screen without layout
	 */
	public MenuScreen( ) {
		
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/Menu/menu");
		
		JPanel menuPanel;
		JLabel menuLabel;
		//Definition UI-Layout
		this.setBackground(Color.white);
		this.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(75, 50, 300, 50);
		menuLabel = new JLabel(STRING_TEXT.getString("title"));
		menuLabel.setBackground(Color.white);
		menuLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		menuPanel.add(menuLabel);
		menuPanel.setBackground(Color.white);
		
		JButton mapButton;
		mapButton = new JButton(STRING_TEXT.getString("map"));
		mapButton.setBackground(Color.white);
		mapButton.setBounds(75, 150, 300, 50);
		mapButton.setBorderPainted(false);
		mapButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		JButton mountainbikemapButton;
		mountainbikemapButton = new JButton(STRING_TEXT.getString("mountainbiking"));
		mountainbikemapButton.setBackground(Color.white);
		mountainbikemapButton.setBounds(75, 250, 300, 50);
		mountainbikemapButton.setBorderPainted(false);
		mountainbikemapButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		JButton myProfileButton;
		myProfileButton = new JButton(STRING_TEXT.getString("my_profile"));
		myProfileButton.setBounds(75, 350, 300, 50);
		myProfileButton.setBackground(Color.white);
		myProfileButton.setBorderPainted(false);
		myProfileButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		JButton logoutButton;
		logoutButton = new JButton(STRING_TEXT.getString("log_out"));
		logoutButton.setBackground(Color.white);
		logoutButton.setBounds(170, 600, 125, 50);
		logoutButton.setBorderPainted(false);
		logoutButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		//Funktionsaufruf ActionListener für Buttons
		
		mapButton.addActionListener(w -> { Window.addToFrame(new Map()); });
		mountainbikemapButton.addActionListener(x -> {Window.addToFrame(new Map());});
		myProfileButton.addActionListener(y -> {Window.addToFrame(new MyProfile());});
		logoutButton.addActionListener(z -> { Window.addToFrame(new Login()); });
		this.add(menuPanel);
		this.add(mapButton);
		this.add(mountainbikemapButton);
		this.add(myProfileButton);
		this.add(logoutButton);
	}
}
