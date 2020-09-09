package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import master.Fenster;
import screens.*;

public class FunktionProfilbildAendern implements ActionListener {

	/**
	 * 	Öffnet beim Drücken des Abbruch-Buttons den Profil-Bearbeiten Screen,
	 *  Wird der Profilbildspeicher-Button gedrückt, so wird das Profilbild geändert und
	 *  danach der Profil Bearbeiten-Screen aufgerufen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ProfilbildAendern.abbrechen) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == ProfilbildAendern.speichern) {

			Benutzer.setProfilbild(ProfilbildAendern.addresse.getText());
			Fenster.addToFrame(new ProfilBearbeiten());
		}

	}

}
