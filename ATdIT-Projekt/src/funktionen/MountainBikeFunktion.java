package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.KarteScreen;
import screens.MenuScreen;

public class MountainBikeFunktion implements ActionListener {
	/**
	 * 	nicht ausimplementierte Funktion: 
	 * 	�ffnet den KarteScreen, da die Funktion dahinter �hnlich ist
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.mountainbikeKarteButton) {
			Fenster.addToFrame(new KarteScreen());
		}
		
	}

}
