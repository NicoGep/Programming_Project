package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.LoginScreen;
import screens.MeinProfil;
import screens.MenuScreen;

public class AusloggenFunktion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.ausloggenButton) {
			Fenster.addToFrame(new MeinProfil());
		}
		
	}

}
