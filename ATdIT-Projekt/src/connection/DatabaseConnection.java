package connection;

import java.sql.*;

import exceptions.DatabaseConnectException;

public class DatabaseConnection {
	
	private static String rootUser = "root";

	private static final String url = "jdbc:mysql://192.168.178.27:3306/";
	private static String rootPassword = "key";
	
//	private static final String url = "jdbc:mysql://localhost:3306/";
//	private static String rootPassword = "";
	
	private static Connection con;
	
	public static final String stdDB = "atdit";
	
	
	public static final String uTB = "benutzer";
	public static final String gTB = "gruppen";
	public static final String connectTB = "gruppenzugehoerigkeit";
	public static final String pTB = "parameter";
	
	public static final String tTB = "testtabelle";
	
	
	
	
	//------------------------------------------------------------------------------- Verbindung zur Datenbank ----------------------------------------------------------
	
	/**
	 * Stellt eine Verbindung zu der SQL-Datenbank her.
	 * 
	 * @return true, wenn Verbindung erfolgreich
	 * @throws DatabaseConnectException
	 */
	@SuppressWarnings("deprecation")
	public static boolean connectDatabase() throws DatabaseConnectException {
		
		if(con != null) 
			throw new DatabaseConnectException(3);

		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, rootUser, rootPassword);	//######### NOCH ROOT CREDS ############
			
			if(con == null)
				throw new DatabaseConnectException(1);

			System.out.println("Database connected\n\n");
			
			return true;
			
		} catch(Exception e) {
//			e.printStackTrace();
			throw new DatabaseConnectException(1);
		}
		
	}
	
	/**
	 * Trennt die aktuelle Verbindung zur Datenbank
	 * 
	 * @return true, wenn die Trennung erfolgreich war
	 * @throws DatabaseConnectException
	 */
	public static boolean disconnectDatabase() throws DatabaseConnectException {
		
		if(con == null) 
			throw new DatabaseConnectException(4);
		
		try {
			con.close();
			con = null;
			System.out.println("\n\nDatabase disconnected");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DatabaseConnectException(2);
		}
		
	}
	
	//----------------------------------------------------------------------------- Direkte Querys ----------------------------------------------------------------
	
	/**
	 * Einfache Datenbankabfrage. Ausführung einer Query auf dem Server.
	 * (Erlaubt sind alle Select-Abfragen o.Ä.)
	 * 
	 * @param statement
	 * @return Die Ergebnis-Relation als ResultSet
	 */
	public static ResultSet makeQuerry(String statement) {
		return makeQuerry(statement, stdDB);	
	}
	
	/**
	 * Einfache Datenbankabfrage. Ausführung einer Query auf dem Server.
	 * (Erlaubt sind alle Select-Abfragen o.Ä.)
	 * 
	 * @param statement
	 * @return Die Ergebnis-Relation als ResultSet
	 */
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
	
	/**
	 * Einfache Datenmanipulations-Query.
	 * (Erlaubt sind alle Update-Funktionen o.Ä.)
	 * 
	 * @param statement
	 * @return
	 */
	public static int makeUpdate(String statement) {
		return makeUpdate(statement, stdDB);	
	}
	
	
	/**
	 * Einfache Datenmanipulations-Query.
	 * (Erlaubt sind alle Update-Funktionen o.Ä.)
	 * 
	 * @param statement
	 * @return
	 */
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
	
	/**
	 * Fügt einer Tabelle eine Spalte hinzu.
	 * 
	 * @param col Spaltenname
	 * @param dataType DatenTyp des Attributs
	 * @param size Größe des Attributs (in Byte)
	 * @param arguments Argumente (z.B. NOT NULL)
	 */
	private static void addColumn(String col, String dataType, String size, String arguments) { //################ Eingabeprüfung einbauen #################
		
		String statement = "ALTER TABLE " + uTB + " ADD " + col + " " + dataType + size + arguments + ";";
		System.out.println(statement);
		makeUpdate(statement);
		
	}
	
	
	

	
	
	
}
