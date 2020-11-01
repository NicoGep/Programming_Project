package connection;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.ErrorFrame;
import master.Window;

public final class DatabaseConnection {
	
	public enum Databases {
		wanderoo, test;
		
		public String getDatabase(Databases d) {
			switch(d) {
			case wanderoo: return "wanderoo";
			case test: return "test";
			default: return "";
			}
		}
		
	}
	
	public enum Tables {
		users, groups
	}
	
	
	
	
	private static String rootUser = "root";

	private static final String url_nico = "jdbc:mysql://192.168.178.27:3306/";
	private static String rootPassword_nico = "key";
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static String rootPassword = "";
	
	private static Connection con;
	
	
	private static final int timeOut = 15000;
	
	
	public static final String standardDatabase = "wanderoo";
	
	
	public static final String usersTable = "users";
	public static final String groupsTable = "groups";
	public static final String users_groupsTable = "users_groups";
	public static final String usercredentialsTable = "usercredentials";
	
	
	
	
	//------------------------------------------------------------------------------- Verbindung zur Datenbank ----------------------------------------------------------
	
	
	public static void connectDatabase() throws DatabaseConnectException {

		DatabaseConnection.disconnectDatabase();

		try {
			
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			if(System.getProperty("user.name").equals("nicol"))
				con = DriverManager.getConnection(url_nico, rootUser, rootPassword_nico);
			else
				con = DriverManager.getConnection(url, rootUser, rootPassword);	//######### NOCH ROOT CREDS ############
			
			
		} catch(SQLException sqlE) {
			throw new DatabaseConnectException(1);
		} catch(Exception e) {
			new ErrorFrame(e);
		}
		
		if(!DatabaseConnection.testConnection())
			throw new DatabaseConnectException(1);

		System.out.println("Database connected\n\n");
		
	}
	
	
	public static void disconnectDatabase() {
		
		try {
			if(con != null)
				con.close();
			con = null;
//			System.out.println("\n\nDatabase disconnected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static boolean testConnection() {
		
		try {
			
			if(con == null)
				return false;
			
			if(con.isValid(timeOut))
				return true;
			else
				return false;
		
		} catch(SQLException e) {
			return false;
		}
		
	}
	
	
	//----------------------------------------------------------------------------- Direkte Querys ----------------------------------------------------------------
	
	
	public static ResultSet makeQuerry(String statement) {
		return makeQuerry(statement, standardDatabase);	
	}
	
	public static ResultSet makeQuerry(String statement, String database) {      //################## Null returnen, wenn Set leer #####################
		
		try {
			
			Statement s = con.createStatement();
			
			s.execute("USE " + database);
			
			return s.executeQuery(statement);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("makeQuerry Exception");
			return null;
		}
	}
	
	
	
	
	public static int makeUpdate(String statement) {
		return makeUpdate(statement, standardDatabase);	
	}
	
	
	public static int makeUpdate(String statement, String database) {
		
		try {
			
			Statement s = con.createStatement();
			
			s.execute("USE " + database);
			
			return s.executeUpdate(statement);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("makeUpdateException");
			return 0;
		}
	}
	
	
}
