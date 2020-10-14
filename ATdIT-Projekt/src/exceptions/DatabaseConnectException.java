package exceptions;

/**
 * Exception class to detect failed database connections 
 * 
 *
 */
public class DatabaseConnectException extends Exception {
	
	/**
	 * 	
	 * @param state : int (Connection state to provide specific information)
	 */
	public DatabaseConnectException(int state) {


		switch(state) {
		
		case 1: System.out.println("Verbindung herstellen fehlgeschlagen"); break;
		case 2: System.out.println("Verbindung trennen fehlgeschlagen"); break;
		case 3: System.out.println("Es besteht bereits eine Verbindung"); break;
		case 4: System.out.println("Es besteht gar keine Verbindung"); break;
		
		}
		
	}

}
