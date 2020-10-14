package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.KarteScreen;
import screens.MenuScreen;

/**	class with the functions for class "KarteScreen"
 * 
 * @author Group3
 *
 */
public class KarteFunktion implements ActionListener {

	/**
	 * when the 'map' button is pressed, the screen 'map' will open 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.mapButton) {
			Fenster.addToFrame(new KarteScreen());
		}
	}

}
