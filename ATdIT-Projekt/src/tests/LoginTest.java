package tests;

import org.junit.*;
import connection.User;
import exceptions.LoginCredentialsException;

public class LoginTest {

	@Test (expected = LoginCredentialsException.class )
	public void testLoginCredentials() throws LoginCredentialsException {

		User.loginUser("", "");
	}
}
