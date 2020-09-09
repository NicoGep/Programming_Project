package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.InputException;
import master.Fenster;
import screens.GruppeBeitreten;
import screens.MeinProfil;
import screens.ProfilBearbeiten;

public class FunktionGruppeBeitreten implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			DatabaseConnection.connectDatabase();
			if (e.getSource() == GruppeBeitreten.suchen) {
				GruppeBeitreten.gruppen.removeAllItems();

				Iterator it = GruppeBeitreten.gruppenListe.iterator();
				while (it.hasNext()) {
					String item = (String) it.next();
					String suche = GruppeBeitreten.gruppenName.getText();
					if (item.contains(suche)) {
						GruppeBeitreten.gruppen.addItem(item);
						System.out.println(item);
					}
				}
				GruppeBeitreten.gruppen.setVisible(true);
			}

			if (e.getSource() == GruppeBeitreten.loeschen) {
				Benutzer.leaveGroup((GruppeBeitreten.gruppen.getItemAt(GruppeBeitreten.gruppen.getSelectedIndex())));
			}
			if (e.getSource() == GruppeBeitreten.beitreten) {

				Benutzer.joinGroup((GruppeBeitreten.gruppen.getItemAt(GruppeBeitreten.gruppen.getSelectedIndex())));

			}

			if (e.getSource() == GruppeBeitreten.zurueck) {
				Fenster.addToFrame(new MeinProfil());
			}
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e1) {
			e1.printStackTrace();
		} catch (InputException e1) {
			e1.printStackTrace();
		}

	}

	public void gruppenLaden() {
		GruppeBeitreten.gruppenListe = AdminFunctions.getAllGroups();

	}

}
