package funktionen;

import java.sql.*;

import connection.DatabaseConnection;
import exceptions.InputException;
import exceptions.LoginCredentialsException;

public class AdminFunctions {
	
	
	private static void addUser(String name, int password) {
		
		
		if(findUser(name) == null) {
			
			DatabaseConnection.makeUpdate("INSERT INTO benutzer(name, password) VALUES('" + name + "', '" + password + "');");
			
			System.out.println("Benutzer " + name + " hinzugefügt.");
			
		} else {
			
			System.out.println("Benutzer existiert bereits.");
			
		}
		
		
	}
	
	public static ResultSet findUser(String name) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT id, name, password FROM benutzer WHERE name = '" + name + "';");
		
			if(!set.first())	
				return null;
			
			return DatabaseConnection.makeQuerry("SELECT id, name, password FROM benutzer WHERE name = '" + name + "';");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
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
	
	
	public static String outputResultSet(ResultSet set) throws SQLException {
		
		String result = "";
		
		while(set.next()) {
			result += set.getString("id") + " " + set.getString("name") + "\n";
		}
		
		return result;
	
	}
		

}
