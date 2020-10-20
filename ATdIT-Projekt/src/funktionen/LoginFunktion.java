package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.Benutzer;
import connection.DatabaseConnection;
import connection.Validator;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;
import master.Fenster;
import screens.PasswortVerg;
import screens.Registrierung;
import screens.Login;
import screens.MenuScreen;

/** Klasse um die Funktion des Login-Screens bereitzustellen
 * 
 * @author Gruppe3
 *
 */
public class LoginFunktion implements ActionListener {
	
	private JTextField name;
	private JPasswordField password;
	
	private JLabel falscherName, falschesPasswort;
	
	/** Datenbank wird gestartet
	 * 
	 * @param benutzertx : String (Benutzername)
	 * @param passworttx : String (Passwort)
	 * @throws DatabaseConnectException 
	 */
	public LoginFunktion(JTextField benutzertx, JPasswordField passworttx, JLabel falscherName, JLabel falschesPasswort) throws DatabaseConnectException {
		
//		try {
//			DatabaseConnection.connectDatabase();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		Validator.createValidator();
		
		name = benutzertx;
		password = passworttx;
		this.falscherName = falscherName;
		this.falschesPasswort = falschesPasswort;
	}

	/** Buttonereignisse.
	 *  Logindaten mit Datenbank �berpr�fen mit der entsprechenden Fehlermeldung bei falschem Namen/Passwort.
	 *  Weiterleitung zu den Screens Men�, Passwort vergessen und Registrierung.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			
			falscherName.setText("");
			falschesPasswort.setText("");
			
			if (e.getSource() == Login.login) {
				String s = "";
				char[] c = password.getPassword();
				for(int i = 0; i < c.length; i++)
					s += c[i];
				Benutzer.loginUser(Validator.getValidator().getUser(name.getText().strip()), s);
				Fenster.addToFrame(new MenuScreen());
			} else if (e.getSource() == Login.passwortVergessen) {
				Fenster.addToFrame(new PasswortVerg());
			} else if (e.getSource() == Login.registrieren) {
				Fenster.addToFrame(new Registrierung());
			}
			
//			DatabaseConnection.disconnectDatabase();

		} /*catch (DatabaseConnectException dbE) {
//			dbE.printStackTrace();
			System.out.println("No verbindungo");
			// Fehler ausgeben, z.B. Anscheinend keine Internetverbindung o.�.
		} */catch (LoginCredentialsException lE) {
			switch(lE.getState()) {//Hier z.B. roten Text ausgeben, wenn Passwort bzw. Benutzername falsch war.
			case 1: falscherName.setText("Benutzername falsch."); 
			falscherName.setBackground(Color.WHITE);
			falscherName.setForeground(Color.RED);
			break;			
			
			case 2: falschesPasswort.setText("Passwort falsch.");
			falschesPasswort.setBackground(Color.WHITE);
			falschesPasswort.setForeground(Color.RED);
			break;
			
			default: break;
			}
			Fenster.neuZeichnen();
		}
	}
}
