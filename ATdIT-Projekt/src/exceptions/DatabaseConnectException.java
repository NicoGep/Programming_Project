package exceptions;

/**
 * 	Exception-Klasse um gescheiterte Datenbankverbindungen spezifisch anzugeben
 * 
 *
 */
public class DatabaseConnectException extends Exception {
	
	private int state;
	
	/**
	 * 	
	 * @param state : int (Conncetion-State um spezifische Angaben zu machen)
	 */
	public DatabaseConnectException(int state) {

		this.state = state;

		switch(state) {
		
		case 1: System.out.println("Verbindung herstellen fehlgeschlagen"); break;
		case 2: System.out.println("Verbindung trennen fehlgeschlagen"); break;
		case 3: System.out.println("Es besteht bereits eine Verbindung"); break;
		case 4: System.out.println("Es besteht gar keine Verbindung"); break;
		
		}
		
	}
	
	public int getState() {
		return state;
	}

}
