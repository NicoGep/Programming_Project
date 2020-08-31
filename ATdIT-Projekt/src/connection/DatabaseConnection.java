package connection;

import java.sql.*;

import exceptions.DatabaseConnectException;

public class DatabaseConnection {

//	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String url = "jdbc:mysql://192.168.178.27:3306/";
	private static String rootUser = "root";
	private static String rootPassword = "key";
//	private static String rootPassword = "pass";
	
	private static Connection con;
	
	private static final String stdDB = "atdit";
	
	@SuppressWarnings("deprecation")
	public static boolean connectDatabase() throws DatabaseConnectException {
		
		if(con != null) 
			throw new DatabaseConnectException(true);

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, rootUser, rootPassword);	//----------------------------- NOCH ROOT CREDS --------------------------------
			System.out.println("Database connected\n\n");
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static boolean disconnectDatabase() throws DatabaseConnectException {
		
		if(con == null) 
			throw new DatabaseConnectException(false);
		
		try {
			con.close();
			con = null;
			System.out.println("\n\nDatabase disconnected");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static ResultSet makeQuerry(String statement) {
		
		try {
			
			Statement s = con.createStatement();
			
			s.execute("USE " + stdDB);
			
			return s.executeQuery(statement);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("makeQuerry Exception");
			return null;
		}
		
	}
	
	
	public static ResultSet makeQuerry(String statement, String database) {
		
		try {
			
			Statement s = con.createStatement();
			
			s.execute("USE " + database);
			
			return s.executeQuery(statement);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static int makeUpdate(String statement) {
		
		try {
			
			Statement s = con.createStatement();
			
			s.execute("USE " + stdDB);
			
			return s.executeUpdate(statement);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public static int makeUpdate(String statement, String database) {
		
		try {
			
			Statement s = con.createStatement();
			
			s.execute("USE " + database);
			
			return s.executeUpdate(statement);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String outputSet(ResultSet set) throws SQLException {
		
		String result = "";
		
		while(set.next()) {
			result += set.getString("id") + " " + set.getString("name") + "\n";
		}
		
		return result;
	
	}
	
	
	
//	--------------------------------------------------------------- WIP -------------------------------------------
//	public static ResultSet selectQuerry(String select) {
//		
//		return null;
//	}

	
	
	
}
