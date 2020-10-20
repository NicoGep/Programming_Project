package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import master.Fenster;
import screens.Login;
import screens.PasswortVerg;

/** Class for the function of class "PasswortVerg"
 * 
 * @author Group3
 *
 */

public class PasswortVergFunktion implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

/** Function of the back button 
 * 
 */
		if(e.getSource() == PasswortVerg.backButton) {
			Benutzer.logoutUser();
			Fenster.clearHistory();
			Fenster.newDraw(new Login());
		}
	}
	
}
