package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import master.Fenster;
import screens.GruppeBeitreten;
import screens.MeinProfil;
import screens.ProfilBearbeiten;

public class FunktionGruppeBeitreten implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == GruppeBeitreten.suchen) {
			GruppeBeitreten.gruppen.removeAllItems();

			Iterator it = GruppeBeitreten.gruppenListe.iterator();
			while (it.hasNext()) {
				String item = (String) it.next();
				String suche = GruppeBeitreten.gruppenName.getText();
				if (item.contains(suche)) {
					GruppeBeitreten.gruppen.addItem(item);
				}

			}
			GruppeBeitreten.ergebnisse.setVisible(true);
			GruppeBeitreten.gruppen.setVisible(true);
		}

		if (e.getSource() == GruppeBeitreten.loeschen) {
			MeinProfil.gruppenListe
					.remove(GruppeBeitreten.gruppen.getItemAt(GruppeBeitreten.gruppen.getSelectedIndex()));
		}
		if (e.getSource() == GruppeBeitreten.beitreten) {
			MeinProfil.gruppenListe.add(GruppeBeitreten.gruppen.getItemAt(GruppeBeitreten.gruppen.getSelectedIndex()));
		}

		if (e.getSource() == GruppeBeitreten.zurueck) {
			Fenster.addToFrame(new MeinProfil());
		}

	}

	public void gruppenLaden() {
		GruppeBeitreten.gruppenListe = AdminFunctions.getAllGroups();

	}

}
