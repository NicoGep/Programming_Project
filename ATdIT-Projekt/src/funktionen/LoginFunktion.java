package funktionen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.Login;
import screens.MenuScreen;
import screens.PasswortVerg;
import screens.Registrierung;



public class LoginFunktion implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Login.login) {
			Fenster.addToFrame(new MenuScreen());
				
			} else if (e.getSource() == Login.reg) {
			Fenster.addToFrame(new Registrierung());
			
			} else if (e.getSource() == Login.passVer) {
			Fenster.addToFrame(new PasswortVerg());
			
		}
	}
}
	

