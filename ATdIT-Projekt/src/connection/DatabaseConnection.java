package connection;

import java.sql.*;

import exceptions.DatabaseConnectException;

public class DatabaseConnection {
	
	private static String rootUser = "root";

//	private static final String url = "jdbc:mysql://192.168.178.27:3306/";
//	private static String rootPassword = "key";
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static String rootPassword = "";
	
	private static Connection con;
	
	public static final String stdDB = "atdit";
	
	
	public static final String uTB = "benutzer";
	public static final String gTB = "gruppen";
	public static final String connectTB = "gruppenzugehoerigkeit";
	
	public static final String tTB = "testtabelle";
	
	
	
	
	//------------------------------------------------------------------------------- Verbindung zur Datenbank ----------------------------------------------------------
	
	@SuppressWarnings("deprecation")
	public static boolean connectDatabase() throws DatabaseConnectException {
		
//		if(con != null) 
//			throw new DatabaseConnectException(true);

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, rootUser, rootPassword);	//######### NOCH ROOT CREDS ############
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
	
	//----------------------------------------------------------------------------- Direkte Querys ----------------------------------------------------------------
	
	
	public static ResultSet makeQuerry(String statement) {
		
		return makeQuerry(statement, stdDB);
		
//		try {
//			
//			Statement s = con.createStatement();
//			
//			s.execute("USE " + stdDB);
//			
//			return s.executeQuery(statement);
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("makeQuerry Exception");
//			return null;
//		}
		
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
		
		return makeUpdate(statement, stdDB);
		
//		try {
//			
//			Statement s = con.createStatement();
//			
//			s.execute("USE " + stdDB);
//			
//			return s.executeUpdate(statement);
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("makeUpdateException");
//			return 0;
//		}
		
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
	
	
	
	//-------------------------------------------------------------------- Spalte hinzufügen -------------------------------------------------------------
	
	public static void addColumn(String col, String dataType) {
		addColumn(col, dataType, " ", "NOT NULL");
	}
	
	public static void addColumn(String col, String dataType, int size) {
		addColumn(col, dataType, size, "NOT NULL");
	}
	
	public static void addColumn(String col, String dataType, int size, String arguments) {
		addColumn(col, dataType, "(" + size + ") ", arguments);
	}
	
	private static void addColumn(String col, String dataType, String size, String arguments) { //################ Eingabeprüfung einbauen #################
		
		String statement = "ALTER TABLE " + uTB + " ADD " + col + " " + dataType + size + arguments + ";";
		System.out.println(statement);
		makeUpdate(statement);
		
	}
	
	
	

	
	
	
}
