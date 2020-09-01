package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.LoginScreen;
import screens.MenuScreen;

public class MountainBikeFunktion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.mountainbikeKarteButton) {
//			Fenster.addToFrame(new KarteScreen());
		}
		
	}

}
