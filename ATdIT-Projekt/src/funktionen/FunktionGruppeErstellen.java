package funktionen;

import connection.Benutzer;
import exceptions.InputException;
import screens.GruppeErstellen;

/**
 * Class with the functions for class "GruppeErstellen"
 * 
 * @author Group3
 *
 */
public class FunktionGruppeErstellen {

	/**
	 * Creates a new group when the create button is clicked The screen of 'my
	 * profile' opens when the cancel button is clicked
	 */

	public static void save() {
		try {
			AdminFunctions.createGroup(GruppeErstellen.groupNameTextfield.getText(),
					(String) GruppeErstellen.levelSelection
							.getItemAt(GruppeErstellen.levelSelection.getSelectedIndex()));
			Benutzer.joinGroup(GruppeErstellen.groupNameTextfield.getText());
		} catch (InputException e) {

		}

	}

}
