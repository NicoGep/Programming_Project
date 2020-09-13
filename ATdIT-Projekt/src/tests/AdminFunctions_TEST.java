package tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.*;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;

public class AdminFunctions_TEST {
	
	/*
	 * In der Datenbank wurden ein Test-Benuzter angelegt.
	 * User: "Test1" mit Pw: "123"
	 * 
	 * Auﬂerdem wurde noch eine TestGruppe angelegt, 
	 * mit dem Namen: "TestGrp"
	 */

	public AdminFunctions_TEST() {

		try {
			DatabaseConnection.connectDatabase();
		} catch (DatabaseConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void findUserTest() {
		
		ResultSet set;
		set = AdminFunctions.findUser("Test1");
		
		String name;
		int pass;
		
		assertFalse(set == null);
		
		try {
			set.first();
			name = set.getString("name");
			pass = set.getInt("password");
			
			assertFalse(set.next());
			
			assertTrue(name.equals("Test1"));
			assertTrue(pass == AdminFunctions.encrypt("123"));
			
			
			set = AdminFunctions.findUser("aaa");
			
			assertTrue(set == null);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	@Test (expected = InputException.class)
	public void addUserTest1() throws InputException {
		
		AdminFunctions.addUser("any", "");
		
	}
	@Test (expected = InputException.class)
	public void addUserTest2() throws InputException {
		
		AdminFunctions.addUser("", "any");
		
	}
	@Test (expected = InputException.class)
	public void addUserTest3() throws InputException {
		
		AdminFunctions.addUser("Test", "any");
		
	}
	
	@Test 
	public void checkPasswordTest() {
		
		try {
			assertTrue(AdminFunctions.checkPassword(AdminFunctions.encrypt("123"), AdminFunctions.findUser("Test")));
		} catch (LoginCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test (expected = LoginCredentialsException.class)
	public void checkPasswordTest2() throws LoginCredentialsException {
		try {
			AdminFunctions.checkPassword(AdminFunctions.encrypt("aaa"), AdminFunctions.findUser("Test1"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void findGroupTest() {
		
		ResultSet set;
		String name;
		
		try {
			
			set = AdminFunctions.findGroup("TestGrp");
			
			assertFalse(set == null);
			
			set.first();
			
			name = set.getString("gruppenname");
			
			assertTrue(name.equals("TestGrp"));
			
			assertFalse(set.next());
			
			
			set = AdminFunctions.findGroup("aaa");
			
			assertTrue(set == null);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
