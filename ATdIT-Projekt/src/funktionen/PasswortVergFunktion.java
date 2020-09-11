package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import master.Fenster;
import screens.Login;
import screens.PasswortVerg;

/** Klasse um die Funktion des PasswortVerg-Screens bereitzustellen
 * 
 * @author Gruppe3
 *
 */

public class PasswortVergFunktion implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

/** Funktion des Zurückknopfs 
 * 
 */
		if(e.getSource() == PasswortVerg.back) {
			Benutzer.logoutUser();
			Fenster.clearHistory();
			Fenster.neuZeichnen(new Login());
		}
	}
	
}
