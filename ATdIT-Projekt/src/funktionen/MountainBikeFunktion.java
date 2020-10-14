package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.KarteScreen;
import screens.MenuScreen;

public class MountainBikeFunktion implements ActionListener {
	/**
	 * 	Function not fully implemented:
	 * opens the map screen, as the function behind it is similar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.mountainbikemapButton) {
			Fenster.addToFrame(new KarteScreen());
		}
		
	}

}
