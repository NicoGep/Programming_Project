package funktionen;

import java.awt.event.*;
import java.sql.SQLException;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import exceptions.LoginCredentialsException;
import master.Fenster;
import screens.*;

/**	Class for the functions for class "PasswortAendern"
 * 
 * @author Group3
 *
 */
public class FunktionPasswortAendern implements ActionListener {

	/**	ActionListener for the cancel button and the save button to control the entered data
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			DatabaseConnection.connectDatabase();

			if (e.getSource() == PasswortAendern.cancelButton) {
				Fenster.addToFrame(new ProfilBearbeiten());
			}
			if (e.getSource() == PasswortAendern.saveButton) {
				PasswortAendern.newpassworddoesnotmatchLabel.setVisible(false);
				PasswortAendern.stateoldpasswordLabel.setVisible(false);

				// password control with data query
				try {
					AdminFunctions.checkPassword(AdminFunctions.encrypt(PasswortAendern.oldpasswordPasswordfield.getText()),
							AdminFunctions.findUser(Benutzer.getName()));
					if (PasswortAendern.newpasswordPasswordfield.getText()
							.equals(PasswortAendern.newpasswordPasswordfield.getText())) {

						Benutzer.setPassword((String) PasswortAendern.newpasswordPasswordfield.getText());

						Fenster.addToFrame(new ProfilBearbeiten());
					} else {
						PasswortAendern.newpassworddoesnotmatchLabel.setVisible(true);
					}
				} catch (LoginCredentialsException e1) {
					if (!(PasswortAendern.newpasswordPasswordfield.getText()
							.equals(PasswortAendern.newpasswordcontrolPasswordfield.getText()))) {
						PasswortAendern.newpassworddoesnotmatchLabel.setVisible(true);
					}
					PasswortAendern.stateoldpasswordLabel.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DatabaseConnection.disconnectDatabase();
			}
		} catch (DatabaseConnectException dbE) {
			dbE.printStackTrace();
		} catch (InputException e1) {

			e1.printStackTrace();
		}
	}

}
