import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import connection.Validator;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.LoginFunction;
import screens.Login;


public class LoginTest {
	
	@Test
	public void testWrongName() throws LoginCredentialsException, InputException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		JTextField testUser = new JTextField("TestBenutzer123");
		JPasswordField testPass = new JPasswordField("pass");
		Login.wrongnameLabel = new JLabel();
		Login.wrongpasswordLabel = new JLabel();
		
		Login.wrongnameLabel.setVisible(false);
		Login.wrongpasswordLabel.setVisible(false);
		

		LoginFunction test = new LoginFunction(testUser, testPass, Login.wrongnameLabel, Login.wrongpasswordLabel);
		
		
		assertThrows(LoginCredentialsException.class, () -> {
			test.login();
		});

	}

	@Test
	public void testWrongPassword() throws LoginCredentialsException, InputException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		JTextField testUser = new JTextField("TestBenutzer1");
		JPasswordField testPass = new JPasswordField("pass123");
		Login.wrongnameLabel = new JLabel();
		Login.wrongpasswordLabel = new JLabel();
		
		Login.wrongnameLabel.setVisible(false);
		Login.wrongpasswordLabel.setVisible(false);
		
	
		LoginFunction test = new LoginFunction(testUser, testPass, Login.wrongnameLabel, Login.wrongpasswordLabel);
		
		
		assertThrows(LoginCredentialsException.class, () -> {
			test.login();
		});
	
	}

}
