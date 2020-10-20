package funktionen;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;

/** Klasse mit Methoden, die in anderen Klassen aufgerufen werden, keine Methoden direkt f�r den Benutzer
 * 
 *
 */
public class AdminFunctions {
	
	
	//------------------------------------------------------------------ Benutzer-Funktionen -----------------------------------------------------------------------
	
	/**	Updatet die Datenbank und f�gt einen neuen Benutzer mit dem dazugeh�rigen Passwort hinzu
	 * 
	 * @param name : String (Benutzername des Nutzers)
	 * @param password : String  (Passwort als Hash-Wert)
	 */
	static boolean addUser(String name, int password) {
		
		
		if(findUser(name) == null) {
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.usersTable + "(name, password) VALUES('" + name + "', '" + password + "');");
			
			System.out.println("Benutzer " + name + " hinzugef�gt.");
			
			return true;
			
		} else {
			
			System.out.println("Benutzer existiert bereits.");
			
			return false;
		}
		
		
	}
	
	/**	Methode zum finden eines Benutzers anhand seines Benutzernamens
	 * 
	 * @param name Benutzername
	 * @return null , im Falle, falls der Benutzer nicht gefunden
	 * 		   set, falls, der Benutzer gefinden wird, wird das gef�llte set mit dem Benutzer zur�ckgegeben
	 */
	public static ResultSet findUser(String name) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.usersTable + " WHERE name = '" + name + "';");
		
			if(!set.first())	
				return null;
			
			return set;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/**	kontrolliert, ob das Passwort mit dem jeweiligen Benutzer �bereinstimmt
	 * 
	 * @param passwordHash : int	gehashtes Passwort
	 * @param user : ResultSet	Benutzer
	 * @return	true, wenn das Passwort zum Benutzer passt
	 * @throws LoginCredentialsException wird geworfen, falls das Passwort mit dem Passwort von der Datenbank �bereinstimmt
	 * @throws SQLException wird geworfen, falls die SQL-Abfrage inkorrekt ist
	 */
	public static boolean checkPassword(int passwordHash, ResultSet user) throws LoginCredentialsException, SQLException {

		int passwordDB;
		
		user.first();
		
		passwordDB = user.getInt("password");
		
			
		
		if(!(passwordDB == passwordHash))
			throw new LoginCredentialsException(2);
		
		return true;
	}
	
	/** Wandelt das Passwort in einen Hash-Wert um, damit das Passwort nicht V�LLIG ungesch�tzt auf der Datenbank liegt
	 * 
	 * @param name Benutzername des Nutzers
	 * @param password wird hier als String eingegeben
	 * @throws InputException falls keine Daten eingegeben wurden
	 */
	public static void addUser(String name, String password) throws InputException {
		
		if(name.isBlank())
			throw new InputException(4);
		if(password.isBlank())
			throw new InputException(5);
		
		
		if(addUser(name, encrypt(password)) == false)
			throw new InputException(3);
	}
	
	/**
	 * Verschl�sselt einen Input-String. 
	 * (F�r Passwort gedacht)
	 * 
	 * @param st
	 * @return
	 */
	public static int encrypt(String st) {
		return st.hashCode();
	}
	
	/**
	 * Verschl�sselt einen Input-char-Array
	 * (F�r Passwort gedacht)
	 * 
	 * @param c
	 * @return
	 */
	public static int encrypt(char[] c) {
		String s = "";
		
		for(int i = 0; i < c.length; i++)
			s += c[i];
		
		return encrypt(s);
	}
	
	//----------------------------------------------------------- Gruppen-Funktionen ----------------------------------------------------------------------------
	
	
	/**
	 * Sucht die gew�nschte Gruppe in der Datenbank.
	 * Gibt null zur�ck, wenn sie nicht existiert.
	 * 
	 * @param gruppenName
	 * @return Ein ResultSet der gesuchten Gruppe(n)
	 */
	public static ResultSet findGroup(String gruppenName) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.groupsTable + " WHERE gruppenname = '" + gruppenName + "';");
			
			if(!set.first())
				return null;
			
			return set;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/** Methode um eine Gruppe zu erstellen und diese auf der Datenbank zu registrieren
	 * 
	 * @param gruppenName : String (Name der Gruppe)
	 * @param niveau : String (Niveau des Benutzers)
	 * @throws InputException Falsche Eingaben
	 */
	public static void gruppeErstellen(String gruppenName, String niveau) throws InputException {
		
		if(findGroup(gruppenName) != null)
			throw new InputException(6);
			
		
		DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.groupsTable + " (gruppenname, niveau) VALUES ('" + gruppenName + "', '" + niveau + "');");
		
		System.out.println("Gruppe " + gruppenName + " wurde erstellt.");
	}
	
	public static void gruppeErstellen(String gruppenName) throws InputException {
		gruppeErstellen(gruppenName, "Anf�nger");
	}
	
	
	public static void setGroupNiveau(String neuesNiveau, String gruppenname) {
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.groupsTable + " SET niveau = '" + neuesNiveau + "' WHERE gruppenname = " + gruppenname + ";");
	}
	
	
	/**	Gibt alle Gruppen zur�ck
	 * 
	 * @return null, wenn kein Benutzer im Set gefunden werden konnte
	 * 			set, wenn Benutzer gefunden wurden
	 */
	public static ResultSet getAllGroups() {
		
		ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.groupsTable + ";");
		
		try {
			
			if(!set.first())
				return null;
			
			return set;			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	//-------------------------------------------------------------- Misc ------------------------------------------------------------------------
	
	/** Methode um ein Set in eine Liste umzuwandeln
	 * 
	 * @param set : ResultSet (Benutzer-Set)
	 * @param columnName : String (Column-Name)
	 * @return null, wenn kein Set gefunden werden konnte
	 * 			list, wenn das Set umgewandelt werden konnte
	 */
	public static List<String> setToList(ResultSet set, String columnName) {
		
		List<String> list = new LinkedList<String>();
		
		try {
			
			if(set == null)
				return null;
			
			if(!set.first())
				return null;
		
			set.beforeFirst();
		
			while(set.next()) {
			
				list.add(set.getString(columnName));
				
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
