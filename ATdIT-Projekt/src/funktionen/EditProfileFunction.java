package funktionen;

import connection.User;
import exceptions.InputException;
import screens.EditProfile;

/**
 * Class for the function of class "EditProfile"
 * 
 * @author Group3
 *
 */
public class EditProfileFunction{
	/**
	 * Method for saving changes to the profile. If the cancel button is pressed,
	 * the "MyProfile" screen opens without saving the values. If the name entered
	 * is not zero and does not yet exist, it will be saved. Otherwise the old name
	 * remains and the text "Name already exists!" issued.
	 * 
	 */

	public static void saveChanges() {
		if (EditProfile.newnameTextfield.getText() != ""
				&& !(EditProfile.newnameTextfield.getText().equals(User.getName()))) {
			try {
				User.setName(EditProfile.newnameTextfield.getText());
			} catch (InputException e) {
				System.out.println("Name existiert schon!");
			}
		}
		User.setLevel(
				(String) EditProfile.levelSelection.getItemAt(EditProfile.levelSelection.getSelectedIndex()));
		if (EditProfile.newmailTextfield.getText() != "") {
			User.setMail(EditProfile.newmailTextfield.getText());
		}
	}

}
