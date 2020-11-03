package exceptions;

import java.util.ResourceBundle;

/**
 * 	
Exception class for specific information for incorrect inputs
 * 
 *
 */
@SuppressWarnings("serial")
public class InputException extends Exception {
	
	private int state;
	private final ResourceBundle STRING_TEXT;
	
	/**
	 *  Input-Exception for specific information for incorrect user inputs 
	 * @param state : int 
	 */
	public InputException(int state) {
		
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/exceptions/Input/Exception/inpute");
		this.setState(state);
		
		switch(state) {
		
		case 1: System.out.println(STRING_TEXT.getString("no_user")); break;
		case 2: System.out.println(STRING_TEXT.getString("two_users")); break;
		case 3: System.out.println(STRING_TEXT.getString("name_exists")); break;
		case 4: System.out.println(STRING_TEXT.getString("no_name")); break;
		case 5: System.out.println(STRING_TEXT.getString("no_pw")); break;
		case 6: System.out.println(STRING_TEXT.getString("group_exists")); break;
		case 7: System.out.println(STRING_TEXT.getString("group_not_exists")); break;
		case 8: System.out.println(STRING_TEXT.getString("user_in_group")); break;
		case 9: System.out.println(STRING_TEXT.getString("user_not_in_group")); break;
		case 10: System.out.println(STRING_TEXT.getString("param_negative"));
		
		}
		
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
