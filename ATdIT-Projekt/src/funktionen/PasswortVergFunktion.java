package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.Benutzer;
import master.Fenster;
import screens.Login;
import screens.PasswortVerg;

public class PasswortVergFunktion implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == PasswortVerg.back) {
			Benutzer.logoutUser();
			Fenster.clearHistory();
			Fenster.neuZeichnen(new Login());
		}
	}
	
}
