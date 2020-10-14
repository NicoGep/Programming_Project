package screens;

import master.MasterScreen;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import funktionen.FunktionProfilBearbeiten;

/** UI-Klasse für den Profil bearbeiten-Screen
 * 
 * @author Gruppe 3
 *
 */
public class ProfilBearbeiten extends MasterScreen {
	ActionListener ProfilBearbeitenAL = new FunktionProfilBearbeiten();
	
	JLabel name;
	JLabel niveau;
	JLabel email;

	public static JComboBox niveauAuswahl;
	
	public static JTextField neuerName;
	public static JTextField neueemail;
	
	public static JButton speichern;
	public static JButton abbrechen;
	public static JButton neuesProfilbild;
	public static JButton passwortAendern;

	/**
	 *  Konstruktor für den Mein Profil bearbeiten-Screen ohne Layout
	 */
	public ProfilBearbeiten() {
		
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		name = new JLabel("Name");
		name.setBounds(0, 0, 450, 100);
		name.setBackground(Color.LIGHT_GRAY);
		name.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		niveau = new JLabel("Niveau");
		niveau.setBounds(0,150,450,100);
		niveau.setBackground(Color.LIGHT_GRAY);
		niveau.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		email = new JLabel("E-Mail:");
		email.setBounds(0,300,450,100);
		email.setBackground(Color.LIGHT_GRAY);
		email.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		niveauAuswahl = new JComboBox();
		niveauAuswahl.addItem("Anfänger");
		niveauAuswahl.addItem("Medium");
		niveauAuswahl.addItem("Professionell");
		niveauAuswahl.setBounds(0, 250, 450, 50);
		niveauAuswahl.setSelectedItem(MeinProfil.niveau);
		
		
		neuerName = new JTextField(MeinProfil.name);
		neuerName.setBounds(0,100,450,50);
		
		neueemail = new JTextField(MeinProfil.email);
		neueemail.setBounds(0,400,450,50);
		
		neuesProfilbild = new JButton("Neues Profilbild");
		neuesProfilbild.setBounds(0, 450, 450, 100);
		neuesProfilbild.setBackground(Color.LIGHT_GRAY);
		neuesProfilbild.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		neuesProfilbild.addActionListener(ProfilBearbeitenAL);
		
		passwortAendern = new JButton("Passwort ändern");
		passwortAendern.setBounds(0, 550, 450, 50);
		passwortAendern.setBackground(Color.LIGHT_GRAY);
		passwortAendern.setForeground(Color.RED);
		passwortAendern.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		passwortAendern.addActionListener(ProfilBearbeitenAL);
		
		speichern = new JButton("Speichern");
		speichern.setBackground(Color.GREEN);
		speichern.setBounds(225, 600, 225, 100);
		speichern.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		speichern.addActionListener(ProfilBearbeitenAL);
		
		abbrechen = new JButton("Abbrechen");		
		abbrechen.setBackground(Color.RED);
		abbrechen.setBounds(0, 600, 225, 100);
		abbrechen.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		abbrechen.addActionListener(ProfilBearbeitenAL);
		
		
		this.add(name);
		this.add(neuerName);
		this.add(niveau);
		this.add(niveauAuswahl);
		this.add(email);
		this.add(neueemail);
		this.add(neuesProfilbild);
		this.add(passwortAendern);
		this.add(abbrechen);
		this.add(speichern);
		
		
	}

}
