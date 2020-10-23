package funktionen;

import connection.User;
import exceptions.InputException;
import screens.EditProfile;

/**
 * Class for the function of class "ProfilBearbeiten"
 * 
 * @author Group3
 *
 */
public class EditProfileFunction {
	/**
	 * Method for saving changes to the profile. If the cancel button is pressed,
	 * the "MyProfile" screen opens without saving the values. If the name entered
	 * is not zero and does not yet exist, it will be saved. Otherwise the old name
	 * remains and the text "Name already exists!" issued.
	 * 
	 */

	public static void saveChanges() {
		User user = User.getLoggedUser();
		if (EditProfile.newnameTextfield.getText() != ""
				&& !(EditProfile.newnameTextfield.getText().equals(user.getName()))) {
			user.setName(EditProfile.newnameTextfield.getText());
		}
		user.setNiveau(
				(String) EditProfile.levelSelection.getItemAt(EditProfile.levelSelection.getSelectedIndex()));
		if (EditProfile.newmailTextfield.getText() != "") {
			user.setEmail(EditProfile.newmailTextfield.getText());
		}
	}

}
