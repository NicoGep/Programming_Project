import javax.swing.JLabel;
import javax.swing.JPasswordField;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import connection.User;
import connection.Validator;
import exceptions.ChangePasswordException;
import exceptions.LoginCredentialsException;
import funktionen.ChangePasswordFunction;

public class ChangePasswordTest {

	@Test
	public void wrongControlPasswordTest() throws LoginCredentialsException, ChangePasswordException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");

		JPasswordField old, newp, control;
		JLabel sop = new JLabel();
		JLabel npw = new JLabel();

		old = new JPasswordField("pass");
		newp = new JPasswordField("test");
		control = new JPasswordField("tets");
		
		assertThrows(ChangePasswordException.class, () -> {
			new ChangePasswordFunction(npw, sop).changePassword(newp, control, old);
		});
		
	}
	
	@Test
	public void wrongOldPasswordTest() throws LoginCredentialsException, ChangePasswordException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");

		JPasswordField old, newp, control;
		JLabel sop = new JLabel();
		JLabel npw = new JLabel();

		old = new JPasswordField("paß");
		newp = new JPasswordField("test");
		control = new JPasswordField("test");
		
		assertThrows(ChangePasswordException.class, () -> {
			new ChangePasswordFunction(npw, sop).changePassword(newp, control, old);
		});

	}
	
}
