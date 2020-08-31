package funktionen;

import java.sql.*;

import connection.DatabaseConnection;
import exceptions.LoginCredentialsException;

public class AdminFunctions {
	
	
	public static void addUser(String name, int password) {
		
		DatabaseConnection.makeUpdate("INSERT INTO benutzer(name, password) VALUES('" + name + "', '" + password + "');");
		
	}
	
	public static ResultSet findUser(String name) throws LoginCredentialsException {
		
		ResultSet set = DatabaseConnection.makeQuerry("SELECT id, name, password FROM benutzer WHERE name = '" + name + "';");
		
		try {
			
			if(!set.first())
				throw new LoginCredentialsException(1);
			
			return set;
			
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
		
	}
	
//	<classpathentry kind="lib" path="C:/Users/nicol/Documents/Workspace/GitHub/ATdIT-Projekt/Programming_Project/ATdIT-Projekt/lib/mysql-connector-java-5.1.49.jar"/>
	
	public static boolean checkPassword(int passwordHash, ResultSet user) throws LoginCredentialsException, SQLException {

		int passwordDB;
		
		user.first();
		
		passwordDB = user.getInt("password");
		
			
		
		if(!(passwordDB == passwordHash))
			throw new LoginCredentialsException(2);
		
		return true;
	}
	
	
	public static void addUser(String name, String password) {
		addUser(name, encrypt(password));
	}
	
	
	public static int encrypt(String st) {
		return st.hashCode();
	}
		

}
