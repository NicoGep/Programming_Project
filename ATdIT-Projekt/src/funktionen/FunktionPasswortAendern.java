package funktionen;

import java.awt.event.*;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.Fenster;
import screens.*;

public class FunktionPasswortAendern implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == PasswortAendern.abbrechen) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == PasswortAendern.speichern) {
			PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(false);
			PasswortAendern.altesPasswortAngeben.setVisible(false);

			if (PasswortAendern.neuesPasswort.getText().equals(PasswortAendern.neuesPasswortKontrolle.getText())
					&& !(PasswortAendern.altesPasswort.getText().equals(""))) {
				try {
					DatabaseConnection.connectDatabase();
					Benutzer.setPassword((String) PasswortAendern.neuesPasswort.getText());
					DatabaseConnection.disconnectDatabase();
				} catch (DatabaseConnectException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InputException e1) {
					e1.printStackTrace();
				}
				Fenster.addToFrame(new ProfilBearbeiten());
			} else if (!(PasswortAendern.neuesPasswort.getText()
					.equals(PasswortAendern.neuesPasswortKontrolle.getText()))
					&& PasswortAendern.altesPasswort.getText().equals("")) {
				PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(true);
				PasswortAendern.altesPasswortAngeben.setVisible(true);
			} else if (!(PasswortAendern.neuesPasswort.getText()
					.equals(PasswortAendern.neuesPasswortKontrolle.getText()))) {
				PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(true);
			} else if (PasswortAendern.altesPasswort.getText().equals("")) {
				PasswortAendern.altesPasswortAngeben.setVisible(true);
			}

		}

	}

}
