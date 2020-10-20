package tests;

import org.junit.*;
import connection.Benutzer;
import exceptions.LoginCredentialsException;

public class LoginTest {

	@Test (expected = LoginCredentialsException.class )
	public void testLoginCredentials() throws LoginCredentialsException {

		Benutzer.loginUser("", "");
	}
}
