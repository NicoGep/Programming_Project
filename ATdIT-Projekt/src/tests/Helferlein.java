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
		
			

			Benutzer.loginUser("Test3", "vero");
			
			
			System.out.println(Benutzer.getParameter().getString("streckenlaenge") + " - " + Benutzer.getParameter().getString("hoehenunterschied"));
			
			Benutzer.updateParameter(20, 30);
			
			
			
			

			System.out.println(Benutzer.getParameter().getString("streckenlaenge") + " - " + Benutzer.getParameter().getString("hoehenunterschied"));
			
			
			
			
			
			
			
			
			
			
			
			
			
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
