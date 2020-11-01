package funktionen;

import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import connection.User;


/**
 * Class for the function of class "ProfilBearbeiten"
 * 
 * @author Group3
 *
 */
public class EditProfileFunction {
	public JComboBox<String> levelSelection;

	public JTextField newnameTextfield;
	public JTextField newmailTextfield;
	
	private final ResourceBundle STRING_TEXT = ResourceBundle.getBundle("i18n/Funktionen/EditProfileFunction/editprofilefunction");

	/**
	 * Method for saving changes to the profile. If the cancel button is pressed,
	 * the "MyProfile" screen opens without saving the values. If the name entered
	 * is not zero and does not yet exist, it will be saved. Otherwise the old name
	 * remains and the text "Name already exists!" issued.
	 * 
	 */
	public EditProfileFunction(JComboBox<String> levelSelection, JTextField newnameTextfield, JTextField newmailTextfield) {
		this.levelSelection = levelSelection;
		this.newnameTextfield = newnameTextfield;
		this.newmailTextfield = newmailTextfield;
	}

	public void saveChanges() {
		User user = User.getLoggedUser();
		if (newnameTextfield.getText() != ""
				&& !(newnameTextfield.getText().equals(user.getName()))) {
			user.setName(newnameTextfield.getText());
		}
		
		if (((String) levelSelection.getItemAt(levelSelection.getSelectedIndex())).equals(STRING_TEXT.getString("beginner"))) {
			user.setNiveau("1");
		}
		else if (((String) levelSelection.getItemAt(levelSelection.getSelectedIndex())).equals(STRING_TEXT.getString("medium"))) {
			user.setNiveau("2");
		}
		else if (((String) levelSelection.getItemAt(levelSelection.getSelectedIndex())).equals(STRING_TEXT.getString("pro"))) {
			user.setNiveau("3");
		}
		
	
		
		if (newmailTextfield.getText() != "") {
			user.setEmail(newmailTextfield.getText());
		}
	}

}
