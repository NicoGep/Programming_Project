package exceptions;

import javax.swing.JLabel;



/**
 * Exception class to detect failed change of password
 * 
 *
 */
@SuppressWarnings("serial")
public class ChangePasswordException extends Exception {
	public JLabel newpassworddoesnotmatchLabel;
	public JLabel stateoldpasswordLabel;

	/**
	 * 
	 */

	/**
	 * 
	 * @param state : int (Connection state to provide specific information)
	 */
	public ChangePasswordException(int state, JLabel newpassworddoesnotmatchLabel, JLabel stateoldpasswordLabel) {
		this.newpassworddoesnotmatchLabel = newpassworddoesnotmatchLabel;
		this.stateoldpasswordLabel = stateoldpasswordLabel;
		switch (state) {
		case 1:
			newpassworddoesnotmatchLabel.setVisible(true);
			break;
		case 2:
			stateoldpasswordLabel.setVisible(true);
			break;
		case 3:
			newpassworddoesnotmatchLabel.setVisible(true);
			stateoldpasswordLabel.setVisible(true);
			break;
		}

	}

}