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

/** Klasse, um die Funktion des Profil bearbeiten-Screens bereitzustellen
 * 
 * @author Gruppe 3
 *
 */
public class FunktionProfilBearbeiten implements ActionListener {
/**Methode, um Änderungen am Profil zu speichern.
 * Wird der Abbrechen-Knopf gedrückt, so öffnet sich, ohne Speichern der Werte der "MeinProfil"-Screen
 * Ist der eingegebene Name ungleich null und noch nicht vorhanden, so wird dieser gespeichert. Ansonsten bleibt es beim alten Namen
 * und in der Konsole wird der Text "Name existiert schon!" ausgegeben.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
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
			// Profilbild hinzufügen
			if (e.getSource() == ProfilBearbeiten.neuesProfilbild) {
				Fenster.addToFrame(new ProfilbildAendern());
			}
			// Passwort ändern
			if (e.getSource() == ProfilBearbeiten.passwortAendern) {
				Fenster.addToFrame(new PasswortAendern());
			}
		}

		catch (DatabaseConnectException eee) {
			System.out.println("Name gibt es schon");
		}
		

	}

}
