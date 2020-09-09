package tests;

import java.sql.ResultSet;

import javax.swing.JPanel;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import funktionen.AdminFunctions;
import master.Body;

public class Helferlein {

	public static void main(String[] args) {

		try {
			DatabaseConnection.connectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

		try {
		
		

//			Benutzer.loginUser("Test", "key");
//			
//			Benutzer.updateParameter(15, 55);
			
			
			JPanel b = new Body();
			
			
			System.out.println(b.getClass());
			
			
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

		
	}

}
