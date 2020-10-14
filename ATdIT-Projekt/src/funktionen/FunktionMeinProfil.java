package funktionen;

import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import master.Fenster;
import screens.GruppeBeitreten;
import screens.GruppeErstellen;
import screens.MeinProfil;
import screens.ProfilBearbeiten;

/** Klasse die die Funktionen des Mein Profil-Screens festlegt
 * 
 */
public class FunktionMeinProfil implements ActionListener {

	/**
	 * Methode zum Laden der Benutzerdaten
	 */
	public void datenLaden() {
		MeinProfil.name = Benutzer.getName();
		MeinProfil.niveau = Benutzer.getNiveau();
		MeinProfil.email = Benutzer.getEmail();
		MeinProfil.profilBildAdresse = Benutzer.getProfilBild();
//				"./ui/images/github_profilbild.jpg";
		gruppenHinzufügen();
	}
	
	/**
	 * Methode zum Hinzufügen einer Gruppe
	 */
	public void gruppenHinzufügen() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.setToList(Benutzer.getAllGroups(), "gruppenname") != null) {
				MeinProfil.gruppenListe = AdminFunctions.setToList(Benutzer.getAllGroups(), "gruppenname");
			}
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

	}

	/**
	 * je nach Button wird hier der Screen ProfilBearbeiten, GruppeErstellen oder
	 * Gruppe beitreten geöffnet
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MeinProfil.profilBearbeiten) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == MeinProfil.gruppeErstellen) {
			Fenster.addToFrame(new GruppeErstellen());
		}
		if (e.getSource() == MeinProfil.gruppeBeitreten) {
			Fenster.addToFrame(new GruppeBeitreten());
		}

	}

}
