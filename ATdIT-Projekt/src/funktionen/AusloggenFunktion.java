package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.*;

public class AusloggenFunktion implements ActionListener {
	
	/** Wenn der Ausloggen-Button gedrückt wird, wird der Login-Screen geöffnet.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MenuScreen.ausloggenButton) {
			Fenster.addToFrame(new Login());
		}
		
	}

}
