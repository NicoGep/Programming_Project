package funktionen;

import java.awt.event.*;
import java.util.LinkedList;

import connection.Benutzer;
import master.Fenster;
import screens.GruppeBeitreten;
import screens.GruppeErstellen;
import screens.MeinProfil;
import screens.ProfilBearbeiten;

public class FunktionMeinProfil implements ActionListener {

	public void datenLaden() {
		MeinProfil.name = Benutzer.getName();
		MeinProfil.niveau = Benutzer.getNiveau();
		MeinProfil.email = Benutzer.getEmail();
		MeinProfil.profilBildAdresse = Benutzer.getProfilBild();
//				"./ui/images/github_profilbild.jpg";
		gruppenHinzufügen();
	}

	public void gruppenHinzufügen() {
		
	}

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
