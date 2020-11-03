package funktionen;

import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connection.User;
import connection.Validator;
import exceptions.EditProfileException;
import master.Window;
import screens.MyProfile;

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

	public JLabel userexists, wrongMailFormat;

	private final ResourceBundle STRING_TEXT = ResourceBundle
			.getBundle("i18n/Funktionen/EditProfileFunction/editprofilefunction");

	/**
	 * Method for saving changes to the profile. If the cancel button is pressed,
	 * the "MyProfile" screen opens without saving the values. If the name entered
	 * is not zero and does not yet exist, it will be saved. Otherwise the old name
	 * remains and the text "Name already exists!" issued.
	 * 
	 */
	public EditProfileFunction(JComboBox<String> levelSelection, JTextField newnameTextfield,
			JTextField newmailTextfield, JLabel userexists, JLabel wrongMailFormat) {
		this.levelSelection = levelSelection;
		this.newnameTextfield = newnameTextfield;
		this.newmailTextfield = newmailTextfield;
		this.userexists = userexists;
		this.wrongMailFormat = wrongMailFormat;
	}

	public void saveChanges() throws EditProfileException {
		User user = User.getLoggedUser();
		userexists.setText("");
		wrongMailFormat.setText("");

		if (((String) levelSelection.getItemAt(levelSelection.getSelectedIndex()))
				.equals(STRING_TEXT.getString("beginner"))) {
			user.setNiveau("1");
		} else if (((String) levelSelection.getItemAt(levelSelection.getSelectedIndex()))
				.equals(STRING_TEXT.getString("medium"))) {
			user.setNiveau("2");
		} else if (((String) levelSelection.getItemAt(levelSelection.getSelectedIndex()))
				.equals(STRING_TEXT.getString("pro"))) {
			user.setNiveau("3");
		}

		String mail = newmailTextfield.getText();
		if (!(newnameTextfield.getText().equals(user.getName()))) {
			if ((Validator.getValidator().getUser(newnameTextfield.getText())) == null) {
				if (newnameTextfield.getText() != "") {
					if (mail.contains("@") && !(mail.equalsIgnoreCase("")) && mail.contains(".")) {

						user.setName(newnameTextfield.getText());

						user.setEmail(newmailTextfield.getText());
						Window.addToFrame(new MyProfile());
					} else {
						throw new EditProfileException(wrongMailFormat, STRING_TEXT.getString("wrong_mail_format"));
					}
				} else {
					throw new EditProfileException(userexists, STRING_TEXT.getString("no_user"));
				}
			} else {
				throw new EditProfileException(userexists, STRING_TEXT.getString("user_exists"));
			}
		} else {
			if (newnameTextfield.getText() != "") {
				if (mail.contains("@") && !(mail.equalsIgnoreCase("")) && mail.contains(".")) {

					user.setName(newnameTextfield.getText());

					user.setEmail(newmailTextfield.getText());
					Window.addToFrame(new MyProfile());
				} else {
					throw new EditProfileException(wrongMailFormat, STRING_TEXT.getString("wrong_mail_format"));
				}
			} else {
				throw new EditProfileException(userexists, STRING_TEXT.getString("no_user"));
			}
		}

	}

}
