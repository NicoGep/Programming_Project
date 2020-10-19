package funktionen;

import java.util.Iterator;
import connection.Benutzer;
import exceptions.InputException;
import screens.GruppeBeitreten;

/**
 * class with functions for class "GruppeBeitreten"
 *
 */
public class FunktionGruppeBeitreten {

	/**
	 * Implementation of the function for the join group button
	 * 
	 */

	public static void search() {
		GruppeBeitreten.groups.removeAllItems();
		new FunktionGruppeBeitreten().loadGroups();
		Iterator<String> it = GruppeBeitreten.allGroupsList.iterator();
		while (it.hasNext()) {
			String item = (String) it.next();
			String search = GruppeBeitreten.groupNameTextfield.getText();
			if (item.contains(search)) {
				GruppeBeitreten.groups.addItem(item);
				System.out.println(item);
			}
		}
		GruppeBeitreten.groups.setVisible(true);
	}

	public static void leaveGroup() {
		try {
			Benutzer.leaveGroup((GruppeBeitreten.groups.getItemAt(GruppeBeitreten.groups.getSelectedIndex())));
		} catch (InputException e) {
			System.out.println("Fehler beim Verlassen der Gruppe");
		}
	}

	public static void joinGroup() {
		try {
			Benutzer.joinGroup((GruppeBeitreten.groups.getItemAt(GruppeBeitreten.groups.getSelectedIndex())));
		} catch (InputException e) {

		}
	}

	/**
	 * Function to load existing groups
	 * 
	 */
	public void loadGroups() {
		if (AdminFunctions.setToList(AdminFunctions.getAllGroups(), "gruppenname") != null) {
			GruppeBeitreten.allGroupsList = AdminFunctions.setToList(AdminFunctions.getAllGroups(), "gruppenname");
		}
	}

}
