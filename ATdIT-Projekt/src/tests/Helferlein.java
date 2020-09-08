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
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

		
		
		try {
		
		
		
		ResultSet set = AdminFunctions.findGroup("TestGruppe");
		
		if(set == null)
			System.out.println("Set ist null");
		else 
			System.out.println(set.getString("gruppenname"));
			
		
		
		
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
