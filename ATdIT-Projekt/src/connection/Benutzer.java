package connection;

import java.sql.*;
import java.util.*;

import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;

public class Benutzer {
	
	private static Benutzer loggedUser;
	
	//-------------------------------------- WIP ---------------------------------------------------
	private int userID;
	private String name;
	private String email;
	private String niveau;
	private String profilbild;
	
	
	private Benutzer(ResultSet set) {
		Benutzer.loggedUser = this;
		
		try {
		
		userID = set.getInt("id");
		name = set.getString("name");
		email = set.getString("email");
		niveau = set.getString("niveau");
		profilbild = set.getString("profilbild");
		
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
		
		
	}
	//----------------------------------------------- Login & Logout -----------------------------------------------
	
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
		
		System.out.println("\nLogin erfolgreich! \n");
		
		new Benutzer(user);
		
		
		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			System.out.println("SQLException1");
		} catch(InputException inputE) {
			System.out.println("Da ist was richtig schief gegangen");
		}
		
	}
	
	//#################### Logout einf�gen ###################
	
	//------------------------------------------------------------ Getter ------------------------------------------------
	
	
	public static int getID() {
		return loggedUser.userID;
	}
	
	public static String getName() {
		return loggedUser.name;
	}
	
	public static String getEmail() {
		return loggedUser.email;
	}

	public static String getNiveau() {
		return loggedUser.niveau;
	}
	
	public static String getProfilBild() {
		return loggedUser.profilbild;
	}
	
	//-------------------------------------------------------------- Setter ------------------################### Bessere Eingabe-�berpr�fungen einbauen ###################
	
	public static boolean setName(String neuerName) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		if(AdminFunctions.findUser(neuerName) != null)
			throw new InputException(3);
		
		
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.uTB + " SET name = '" + neuerName + "' WHERE id = " + getID() + ";");
		loggedUser.name = neuerName;
		
		return true;
	}
	
	public static boolean setPassword(String password) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		if(password.isBlank())
			throw new InputException(5);
		
		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.uTB + " SET password = " + AdminFunctions.encrypt(password) + " WHERE id = " + getID() + ";");
			
		return true;		
	}
	

	public static boolean setEmail(String neueEmail) {
		
		if(loggedUser == null)
			return false;
		
		
		if(!neueEmail.contains("@"))		
			return false;
		
		if(!neueEmail.contains("."))
			return false;
		
		

		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.uTB + " SET email = '" + neueEmail + "' WHERE id = " + getID() + ";");
		loggedUser.email = neueEmail;
		
		return true;
	}
	

	public static boolean setNiveau(String neuesNiveau) {
		
		if(loggedUser == null)
			return false;
		
		

		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.uTB + " SET niveau = '" + neuesNiveau + "' WHERE id = " + getID() + ";");
		loggedUser.niveau = neuesNiveau;
		
		return true;
	}
	
	

	public static boolean setProfilbild(String neuesProfilbild) {
		
		if(loggedUser == null)
			return false;
		
		
		if(!neuesProfilbild.contains("/"))		
			return false;
		
		if(!neuesProfilbild.contains(".jpg") || !neuesProfilbild.contains(".png"))
			return false;
		
		

		DatabaseConnection.makeUpdate("UPDATE " + DatabaseConnection.uTB + " SET profilbild = '" + neuesProfilbild + "' WHERE id = " + getID() + ";");
		loggedUser.profilbild = neuesProfilbild;
		
		return true;
	}
	
	
	
	//------------------------------------------------------------------------------- Gruppen verwalten -------------------------------------------------------
	
	
	public static boolean joinGroup(String gruppe) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		
		
		ResultSet group = AdminFunctions.findGroup(gruppe);
		
		
		if(group == null)
			throw new InputException(7);
		
		if(isInGroup(gruppe))
			throw new InputException(8);
		
		
		try {
			
			group.first();
			
			DatabaseConnection.makeUpdate("INSERT INTO " + DatabaseConnection.connectTB + " (gruppenid, id, gruppenname) VALUES (" + group.getInt("gruppenid") + ", " + getID() + ", '" + gruppe + "');");
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean leaveGroup(String group) throws InputException {
		
		if(loggedUser == null)
			return false;
		
		
		if(!isInGroup(group))
			throw new InputException(9);
		
		//######################## Aufpassen, wenn die Spalte wieder rausgenommen wird! #######################
		DatabaseConnection.makeUpdate("DELETE FROM " + DatabaseConnection.connectTB + " WHERE gruppenname = '" + group + "' AND id = " + getID() + ";");
		
		System.out.println("Gruppe " + group + " wurde verlassen.");
		
		return true;
	}
	
	public static ResultSet getAllGroups() {
		
		if(loggedUser == null)
			return null;
		
		//###################### Evtl. noch einen Fremdschl�ssel drau� machen ####################
//		ResultSet set = DatabaseConnection.makeQuerry("SELECT " + DatabaseConnection.gTB + ".* FROM " + DatabaseConnection.gTB + " LEFT JOIN " + DatabaseConnection.connectTB + " ON " 
//						+ DatabaseConnection.gTB + ".gruppenid = " + DatabaseConnection.connectTB + ".gruppenid WHERE " + DatabaseConnection.connectTB + ".id = " + getID() + ";");
		
		ResultSet set = DatabaseConnection.makeQuerry("SELECT gruppenname FROM " + DatabaseConnection.connectTB + " WHERE id = " + getID() + ";");
		 
		
		try {
			if(!set.first())
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return set;
	}
	
	public static boolean isInGroup(String group) {	//################ Implementieren evtl. mit dem ResultSet ######################
		
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
	 * Gibt ein ResultSet mit allen Feldern die in der args-Liste stehen zur�ck
	 * 
	 * @param args Eine Aufz�hlung der gew�nschten Felder.
	 * @return Ein ResultSet mit den gew�nschten Feldern.
	 */
	public ResultSet getInfos(List<String> args) {
		
		if(args.size() == 0)
			return null;
		
		int i = 0;
		
		String querry = "" + args.get(i).strip();
		i++;
		
		while(i < args.size()) 
			querry = ", " + args.get(i++).strip();
		
		return DatabaseConnection.makeQuerry("SELECT " + querry + " FROM " + DatabaseConnection.uTB + " WHERE id = '" + userID + "';");
	}
	
	private ResultSet getAllInfos() {
		return DatabaseConnection.makeQuerry("SELECT * FROM " + DatabaseConnection.uTB + " WHERE id = '" + userID + "';");
	}

	
}
