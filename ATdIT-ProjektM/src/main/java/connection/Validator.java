package connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import exceptions.DatabaseConnectException;
import master.Main;
import master.Window;

public final class Validator extends Thread {
	
	
	private static Validator validatorObject;
	
	
	
	private final int testInterval = 10000;
	
	
	//------------------------------------------------------- Konstruktor ------------------------------------------------------
	
	private Validator() {
		validatorObject = this;
		this.setDaemon(true);
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		Validator.killValidator();
	}

	public static Validator getValidator() {
		return validatorObject;
	}
	
	
	
	//---------------------------------------------------- Valdation and Thread -----------------------------------------------
	
	
	public static void createValidator() {
		new Validator().start();
	}
	
	public static void killValidator() {
		if(validatorObject != null)
			validatorObject.interrupt();
		DatabaseConnection.disconnectDatabase();
		validatorObject = null;
	}
	
	
	@Override
	public void run() {
		
		try {
			DatabaseConnection.connectDatabase();
			Window.reset();
		} catch (DatabaseConnectException e) {
			Main.printError(e, "Database connection could not be initialised.");
		}
		
		
		while(!isInterrupted()) {
			
			try {
				
				if(!DatabaseConnection.testConnection()) {
					Window.showDisconnectScreen(0);
					
					DatabaseConnection.connectDatabase();
					Window.hideDisconnectScreen();
				}
				
				
				sleep(testInterval);
				
			} catch(InterruptedException e) {
				interrupt();
			} catch(DatabaseConnectException dbE) {
				
				Main.printError(dbE, "Database connection could not be established.");
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------- Methoden -----------------------------------------------------
	
	//return null if doesnt exit
	public User getUser(String name) {
		
		String statement = "SELECT * FROM " + DatabaseConnection.usersTable + " WHERE username = '" + name + "';";
		
		ResultSet set = DatabaseConnection.makeQuerry(statement);
		
		try {
			if(!set.first())
			
				return null;
			
		} catch (SQLException e) {
			Main.printError(e);
			return null;
		}
		
		return new User(set);
	}
	
	protected void deleteUser(User user) {
		
		String statement =
				"DELETE FROM " + DatabaseConnection.usersTable + " " +
				"WHERE userid = '" + user.getID() + "';"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
	}
	
	protected void updateUser(User user) {
		
		String statement = 
				"UPDATE " + DatabaseConnection.usersTable + " SET " +
				"username = '" + user.getName() + "', " +
				"useremail = '" + user.getEmail() + "', " +
				"userniveau = '" + user.getNiveau() + "', " +
				"userprofilepic = '" + user.getProfilBild() + "', " +
				"userroutelength = '" + user.getRouteLength() + "', " +
				"userheightdifference = '" + user.getHeightDifference() + "' " +
				"WHERE userid = '" + user.getID() + "';"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
	}
	
	protected void deleteGroup(Groups group) {
		
		String statement =
				"DELETE FROM " + DatabaseConnection.groupsTable + " " +
				"WHERE groupid = '" + group.getGroupID() + "';"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
	}
	
	protected void updateGroup(Groups group) {
		
		String statement = 
				"UPDATE " + DatabaseConnection.groupsTable + " SET " +
				"groupname = '" + group.getGroupName() + "', " +
				"groupniveau = '" + group.getGroupNiveau() + "' " +
				"WHERE groupid = '" + group.getGroupID() + "';"
				;
		
		DatabaseConnection.makeUpdate(statement);
		
	}
	
	
	//return null if doesnt exist
	public Groups getGroup(String name) {
		
		String statement = "SELECT * FROM " + DatabaseConnection.groupsTable + " WHERE groupname = '" + name + "';";
		
		ResultSet set = DatabaseConnection.makeQuerry(statement);
		
		try {
			if(!set.first())
				return null;
			
		} catch (SQLException e) {
			Main.printError(e);
			return null;
		}
		
		return new Groups(set);
		
	}
	
	
	public boolean checkPassword(User user, String password) {
		
		String statement = "SELECT userpassword FROM usercredentials INNER JOIN users ON users.userid = usercredentials.userid WHERE users.userid = " + user.getID() + ";";
		
		ResultSet set = DatabaseConnection.makeQuerry(statement);
		
		int encr_Pass = Validator.encrypt(password);
		
		try {
			
			if(!set.first())
				return false;
			
			if(!(set.getInt("userpassword") == encr_Pass))
				return false;
			
			return true;
			
		} catch (SQLException e) {
			Main.printError(e);
			return false;
		}
		
	}
	
	public boolean checkPassword(User user, char[] c) {
		
		String s = "";
		
		for(int i = 0; i < c.length; i++)
			s += c[i];
		
		return checkPassword(user, s);
	}

	public static int encrypt(String password) {
		return password.hashCode();
	}
	
	
}