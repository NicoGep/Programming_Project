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


/**	UI-Klasse für den Registrieren-Screen
 * 
 * @author Gruppe 3
 *
 */
public class Registrierung extends Body {

	public static JTextField benutzernametx;
	public static JPasswordField passworttx; 
	public static JTextField mailtx;
	public static JPasswordField passwortWiederholentx;
	
	public static JButton registrierenB;
	public static JButton back;
	
	public static JLabel passwortStimmtNichtUeberein;
	public static JLabel benutzerExistiertBereits;
	
	/**
	 * Konstruktor für den Registrieren-Screen (GridLayout)
	 */
	public Registrierung() {
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(17,1));
		pan.setBounds(0,0,450,800);
		
		JLabel registrieren = new JLabel ("Registrieren");
		Font titel = new Font ("Segoe UI", Font.BOLD, 30);
		registrieren.setFont(titel);
		
		JLabel mail = new JLabel("E-Mail Adresse: ");
		mailtx = new JTextField();
		
		JLabel benutzername = new JLabel("Benutzername: ");
		benutzernametx = new JTextField();
		
		JLabel passwort = new JLabel("Passwort: ");
		passworttx = new JPasswordField();
		
		JLabel passwortWiederholen = new JLabel("Passwort wiederholen: ");
		passwortWiederholentx = new JPasswordField();
		
		JCheckBox agb = new JCheckBox("Ich stimme den AGB zu ...");
		
		registrierenB = new JButton("Registieren");
		
		back = new JButton("Zurück");
		
		passwortStimmtNichtUeberein = new JLabel("");
		benutzerExistiertBereits = new JLabel("");
		
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		JLabel leer2 = new JLabel();
		
		pan.add(leer);
		pan.add(registrieren);
		pan.add(mail);
		pan.add(mailtx);
		pan.add(benutzername);
		pan.add(benutzernametx);
		pan.add(passwort);
		pan.add(passworttx);
		pan.add(passwortWiederholen);
		pan.add(passwortWiederholentx);
		pan.add(agb);
		pan.add(leer1);
		pan.add(registrierenB);
		pan.add(leer2);
		pan.add(back);
		pan.add(passwortStimmtNichtUeberein);
		pan.add(benutzerExistiertBereits);
		
		this.add(pan);
			

		registrierenB.addActionListener(new RegistierenFunktion());
		back.addActionListener(new RegistierenFunktion());
			
	}
	
	/** Hintergrundbild wird gezeichnet
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

