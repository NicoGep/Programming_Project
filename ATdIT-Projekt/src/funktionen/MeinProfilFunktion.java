package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.MeinProfil;
import screens.MenuScreen;

/**	Klasse, die die Funktion bereitstellt einen Mein Profil-Screen zu �ffnen
 * 
 * @author I518230
 *
 */
public class MeinProfilFunktion implements ActionListener {

	/**
	 * 	wird der mein Profil-Button gedr�ckt, so �ffnet sich der Mein Profil-Screen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.meinProfilButton) {
			Fenster.addToFrame(new MeinProfil());
		}

	}

}
