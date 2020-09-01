package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.MeinProfil;
import screens.MenuScreen;

public class MeinProfilFunktion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.meinProfilButton) {
			Fenster.addToFrame(new MeinProfil());
		}

	}

}
