package tests;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import funktionen.AdminFunctions;

public class testVero {
	
	public static void main(String[] args) {
		try {
		DatabaseConnection.connectDatabase();
		AdminFunctions.addUser("Test2", "egal");
		DatabaseConnection.disconnectDatabase();
		}catch(DatabaseConnectException ec){
			ec.printStackTrace();
		} catch (InputException e) {
			e.printStackTrace();
		}
	}

}
