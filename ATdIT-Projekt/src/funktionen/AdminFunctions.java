package funktionen;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import connection.DatabaseConnection;

import exceptions.InputException;
import exceptions.LoginCredentialsException;

/** class with methods that are used in other classes, no methods included that are directly for the user
 * 
 *
 */
public class AdminFunctions {
	
	
	//------------------------------------------------------------------ user functions -----------------------------------------------------------------------
	
	/**	method does a data base update and add new user with the corresponding password
	 * 
	 * @param name : String (user name)
	 * @param password : String  (password as hash value)
	 */
	static boolean addUser(String name, int password) {
		
		
		if(findUser(name) == null) {
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.userTable + "(name, password) VALUES('" + name + "', '" + password + "');");
			
			System.out.println("Benutzer " + name + " hinzugefügt.");
			
			return true;
			
		} else {
			
			System.out.println("Benutzer existiert bereits.");
			
			return false;
		}
		
		
	}
	
	/**	Method to find a user through his user name
	 * 
	 * @param name (user name)
	 * @return null , if the user name cannot be found
	 * 		   set, if the user is found, the filled set with the user is returned
	 */
	public static ResultSet findUser(String name) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.userTable + " WHERE name = '" + name + "';");
		
			if(!set.first())	
				return null;
			
			return set;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	/**	checks whether the password matches the respective user
	 * 
	 * 
	 * @param passwordHash : int	(hashed password)
	 * @param user : ResultSet	(user)
	 * @return	true, if the user matches to the password
	 * @throws LoginCredentialsException, if the password does not match with the passwort in the database
	 * @throws SQLException, if the sql query is incorrect
	 */
	public static boolean checkPassword(int passwordHash, ResultSet user) throws LoginCredentialsException, SQLException {

		int passwordDB;
		
		user.first();
		
		passwordDB = user.getInt("password");
		
			
		
		if(!(passwordDB == passwordHash))
			throw new LoginCredentialsException(2);
		
		return true;
	}
	
	/** Converts the password into a hash value so that the password is not completely unprotected in the database
	 * 
	 * @param name user name
	 * @param password (String)
	 * @throws InputException if no data has been entered
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
	 * encrypts an input string
	 * (for passwords)
	 * 
	 * @param passwordString
	 * @return
	 */
	public static int encrypt(String passwordString) {
		return passwordString.hashCode();
	}
	
	/**
	 * encrypt an input char-Array
	 * (for password)
	 * 
	 * @param passwordCharArray
	 * @return
	 */
	public static int encrypt(char[] passwordCharArray) {
		String s = "";
		
		for(int i = 0; i < passwordCharArray.length; i++)
			s += passwordCharArray[i];
		
		return encrypt(s);
	}
	
	//----------------------------------------------------------- group functions ----------------------------------------------------------------------------
	
	
	/**
	 * Searches for the desired group in the database.
	 * Returns null if it doesn't exist
	 * 
	 * @param groupName
	 * @return a ResultSet of the searched group(s)
	 */
	public static ResultSet findGroup(String groupName) {
		
		try {
			
			ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.groupTable + " WHERE gruppenname = '" + groupName + "';");
			
			if(!set.first())
				return null;
			
			return set;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/** Method for creating a group and registering it in the database
	 * 
	 * @param groupnName : String (name of the group)
	 * @param level : String (level of the user)
	 * @throws InputException wrong input
	 */
	public static void createGroup(String groupName, String level) throws InputException {
		
		if(findGroup(groupName) != null)
			throw new InputException(6);
			
		
		DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.groupTable + " (gruppenname, niveau) VALUES ('" + groupName + "', '" + level + "');");
		
		System.out.println("Gruppe " + groupName + " wurde erstellt.");
	}
	
	public static void createGroup(String groupName) throws InputException {
		createGroup(groupName, "Anfänger");
	}
	
	
	public static void setGroupLevel(String newLevel, String groupName) {
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.groupTable + " SET niveau = '" + newLevel + "' WHERE gruppenname = " + groupName + ";");
	}
	
	
	/**	Returns all groups
	 * 
	 * @return null, if no user could be found in the set
	 * 			set, if user can be found
	 */
	public static ResultSet getAllGroups() {
		
		ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.groupTable + ";");
		
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
	
	/** Method to convert a set into a list
	 * 
	 * @param set : ResultSet (user set)
	 * @param columnName : String (column name)
	 * @return null, if no set could be found
	 * 		   list, if the set could be converted
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
