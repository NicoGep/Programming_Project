import javax.swing.JLabel;
import javax.swing.JPasswordField;

import org.junit.jupiter.api.*;

import connection.User;
import connection.Validator;
import exceptions.ChangePasswordException;
import exceptions.LoginCredentialsException;
import funktionen.ChangePasswordFunction;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test_Philipp {
//	public boolean ab() throws ChangePasswordException, LoginCredentialsException {
//		Validator.createValidator();
//
//		JPasswordField old, newp, control;
//		JLabel sop = new JLabel();
//		sop.setVisible(false);
//		JLabel npw = new JLabel();
//		npw.setVisible(false);
//
//		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");
//
//		old = new JPasswordField("pass");
//		newp = new JPasswordField("test2");
//		control = new JPasswordField("test3");
//
//		new ChangePasswordFunction(npw, sop).changePassword(newp, control, old);
//		return npw.isVisible();
//
//	}

	@Test
	public void test1() throws LoginCredentialsException, ChangePasswordException, InterruptedException {
		Validator.createValidator();

		JPasswordField old, newp, control;
		JLabel sop = new JLabel();
		sop.setVisible(false);
		JLabel npw = new JLabel();
		npw.setVisible(false);
		Thread.sleep(5000);
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");

		old = new JPasswordField("pass");
		newp = new JPasswordField("test2");
		control = new JPasswordField("test3");

		new ChangePasswordFunction(npw, sop).changePassword(newp, control, old);
		
		
		assertTrue(npw.isVisible());
		
		
	}
}
