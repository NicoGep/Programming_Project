package connection;

import java.sql.*;

import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;

public class Benutzer {
	
	private static int loggedUserID = 1;
	private static Benutzer benutzer;
	
	//-------------------------------------- WIP ---------------------------------------------------
	public int TEMP_loggedUserID;
	public String name;
	
	
	private Benutzer() {
		Benutzer.benutzer = this;
		TEMP_loggedUserID = getID();
		name = getName();
	}
	//----------------------------------------------------------------------------------------------
	
	public static void loginUser(String name, String password) throws LoginCredentialsException {

		if(name.isBlank())
			throw new LoginCredentialsException(3);
		if(password.isBlank())
			throw new LoginCredentialsException(4);
		
		
		ResultSet user;
		
		try {
		
		user = AdminFunctions.findUser(name);
		
		
		if(!user.first()) 
			throw new LoginCredentialsException(1);
		
		if(user.next())
			throw new InputException();
		
		user.first();
		
		AdminFunctions.checkPassword(AdminFunctions.encrypt(password), user);	
		
		
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			System.out.println("SQLException1");
		} catch(InputException inputE) {
			System.out.println("Da ist was richtig schief gegangen");
		}
		
	}
	
	public static void setUserID(int key) {
		
		loggedUserID = key;
		
	}
	
	public static void unsetUserID() {
		loggedUserID = -1;
	}
	
	
	private static String abfrageString(String col) {
		
		ResultSet temp = DatabaseConnection.makeQuerry("SELECT " + col + " FROM benutzer WHERE id = '" + loggedUserID + "';");
		
		try {
		
			temp.next();
		
			return temp.getString(col);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	private static int abfrageInt(String col) {
		
		ResultSet temp = DatabaseConnection.makeQuerry("SELECT " + col + " FROM benutzer WHERE id = '" + loggedUserID + "';");
		try {
			
			temp.next();
			
			return temp.getInt(col);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public static int getID() {
		return abfrageInt("id");
	}
	
	public static String getName() {
		return abfrageString("name");
	}
	
	public static int getPassword() {
		return abfrageInt("password");
	}
	
}
