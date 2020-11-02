import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import connection.User;
import connection.Validator;
import exceptions.LoginCredentialsException;
import master.Window;

public class MapTest {

static Validator v;
	
	@BeforeAll
	public static void creation() {
		Window frame = new Window();
		
		Validator.createValidator();
		v = Validator.getValidator();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}
	@Test
	public void inputRouteLengthTest() throws LoginCredentialsException {
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");
		User.getLoggedUser().setRouteLength(5);
		assertEquals((int) 5, User.getLoggedUser().getRouteLength());
	}
	
	@Test
	public void inputHeightDifTest() throws LoginCredentialsException {
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");
		User.getLoggedUser().setHeightDifference(100);
		assertEquals((int) 100, User.getLoggedUser().getHeightDifference());
	}
	
	@AfterAll
	public static void terminate() {
		Validator.killValidator();
		v = null;
	}
}
