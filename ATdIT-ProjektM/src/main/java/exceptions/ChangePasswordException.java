package exceptions;

import screens.ChangePassword;

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
			ChangePassword.newpassworddoesnotmatchLabel.setVisible(true);
			break;
		case 2:
			ChangePassword.stateoldpasswordLabel.setVisible(true);
			break;
		case 3:
			ChangePassword.newpassworddoesnotmatchLabel.setVisible(true);
			ChangePassword.stateoldpasswordLabel.setVisible(true);
			break;
		}

	}

}