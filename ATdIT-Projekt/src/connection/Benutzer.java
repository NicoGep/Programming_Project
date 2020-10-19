package connection;

import java.sql.*;
import java.util.*;

import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;


/**User class for user functions
 * User is a singleton.
 * The user functions only work when a user is logged in.
 * 
 * 
 *
 */
public class Benutzer {
	
	private static Benutzer loggedUser;
	
	//-------------------------------------- WIP ---------------------------------------------------
	private int userID;
	private String name;
	private String mail;
	private String level;
	private String profilepicture;
	
	
	/**
	 * Constructor
	 * 
	 * @param set User set that must be passed: ResultSet
	 */
	private Benutzer(ResultSet set) {
		Benutzer.loggedUser = this;
		
		try {
		
		userID = set.getInt("id");
		name = set.getString("name");
		mail = set.getString("email");
		level = set.getString("niveau");
		profilepicture = set.getString("profilbild");
		
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
		}
		
		
	}
	//----------------------------------------------- Login & Logout -----------------------------------------------
	
	/** 
	 * User login in the database
	 * 
	 * @param name Username: String
	 * @param password Password: String
	 * @throws LoginCredentialsException if the entries do not match the database data
	 */
	public static void loginUser(String name, String password) throws LoginCredentialsException {

		if(name.isBlank())
			throw new LoginCredentialsException(3);
		if(password.isBlank())
			throw new LoginCredentialsException(4);
		
		if(loggedUser != null)
			logoutUser();
		
		
		ResultSet user;
		
		try {
		
		user = AdminFunctions.findUser(name);
		
		if(user == null)
			throw new LoginCredentialsException(1);
		
		if(!user.first()) 
			throw new LoginCredentialsException(1);
		
		if(user.next())
			throw new InputException(2);
		
		user.first();
		
		AdminFunctions.checkPassword(AdminFunctions.encrypt(password), user);	
		
		System.out.println("\nLogin erfolgreich! \n");
		
		new Benutzer(user);
		
		
		} catch(SQLException sqlException) {
			sqlException.printStackTrace();
			System.out.println("SQLException1");
		} catch(InputException inputE) {
			System.out.println("Da ist was richtig schief gegangen");
		}
		
	}
	
	/**
	 * logs the user out
	 * @return false if no user is logged in
	 * true if the user was successfully logged out
	 */
	public static boolean logoutUser() {
		
		if(loggedUser == null)
			return false;
		
		loggedUser = null;
		
		return true;
	}
	

	/**
	 * Deletes the last user object for greater security
	 * 
	 */
	@Override
	protected void finalize() throws Throwable {

		this.userID = -1;
		this.name = null;
		this.mail = null;
		this.level = null;
		this.profilepicture = null;
		
	}
	
	
	//------------------------------------------------------------ Getter ------------------------------------------------
	
	/**	get method for the user ID
	 *  @return the user ID of the user: int
	 */
	public static int getID() {
		return loggedUser.userID;
	}
	
	/** get method for the name of the user
	 * 
	 * @return the name of the user
	 */
	public static String getName() {
		return loggedUser.name;
	}
	
	/** get method for the user's email address
	 * @return the user's email address: String
	 */
	public static String getMail() {
		return loggedUser.mail;
	}

	/**	get method for the level of the user
	 * 
	 * @return user level: String
	 */
	public static String getLevel() {
		return loggedUser.level;
	}
	
	/**get method for the user's profile picture
	 * @return the profile picture path: String
	 */
	public static String getProfilePicture() {
		return loggedUser.profilepicture;
	}
	
	//-------------------------------------------------------------- Setter ------------------################### Bessere Eingabe-Überprüfungen einbauen ###################
	
