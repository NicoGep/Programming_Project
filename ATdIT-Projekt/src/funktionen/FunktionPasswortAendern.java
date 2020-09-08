package funktionen;

import java.awt.event.*;


import master.Fenster;
import screens.*;


public class FunktionPasswortAendern implements ActionListener{

	/**
	 * ruft je nach Button den ProfilBearbeitenScreen auf oder speichert das Passwort ab.
	 * Hierbei wird durch die if-Abfragen kontrolliert, dass das eingegebene Passwort überein stimmt
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == PasswortAendern.abbrechen) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == PasswortAendern.speichern) {			
			PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(false);
			PasswortAendern.altesPasswortAngeben.setVisible(false);
			
			if (PasswortAendern.neuesPasswort.getText().equals(PasswortAendern.neuesPasswortKontrolle.getText()) && !(PasswortAendern.altesPasswort.getText().equals("")) ) {
				Fenster.addToFrame(new ProfilBearbeiten());
			}
			else if (!(PasswortAendern.neuesPasswort.getText().equals(PasswortAendern.neuesPasswortKontrolle.getText())) && PasswortAendern.altesPasswort.getText().equals("") ) {
				PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(true);
				PasswortAendern.altesPasswortAngeben.setVisible(true);
			}
			else if (!(PasswortAendern.neuesPasswort.getText().equals(PasswortAendern.neuesPasswortKontrolle.getText()))){
				PasswortAendern.neuesPasswortStimmtNichtUeberein.setVisible(true);
			}
			else if (PasswortAendern.altesPasswort.getText().equals("")){
				PasswortAendern.altesPasswortAngeben.setVisible(true);
			}
			
		}
		
	}

}
