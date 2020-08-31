package tests;

import java.util.*;

import connection.*;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;

public class FlexTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try { 
		
		DatabaseConnection.connectDatabase();
		
		System.out.print("Name: ");
		String name = sc.next();
		
		System.out.print("Passwort: ");
		String pass = sc.next();
		
		Benutzer.loginUser(name, pass);
		
		System.out.println("Logged in");
		
		
		
		} catch(LoginCredentialsException logE) {
			
			switch(logE.getState()) {
			
			case 1: System.out.println("Name nicht gefunden_Main"); break;
			case 2: System.out.println("Password falsch_Main"); break;
			
			default: System.out.println("Login fehlgeschlagen_Main");
			
			}
			
		} catch(DatabaseConnectException e) {
			System.out.println(e.getClass());
			e.printStackTrace();
		}
		
		try {
			DatabaseConnection.disconnectDatabase();
	
		} catch(DatabaseConnectException dbE) {
			dbE.printStackTrace();
		}
		sc.close();
	}
}
