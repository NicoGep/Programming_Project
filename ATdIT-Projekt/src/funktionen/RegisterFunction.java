package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import connection.User;
import connection.DatabaseConnection;
import connection.Validator;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Window;
import screens.Login;
import screens.MenuScreen;
import screens.Registration;

/**
 * Class for the function of class "Registrierung"
 * 
 * @author Group3
 *
 */

public class RegisterFunction {

	public JTextField userTextfield, mailTextfield;
	public JPasswordField passwordPasswordfield, repeatpasswordPasswordfield;

	public RegisterFunction(JTextField user, JTextField mail, JPasswordField password,
			JPasswordField repeatpassword) {
		userTextfield = user;
		mailTextfield = mail;
		passwordPasswordfield = password;
		repeatpasswordPasswordfield = repeatpassword;
	}

	/**
	 * Function back button.
	 * 
	 */

	/**
	 * Database is started. User is registered in the database with a user name and
	 * password. Corresponding error messages if the user name already exists and
	 * the password does not match.
	 */

	public void register() {

		JTextField name;

		Registration.userexistsLabel.setText("");
		Registration.passworddoesnotmatchLabel.setText("");

		String userPassword = "";
		char[] passwordLetters = passwordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			userPassword += passwordLetters[i];

		String userControlPassword = "";
		passwordLetters = repeatpasswordPasswordfield.getPassword();
		for (int i = 0; i < passwordLetters.length; i++)
			userControlPassword += passwordLetters[i];

		if (userControlPassword.equals(userPassword)) {
			name = userTextfield;

			if (AdminFunctions.findUser(name.getText()) == null) {
				try {
					User.addNewUser(name.getText(), "test@test.de", "Anf�nger", "", 10, 10, userPassword);
				} catch (InputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				User.getLoggedUser().setEmail(mailTextfield.getText());
				try {
					User.loginUser(Validator.getValidator().getUser(name.getText().strip()), userPassword);
				} catch (LoginCredentialsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				/**
				 * Database is started. User is registered in the database with a user name and
				 * password. Corresponding error messages if the user name already exists and
				 * the password does not match.
				 */

			}

		}
	}
}
