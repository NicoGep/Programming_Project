package connection;

import java.sql.*;
import java.util.*;

import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Fenster;

/**Benutzerklasse für Benutzerfunktionen
 * Benutzer ist ein Singleton.
 * Die Benutzerfunktionen funktionieren nur, wenn ein Benutzer eingeloggt ist.
 * 
 * 
 *
 */
public class User {
	
	private static User loggedUser;
	
	
	private int userID;
	private String name;
	private String email;
	private String niveau;
	private String profilePic;
	private int routeLength;
	private int heightDifference;
	
	
	
	
	/**Konstruktor
	 * 
	 * @param set Benutzerset, das übergeben werden muss : ResultSet
	 * @throws DatabaseConnectException 
	 */
	protected User(ResultSet set) {
		
		try {
		
			userID = set.getInt("userid");
			name = set.getString("username");
			email = set.getString("useremail");
			niveau = set.getString("userniveau");
			profilePic = set.getString("userprofilepic");
			routeLength = set.getInt("userroutelength");
			heightDifference = set.getInt("userheightdifference");
		
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
		
	}
	
	
	//----------------------------------------------- Login & Logout -----------------------------------------------
	
	
	public static void loginUser(User user, String password) throws LoginCredentialsException {
		
		if(loggedUser != null)
			logoutUser();
		
		
		Validator val = Validator.getValidator();
		
		if(!(val.checkPassword(user, password)))
			throw new LoginCredentialsException(2);
		
		
		User.loggedUser = user;
		
	}
	
	
	/**
	 * loggt den Benutzer aus
	 * @return	false, wenn kein Nutzer angemeldet ist
	 * 			true, wenn der Nutzer erfolgreich abgemeldet werden konnte
	 */
	public static void logoutUser() {
		loggedUser = null;
	}
	

	public static void addNewUser(String name, String email, String niveau, String profilePic, int routeLength, int heightDifference, String password) throws InputException {
		
		if(Validator.getValidator().getUser(name) != null)
			throw new InputException(3);
		
		String statementUserEntry = 
				"INSERT INTO " + DatabaseConnection.usersTable + 
				"(username, useremail, userniveau, userprofilepic, userroutelength, userheightdifference) "
				+ "VALUES ('" + name + "', '" + email + "', '" + niveau + "', '" + profilePic + "', '" + routeLength + "', '" + heightDifference + "');"
				;

		DatabaseConnection.makeUpdate(statementUserEntry);
		
		User temp = Validator.getValidator().getUser(name);
		
		int encr_Pass = Validator.encrypt(password);
		
		String statementPasswordEntry =
				"INSERT INTO " + DatabaseConnection.usercredentialsTable +
				"(userid, userpassword) "
				+ "VALUES ('" + temp.getID() + "', '" + encr_Pass + "');"
				;
		
		DatabaseConnection.makeUpdate(statementPasswordEntry);
		
	}
	
	
	/**
	 * Löscht das letzte Benutzer-Objekt für höhere Sicherheit
	 * 
	 */
	@Override
	protected void finalize() throws Throwable {

		this.userID = -1;
		this.name = null;
		this.email = null;
		this.niveau = null;
		this.profilePic = null;
		this.heightDifference = -1;
		this.routeLength = -1;
		
	}
	
	
	//------------------------------------------------------------ Getter ------------------------------------------------
	
	public static User getLoggedUser() {
		return User.loggedUser;
	}
	
	public boolean isInGroup(Groups group) {
		
		try {
			String statement = 
					"SELECT groupid FROM " + DatabaseConnection.users_groupsTable + " WHERE userid = '" + getID() + "';";
			
			ResultSet set = DatabaseConnection.makeQuerry(statement);
			
			while(set.next())
				if(set.getInt("groupid") == group.getGroupID())
					return true;
			
			return false;
		} catch (SQLException e) {
			return true;
		}
	}
	
	public void addToGroup(Groups group) throws InputException {
		
		if(isInGroup(group)) {
			throw new InputException(5);
		}
		
		int groupID = Validator.getValidator().getGroup(group.getGroupName()).getGroupID();
		int userID = getID();
		
		String statement = 
				"INSERT INTO " + DatabaseConnection.users_groupsTable + 
				"(userid, groupid) " +
				"VALUES ('" + userID + "', '" + groupID + "');"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
	}
	
	//------------------------------------------- Getter ---------------------------------------------
	
	public int getID() {
		return this.userID;
	}
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getNiveau() {
		return this.niveau;
	}
	public String getProfilBild() {
		return this.profilePic;
	}
	public int getRouteLength() {
		return this.routeLength;
	}
	public int getHeightDifference() {
		return this.heightDifference;
	}
	
	//---------------------------------------------------- Setter -------------------------------------------------
	
	public void setName(String name) {
		this.name = name;
		Validator.getValidator().updateUser(this);
	}
	
	public void setEmail(String email) {
		this.email = email;
		Validator.getValidator().updateUser(this);
	}
	
	public void setNiveau(String niveau) {
		this.niveau = niveau;
		Validator.getValidator().updateUser(this);
	}
	
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
		Validator.getValidator().updateUser(this);
	}
	
	public void setRouteLength(int routeLength) {
		this.routeLength = routeLength;
		Validator.getValidator().updateUser(this);
	}
	
	public void setHeightDifference(int heightDifference) {
		this.heightDifference = heightDifference;
		Validator.getValidator().updateUser(this);
	}
	
}
	