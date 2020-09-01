package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.MenuScreen;

public class KarteFunktion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.karteButton) {
//			Fenster.addToFrame(new KarteScreen());
		}
	}

}
