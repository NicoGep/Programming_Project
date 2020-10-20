package tests;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import connection.Benutzer;
import connection.DatabaseConnection;
import connection.DatabaseConnection.Databases;
import connection.Validator;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;
import master.Fenster;

public class Helferlein {

	public static void main(String[] args) throws DatabaseConnectException {
		
		DatabaseConnection.connectDatabase();

		checkPassword(new Benutzer(), 1);
		
		DatabaseConnection.disconnectDatabase();
		
	}
	

	public static boolean checkPassword(Benutzer user, int encr_Pass) {
		
//		ResultSet set = DatabaseConnection.makeQuerry("SELECT userpassword FROM " + DatabaseConnection.usercredentialsTable + " INNER JOIN " + Database);
		
		String statement = "SELECT userpassword FROM usercredentials INNER JOIN users ON users.userid = usercredentials.userid WHERE users.userid = " + user.getID() + ";";
		
		ResultSet set = DatabaseConnection.makeQuerry(statement);
		
		try {
			set.first();
			
			
			
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}
