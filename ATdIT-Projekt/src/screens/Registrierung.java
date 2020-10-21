package screens;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import funktionen.RegistierenFunktion;
import master.Body;


/**	UI class for class "Registrierung"
 * 
 * @author Group3
 *
 */
public class Registrierung extends Body {

	public static JTextField userTextfield;
	public static JPasswordField passwordPasswordfield; 
	public static JTextField mailTextfield;
	public static JPasswordField repeatpasswordPasswordfield;
	
	public JButton registerButton;
	public JButton backButton;
	
	public static JLabel passworddoesnotmatchLabel;
	public static JLabel userexistsLabel;
	
	/**
	 * constructor (GridLayout)
	 */
	public Registrierung() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(17,1));
		panel.setBounds(0,0,450,800);
		
		JLabel registerLabel = new JLabel ("Registrieren");
		Font title = new Font ("Segoe UI", Font.BOLD, 30);
		registerLabel.setFont(title);
		
		JLabel mailLabel = new JLabel("E-Mail Adresse: ");
		mailTextfield = new JTextField();
		
		JLabel userLabel = new JLabel("Benutzername: ");
		userTextfield = new JTextField();
		
		JLabel passwordLabel = new JLabel("Passwort: ");
		passwordPasswordfield = new JPasswordField();
		
		JLabel repeatpasswordLabel = new JLabel("Passwort wiederholen: ");
		repeatpasswordPasswordfield = new JPasswordField();
		
		JCheckBox agbCheckbox = new JCheckBox("Ich stimme den AGB zu ...");
		
		registerButton = new JButton("Registieren");
		
		backButton = new JButton("Zur�ck");
		
		passworddoesnotmatchLabel = new JLabel("");
		userexistsLabel = new JLabel("");
		
		JLabel space = new JLabel();
		JLabel space1 = new JLabel();
		JLabel space2 = new JLabel();
		
		panel.add(space);
		panel.add(registerLabel);
		panel.add(mailLabel);
		panel.add(mailTextfield);
		panel.add(userLabel);
		panel.add(userTextfield);
		panel.add(passwordLabel);
		panel.add(passwordPasswordfield);
		panel.add(repeatpasswordLabel);
		panel.add(repeatpasswordPasswordfield);
		panel.add(agbCheckbox);
		panel.add(space1);
		panel.add(registerButton);
		panel.add(space2);
		panel.add(backButton);
		panel.add(passworddoesnotmatchLabel);
		panel.add(userexistsLabel);
		
		this.add(panel);
			
		registerButton.addActionListener(l -> {
		try {
			DatabaseConnection.connectDatabase();
			RegistrierenFunktion.register();
			DatabaseConnection.disconnectDatabase();
		{ catch (DatabaseConnectException e){
			
		}
		});
		
		backButton.addActionListener(l -> {
			Benutzer.logoutUser();
			Fenster.clearHistory();
			Fenster.newDraw(new Login());
		});
			
	}
	
	/** background image is drawn
	 * 
	 */
	@Override
		protected void paintComponent (Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("./ui/images/wandern (2).jpg");	
		super.paintComponent(g);
		g.drawImage(img, 0, 0 , null);
		setVisible(true);
		}
	

	}

