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

/** Class for the function of class "ProfilBearbeiten"
 * 
 * @author Group3
 *
 */
public class FunktionProfilBearbeiten implements ActionListener {
/**
 * Method for saving changes to the profile.
 * If the cancel button is pressed, the "MyProfile" screen opens without saving the values. 
 * If the name entered is not zero and does not yet exist, it will be saved. 
 * Otherwise the old name remains and the text "Name already exists!" issued.
 * 
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == ProfilBearbeiten.cancelButton) {
				Fenster.addToFrame(new MeinProfil());
			}
			if (e.getSource() == ProfilBearbeiten.saveButton) {
				try {
					DatabaseConnection.connectDatabase();
					if (ProfilBearbeiten.newnameTextfield.getText() != "" && !(ProfilBearbeiten.newnameTextfield.getText().equals(Benutzer.getName())) ) {
						Benutzer.setName(ProfilBearbeiten.newnameTextfield.getText());
					}
					Benutzer.setLevel((String) ProfilBearbeiten.levelSelection
							.getItemAt(ProfilBearbeiten.levelSelection.getSelectedIndex()));
					if (ProfilBearbeiten.newmailTextfield.getText() != "") {
						Benutzer.setMail(ProfilBearbeiten.newmailTextfield.getText());
					}
					DatabaseConnection.disconnectDatabase();

					Fenster.addToFrame(new MeinProfil());
				} catch (InputException e1) {
					System.out.println("Name existiert schon!");
				}

			}
			// add profile picture
			if (e.getSource() == ProfilBearbeiten.newprofilepictureButton) {
				Fenster.addToFrame(new ProfilbildAendern());
			}
			// change password
			if (e.getSource() == ProfilBearbeiten.changepasswordButton) {
				Fenster.addToFrame(new PasswortAendern());
			}
		}

		catch (DatabaseConnectException eee) {
			System.out.println("Name gibt es schon");
		}
		

	}

}
