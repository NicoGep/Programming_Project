package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.User;
import connection.Validator;
import connection.DatabaseConnection;
import connection.Validator;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;
import master.Window;
import screens.ForgotPassword;
import screens.Registration;
import screens.Login;
import screens.MenuScreen;

/**
 * Class with the functions of "Login"
 * 
 * @author Group3
 *
 */
public class LoginFunction {

	private JTextField name;
	private JPasswordField password;

	private JLabel wrongnameLabel, wrongpasswordLabel;

	/**
	 * Data base is started
	 * 
	 * @param userTextfield     : String (user name)
	 * @param passwordTextfield : String (password)
	 */

	public LoginFunction(JTextField userTextfield, JPasswordField passwordPasswordfield, JLabel wrongnameLabel,
			JLabel wrongpasswordLabel) {
		name = userTextfield;
		password = passwordPasswordfield;
		this.wrongnameLabel = wrongnameLabel;
		this.wrongpasswordLabel = wrongpasswordLabel;
	}

	/**
	 * Check the login data with the database with the corresponding error message
	 * if the name / password is incorrect. Forwarding to the screens menu, forgot
	 * password and registration.
	 * 
	 */
	public void login() {
		wrongnameLabel.setText("");
		wrongpasswordLabel.setText("");
		String s = "";
		char[] c = this.password.getPassword();
		for (int i = 0; i < c.length; i++)
			s += c[i];

		try {
			User.loginUser(Validator.getValidator().getUser(name.getText().strip()), s);
		} catch (LoginCredentialsException lE) {
			switch (lE.getState()) {// Label which is shown when the user or password is wrong
			case 1:
				wrongnameLabel.setText("Benutzername falsch.");
				wrongnameLabel.setBackground(Color.WHITE);
				wrongnameLabel.setForeground(Color.RED);
				break;

			case 2:
				wrongpasswordLabel.setText("Passwort falsch.");
				wrongpasswordLabel.setBackground(Color.WHITE);
				wrongpasswordLabel.setForeground(Color.RED);
				break;

			default:
				break;
			}
			Window.newDraw();
		}
		Window.addToFrame(new MenuScreen());
	}

}
