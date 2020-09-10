package tests;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import funktionen.AdminFunctions;

public class testVero {
	
	public static void main(String[] args) {
		try {
		DatabaseConnection.connectDatabase();

		
		
		DatabaseConnection.disconnectDatabase();
		}catch(DatabaseConnectException ec){
			ec.printStackTrace();
		}
	}

}
