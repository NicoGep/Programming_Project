package tests;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;

public class Helferlein {

	public static void main(String[] args) {

		try {

			DatabaseConnection.connectDatabase();

//			AdminFunctions.addUser("TestBenutzer", "qwertz");

			DatabaseConnection.disconnectDatabase();

		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

	}

}
