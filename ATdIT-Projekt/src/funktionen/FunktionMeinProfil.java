package funktionen;

import java.awt.event.*;
import java.util.LinkedList;


import master.Fenster;
import screens.MeinProfil;
import screens.ProfilBearbeiten;


public class FunktionMeinProfil implements ActionListener {
	
	public void datenLaden() {
		MeinProfil.name = "Appuser";
		MeinProfil.niveau = "Anf�nger";
		MeinProfil.profilBildAdresse = "/ATdIT-Projekt/src/screens/github_profilbild.jpg";
		gruppenHinzuf�gen();
	}
	
	
	public void gruppenHinzuf�gen() {
		MeinProfil.gruppenListe.add("Gruppe1");
		MeinProfil.gruppenListe.add("Gruppe2");
		MeinProfil.gruppenListe.add("Gruppe3");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MeinProfil.profilBearbeiten) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		
	}

	
	

}
