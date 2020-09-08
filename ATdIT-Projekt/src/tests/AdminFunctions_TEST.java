package tests;

import java.sql.ResultSet;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import funktionen.AdminFunctions;

public class AdminFunctions_TEST {
	
	public static void main(String[] args) {
		
		try {
			DatabaseConnection.connectDatabase();

			ResultSet set = AdminFunctions.findUser("root");

			if (set == null)
				System.out.println("Das Set ist null");

			set = AdminFunctions.findUser("test");

			if (set == null)
				System.out.println("Das andere Set ist null");

			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}
		
	}

}
