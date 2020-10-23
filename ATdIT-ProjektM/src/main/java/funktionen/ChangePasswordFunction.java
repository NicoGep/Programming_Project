package funktionen;


import java.sql.SQLException;
import connection.User;
import connection.Validator;
import exceptions.ChangePasswordException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Window;
import screens.*;



/**
 * Class for the functions for class "ChangePassword"
 * 
 * @author Group3
 *
 */
public class ChangePasswordFunction {

	/**
	 * ActionListener for the cancel button and the save button to control the
	 * entered data
	 * 
	 * @throws ChangePasswordException
	 * 
	 */

	public static void changePassword() throws ChangePasswordException {
		Validator val = Validator.getValidator();
		User user = User.getLoggedUser();

		ChangePassword.newpassworddoesnotmatchLabel.setVisible(false);
		ChangePassword.stateoldpasswordLabel.setVisible(false);

		String oldpassword = "";
		char[] passwordLetters = ChangePassword.oldpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			oldpassword += passwordLetters[i];

		String newpassword = "";
		passwordLetters = ChangePassword.newpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			newpassword += passwordLetters[i];

		String controlpassword = "";
		passwordLetters = ChangePassword.newpasswordcontrolPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			controlpassword += passwordLetters[i];
		
		if(!val.checkPassword(user, oldpassword)) {
			if (!newpassword.equals(controlpassword)) {
				throw new ChangePasswordException(3);
			}
			throw new ChangePasswordException(2);
		}
		
		if (newpassword.equals(controlpassword)) {
			user.changePassword(newpassword);
			Window.addToFrame(new EditProfile());
		} else {
			throw new ChangePasswordException(1);
		}

	}
}
