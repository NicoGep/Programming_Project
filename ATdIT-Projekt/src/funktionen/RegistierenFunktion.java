package funktionen;

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
			Fenster.addToFrame(new Login());
		}

		if (e.getSource() == Registrierung.reg) {
			JTextField name;
			JPasswordField password;
			try {
				DatabaseConnection.connectDatabase();
//				System.out.println(Registrierung.bnametx.getText());
//				System.out.println(Registrierung.pwtx.getText());
				password = Registrierung.pwtx;
				name = Registrierung.bnametx;
				String s = "";
				char[] c = password.getPassword();
				for(int i = 0; i < c.length; i++)
					s += c[i];
				AdminFunctions.addUser(name.getText(), s);
				
				
				
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e1) {
				e1.printStackTrace();
			} catch (InputException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Fenster.addToFrame(new MenuScreen());
		}

	}

}
