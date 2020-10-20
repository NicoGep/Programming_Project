package funktionen;


import java.sql.SQLException;
import connection.Benutzer;
import exceptions.ChangePasswordException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Fenster;
import screens.*;

/**
 * Class for the functions for class "PasswortAendern"
 * 
 * @author Group3
 *
 */
public class FunktionPasswortAendern {

	/**
	 * ActionListener for the cancel button and the save button to control the
	 * entered data
	 * 
	 * @throws ChangePasswordException
	 * 
	 */

	public static void changePassword() throws ChangePasswordException {

		PasswortAendern.newpassworddoesnotmatchLabel.setVisible(false);
		PasswortAendern.stateoldpasswordLabel.setVisible(false);

		String oldpassword = "";
		char[] passwordLetters = PasswortAendern.oldpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			oldpassword += passwordLetters[i];

		String newpassword = "";
		passwordLetters = PasswortAendern.newpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			newpassword += passwordLetters[i];

		String controlpassword = "";
		passwordLetters = PasswortAendern.newpasswordcontrolPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			controlpassword += passwordLetters[i];
		// password control with data query
		try {
			AdminFunctions.checkPassword(AdminFunctions.encrypt(oldpassword),
					AdminFunctions.findUser(Benutzer.getName()));
			if (newpassword.equals(controlpassword)) {
				Benutzer.setPassword(newpassword);
				Fenster.addToFrame(new ProfilBearbeiten());
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
