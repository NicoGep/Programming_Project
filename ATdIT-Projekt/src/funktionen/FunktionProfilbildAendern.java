package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.*;


public class FunktionProfilbildAendern implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ProfilbildAendern.abbrechen) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == ProfilbildAendern.speichern) {
			MeinProfil.profilBildAdresse = ProfilbildAendern.addresse.getText();
			Fenster.addToFrame(new ProfilBearbeiten());
		}

	}

}
