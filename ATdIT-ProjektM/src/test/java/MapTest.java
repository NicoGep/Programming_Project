import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import connection.User;
import connection.Validator;
import exceptions.LoginCredentialsException;

public class MapTest {

	@Test
	public void inputRouteLengthTest() throws LoginCredentialsException, InterruptedException {
		Validator.createValidator();
		Thread.sleep(5000);
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");
		assertEquals(5, User.getLoggedUser().getRouteLength());
	}
	
	@Test
	public void inputHeightDifTest() throws InterruptedException, LoginCredentialsException {
		Validator.createValidator();
		Thread.sleep(5000);
		User.loginUser(Validator.getValidator().getUser("TestBenutzer1"), "pass");
		assertEquals(100, User.getLoggedUser().getHeightDifference());
	}
}
