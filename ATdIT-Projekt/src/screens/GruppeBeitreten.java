package screens;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.*;

import funktionen.FunktionGruppeBeitreten;

import master.MasterScreen;

/**
 * 	UI für den Gruppe-Beitreten Screen
 * @author I518230
 *
 */
public class GruppeBeitreten extends MasterScreen {

	public static JButton zurueck;
	public static JButton beitreten;
	public static JButton loeschen;
	public static JButton suchen;

	public static JComboBox<String> gruppen;
	
	public static List<String> gruppenListe;

	JLabel gruppenNameLabel;
	public static JLabel ergebnisse;

	public static JTextField gruppenName;

	/**
	 * Konstruktor GruppeBeitreten
	 * @param gruppenNameLabel : JLabel
	 * @param gruppenName : JTextField
	 * @param ergebnisse : JLabel
	 * @param gruppen : JComboBox<String>
	 * @param suchen : JButton
	 * @param beitreten : JButton
	 * @param loeschen : JButton
	 * @param zurueck : JButton
	 */
	public GruppeBeitreten() {

		this.setLayout(null);
		ActionListener gruppeBeitretenAL = new FunktionGruppeBeitreten();
//		new FunktionGruppeBeitreten().gruppenLaden();

		gruppenNameLabel = new JLabel("Name der Gruppe:");
		gruppenNameLabel.setBounds(0, 0, 450, 100);
		gruppenNameLabel.setBackground(Color.LIGHT_GRAY);
		gruppenNameLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		gruppenName = new JTextField();
		gruppenName.setBounds(0, 100, 450, 50);

		ergebnisse = new JLabel("Ergebnisse der Suche");
		ergebnisse.setBounds(0, 150, 450, 100);
		ergebnisse.setBackground(Color.LIGHT_GRAY);
		ergebnisse.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		ergebnisse.setVisible(false);

		gruppen = new JComboBox<String>();
		gruppen.setBounds(0, 250, 450, 50);
		gruppen.setVisible(false);
		
		suchen = new JButton("Suchen");
		suchen.setBackground(Color.BLUE);
		suchen.setBounds(0, 400, 450, 100);
		suchen.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		suchen.addActionListener(gruppeBeitretenAL);

		beitreten = new JButton("Beitreten");
		beitreten.setBackground(Color.LIGHT_GRAY);
		beitreten.setBounds(225, 500, 225, 100);
		beitreten.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		beitreten.addActionListener(gruppeBeitretenAL);

		loeschen = new JButton("Austreten");
		loeschen.setBackground(Color.LIGHT_GRAY);
		loeschen.setBounds(0, 500, 225, 100);
		loeschen.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		loeschen.addActionListener(gruppeBeitretenAL);		

		zurueck = new JButton("Zurück");
		zurueck.setBackground(Color.RED);
		zurueck.setBounds(0, 600, 450, 100);
		zurueck.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		zurueck.addActionListener(gruppeBeitretenAL);

		this.add(gruppenNameLabel);
		this.add(gruppenName);
		this.add(ergebnisse);
		this.add(gruppen);
		this.add(suchen);
		this.add(loeschen);
		this.add(beitreten);
		this.add(zurueck);

	}
}
