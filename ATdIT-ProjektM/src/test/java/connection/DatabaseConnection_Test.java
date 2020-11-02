package connection;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;

public class DatabaseConnection_Test {
	
	
//	public Test_DatabaseConnection() {
//		try {
//			DatabaseConnection.connectDatabase();
//		} catch(DatabaseConnectException e) {
//		}
//	}
//	
//	@Override
//	protected void finalize() throws Throwable {
//		DatabaseConnection.disconnectDatabase();
//	}
	
	@BeforeAll
	public static void connect() throws DatabaseConnectException {
		DatabaseConnection.connectDatabase();
	}
	
	@Test
	public void testConnection() {
		assertTrue(DatabaseConnection.testConnection());
	}
	
	@Test
	public void testMakeQuery() throws SQLException {
		String statement = "SELECT username FROM " + DatabaseConnection.usersTable + " WHERE userid = '1'";
		ResultSet set = DatabaseConnection.makeQuerry(statement);
		set.first();
		String username = set.getString("username");
		assertEquals(username, "TestBenutzer1");
	}
	
	
	@AfterAll
	public static void disconnect() {
		DatabaseConnection.disconnectDatabase();
	}
	

}