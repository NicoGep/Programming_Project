package exceptions;

import java.util.ResourceBundle;

/**
 * 	Exception class for wrong user input in the login screen
 *
 */
@SuppressWarnings("serial")
public class LoginCredentialsException extends Exception {
	
	private int state;
	private final ResourceBundle STRING_TEXT;
	
	/**
	 *  Function for specifying incorrect user entries in the login screen
	 * @param state : int 
	 */
	public LoginCredentialsException(int state) {
		
		this.state = state;
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/exceptions/LoginCredentialsException/logince");

		switch(state) {
		
		case 1: System.out.println(STRING_TEXT.getString("user_wrong")); break;
		case 2: System.out.println(STRING_TEXT.getString("pw_wrong")); break;
		case 3: System.out.println(STRING_TEXT.getString("empty_user")); break;
		case 4: System.out.println(STRING_TEXT.getString("empty_pw")); break;
		
		}
		
	}
	
	public int getState() {
		return state;
	}

}