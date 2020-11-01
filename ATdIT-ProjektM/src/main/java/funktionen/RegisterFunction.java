package funktionen;

import java.awt.Color;
<<<<<<< HEAD
=======
import java.util.ResourceBundle;
>>>>>>> 23f808221443bc60226e306a4b229ae5fe30dbdd

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import connection.User;
import connection.Validator;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
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

			if (Validator.getValidator().getUser(name.getText()) == null) {
				try {
					User.addNewUser(name.getText().strip(), mailTextfield.getText(), userPassword);
					User.loginUser(Validator.getValidator().getUser(name.getText().strip()), userPassword);
				} catch (InputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LoginCredentialsException e) {
					System.out.println("Test");
				}
				Window.newDraw();
				Window.addToFrame(new MenuScreen());
			} else {
				Registration.userexistsLabel.setText(STRING_TEXT.getString("user_exists"));
				Registration.userexistsLabel.setBackground(Color.WHITE);
				Registration.userexistsLabel.setForeground(Color.RED);
			}

		}
		else {
			Registration.passworddoesnotmatchLabel.setText(STRING_TEXT.getString("password_match"));
			Registration.passworddoesnotmatchLabel.setBackground(Color.WHITE);
			Registration.passworddoesnotmatchLabel.setForeground(Color.RED);
		}
	}
}
