package funktionen;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;

public class AdminFunctions {
	
	
	//------------------------------------------------------------------ Benutzer-Funktionen -----------------------------------------------------------------------
	
	private static void addUser(String name, int password) {
		
		
		if(findUser(name) == null) {
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.uTB + "(name, password) VALUES('" + name + "', '" + password + "');");
			
			System.out.println("Benutzer " + name + " hinzugef�gt.");
			
		} else {
			
			System.out.println("Benutzer existiert bereits.");
			
		}
		
		
	}
	
	public static ResultSet findUser(String name) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.uTB + " WHERE name = '" + name + "';");
		
			if(!set.first())	
				return null;
			
			return set;
			
			
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
	
	
	public static void addUser(String name, String password) throws InputException {
		
		if(name.isBlank())
			throw new InputException(4);
		if(password.isBlank())
			throw new InputException(5);
		
		
		addUser(name, encrypt(password));
	}
	
	
	public static int encrypt(String st) {
		return st.hashCode();
	}
	
	//----------------------------------------------------------- Gruppen-Funktionen ----------------------------------------------------------------------------
	
	public static ResultSet findGroup(String gruppenName) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.gTB + " WHERE gruppenname = '" + gruppenName + "';");
			
			if(!set.first())
				return null;
			
			return set;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void gruppeErstellen(String gruppenName, String niveau) throws InputException {
		
		if(findGroup(gruppenName) != null)
			throw new InputException(6);
			
		
		DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.gTB + " (gruppenname, niveau) VALUES ('" + gruppenName + "', '" + niveau + "');");
		
		System.out.println("Gruppe " + gruppenName + " wurde erstellt.");
	}
	
	public static void gruppeErstellen(String gruppenName) throws InputException {
		gruppeErstellen(gruppenName, "Anf�nger");
	}
	
	
	public static void setGroupNiveau(String neuesNiveau, String gruppenname) {
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.gTB + " SET niveau = '" + neuesNiveau + "' WHERE gruppenname = " + gruppenname + ";");
	}
	
	public static List<String> getAllGroups() {
		
		List<String> l = new LinkedList<String>();
		
		try {
			
			DatabaseConnection.connectDatabase();
		
			ResultSet set = DatabaseConnection.makeQuerry("SELECT gruppenname FROM " + DatabaseConnection.gTB + ";");
		
			while(set.next()) 
				l.add(set.getString("gruppenname"));
			
			DatabaseConnection.disconnectDatabase();

		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(l.size() == 0)
			return null;
		
		return l;
	}
	
	
	
	//-------------------------------------------------------------- Nilles ------------------------------------------------------------------------
	
//	public static String outputResultSet(ResultSet set) throws SQLException {
//		
//		String result = "";
//		
//		while(set.next()) {
//			result += set.getString("id") + " " + set.getString("name") + "\n";
//		}
//		
//		return result;
//	
//	}
		

}
