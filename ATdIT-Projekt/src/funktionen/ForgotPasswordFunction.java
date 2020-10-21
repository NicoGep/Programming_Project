package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.User;
import master.Window;
import screens.Login;
import screens.ForgotPassword;

/** Class for the function of class "PasswortVerg"
 * 
 * @author Group3
 *
 */

public class ForgotPasswordFunction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

/** Function of the back button 
 * 
 */
		if(e.getSource() == ForgotPassword.backButton) {
			User.logoutUser();
			Window.clearHistory();
			Window.newDraw(new Login());
		}
	}
	
}
