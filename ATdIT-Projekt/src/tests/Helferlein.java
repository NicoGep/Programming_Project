package tests;

import connection.Groups;
import connection.Validator;
import exceptions.DatabaseConnectException;

public class Helferlein {

	public static void main(String[] args) throws DatabaseConnectException, InterruptedException {
		
		Validator.createValidator();
		
		Thread.sleep(30000);
		
		
	}
	

}
