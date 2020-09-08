package exceptions;

public class DatabaseConnectException extends Exception {
	

	public DatabaseConnectException(boolean state) {
		
		if(state == true)
			System.out.println("Es besteht bereits eine Verbindung");
		
		if(state == false)
			System.out.println("Es besteht keine Verbindung");
		
	}

}
