package exceptions;

import screens.PasswortAendern;

/**
 * Exception class to detect failed change of password
 * 
 *
 */
public class ChangePasswordException extends Exception {

	/**
	 * 
	 */

	/**
	 * 
	 * @param state : int (Connection state to provide specific information)
	 */
	public ChangePasswordException(int state) {

		switch (state) {		
		case 1:
			PasswortAendern.newpassworddoesnotmatchLabel.setVisible(true);
			break;
		case 2:
			PasswortAendern.stateoldpasswordLabel.setVisible(true);
			break;
		case 3:
			PasswortAendern.newpassworddoesnotmatchLabel.setVisible(true);
			PasswortAendern.stateoldpasswordLabel.setVisible(true);
			break;
		}

	}

}