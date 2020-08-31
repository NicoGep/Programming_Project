package tests;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;

public class testVero {
	
	public static void main(String[] args) {
		try {
		DatabaseConnection.connectDatabase();
		
		DatabaseConnection.disconnectDatabase();
		}catch(DatabaseConnectException ec){
			
		}
	}

}
