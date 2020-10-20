package funktionen;


import java.sql.SQLException;
import connection.User;
import exceptions.ChangePasswordException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Window;
import screens.*;

/**
 * Class for the functions for class "PasswortAendern"
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
		// password control with data query
		try {
			AdminFunctions.checkPassword(AdminFunctions.encrypt(oldpassword),
					AdminFunctions.findUser(User.getName()));
			if (newpassword.equals(controlpassword)) {
				User.setPassword(newpassword);
				Window.addToFrame(new EditProfile());
			} else {

				throw new ChangePasswordException(1);
			}
		} catch (LoginCredentialsException e1) {
			if (!(newpassword.equals(controlpassword))) {
				throw new ChangePasswordException(3);
			}
			throw new ChangePasswordException(2);
		} catch (SQLException e) {

		} catch (InputException e) {

		}

	}
}
