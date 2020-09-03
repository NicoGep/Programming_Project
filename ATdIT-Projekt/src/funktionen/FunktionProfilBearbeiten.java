package funktionen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import master.Fenster;
import screens.MeinProfil;
import screens.PasswortAendern;
import screens.ProfilBearbeiten;
import screens.ProfilbildAendern;

public class FunktionProfilBearbeiten implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ProfilBearbeiten.abbrechen) {
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == ProfilBearbeiten.speichern) {
			MeinProfil.name = ProfilBearbeiten.neuerName.getText();
			MeinProfil.niveau = (String) ProfilBearbeiten.niveauAuswahl.getItemAt(ProfilBearbeiten.niveauAuswahl.getSelectedIndex());
			MeinProfil.email = ProfilBearbeiten.neueemail.getText();
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == ProfilBearbeiten.neuesProfilbild) {
			Fenster.addToFrame(new ProfilbildAendern());
		}
		if (e.getSource() == ProfilBearbeiten.passwortAendern) {
			Fenster.addToFrame(new PasswortAendern());
		}

	}

}
