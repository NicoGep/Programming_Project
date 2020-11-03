package exceptions;

import java.util.ResourceBundle;

/**
 * Exception class to detect failed database connections 
 * 
 *
 */
@SuppressWarnings("serial")
public class DatabaseConnectException extends Exception {
	
	private int state;
	private final ResourceBundle STRING_TEXT;
	
	/**
	 * 	
	 * @param state : int (Connection state to provide specific information)
	 */
	public DatabaseConnectException(int state) {

		this.state = state;
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/exceptions/DatabaseConnectException/databaseconnecte");

		switch(state) {
		
		case 1: System.out.println(STRING_TEXT.getString("no_con")); break;
		case 2: System.out.println(STRING_TEXT.getString("discon")); break;
		case 3: System.out.println(STRING_TEXT.getString("already_con")); break;
		case 4: System.out.println(STRING_TEXT.getString("absolut_no_con")); break;
		
		}
		
	}
	
	public int getState() {
		return state;
	}

}
