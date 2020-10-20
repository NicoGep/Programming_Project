package exceptions;

/**
 * 	
Exception class for specific information for incorrect inputs
 * 
 *
 */
public class InputException extends Exception {
	
	private int state;
	
	/**
	 *  Input-Exception for specific information for incorrect user inputs 
	 * @param state : int 
	 */
	public InputException(int state) {
		
		this.state = state;
		
		switch(state) {
		
		case 1: System.out.println("Kein User gefunden."); break;
		case 2: System.out.println("Zwei User gefunden."); break;
		case 3: System.out.println("Der Name Existiert bereits."); break;
		case 4: System.out.println("Kein Name angegeben."); break;
		case 5: System.out.println("Kein Passwort angegeben."); break;
		case 6: System.out.println("Gruppe exitiert bereits."); break;
		case 7: System.out.println("Gruppe existiert nicht."); break;
		case 8: System.out.println("Benutzer ist bereits in dieser Gruppe."); break;
		case 9: System.out.println("Benutzer ist nicht in dieser Gruppe."); break;
		case 10: System.out.println("Streckenlänge oder Höehenunterschied ist negativ.");
		
		}
		
	}

}
