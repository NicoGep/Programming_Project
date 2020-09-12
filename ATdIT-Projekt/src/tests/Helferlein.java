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
		
		
			
			
			Benutzer.setEmail(DatenbankFunktionenTest.email);
			Benutzer.setNiveau(DatenbankFunktionenTest.niveau);
			Benutzer.setProfilbild(DatenbankFunktionenTest.profilbild);
			
			
			
			
			
			
			
			
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
