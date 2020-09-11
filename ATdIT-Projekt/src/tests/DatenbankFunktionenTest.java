package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;

public class DatenbankFunktionenTest {
	static String name = "Test";
	static String password = "passwordTest";
	static String niveau = "Anfänger";
	static String email = "email@test.de";
	static String profilbild = "./ui/images/github_profilbild.jpg";

	@Test
	public void nameTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) {

			}
			Benutzer.loginUser(name, password);
			assertEquals(name, Benutzer.getName());
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
