package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.GruppeBeitreten;
import screens.GruppeErstellen;
import screens.MeinProfil;


public class FunktionGruppeErstellen implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == GruppeErstellen.abbrechen) {
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == GruppeErstellen.speichern) {
			MeinProfil.gruppenListe.add(GruppeErstellen.gruppenName.getText());
			GruppeBeitreten.gruppenListe.add(GruppeErstellen.gruppenName.getText());
			Fenster.addToFrame(new MeinProfil());
		}

	}

}
