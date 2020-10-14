package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.*;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.InputException;
import funktionen.AdminFunctions;

public class Benutzer_TEST {
	
	public Benutzer_TEST() {

		try {
			
			DatabaseConnection.connectDatabase();
			
			Benutzer.loginUser("Test1", "123");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void getterTest() {
		
		assertTrue(Benutzer.getName().equals("Test1"));
//		assertTrue(Benutzer.getEmail().equals(""));
		assertTrue(Benutzer.getNiveau().equals("Anfänger"));
		assertNull(Benutzer.getProfilBild());
		
	}
	
	@Test
	public void setterTest() {
		
		try {
		
			Benutzer.setName("neuerName");
			Benutzer.setEmail("a.b@c.de");
			Benutzer.setNiveau("Amateur");

			assertEquals("neuerName", Benutzer.getName());
			assertEquals("a.b@c.de", Benutzer.getEmail());
			assertEquals("Amateur", Benutzer.getNiveau());

			Benutzer.setName("Test1");
			Benutzer.setEmail("test@t.de");
			Benutzer.setNiveau("Anfänger");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void parameterTest() {
		
		try {
			
			Benutzer.updateParameter(10, 20);
			
			ResultSet set = Benutzer.getParameter();
			set.first();
			
			assertEquals(10, set.getInt("steckenlaenge"));
			assertEquals(20, set.getInt("hoehenunterschied"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void gruppenTests() {
		
		
		assertNotNull(AdminFunctions.findGroup("TestGrp"));
		
		try {
			
			Benutzer.joinGroup("TestGrp");
			
			assertTrue(Benutzer.isInGroup("TestGrp"));
			
			Benutzer.leaveGroup("TestGrp");
			
			assertFalse(Benutzer.isInGroup("TestGrp"));

		} catch (InputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		
	}
	

}
