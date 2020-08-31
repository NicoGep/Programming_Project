package funktionen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import master.Fenster;
import screens.LoginScreen;
import screens.PasswortVerg;
import screens.Registrierung;



public class LoginFunktion implements ActionListener {
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			e.getSource();
			Fenster.addToFrame(new Registrierung());
			
			
			
			
			
			
			
			
		
			}	
	}
	

