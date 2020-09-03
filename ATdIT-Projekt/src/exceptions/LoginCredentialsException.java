package exceptions;

public class LoginCredentialsException extends Exception {
	
	private int state;
	
	public LoginCredentialsException(int state) {
		
		this.state = state;

		switch(state) {
		
		case 1: System.out.println("Benutzername nicht gefunden."); break;
		case 2: System.out.println("Passwort falsch."); break;
		case 3: System.out.println("Leerer Benutzername"); break;
		case 4: System.out.println("Leeres Passwort"); break;
		
		}
		
	}
	
	public int getState() {
		return state;
	}

}