package screens;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import funktionen.FunktionPasswortAendern;
import funktionen.FunktionProfilBearbeiten;
import master.MasterScreen;

/** UI-Klasse zur Festlegung des PasswortAendern-Screens
 * 
 * @author Gruppe 3
 *
 */
public class PasswortAendern extends MasterScreen {
	
	public static JButton speichern;
	public static JButton abbrechen;
	
	public static JPasswordField altesPasswort;
	public static JPasswordField neuesPasswort;
	public static JPasswordField neuesPasswortKontrolle;
	
	JLabel altesPasswortLabel;
	JLabel neuesPasswortLabel;
	JLabel neuesPasswortKontrolleLabel;
	public static JLabel neuesPasswortStimmtNichtUeberein;
	public static JLabel altesPasswortAngeben;
	
	/**
	 * Konstruktor für den Passwort Ändern-Screen ohne Layout
	 */
	public PasswortAendern() {
		this.setLayout(null);
		ActionListener PasswortAendernAL = new FunktionPasswortAendern();
		
		altesPasswortLabel = new JLabel("Altes Passwort: ");
		altesPasswortLabel.setBounds(0, 0, 450, 100);
		altesPasswortLabel.setBackground(Color.LIGHT_GRAY);
		altesPasswortLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		neuesPasswortLabel = new JLabel("Neues Passwort: ");
		neuesPasswortLabel.setBounds(0, 150, 450, 100);
		neuesPasswortLabel.setBackground(Color.LIGHT_GRAY);
		neuesPasswortLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		neuesPasswortKontrolleLabel = new JLabel("Wiederholen Sie Ihr neues Passwort: ");
		neuesPasswortKontrolleLabel.setBounds(0, 300, 450, 100);
		neuesPasswortKontrolleLabel.setBackground(Color.LIGHT_GRAY);
		neuesPasswortKontrolleLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		neuesPasswortStimmtNichtUeberein= new JLabel("Das neue Passwort stimmt nicht überein!");
		neuesPasswortStimmtNichtUeberein.setBounds(0, 450, 450, 75);
		neuesPasswortStimmtNichtUeberein.setBackground(Color.WHITE);
		neuesPasswortStimmtNichtUeberein.setForeground(Color.RED);
		neuesPasswortStimmtNichtUeberein.setVisible(false);
		
		altesPasswortAngeben= new JLabel("Altes Passwort ist falsch!");
		altesPasswortAngeben.setBounds(0, 525, 450, 75);
		altesPasswortAngeben.setBackground(Color.WHITE);
		altesPasswortAngeben.setForeground(Color.RED);
		altesPasswortAngeben.setVisible(false);
	
		altesPasswort = new JPasswordField();
		altesPasswort.setBounds(0, 100, 450, 50);
		
		neuesPasswort = new JPasswordField();
		neuesPasswort.setBounds(0, 250, 450, 50);
		
		neuesPasswortKontrolle = new JPasswordField();
		neuesPasswortKontrolle.setBounds(0, 400, 450, 50);
		
		speichern = new JButton("Speichern");
		speichern.setBackground(Color.GREEN);
		speichern.setBounds(225, 600, 225, 100);
		speichern.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		speichern.addActionListener(PasswortAendernAL);
		
		abbrechen = new JButton("Abbrechen");		
		abbrechen.setBackground(Color.RED);
		abbrechen.setBounds(0, 600, 225, 100);
		abbrechen.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		abbrechen.addActionListener(PasswortAendernAL);
		
		this.add(altesPasswortLabel);
		this.add(altesPasswort);
		this.add(neuesPasswortLabel);
		this.add(neuesPasswort);
		this.add(neuesPasswortKontrolleLabel);
		this.add(neuesPasswortKontrolle);
		this.add(neuesPasswortStimmtNichtUeberein);
		this.add(altesPasswortAngeben);
		this.add(abbrechen);
		this.add(speichern);
	}

	public static JPasswordField getAltesPasswort() {
		return altesPasswort;
	}

	public static JPasswordField getNeuesPasswort() {
		return neuesPasswort;
	}

	public static JPasswordField getNeuesPasswortKontrolle() {
		return neuesPasswortKontrolle;
	}


	
}
