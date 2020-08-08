package screens;

import java.awt.*;
import javax.swing.*;
import master.MasterScreen;

public class MeinProfil extends MasterScreen {
	JPanel daten;
	JPanel gruppen;
	JPanel profilbildPanel;
	JPanel nameNiveau;
	JPanel meineGruppenListe;

	JButton profilBearbeiten;
	JButton gruppeBeitreten;
	JButton gruppeErstellen;

	JLabel profilbild;
	JLabel meineGruppen;
	JLabel gruppe1;
	JLabel name;
	JLabel niveau;
	ScrollPane sp;
	Icon profilBild;

	public MeinProfil() {

		this.setBackground(Color.lightGray);
		this.setLayout(null);

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
		meineGruppenListe.setBounds(0,200,450,400);
		meineGruppenListe.setLayout(new GridLayout(0, 1));
		meineGruppenListe.setBackground(Color.RED);
	

		/**
		 * Erstellen der Knöpfe inklusive Einstellen der jeweiligen Position und der
		 * Hintergrundfarbe
		 **/
		profilBearbeiten = new JButton("Profil bearbeiten");
		profilBearbeiten.setBounds(0, 0, 450, 50);
		profilBearbeiten.setBackground(Color.LIGHT_GRAY);
		
		gruppeBeitreten = new JButton("Gruppe beitreten");
		gruppeBeitreten.setBounds(0, 50, 450, 50);
		gruppeBeitreten.setBackground(Color.LIGHT_GRAY);
		
		gruppeErstellen = new JButton("Gruppe erstellen");
		gruppeErstellen.setBounds(0, 100, 450, 50);
		gruppeErstellen.setBackground(Color.LIGHT_GRAY);

		profilBild = new ImageIcon("file:///C:/Users/Philipp/Downloads/github_profilbild.jpg");

		/**
		 * Erstellen der Beschriftungen inklusive Einstellen der jeweiligen Position und
		 * der Hintergrundfarbe
		 **/
		meineGruppen = new JLabel("Meine Gruppen");
		meineGruppen.setBounds(180, 150, 450, 50);
		meineGruppen.setBackground(Color.GRAY);
		
		profilbild = new JLabel("fuck");
		profilbild.setToolTipText("Existiert");
		profilbild.setBounds(100, 35, 25, 25);
		profilbild.setBackground(Color.GRAY);
		
		JLabel nameBeschriftung = new JLabel("Name:");
		nameBeschriftung.setBounds(0, 0, 50, 50);
		
		name = new JLabel("Appuser");
		name.setBounds(100, 0, 100, 50);
		
		JLabel niveauBeschriftung = new JLabel("Niveau:");
		niveauBeschriftung.setBounds(0, 50, 50, 50);
		
		niveau = new JLabel("Anfänger");
		niveau.setBounds(100, 50, 100, 50);

		profilbildPanel.add(profilbild);

		nameNiveau.add(nameBeschriftung);
		nameNiveau.add(name);
		nameNiveau.add(niveauBeschriftung);
		nameNiveau.add(niveau);

		daten.add(profilbildPanel);
		daten.add(nameNiveau);
		
		for (int i = 0; i<4 ; i++) {
			meineGruppenListe.add(new JLabel("Gruppe "+i));
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
