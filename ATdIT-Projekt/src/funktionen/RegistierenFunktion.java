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
import exceptions.LoginCredentialsException;
import master.Fenster;
import master.Panel;
import screens.Login;
import screens.MenuScreen;
import screens.PasswortAendern;
import screens.ProfilBearbeiten;
import screens.Registrierung;

/** Class for the function of class "Registrierung"
 * 
 * @author Group3
 *
 */

public class RegistierenFunktion implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

/** Function back button.
 * 
 */		
		if(e.getSource() == Registrierung.backButton) {
			Benutzer.logoutUser();
			Fenster.clearHistory();
			Fenster.newDraw(new Login());;
		}
		
/** Database is started.
 * User is registered in the database with a user name and password.
 * Corresponding error messages if the user name already exists and the password does not match.
 */				
		if (e.getSource() == Registrierung.registerButton) {
			JTextField name;
//			JPasswordField password;
			try {
				DatabaseConnection.connectDatabase();
				Registrierung.userexistsLabel.setText("");
				Registrierung.passworddoesnotmatchLabel.setText("");
				
				String userPassword = "";
				char[] passwordLetters = Registrierung.passwordPasswordfield.getPassword();
				for (int i = 0; i < passwordLetters.length; i++)
					userPassword += passwordLetters[i];
				
				String userControlPassword = "";
				passwordLetters = Registrierung.repeatpasswordPasswordfield.getPassword();
				for (int i = 0; i < passwordLetters.length; i++)
					userControlPassword += passwordLetters[i];
				
				if(userControlPassword.equals(userPassword)) {
//				password = Registrierung.passwordPasswordfield;
				name = Registrierung.userTextfield;
//				String s = "";
//				char[] c = password.getPassword();
//				for(int i = 0; i < c.length; i++)
//					s += c[i];
		
					if(AdminFunctions.findUser(name.getText()) == null) {
						AdminFunctions.addUser(name.getText(), userPassword);
						Benutzer.setMail(Registrierung.mailTextfield.getText());
						try {
							Benutzer.loginUser(name.getText(), userPassword);
						} catch (LoginCredentialsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Fenster.addToFrame(new MenuScreen()); 
						}
					else {
						Registrierung.userexistsLabel.setText("Benutzer existiert bereits!");
						Registrierung.userexistsLabel.setBackground(Color.WHITE);
						Registrierung.userexistsLabel.setForeground(Color.RED);
				
					}
				}else {
					Registrierung.passworddoesnotmatchLabel.setText("Passwort stimmt nicht überrein!");
					Registrierung.passworddoesnotmatchLabel.setBackground(Color.WHITE);
					Registrierung.passworddoesnotmatchLabel.setForeground(Color.RED);
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
