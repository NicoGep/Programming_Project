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

/**	class with functions for class "GruppeBeitreten"
 *
 */
public class FunktionGruppeBeitreten implements ActionListener {

	/**	Implementation of the function for the join group button
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			DatabaseConnection.connectDatabase();
			if (e.getSource() == GruppeBeitreten.searchButton) {
				GruppeBeitreten.groups.removeAllItems();
				loadGroups();
				Iterator it = GruppeBeitreten.groupList.iterator();
				while (it.hasNext()) {
					String item = (String) it.next();
					String search = GruppeBeitreten.groupNameTextfield.getText();
					if (item.contains(search)) {
						GruppeBeitreten.groups.addItem(item);
						System.out.println(item);
					}
				}
				GruppeBeitreten.groups.setVisible(true);
				DatabaseConnection.disconnectDatabase();
			}

			else if (e.getSource() == GruppeBeitreten.deleteButton) {
				Benutzer.leaveGroup((GruppeBeitreten.groups.getItemAt(GruppeBeitreten.groups.getSelectedIndex())));
				DatabaseConnection.disconnectDatabase();
			} else if (e.getSource() == GruppeBeitreten.joinButton) {

				Benutzer.joinGroup((GruppeBeitreten.groups.getItemAt(GruppeBeitreten.groups.getSelectedIndex())));
				DatabaseConnection.disconnectDatabase();
			}

			else if (e.getSource() == GruppeBeitreten.backButton) {
				DatabaseConnection.disconnectDatabase();
				Fenster.addToFrame(new MeinProfil());
			} else {
				DatabaseConnection.disconnectDatabase();
			}
		} catch (DatabaseConnectException e1) {
			e1.printStackTrace();
		} catch (InputException e1) {
			e1.printStackTrace();
		}
	}

	/**Function to load existing groups
	 * 
	 */
	public void loadGroups() {
		if (AdminFunctions.setToList(AdminFunctions.getAllGroups(), "gruppenname") != null) {
			GruppeBeitreten.groupList = AdminFunctions.setToList(AdminFunctions.getAllGroups(), "gruppenname");
		}
	}

}
