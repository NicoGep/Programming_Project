package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;

public class RegistrierenFunktionTest {
	static String name = "Test";
	static String password = "password";
	static String mail = "email@test.de";
	
	@Test
	public void registerTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) 
				AdminFunctions.addUser(name, password);
			DatabaseConnection.disconnectDatabase();	
	
	
			} catch (DatabaseConnectException e1) {
				e1.printStackTrace();
			} catch (InputException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		
	
		}	

	}
