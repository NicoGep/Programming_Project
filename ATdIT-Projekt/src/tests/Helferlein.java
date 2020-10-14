package tests;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;

public class Helferlein {

	public static void main(String[] args) {

		try {
			DatabaseConnection.connectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

		try {
		
		
			
			
			Benutzer.setMail(DatenbankFunktionenTest.mail);
			Benutzer.setLevel(DatenbankFunktionenTest.level);
			Benutzer.setProfilePicture(DatenbankFunktionenTest.profilepicture);
			
			
			
			
			
			
			
			
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
