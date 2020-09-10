package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import master.Fenster;
import screens.*;

public class FunktionProfilbildAendern implements ActionListener {

	/**
	 * �ffnet beim Dr�cken des Abbruch-Buttons den Profil-Bearbeiten Screen, Wird
	 * der Profilbildspeicher-Button gedr�ckt, so wird das Profilbild ge�ndert und
	 * danach der Profil Bearbeiten-Screen aufgerufen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ProfilbildAendern.abbrechen) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == ProfilbildAendern.speichern) {
			try {
				DatabaseConnection.connectDatabase();
				Benutzer.setProfilbild(ProfilbildAendern.addresse.getText());
				DatabaseConnection.disconnectDatabase();
				Fenster.addToFrame(new ProfilBearbeiten());
			} catch (DatabaseConnectException e1) {
				System.out.println("Profilbild kann nicht gespeichert werden");
			}

		}

	}

}
