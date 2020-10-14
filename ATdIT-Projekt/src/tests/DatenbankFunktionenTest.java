package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import connection.*;
import exceptions.*;
import funktionen.*;

public class DatenbankFunktionenTest {
	static String name = "Test";
	static String password = "passwordTest";
	static String level = "Anfänger";
	static String mail = "email@test.de";
	static String profilepicture = "./ui/images/github_profilbild.jpg";

	@Test
	public void nameTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) {
				AdminFunctions.addUser(name, password);
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			} else {
				Benutzer.setPassword(password);
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
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
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void levelTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) {
				AdminFunctions.addUser(name, password);
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			} else {
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			}
			Benutzer.loginUser(name, password);
			assertEquals(level, Benutzer.getLevel());
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void mailTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) {
				AdminFunctions.addUser(name, password);
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			} else {
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			}
			Benutzer.loginUser(name, password);
			assertEquals(mail, Benutzer.getMail());
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void profilepictureTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) {
				AdminFunctions.addUser(name, password);
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			} else {
				Benutzer.setMail(mail);
				Benutzer.setLevel(level);
				Benutzer.setProfilePicture(profilepicture);
			}
			Benutzer.loginUser(name, password);
			assertEquals(profilepicture, Benutzer.getProfilePicture());
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = DatabaseConnectException.class)
	public void databaseConnectExceptionTest() throws DatabaseConnectException {
		DatabaseConnection.disconnectDatabase();
	}
}
