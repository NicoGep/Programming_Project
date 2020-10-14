package connection;

import java.sql.*;

import exceptions.DatabaseConnectException;

public class DatabaseConnection {
	
	private static String rootUser = "root";

//	private static final String url = "jdbc:mysql://192.168.178.27:3306/";
//	private static String rootPassword = "key";
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static String rootPassword = "";
	
	private static Connection connection;
	
	public static final String database = "atdit";
	
	
	public static final String userTable = "benutzer";
	public static final String groupTable = "gruppen";
	public static final String groupmembershipTable = "gruppenzugehoerigkeit";
	public static final String parameterTable = "parameter";
	
	public static final String testTable = "testtabelle";
	
	
	
	
	//------------------------------------------------------------------------------- Verbindung zur Datenbank ----------------------------------------------------------
	
	/**
	 * Establishes a connection to the SQL database.
	 *  @return true if connection was successful
	 *  @throws DatabaseConnectException
	 */
	@SuppressWarnings("deprecation")
	public static boolean connectDatabase() throws DatabaseConnectException {
		
		if(connection != null) 
			throw new DatabaseConnectException(3);

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, rootUser, rootPassword);	//######### NOCH ROOT CREDS ############
			
			if(connection == null)
				throw new DatabaseConnectException(1);

			System.out.println("Database connected\n\n");
			
			return true;
			
		} catch(Exception exception) {
//			e.printStackTrace();
			throw new DatabaseConnectException(1);
		}
		
	}
	
	/**
	 *Disconnects the current connection to the database
	 *@return true if the separation was successful
	 *@throws DatabaseConnectException
	 */
	public static boolean disconnectDatabase() throws DatabaseConnectException {
		
		if(connection == null) 
			throw new DatabaseConnectException(4);
		
		try {
			connection.close();
			connection = null;
			System.out.println("\n\nDatabase disconnected");
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new DatabaseConnectException(2);
		}
		
	}
	
	//----------------------------------------------------------------------------- Direkte Querys ----------------------------------------------------------------
	
	/**
	 * Simple database query. Execution of a query on the server.
	 * (All select queries, etc. are allowed)
	 * 
	 * @param statement
	 * @return The result relation as a ResultSet
	 */
	public static ResultSet makeQuerry(String statement) {
		return makeQuerry(statement, database);	
	}
	
	/**
	 *Simple database query. Execution of a query on the server.
	 *(All select queries, etc. are allowed)
	 * @param statement
	 * @return The result relation as a ResultSet
	 */
	public static ResultSet makeQuerry(String statement, String database) {      //################## Null returnen, if Set empty #####################
		
		try {
			
			Statement state = connection.createStatement();
			
			state.execute("USE " + database);
			
			return state.executeQuery(statement);
			
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			System.out.println("makeQuerry Exception");
			return null;
		}
	}
	
	/**
	 * Simple data manipulation query.
	 * (All update functions or similar are allowed)
	 *  @param statement
	 *  @return
	 */
	public static int makeUpdate(String statement) {
		return makeUpdate(statement, database);	
	}
	
	
	/**
	 * Simple data manipulation query.
	 *  (All update functions or similar are allowed)
	 *  
	 *  @param statement
	 *  @return
	 */
	public static int makeUpdate(String statement, String database) {
		
		try {
			
			Statement state = connection.createStatement();
			
			state.execute("USE " + database);
			
			return state.executeUpdate(statement);
			
			
		} catch (SQLException exception) {
			exception.printStackTrace();
			System.out.println("makeUpdateException");
			return 0;
		}
	}
	
	
	
	//-------------------------------------------------------------------- Spalte hinzufügen -------------------------------------------------------------
	
	public static void addColumn(String column, String dataType) {
		addColumn(column, dataType, " ", "NOT NULL");
	}
	
	public static void addColumn(String column, String dataType, int size) {
		addColumn(column, dataType, size, "NOT NULL");
	}
	
	public static void addColumn(String column, String dataType, int size, String arguments) {
		addColumn(column, dataType, "(" + size + ") ", arguments);
	}
	
	/**
	 * Adds a column to a table.
	 * 
	 * @param col column name
	 * @param dataType Data type of the attribute
	 * @param size size of the attribute (in bytes)
	 * @param arguments arguments (e.g. NOT NULL)
	 */
	private static void addColumn(String column, String dataType, String size, String arguments) { //################ Eingabeprüfung einbauen #################
		
		String statement = "ALTER TABLE " + userTable + " ADD " + column + " " + dataType + size + arguments + ";";
		System.out.println(statement);
		makeUpdate(statement);
		
	}
	
	
	

	
	
	
}
