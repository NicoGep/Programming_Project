package funktionen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.User;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;
import master.Window;
import screens.ForgotPassword;
import screens.Register;
import screens.Login;
import screens.Menu;

/** Class with the functions of "Login"
 * 
 * @author Group3
 *
 */
public class LoginFunction implements ActionListener {
	
	private JTextField name;
	private JPasswordField password;
	
	private JLabel wrongnameLabel, wrongpasswordLabel;
	
	/** Data base is started
	 * 
	 * @param userTextfield : String (user name)
	 * @param passwordTextfield : String (password)
	 */
	public LoginFunction(JTextField userTextfield, JPasswordField passwordPasswordfield, JLabel wrongnameLabel, JLabel wrongpasswordLabel) {
		
		try {
			DatabaseConnection.connectDatabase();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		name = userTextfield;
		password = passwordPasswordfield;
		this.wrongnameLabel = wrongnameLabel;
		this.wrongpasswordLabel = wrongpasswordLabel;
	}

	/** Check the login data with the database with the corresponding error message if the name / password is incorrect.
	 * Forwarding to the screens menu, forgot password and registration.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			
			wrongnameLabel.setText("");
			wrongpasswordLabel.setText("");
			
			if (e.getSource() == Login.loginButton) {
				String s = "";
				char[] c = password.getPassword();
				for(int i = 0; i < c.length; i++)
					s += c[i];
				User.loginUser(name.getText().strip(), s);
				Window.addToFrame(new Menu());
			} else if (e.getSource() == Login.forgotpasswordButton) {
				Window.addToFrame(new ForgotPassword());
			} else if (e.getSource() == Login.registerButton) {
				Window.addToFrame(new Register());
			}
			
			DatabaseConnection.disconnectDatabase();

		} catch (DatabaseConnectException dbE) {
			dbE.printStackTrace();
			// Output errors, e.g. Apparently no internet connection or the like.
		} catch (LoginCredentialsException lE) {
			switch(lE.getState()) {// Label which is shown when the user or password is wrong
			case 1: wrongnameLabel.setText("Benutzername falsch."); 
			wrongnameLabel.setBackground(Color.WHITE);
			wrongnameLabel.setForeground(Color.RED);
			break;			
			
			case 2: wrongpasswordLabel.setText("Passwort falsch.");
			wrongpasswordLabel.setBackground(Color.WHITE);
			wrongpasswordLabel.setForeground(Color.RED);
			break;
			
			default: break;
			}
			Window.newDraw();
		}
	}
}
