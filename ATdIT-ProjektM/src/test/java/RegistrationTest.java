
import static org.junit.jupiter.api.Assertions.assertThrows;


import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;


import connection.Validator;

import exceptions.InputException;
import exceptions.LoginCredentialsException;
import exceptions.RegistrationException;

import funktionen.RegisterFunction;
import screens.Registration;

public class RegistrationTest {

	@Test
	public void testUserAlreadyExists() throws LoginCredentialsException, InputException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		JTextField testUser = new JTextField("TestBenutzer1");
		JTextField testMail = new JTextField("test@beispiel.de");
		JPasswordField testPass = new JPasswordField("pass");
		JPasswordField testPassAgain = new JPasswordField("pass");

		RegisterFunction test = new RegisterFunction(testUser, testMail, testPass, testPassAgain);
		
		Registration.userexistsLabel = new JLabel();
		Registration.userexistsLabel.setVisible(false);
		Registration.passworddoesnotmatchLabel = new JLabel();
		Registration.passworddoesnotmatchLabel.setVisible(false);

		assertThrows(RegistrationException.class, () -> {
			test.register();
		});

	}

	@Test
	public void testPasswordDoesNotMatch() throws LoginCredentialsException, InputException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		JTextField testUser = new JTextField("TestBenutzer1");
		JTextField testMail = new JTextField("test@beispiel.de");
		JPasswordField testPass = new JPasswordField("pass");
		JPasswordField testPassAgain = new JPasswordField("pass1");
	
		RegisterFunction test = new RegisterFunction(testUser, testMail, testPass, testPassAgain);
		
		Registration.userexistsLabel = new JLabel();
		Registration.userexistsLabel.setVisible(false);
		Registration.passworddoesnotmatchLabel = new JLabel();
		Registration.passworddoesnotmatchLabel.setVisible(false);
	
		assertThrows(RegistrationException.class, () -> {
			test.register();
		});
	
	}
}