	/**	Method for setting the name of the user
	 * 
	 * @param newname new name: String
	 * @return
	 * @throws InputException
	 */
	public static boolean setName(String newName) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		if(AdminFunctions.findUser(newName) != null)
			throw new InputException(3);
		
		
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.userTable + " SET name = '" + newName + "' WHERE id = " + getID() + ";");
		loggedUser.name = newName;
		
		return true;
	}
	
	/** The user's password can be changed
	 * 
	 * @param password: String
	 * @return false if no user is logged in
	 * true if the database update worked
	 * @throws InputException no password was passed
	 */
	public static boolean setPassword(String password) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		if(password.isBlank())
			throw new InputException(5);
		
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.userTable + " SET password = " + AdminFunctions.encrypt(password) + " WHERE id = " + getID() + ";");
			
		return true;		
	}
	
	
	/** Method for setting the user's email address
	 * 
	 * @param newEmail: String
	 * @return false if no user could be found, the email address no @ or no. owns
	 * true if the database update worked properly
	 */
	public static boolean setMail(String newMail) {
		
		if(loggedUser == null)
			return false;
		
		
		if(!newMail.contains("@"))		
			return false;
		
		if(!newMail.contains("."))
			return false;
		
		

		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.userTable + " SET email = '" + newMail + "' WHERE id = " + getID() + ";");
		loggedUser.mail = newMail;
		
		return true;
	}
	
	/** Method of setting the user's level
	 * 
	 * @param new level: String
	 * @return false if no user is logged in
	 * true if the database update worked properly
	 */
	public static boolean setLevel(String newLevel) {
		
		if(loggedUser == null)
			return false;
		
		

		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.userTable + " SET niveau = '" + newLevel + "' WHERE id = " + getID() + ";");
		loggedUser.level = newLevel;
		
		return true;
	}
	
	
	/** Defines a new profile picture for the user
	 * 
	 * @param new profile picture File path for the picture to be used: String
	 * @return true, if the profile picture could be set
	 * false if the profile picture could not be set
	 */
	public static boolean setProfilePicture(String newProfilepicture) {
		
		if(loggedUser == null)
			return false;
		
		

		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.userTable + " SET profilbild = '" + newProfilepicture + "' WHERE id = " + getID() + ";");
		loggedUser.profilepicture = newProfilepicture;
		
		return true;
	}
	
	
	//--------------------------------------------------------------------------------- Parameter ------------------------------------------------------------
	
	/** Method to find the parameters route length and altitude for the right user
	 * 
	 * @return false if no user is logged in
	 * true if the database update could be carried out correctly
	 */
	public static ResultSet getParameter() {
		
		if(loggedUser == null)
			return null;
		
		
		ResultSet set = DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.parameterTable + " WHERE userid = " + getID() + ";");
		
		
		try {
			
			if(!set.first())
				return null;
			
			
			return set;			
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * Method for changing the parameters route length and altitude
	 * @param strackenL: int (path length)
	 * @param hoehenU: int (altitude difference)
	 * @return false if no user is logged in
	 * true if the database update could be carried out correctly
	 * @throws InputException if the parameters are unrealistic
	 */
	public static boolean updateParameter(int routeLength, int heightDifference) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		
		if(routeLength < 0 || heightDifference < 0)
			throw new InputException(10);
		
		
		if(getParameter() == null) {
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.parameterTable + " (userid, streckenlaenge, hoehenunterschied) VALUES (" + getID() + ", " + routeLength + ", " + heightDifference + ");");
			System.out.println("Parameter hinzugefügt.");
			return true;
		} else {
			
			DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.parameterTable + " SET streckenlaenge = " + routeLength + ", hoehenunterschied = " + heightDifference + " WHERE userid = " + getID() + ";");
			System.out.println("Parameter aktualisiert.");
			return true;
		}
		
	}
	
	
	
	//------------------------------------------------------------------------------- Gruppen verwalten -------------------------------------------------------
	
	/**	Function to join a group.
	 * 
	 * @param group group name
	 * @return true if the group could be joined
	 * false if the group could not be joined
	 * @throws InputException if invalid data was entered
	 */
	public static boolean joinGroup(String group) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		
		
		ResultSet group1 = AdminFunctions.findGroup(group);
		
		
		if(group1 == null)
			throw new InputException(7);
		
		if(isInGroup(group))
			throw new InputException(8);
		
		
		try {
			
			group1.first();
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.groupmembershipTable + " (gruppenid, id, gruppenname) VALUES (" + group1.getInt("gruppenid") + ", " + getID() + ", '" + group + "');");
			
			return true;
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			return false;
		}
		
	}
	
	
	/**	
	 * Function to leave a group
	 * 
	 * @param group group name
	 * @return true if the group could be left
	 * false if the group could not be left
	 * @throws InputException in the case of invalid inputs
	 */
	public static boolean leaveGroup(String group) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		
		if(!isInGroup(group))
			throw new InputException(9);
		
		//########################Be careful when the column is taken out again! #######################
		DatabaseConnection.makeUpdate("DELETE FROM " + DatabaseConnection.groupmembershipTable + " WHERE gruppenname = '" + group + "' AND id = " + getID() + ";");
		
		System.out.println("Gruppe " + group + " wurde verlassen.");
		
		return true;
	}
	
	public static ResultSet getAllGroups() {
		
		if(loggedUser == null)
			return null;
		
		//###################### Possibly. make another foreign key out ####################
//		ResultSet set = DatabaseConnection.makeQuerry("SELECT " + DatabaseConnection.gTB + ".* FROM " + DatabaseConnection.gTB + " LEFT JOIN " + DatabaseConnection.connectTB + " ON " 
//						+ DatabaseConnection.gTB + ".gruppenid = " + DatabaseConnection.connectTB + ".gruppenid WHERE " + DatabaseConnection.connectTB + ".id = " + getID() + ";");
		
		ResultSet set = DatabaseConnection.makeQuerry("SELECT gruppenname FROM " + DatabaseConnection.groupmembershipTable + " WHERE id = " + getID() + ";");
		 
		
		try {
			if(!set.first())
				return null;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		
		return set;
	}
	
	/** 
	 * Check whether the user is already in the group
	 * 
	 * @param group group name
	 * @return true if the user is already in the group
	 * false if the user is not in the group
	 */
	public static boolean isInGroup(String group) {	//################ Implement possibly ResultSet ######################
		
		if(loggedUser == null)
			return false;
		
		
		ResultSet groups = getAllGroups();
		
		if(groups == null)
			return false;
		
		try {
			groups.beforeFirst();
			while(groups.next()) {
				if(groups.getString("gruppenname").equals(group))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	//--------------------------------------------------------------------------------- Nilles -----------------------------------------------------------------
	
	/**
	 * Returns a ResultSet with all fields in the args list
	 * 
	 * @param args A list of the required fields.
	 * @return A ResultSet with the required fields.
	 */
	public ResultSet getInfos(List<String> args) {
		
		if(args.size() == 0)
			return null;
		
		int i = 0;
		
		String querry = "" + args.get(i).strip();
		i++;
		
		while(i < args.size()) 
			querry = ", " + args.get(i++).strip();
		
		return DatabaseConnection.makeQuerry("SELECT " + querry + " FROM " + DatabaseConnection.userTable+ " WHERE id = '" + userID + "';");
	}
	
	private ResultSet getAllInfos() {
		return DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.userTable + " WHERE id = '" + userID + "';");
	}

	
}
