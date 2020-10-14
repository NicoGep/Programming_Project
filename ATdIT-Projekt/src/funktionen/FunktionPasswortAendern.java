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

/**	Klasse um die Funktion bereitzustellen für den Passwort ändern-Button
 *
 */
public class FunktionPasswortAendern implements ActionListener {

	/**	ActionListener für den abbrechen-Button und den speichern-Button,
	 * um die eingegebenen Daten zu kontrollieren
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			DatabaseConnection.connectDatabase();

			if (e.getSource() == PasswortAendern.abbrechen) {
				Fenster.addToFrame(new ProfilBearbeiten());
			}
			if (e.getSource() == PasswortAendern.speichern) {
				PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(false);
				PasswortAendern.altesPasswortAngeben.setVisible(false);

				// Passwortkontrolle mit Datenbankabfrage
				try {
					AdminFunctions.checkPassword(AdminFunctions.encrypt(PasswortAendern.altesPasswort.getText()),
							AdminFunctions.findUser(Benutzer.getName()));
					if (PasswortAendern.neuesPasswort.getText()
							.equals(PasswortAendern.neuesPasswortKontrolle.getText())) {

						Benutzer.setPassword((String) PasswortAendern.neuesPasswort.getText());

						Fenster.addToFrame(new ProfilBearbeiten());
					} else {
						PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(true);
					}
				} catch (LoginCredentialsException e1) {
					if (!(PasswortAendern.neuesPasswort.getText()
							.equals(PasswortAendern.neuesPasswortKontrolle.getText()))) {
						PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(true);
					}
					PasswortAendern.altesPasswortAngeben.setVisible(true);
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
