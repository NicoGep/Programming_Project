package funktionen;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import connection.User;
import connection.Validator;
import exceptions.ChangePasswordException;
import master.Window;
import screens.*;

/**
 * Class for the functions for class "ChangePassword"
 * 
 * @author Group3
 *
 */
public class ChangePasswordFunction {
	public JLabel newpassworddoesnotmatchLabel;
	public JLabel stateoldpasswordLabel;
	public JPasswordField oldpasswordPasswordfield;
	public JPasswordField newpasswordPasswordfield;
	public JPasswordField newpasswordcontrolPasswordfield;

	/**
	 * Method for the save button to control the entered data
	 * 
	 * @throws ChangePasswordException
	 * 
	 */
	public ChangePasswordFunction(JLabel newpassworddoesnotmatchLabel, JLabel stateoldpasswordLabel) {
		this.newpassworddoesnotmatchLabel = newpassworddoesnotmatchLabel;
		this.stateoldpasswordLabel = stateoldpasswordLabel;
	}

	public void changePassword(JPasswordField newpasswordfield, JPasswordField controlpasswordfield,
			JPasswordField oldpasswordfield) throws ChangePasswordException {
		oldpasswordPasswordfield = oldpasswordfield;
		newpasswordPasswordfield = newpasswordfield;
		newpasswordcontrolPasswordfield = controlpasswordfield;

		Validator val = Validator.getValidator();
		User user = User.getLoggedUser();

		newpassworddoesnotmatchLabel.setVisible(false);
		stateoldpasswordLabel.setVisible(false);

		String oldpassword = "";
		char[] passwordLetters = oldpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			oldpassword += passwordLetters[i];

		String newpassword = "";
		passwordLetters = newpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			newpassword += passwordLetters[i];

		String controlpassword = "";
		passwordLetters = newpasswordcontrolPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			controlpassword += passwordLetters[i];

		if (!val.checkPassword(user, oldpassword)) {
			if (!newpassword.equals(controlpassword)) {
				throw new ChangePasswordException(3, newpassworddoesnotmatchLabel, stateoldpasswordLabel);
			}
			throw new ChangePasswordException(2, newpassworddoesnotmatchLabel, stateoldpasswordLabel);
		}

		if (newpassword.equals(controlpassword)) {
			user.changePassword(newpassword);
			Window.addToFrame(new EditProfile());
		} else {
			throw new ChangePasswordException(1, newpassworddoesnotmatchLabel, stateoldpasswordLabel);
		}

	}
}
