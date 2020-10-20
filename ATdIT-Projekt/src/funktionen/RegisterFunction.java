package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import connection.User;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Window;
import screens.Login;
import screens.Menu;
import screens.Register;

/** Class for the function of class "Register"
 * 
 * @author Group3
 *
 */

public class RegisterFunction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {

		
/** Database is started.
 * User is registered in the database with a user name and password.
 * Corresponding error messages if the user name already exists and the password does not match.
 */		
		public static void register() {
			
			JTextField name;
//			JPasswordField password;
				DatabaseConnection.connectDatabase();
				Register.userexistsLabel.setText("");
				Register.passworddoesnotmatchLabel.setText("");
				
				String userPassword = "";
				char[] passwordLetters = Register.passwordPasswordfield.getPassword();
				for (int i = 0; i < passwordLetters.length; i++)
					userPassword += passwordLetters[i];
				
				String userControlPassword = "";
				passwordLetters = Register.repeatpasswordPasswordfield.getPassword();
				for (int i = 0; i < passwordLetters.length; i++)
					userControlPassword += passwordLetters[i];
				
				if(userControlPassword.equals(userPassword)) {
//				password = Registrierung.passwordPasswordfield;
				name = Register.userTextfield;
//				String s = "";
//				char[] c = password.getPassword();
//				for(int i = 0; i < c.length; i++)
//					s += c[i];
		
					if(AdminFunctions.findUser(name.getText()) == null) {
						AdminFunctions.addUser(name.getText(), userPassword);
						User.setMail(Register.mailTextfield.getText());
						try {
							User.loginUser(name.getText(), userPassword);
						} catch (LoginCredentialsException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Window.addToFrame(new Menu()); 
						}
					else {
						Register.userexistsLabel.setText("Benutzer existiert bereits!");
						Register.userexistsLabel.setBackground(Color.WHITE);
						Register.userexistsLabel.setForeground(Color.RED);
				
					}
				}else {
					Register.passworddoesnotmatchLabel.setText("Passwort stimmt nicht überrein!");
					Register.passworddoesnotmatchLabel.setBackground(Color.WHITE);
					Register.passworddoesnotmatchLabel.setForeground(Color.RED);
				}
				
		}
	
	}

}
