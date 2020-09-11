package funktionen;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import connection.Benutzer;
import master.Fenster;
import screens.Login;
import screens.PasswortVerg;
import screens.Registrierung;

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
