package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.*;

import connection.User;
import connection.DatabaseConnection;
import exceptions.InputException;
import funktionen.AdminFunctions;

public class Benutzer_TEST {
	
	public Benutzer_TEST() {

		try {
			
			DatabaseConnection.connectDatabase();
			
			User.loginUser("Test1", "123");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void getterTest() {
		
		assertTrue(User.getName().equals("Test1"));
//		assertTrue(Benutzer.getEmail().equals(""));
		assertTrue(User.getLevel().equals("Anfänger"));
		assertNull(User.getProfilePicture());
		
	}
	
	@Test
	public void setterTest() {
		
		try {
		
			User.setName("neuerName");
			User.setMail("a.b@c.de");
			User.setLevel("Amateur");

			assertEquals("neuerName", User.getName());
			assertEquals("a.b@c.de", User.getMail());
			assertEquals("Amateur", User.getLevel());

			User.setName("Test1");
			User.setMail("test@t.de");
			User.setLevel("Anfänger");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void parameterTest() {
		
		try {
			
			User.updateParameter(10, 20);
			
			ResultSet set = User.getParameter();
			set.first();
			
			assertEquals(10, set.getInt("steckenlaenge"));
			assertEquals(20, set.getInt("hoehenunterschied"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void groupTests() {
		
		
		assertNotNull(AdminFunctions.findGroup("TestGrp"));
		
		try {
			
			User.joinGroup("TestGrp");
			
			assertTrue(User.isInGroup("TestGrp"));
			
			User.leaveGroup("TestGrp");
			
			assertFalse(User.isInGroup("TestGrp"));

		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		
	}
	

}
