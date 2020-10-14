package funktionen;

/**
 * Class with the functions to be able to logout
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.*;

public class AusloggenFunktion implements ActionListener {
	
	/** When the logout button is pressed, the login screen opens.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.logoutButton) {
			Fenster.addToFrame(new Login());
		}
		
	}

}
