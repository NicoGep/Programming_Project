package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.Fenster;
import screens.GruppeErstellen;
import screens.MeinProfil;

public class FunktionGruppeErstellen implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == GruppeErstellen.abbrechen) {
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == GruppeErstellen.speichern) {
			try {
				DatabaseConnection.connectDatabase();
				AdminFunctions.gruppeErstellen(GruppeErstellen.gruppenName.getText(),
						(String) GruppeErstellen.niveauAuswahl
								.getItemAt(GruppeErstellen.niveauAuswahl.getSelectedIndex()));
				DatabaseConnection.disconnectDatabase();
			} catch (InputException | DatabaseConnectException e1) {
				e1.printStackTrace();
			}
			Fenster.addToFrame(new MeinProfil());
		}

	}

}
