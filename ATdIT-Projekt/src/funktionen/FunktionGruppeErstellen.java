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

/**Class with the functions for class "GruppeErstellen"
 * 
 *  @author Group3
 *
 */
public class FunktionGruppeErstellen implements ActionListener {
	
	/**
	 *  Creates a new group when the create button is clicked 
	 *  The screen of 'my profile' opens when the cancel button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == GruppeErstellen.cancelButton) {
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == GruppeErstellen.saveButton) {
			try {
				DatabaseConnection.connectDatabase();
				AdminFunctions.createGroup(GruppeErstellen.groupNameTextfield.getText(),
						(String) GruppeErstellen.levelSelection
								.getItemAt(GruppeErstellen.levelSelection.getSelectedIndex()));
				Benutzer.joinGroup(GruppeErstellen.groupNameTextfield.getText());
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
