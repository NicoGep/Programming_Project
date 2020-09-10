package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.Fenster;
import screens.GruppeErstellen;
import screens.MeinProfil;

/**	Klasse um die Funktion für den Gruppe erstellen-Button + abbrechen-Button
 * 
 * @author I518230
 *
 */
public class FunktionGruppeErstellen implements ActionListener {
	
	/**
	 *  Erstellt im Falle, dass der GruppenErstellen-Button gedrückt wird, eine neue Gruppe
	 *  Falls der Abbrechen-Button gedrückt wird, öffnet sich der MeinProfil-Screen
	 */
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
				Benutzer.joinGroup(GruppeErstellen.gruppenName.getText());
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e1) {
				e1.printStackTrace();
			} catch (InputException e1) {
				e1.printStackTrace();
			}
			Fenster.addToFrame(new MeinProfil());
		}

	}

}
