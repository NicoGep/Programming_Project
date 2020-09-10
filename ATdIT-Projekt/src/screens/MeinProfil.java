package screens;

import java.awt.*;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Iterator;
import javax.swing.*;

import funktionen.FunktionMeinProfil;
import master.MasterScreen;

public class MeinProfil extends MasterScreen {

	public static String name;
	public static String niveau;
	public static String email;
	public static String profilBildAdresse;
	public static List<String> gruppenListe;

	JPanel daten;
	JPanel gruppen;
	JPanel profilbildPanel;
	JPanel nameNiveau;
	JPanel meineGruppenListe;

	public static JButton profilBearbeiten;
	public static JButton gruppeBeitreten;
	public static JButton gruppeErstellen;

	public JLabel profilbildLabel;
	public JLabel meineGruppen;
	public JLabel nameLabel;
	public JLabel niveauLabel;
	public Icon profilBild;

	public MeinProfil() {
	
		this.setBackground(Color.lightGray);
		this.setLayout(null);
		ActionListener meinProfilAL = new FunktionMeinProfil();
		new FunktionMeinProfil().datenLaden();
		Image image = Toolkit.getDefaultToolkit().createImage(profilBildAdresse);

		daten = new JPanel();
		daten.setBounds(0, 0, 450, 100);
		daten.setLayout(new GridLayout(0, 2));
		daten.setBackground(Color.GRAY);

		gruppen = new JPanel();
		gruppen.setLayout(null);
		gruppen.setBounds(0, 100, 450, 600);

		profilbildPanel = new JPanel();
		profilbildPanel.setLayout(null);
		profilbildPanel.setBackground(Color.GRAY);

		nameNiveau = new JPanel();
		nameNiveau.setLayout(null);
		nameNiveau.setBackground(Color.GRAY);

		meineGruppenListe = new JPanel();
		meineGruppenListe.setBounds(0, 200, 450, 400);
		meineGruppenListe.setLayout(new GridLayout(0, 1));
		meineGruppenListe.setBackground(Color.WHITE);

		/**
		 * Erstellen der Knöpfe inklusive Einstellen der jeweiligen Position und der
		 * Hintergrundfarbe
		 **/
		profilBearbeiten = new JButton("Profil bearbeiten");
		profilBearbeiten.setBounds(0, 0, 450, 50);
		profilBearbeiten.setBackground(Color.LIGHT_GRAY);

		profilBearbeiten.addActionListener(meinProfilAL);

		gruppeBeitreten = new JButton("Gruppe beitreten oder löschen");
		gruppeBeitreten.setBounds(0, 50, 450, 50);
		gruppeBeitreten.setBackground(Color.LIGHT_GRAY);
		gruppeBeitreten.addActionListener(meinProfilAL);

		gruppeErstellen = new JButton("Gruppe erstellen");
		gruppeErstellen.setBounds(0, 100, 450, 50);
		gruppeErstellen.setBackground(Color.LIGHT_GRAY);
		gruppeErstellen.addActionListener(meinProfilAL);

		profilBild = new ImageIcon(profilBildAdresse);

		/**
		 * Erstellen der Beschriftungen inklusive Einstellen der jeweiligen Position und
		 * der Hintergrundfarbe
		 **/
		meineGruppen = new JLabel("Meine Gruppen");
		meineGruppen.setBounds(175, 150, 450, 50);
		meineGruppen.setBackground(Color.GRAY);
		meineGruppen.setFont(new Font("Ueberschrift", Font.BOLD, 14));

		profilbildLabel = new JLabel(new ImageIcon(image));
		profilbildLabel.setBounds(75, 0, 100, 100);
		profilbildLabel.setBackground(Color.GRAY);

		JLabel nameBeschriftung = new JLabel("Name:");
		nameBeschriftung.setBounds(0, 0, 75, 50);
		nameBeschriftung.setFont(new Font("Ueberschrift", Font.BOLD, 14));

		nameLabel = new JLabel(name);
		nameLabel.setBounds(100, 0, 100, 50);

		JLabel niveauBeschriftung = new JLabel("Niveau:");
		niveauBeschriftung.setBounds(0, 50, 75, 50);
		niveauBeschriftung.setFont(new Font("Ueberschrift", Font.BOLD, 14));

		niveauLabel = new JLabel(niveau);
		niveauLabel.setBounds(100, 50, 100, 50);

		profilbildPanel.add(profilbildLabel);

		nameNiveau.add(nameBeschriftung);
		nameNiveau.add(nameLabel);
		nameNiveau.add(niveauBeschriftung);
		nameNiveau.add(niveauLabel);

		daten.add(profilbildPanel);
		daten.add(nameNiveau);

		Iterator it = gruppenListe.iterator();
		while (it.hasNext()) {
			meineGruppenListe.add(new JLabel((String) it.next()));
		}

		gruppen.add(profilBearbeiten);
		gruppen.add(gruppeBeitreten);
		gruppen.add(gruppeErstellen);
		gruppen.add(meineGruppen);
		gruppen.add(meineGruppenListe);

		this.add(daten, BorderLayout.NORTH);
		this.add(gruppen, BorderLayout.CENTER);

	}
}
