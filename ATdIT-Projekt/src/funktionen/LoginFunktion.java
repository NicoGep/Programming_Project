package funktionen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import master.Fenster;
import screens.PasswortVerg;
import screens.Registrierung;
import screens.Login;



public class LoginFunktion implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Login.login) {
			Fenster.addToFrame(new MenuScreen());
			}
			else if (e.getSource() == Login.passVer) {
			Fenster.addToFrame(new PasswortVerg());
			}
			else if (e.getSource() == Login.reg) {
			Fenster.addToFrame(new Registrierung());
			}
			
			}	
	}
	

