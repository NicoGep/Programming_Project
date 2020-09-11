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
	static String email = "email@test.de";
	
	@Test
	public void registrierenTest() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.findUser(name) == null) {
				AdminFunctions.addUser();
				
	
	
	
	
	
	
}
