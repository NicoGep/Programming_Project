import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import connection.Validator;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import exceptions.LoginException;
import funktionen.LoginFunction;


public class LoginTest {

	@Test
	public void testWrongName() throws LoginCredentialsException, InputException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		JTextField testUser = new JTextField("TestBenutzer123");
		JPasswordField testPass = new JPasswordField("pass");
		JLabel wrongnameLabel = new JLabel();
		JLabel wrongpasswordLabel = new JLabel();

		LoginFunction test = new LoginFunction(testUser, testPass, wrongnameLabel, wrongpasswordLabel);

		assertThrows(LoginException.class, () -> {
			test.login();
		});

	}

	@Test
	public void testWrongPassword() throws LoginCredentialsException, InputException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		JTextField testUser = new JTextField("TestBenutzer1");
		JPasswordField testPass = new JPasswordField("paß");
		JLabel wrongnameLabel = new JLabel();
		JLabel wrongpasswordLabel = new JLabel();

		LoginFunction test = new LoginFunction(testUser, testPass, wrongnameLabel, wrongpasswordLabel);

		assertThrows(LoginException.class, () -> {
			test.login();
		});

	}

}
