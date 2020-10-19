package screens;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.*;
import master.Fenster;
import master.MasterScreen;

/** GUI class for "MenuScreen"
 * 
 * @author group3
 *
 */
public class MenuScreen extends MasterScreen {
	
	public JPanel menuPanel;
	public JLabel menuLabel;
	public static JButton mapButton;
	public static JButton mountainbikemapButton;
	public static JButton myProfileButton;
	public static JButton logoutButton;
	
	/**
	 * constructor for the creating of the menu screen without layout
	 */
	public MenuScreen( ) {
		
		//Definition UI-Layout
		this.setBackground(Color.white);
		this.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(75, 50, 300, 50);
		menuLabel = new JLabel("MEN�");
		menuLabel.setBackground(Color.white);
		menuLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		menuPanel.add(menuLabel);
		menuPanel.setBackground(Color.white);
		
		
		mapButton = new JButton("Karte");
		mapButton.setBackground(Color.white);
		mapButton.setBounds(75, 150, 300, 50);
		mapButton.setBorderPainted(false);
		mapButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		mountainbikemapButton = new JButton("Mountainbiking");
		mountainbikemapButton.setBackground(Color.white);
		mountainbikemapButton.setBounds(75, 250, 300, 50);
		mountainbikemapButton.setBorderPainted(false);
		mountainbikemapButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		myProfileButton = new JButton("Mein Profil");
		myProfileButton.setBounds(75, 350, 300, 50);
		myProfileButton.setBackground(Color.white);
		myProfileButton.setBorderPainted(false);
		myProfileButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		logoutButton = new JButton("Ausloggen");
		logoutButton.setBackground(Color.white);
		logoutButton.setBounds(170, 600, 125, 50);
		logoutButton.setBorderPainted(false);
		logoutButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		//Funktionsaufruf ActionListener f�r Buttons
		
		mapButton.addActionListener(w -> { Fenster.addToFrame(new KarteScreen()); });
		mountainbikemapButton.addActionListener(x -> {Fenster.addToFrame(new KarteScreen());});
		myProfileButton.addActionListener(y -> {Fenster.addToFrame(new MeinProfil());});
		logoutButton.addActionListener(z -> { Fenster.addToFrame(new Login()); });
		this.add(menuPanel);
		this.add(mapButton);
		this.add(mountainbikemapButton);
		this.add(myProfileButton);
		this.add(logoutButton);
	}
}
