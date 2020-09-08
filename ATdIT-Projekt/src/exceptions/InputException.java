package exceptions;

public class InputException extends Exception {
	
	private int state;
	
	public InputException(int state) {
		
		this.state = state;
		
		switch(state) {
		
		case 1: System.out.println("Kein User gefunden."); break;
		case 2: System.out.println("Zwei User gefunden."); break;
		case 3: System.out.println("Der Name Existiert bereits."); break;
		case 4: System.out.println("Kein Name angegeben."); break;
		case 5: System.out.println("Kein Passwort angegeben"); break;
		
		}
		
	}

}
