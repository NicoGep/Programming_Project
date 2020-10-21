package tests;

import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import connection.Benutzer;
import connection.DatabaseConnection;
import connection.DatabaseConnection.Databases;
import connection.Groups;
import connection.Validator;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import funktionen.AdminFunctions;
import master.Fenster;

public class Helferlein {

	public static void main(String[] args) throws DatabaseConnectException, InterruptedException {
		
		Validator.createValidator();
		
		Thread.sleep(5000);
		
		System.out.println(Groups.getAllGroups().toString());
		
	}
	

}
