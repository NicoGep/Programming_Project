package connection;

import java.sql.*;
import java.util.*;

import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;

public class Benutzer {
	
	private static Benutzer loggedUser;
	
	//-------------------------------------- WIP ---------------------------------------------------
	public int userID;
	public String name;
	
	
	private Benutzer() {
		Benutzer.loggedUser = this;
		
		try {
		
		ResultSet set = getAllInfos();
		
		userID = set.getInt("id");
		name = set.getString("name");
		
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
		
		
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
		
		if(user == null)
			throw new LoginCredentialsException(1);
		
		if(!user.first()) 
			throw new LoginCredentialsException(1);
		
		if(user.next())
			throw new InputException(2);
		
		user.first();
		
		AdminFunctions.checkPassword(AdminFunctions.encrypt(password), user);	
		
		
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			System.out.println("SQLException1");
		} catch(InputException inputE) {
			System.out.println("Da ist was richtig schief gegangen");
		}
		
	}
	
	/**
	 * Gibt ein ResultSet mit allen Feldern die in der args-Liste stehen zurück
	 * 
	 * @param args Eine Aufzählung der gewünschten Felder.
	 * @return Ein ResultSet mit den gewünschten Feldern.
	 */
	public ResultSet getInfos(List<String> args) {
		
		if(args.size() == 0)
			return null;
		
		int i = 0;
		
		String querry = "" + args.get(i).strip();
		i++;
		
		while(i < args.size()) 
			querry = ", " + args.get(i++).strip();
		
		return DatabaseConnection.makeQuerry("SELECT " + querry + " FROM benutzer WHERE id = '" + userID + "';");
	}
	
	private ResultSet getAllInfos() {
		return DatabaseConnection.makeQuerry("SELECT * FROM benutzer WHERE id = '" + userID + "';");
	}
	
//	private static String abfrageString(String col) {
//		
//		ResultSet temp = DatabaseConnection.makeQuerry("SELECT " + col + " FROM benutzer WHERE id = '" + loggedUserID + "';");
//		
//		try {
//		
//			temp.next();
//		
//			return temp.getString(col);
//		} catch(SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//	
//	private static int abfrageInt(String col) {
//		
//		ResultSet temp = DatabaseConnection.makeQuerry("SELECT " + col + " FROM benutzer WHERE id = '" + loggedUserID + "';");
//		try {
//			
//			temp.next();
//			
//			return temp.getInt(col);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return -1;
//		}
//		
//	}
//	
//	public static int getID() {
//		return abfrageInt("id");
//	}
//	
//	public static String getName() {
//		return abfrageString("name");
//	}
//	
//	public static int getPassword() {
//		return abfrageInt("password");
//	}
	
}
