package funktionen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.Fenster;
import screens.MeinProfil;
import screens.PasswortAendern;
import screens.ProfilBearbeiten;
import screens.ProfilbildAendern;

public class FunktionProfilBearbeiten implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String zwischenspeicherName = ProfilBearbeiten.neuerName.getText();
		try {
			if (e.getSource() == ProfilBearbeiten.abbrechen) {
				Fenster.addToFrame(new MeinProfil());
			}
			if (e.getSource() == ProfilBearbeiten.speichern) {
				try {
					DatabaseConnection.connectDatabase();
					if (ProfilBearbeiten.neuerName.getText() != "" && !(ProfilBearbeiten.neuerName.getText().equals(Benutzer.getName())) ) {
						Benutzer.setName(ProfilBearbeiten.neuerName.getText());
					}
					Benutzer.setNiveau((String) ProfilBearbeiten.niveauAuswahl
							.getItemAt(ProfilBearbeiten.niveauAuswahl.getSelectedIndex()));
					if (ProfilBearbeiten.neueemail.getText() != "") {
						Benutzer.setEmail(ProfilBearbeiten.neueemail.getText());
					}
					DatabaseConnection.disconnectDatabase();

					Fenster.addToFrame(new MeinProfil());
				} catch (InputException e1) {
					System.out.println("Name existiert schon!");
				}

			}
			// Profilbild hinzuf�gen
			if (e.getSource() == ProfilBearbeiten.neuesProfilbild) {
				Fenster.addToFrame(new ProfilbildAendern());
			}
			// Passwort �ndern
			if (e.getSource() == ProfilBearbeiten.passwortAendern) {
				Fenster.addToFrame(new PasswortAendern());
			}
		}

		catch (DatabaseConnectException eee) {
			System.out.println("Name gibt es schon");
		}
		

	}

}
