package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;
import master.Fenster;
import screens.PasswortVerg;
import screens.Registrierung;
import screens.Login;
import screens.MenuScreen;

/** Klasse um die Funktion des Login-Screens bereitzustellen
 * 
 * @author I518230
 *
 */
public class LoginFunktion implements ActionListener {
	
	private JTextField name;
	private JPasswordField password;
	
	private JLabel wrongName, wrongPass;
	
	/** Datenbank wird gestartet
	 * 
	 * @param benutzertx : String (Benutzername)
	 * @param passworttx : String (Passwort)
	 */
	public LoginFunktion(JTextField benutzertx, JPasswordField passworttx, JLabel wrongName, JLabel wrongPass) {
		
		try {
			DatabaseConnection.connectDatabase();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		name = benutzertx;
		password = passworttx;
		this.wrongName = wrongName;
		this.wrongPass = wrongPass;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			
			wrongName.setText("");
			wrongPass.setText("");
			
			if (e.getSource() == Login.login) {
				String s = "";
				char[] c = password.getPassword();
				for(int i = 0; i < c.length; i++)
					s += c[i];
				Benutzer.loginUser(name.getText().strip(), s);
				Fenster.addToFrame(new MenuScreen());
			} else if (e.getSource() == Login.passVer) {
				Fenster.addToFrame(new PasswortVerg());
			} else if (e.getSource() == Login.reg) {
				Fenster.addToFrame(new Registrierung());
			}
			
			DatabaseConnection.disconnectDatabase();

		} catch (DatabaseConnectException dbE) {
			dbE.printStackTrace();
			// Fehler ausgeben, z.B. Anscheinend keine Internetverbindung o.Ä.
		} catch (LoginCredentialsException lE) {
			switch(lE.getState()) {
			case 1: wrongName.setText("Benutzername falsch."); break;			//Hier z.B. roten Text ausgeben, wenn Passwort bzw. Benutzername falsch war.
			case 2: wrongPass.setText("Passwort falsch."); break;
			default: break;
			}
			Fenster.neuZeichnen();
		}
	}
}
