package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.KarteScreen;
import screens.MenuScreen;

/**	Klasse um die Funktion bereitzustellen das Kartenfenster zu �ffnen
 * 
 * @author I518230
 *
 */
public class KarteFunktion implements ActionListener {

	/**
	 * Der KartenScreen wird nach Dr�cken des Karten-Buttons ge�ffnet
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.karteButton) {
			Fenster.addToFrame(new KarteScreen());
		}
	}

}
