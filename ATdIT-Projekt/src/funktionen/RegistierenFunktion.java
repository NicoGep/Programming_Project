package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import connection.Benutzer;
import connection.DatabaseConnection;
import connection.Validator;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Fenster;
import screens.Login;
import screens.MenuScreen;
import screens.Registrierung;

/** Class for the function of class "Registrierung"
 * 
 * @author Group3
 *
 */

public class RegistierenFunktion {
	
		
/** Database is started.
 * User is registered in the database with a user name and password.
 * Corresponding error messages if the user name already exists and the password does not match.
 */		
		public static void register() {
			
			JTextField name;
//			JPasswordField password;
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
						try {
							Benutzer.addNewUser(name, email, niveau, profilePic, routeLength, heightDifference, password);(name.getText(), userPassword);
						} catch (InputException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Benutzer.getLoggedUser().setEmail(Registrierung.mailTextfield.getText());
						try {
							Benutzer.loginUser(Validator.getValidator().getUser(name.getText().strip()), userPassword);
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
				
		}
	
	}


