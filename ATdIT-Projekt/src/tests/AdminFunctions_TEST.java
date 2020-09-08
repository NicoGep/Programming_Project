package tests;

import java.sql.ResultSet;
import java.util.List;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import funktionen.AdminFunctions;

public class AdminFunctions_TEST {
	
	public static void main(String[] args) {
		
//			ResultSet set = AdminFunctions.findUser("root");
//
//			if (set == null)
//				System.out.println("Das Set ist null");
//
//			set = AdminFunctions.findUser("test");
//
//			if (set == null)
//				System.out.println("Das andere Set ist null");
		
		List<String> l = AdminFunctions.getAllGroups();
		
		for(int i = 0; i < l.size(); i++) 
			System.out.println(l.get(i));
		

		
	}

}
