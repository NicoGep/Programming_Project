package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.MeinProfil;
import screens.MenuScreen;

/** Class with the functions for class "MeinProfil"
 * 
 *  @author Group3
 */
public class MeinProfilFunktion implements ActionListener {

	/**
	 * when the 'my profile' button is pressed, the 'MeinProfil' screen opens
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.myProfileButton) {
			Fenster.addToFrame(new MeinProfil());
		}

	}

}
