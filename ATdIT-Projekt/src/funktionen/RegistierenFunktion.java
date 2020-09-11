package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.Fenster;
import master.Panel;
import screens.Login;
import screens.MenuScreen;
import screens.PasswortAendern;
import screens.Registrierung;



public class RegistierenFunktion implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Registrierung.back) {
			Benutzer.logoutUser();
			Fenster.clearHistory();
			Fenster.neuZeichnen(new Login());;
		}

		if (e.getSource() == Registrierung.registrierenB) {
			JTextField name;
			JPasswordField password;
			try {
				DatabaseConnection.connectDatabase();
				Registrierung.benutzerExistiertBereits.setText("");
				Registrierung.passwortStimmtNichtUeberein.setText("");
				if(Registrierung.passwortWiederholentx.getText().equals(Registrierung.passworttx.getText())) {
//				System.out.println(Registrierung.bnametx.getText());
//				System.out.println(Registrierung.pwtx.getText());
				password = Registrierung.passworttx;
				name = Registrierung.benutzernametx;
				String s = "";
				char[] c = password.getPassword();
				for(int i = 0; i < c.length; i++)
					s += c[i];
		
					if(AdminFunctions.findUser(name.getText()) == null) {
						AdminFunctions.addUser(name.getText(), s);
						Fenster.addToFrame(new MenuScreen()); 
						}
					else {
						Registrierung.benutzerExistiertBereits.setText("Benutzer existiert bereits!");
						Registrierung.benutzerExistiertBereits.setBackground(Color.WHITE);
						Registrierung.benutzerExistiertBereits.setForeground(Color.RED);
				
					}
				}else {
					Registrierung.passwortStimmtNichtUeberein.setText("Passwort stimmt nicht überrein!");
					Registrierung.passwortStimmtNichtUeberein.setBackground(Color.WHITE);
					Registrierung.passwortStimmtNichtUeberein.setForeground(Color.RED);
				}
				
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e1) {
				e1.printStackTrace();
			} catch (InputException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}

}
