package funktionen;

import connection.Benutzer;
import exceptions.InputException;
import screens.ProfilBearbeiten;

/**
 * Class for the function of class "ProfilBearbeiten"
 * 
 * @author Group3
 *
 */
public class FunktionProfilBearbeiten {
	/**
	 * Method for saving changes to the profile. If the cancel button is pressed,
	 * the "MyProfile" screen opens without saving the values. If the name entered
	 * is not zero and does not yet exist, it will be saved. Otherwise the old name
	 * remains and the text "Name already exists!" issued.
	 * 
	 */

	public static void saveChanges() {
		Benutzer user = Benutzer.getLoggedUser();
		if (ProfilBearbeiten.newnameTextfield.getText() != ""
				&& !(ProfilBearbeiten.newnameTextfield.getText().equals(user.getName()))) {
			user.setName(ProfilBearbeiten.newnameTextfield.getText());
		}
		user.setNiveau(
				(String) ProfilBearbeiten.levelSelection.getItemAt(ProfilBearbeiten.levelSelection.getSelectedIndex()));
		if (ProfilBearbeiten.newmailTextfield.getText() != "") {
			user.setEmail(ProfilBearbeiten.newmailTextfield.getText());
		}
	}

}
