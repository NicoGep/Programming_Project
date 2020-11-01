import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import connection.User;
import connection.Validator;
import exceptions.ChangePasswordException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.ChangePasswordFunction;
import funktionen.RegisterFunction;
import screens.Registration;

public class RegistrationTest {

	@Test
	public void testUserAlreadyExists() throws LoginCredentialsException, InputException {
		Validator.createValidator();
		JTextField testUser = new JTextField("TestBenutzer2");
		JTextField testMail = new JTextField("test@beispiel.de");
		JPasswordField testPass = new JPasswordField("pass");
		JPasswordField testPassAgain = new JPasswordField("pass");

		RegisterFunction test = new RegisterFunction(testUser, testMail, testPass, testPassAgain);
		Registration.userexistsLabel = new JLabel();
		Registration.userexistsLabel.setVisible(false);

		test.register();
		assertTrue(	Registration.userexistsLabel.isVisible());
	}

}
