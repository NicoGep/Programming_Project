package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.engine.*;

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
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			} else {
				User.setPassword(password);
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			}
			User.loginUser(name, password);
			assertEquals(name, User.getName());
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
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			} else {
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			}
			User.loginUser(name, password);
			assertEquals(level, User.getLevel());
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
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			} else {
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			}
			User.loginUser(name, password);
			assertEquals(mail, User.getMail());
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
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			} else {
				User.setMail(mail);
				User.setLevel(level);
				User.setProfilePicture(profilepicture);
			}
			User.loginUser(name, password);
			assertEquals(profilepicture, User.getProfilePicture());
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
