package exceptions;

public class InputException extends Exception {
	
	private int state;
	
	public InputException(int state) {
		
		this.state = state;
		
		switch(state) {
		
		case 1: System.out.println("Kein User gefunden.");
		case 2: System.out.println("Zwei User gefunden.");
		
		}
		
	}

}
