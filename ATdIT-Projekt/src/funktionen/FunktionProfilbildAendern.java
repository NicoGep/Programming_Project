package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import master.Fenster;
import screens.*;
/**
 * class for the functions of class "FunktionProfilbildAendern"
 * 
 * @author Group3
 *
 */
public class FunktionProfilbildAendern implements ActionListener {

	/**
	 * Opens the profile edit screen when you press the cancel button. 
	 * If the profile picture save button is pressed,
	 * the profile picture is changed and then the profile edit screen is called up
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ProfilbildAendern.cancelButton) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == ProfilbildAendern.saveButton) {
			try {
				DatabaseConnection.connectDatabase();
				Benutzer.setProfilePicture(ProfilbildAendern.addressTextfield.getText());
				DatabaseConnection.disconnectDatabase();
				Fenster.addToFrame(new ProfilBearbeiten());
			} catch (DatabaseConnectException e1) {
				System.out.println("Profilbild kann nicht gespeichert werden");
			}

		}

	}

}
