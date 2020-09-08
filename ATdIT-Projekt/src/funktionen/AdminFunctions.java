package funktionen;

import java.sql.*;

import connection.DatabaseConnection;
import exceptions.InputException;
import exceptions.LoginCredentialsException;

public class AdminFunctions {
	
<<<<<<< Updated upstream
	
	//------------------------------------------------------------------ Benutzer-Funktionen -----------------------------------------------------------------------
	
=======
	/**
	 * Lässt den Nutzer einen neuen Benutzer in der Datenbank anlegen
	 * @param name ist der zukünftige Name des Benutzerkontos
	 * @param password ist das verschlüsselte Passwort des Benutzerkontos
	 */
>>>>>>> Stashed changes
	private static void addUser(String name, int password) {
		
		
		if(findUser(name) == null) {
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.uTB + "(name, password) VALUES('" + name + "', '" + password + "');");
			
			System.out.println("Benutzer " + name + " hinzugefügt.");
			
		} else {
			
			System.out.println("Benutzer existiert bereits.");
			
		}
		
		
	}
	
	/**
	 * 
	 * @param name stellt den zu suchenden Namen dar
	 * @return wenn der Nutzer nach der Datenbankabfrage nicht als erster im Set steht null, wenn er als erster im Set steht, wird der Nutzer zurückgegeben
	 */
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
	
	
	/**	Prüft, ob das Password zum Benutzer passt, indem das verschlüsselte Passwort verglichen wird
	 * 
	 * @param passwordHash
	 * @param user
	 * @return
	 * @throws LoginCredentialsException
	 * @throws SQLException
	 */
	public static boolean checkPassword(int passwordHash, ResultSet user) throws LoginCredentialsException, SQLException {

		int passwordDB;
		
		user.first();
		
		passwordDB = user.getInt("password");
		
			
		
		if(!(passwordDB == passwordHash))
			throw new LoginCredentialsException(2);
		
		return true;
	}
	
<<<<<<< Updated upstream
	
	public static void addUser(String name, String password) throws InputException {
		
		if(name.isBlank())
			throw new InputException(4);
		if(password.isBlank())
			throw new InputException(5);
		
		
=======
	/** Fügt ein neues Benutzerkonto hinzu, verschlüsselt jedoch zunächst das Passwort bevor das Datenbankupdate in der obersten Funktion geschieht
	 * 
	 * @param name ist der Benutzername des Benutzerkontos
	 * @param password ist das unverschlüsselte Passwort des Benutzerkontos, was hinzugefügt werden soll.
	 */
	public static void addUser(String name, String password) {
>>>>>>> Stashed changes
		addUser(name, encrypt(password));
	}
	
	/**
	 * 
	 * @param st verschlüsselt das Passwort
	 * @return das übergebene passwort als int-Wert gehasht
	 */
	public static int encrypt(String st) {
		return st.hashCode();
	}
	
<<<<<<< Updated upstream
	//----------------------------------------------------------- Gruppen-Funktionen ----------------------------------------------------------------------------
	
	public static ResultSet findGroup(String gruppenName) {
=======
	/**
	 * 
	 * @param set 
	 * @return
	 * @throws SQLException
	 */
	public static String outputResultSet(ResultSet set) throws SQLException {
>>>>>>> Stashed changes
		
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
	
	public static void gruppeErstellen(String gruppenName) throws InputException {
		
		if(findGroup(gruppenName) != null)
			throw new InputException(6);
			
		
		DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.gTB + " (gruppenname) VALUES ('" + gruppenName + "');");
		
		System.out.println("Gruppe " + gruppenName + " wurde erstellt.");
	}
	
	public static void setGroupNiveau(String neuesNiveau, int gruppenID) {
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.gTB + " SET niveau = '" + neuesNiveau + "' WHERE gruppenid = " + gruppenID + ";");
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
