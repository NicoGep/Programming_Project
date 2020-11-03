package funktionen;

import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import connection.User;
import connection.Validator;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import exceptions.RegistrationException;
import master.Main;
import master.Window;
import screens.MenuScreen;
import screens.Registration;

/**
 * Class for the function of class "Registration"
 * 
 * @author Group3
 *
 */

public class RegisterFunction {

	public JTextField userTextfield, mailTextfield;
	public JPasswordField passwordPasswordfield, repeatpasswordPasswordfield;
	public JLabel passworddoesnotmatchLabel, userexistsLabel;
	private final ResourceBundle STRING_TEXT;

	public RegisterFunction(JTextField user, JTextField mail, JPasswordField password, JPasswordField repeatpassword) {
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/Funktionen/RegisterFunction/registerfunction");
		userTextfield = user;
		mailTextfield = mail;
		passwordPasswordfield = password;
		repeatpasswordPasswordfield = repeatpassword;

	}

	/**
	 * Database is started. User is registered in the database with a user name and
	 * password. Corresponding error messages if the user name already exists and
	 * the password does not match.
	 * 
	 * @throws RegistrationException
	 */

	public void register() throws RegistrationException {

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

			if ((Validator.getValidator().getUser(name.getText())) == null) {
				try {
					String mail = mailTextfield.getText();
					if (mail.contains("@") && !(mail.equalsIgnoreCase("")) && mail.contains(".")) {
						User.addNewUser(name.getText().strip(), mailTextfield.getText(), userPassword);
						User.loginUser(Validator.getValidator().getUser(name.getText().strip()), userPassword);
					}
					else {
						throw new RegistrationException(1, STRING_TEXT.getString("wrong_mail_format"));
					}
				} catch (InputException e) {
					// TODO Auto-generated catch block
					Main.printError(e);
				} catch (LoginCredentialsException e) {
					System.out.println("Test");
				}
				Window.newDraw();
				Window.addToFrame(new MenuScreen());
			} else {
				throw new RegistrationException(1, STRING_TEXT.getString("user_exists"));

			}

		} else {
			throw new RegistrationException(2, STRING_TEXT.getString("password_match"));
		}
	}
}
