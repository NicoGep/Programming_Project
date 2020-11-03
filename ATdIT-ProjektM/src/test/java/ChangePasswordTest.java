import javax.swing.JLabel;
import javax.swing.JPasswordField;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import connection.User;
import connection.Validator;
import exceptions.ChangePasswordException;
import exceptions.LoginCredentialsException;
import funktionen.ChangePasswordFunction;
import master.Window;

public class ChangePasswordTest {
	static Validator v;

	@BeforeAll
	public static void creation() {
		new Window();

		Validator.createValidator();
		v = Validator.getValidator();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	@Test
	public void wrongControlPasswordTest()
			throws LoginCredentialsException, ChangePasswordException, InterruptedException {
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

	@AfterAll
	public static void terminate() {
		Validator.killValidator();
		v = null;
	}

}
