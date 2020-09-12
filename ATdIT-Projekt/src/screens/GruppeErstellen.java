package screens;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import funktionen.FunktionGruppeErstellen;
import master.MasterScreen;

/**
 *  UI zum Gruppe Erstellen-Screen
 * @author Gruppe 3
 *
 */
public class GruppeErstellen extends MasterScreen {

	public static JButton abbrechen;
	public static JButton speichern;

	public static JComboBox<String> niveauAuswahl;

	public static JTextField gruppenName;

	JLabel gruppenNameLabel;
	JLabel niveauLabel;

	/**
	 * Konstruktor Gruppe Erstellen
	 * Layout : null
	 * @param gruppenNameLabel : JLabel
	 * @param niveauLabel : JLabel
	 * @param gruppenName : JTextField
	 * @param niveauAuswahl : JComboBox<String>
	 * @param speichern : JButton
	 * @param abbrechen : JButton
	 */
	public GruppeErstellen() {

		this.setLayout(null);
		ActionListener GruppeErstellenAL = new FunktionGruppeErstellen();

		gruppenNameLabel = new JLabel("Name der Gruppe:");
		gruppenNameLabel.setBounds(0, 0, 450, 100);
		gruppenNameLabel.setBackground(Color.LIGHT_GRAY);
		gruppenNameLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		niveauLabel = new JLabel("Niveau der Gruppe:");
		niveauLabel.setBounds(0, 150, 450, 100);
		niveauLabel.setBackground(Color.LIGHT_GRAY);
		niveauLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		
		gruppenName = new JTextField();
		gruppenName.setBounds(0, 100, 450, 50);

		niveauAuswahl = new JComboBox<String>();
		niveauAuswahl.addItem("Anfänger");
		niveauAuswahl.addItem("Medium");
		niveauAuswahl.addItem("Professionell");
		niveauAuswahl.setBounds(0, 250, 450, 50);

		speichern = new JButton("Speichern");
		speichern.setBackground(Color.GREEN);
		speichern.setBounds(225, 600, 225, 100);
		speichern.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		speichern.addActionListener(GruppeErstellenAL);

		abbrechen = new JButton("Abbrechen");
		abbrechen.setBackground(Color.RED);
		abbrechen.setBounds(0, 600, 225, 100);
		abbrechen.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		abbrechen.addActionListener(GruppeErstellenAL);
		
		this.add(gruppenNameLabel);
		this.add(gruppenName);
		this.add(niveauLabel);
		this.add(niveauAuswahl);
		this.add(abbrechen);
		this.add(speichern);

	}
}
