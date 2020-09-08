package tests;

import java.sql.ResultSet;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import funktionen.AdminFunctions;

public class Helferlein {

	public static void main(String[] args) {

		try {

			DatabaseConnection.connectDatabase();
			
			AdminFunctions.addUser("TestUser", "test");

			Benutzer.loginUser("NeuerName", "test");
			
			Benutzer.setName("TestUser");
			
			System.out.println(Benutzer.getName());
			

		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}


		try {
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

		
	}

}
