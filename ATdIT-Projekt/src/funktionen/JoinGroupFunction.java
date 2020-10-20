package funktionen;

import java.util.Iterator;
import connection.User;
import exceptions.InputException;
import screens.JoinGroup;

/**
 * class with functions for class "JoinGroup"
 *
 */
public class JoinGroupFunction {

	/**
	 * Implementation of the function for the join group button
	 * 
	 */

	public static void search() {
		JoinGroup.groups.removeAllItems();
		new JoinGroupFunction().loadGroups();
		Iterator<String> it = JoinGroup.allGroupsList.iterator();
		while (it.hasNext()) {
			String item = (String) it.next();
			String search = JoinGroup.groupNameTextfield.getText();
			if (item.contains(search)) {
				JoinGroup.groups.addItem(item);
				System.out.println(item);
			}
		}
		JoinGroup.groups.setVisible(true);
	}

	public static void leaveGroup() {
		try {
			User.leaveGroup((JoinGroup.groups.getItemAt(JoinGroup.groups.getSelectedIndex())));
		} catch (InputException e) {
			System.out.println("Fehler beim Verlassen der Gruppe");
		}
	}

	public static void joinGroup() {
		try {
			User.joinGroup((JoinGroup.groups.getItemAt(JoinGroup.groups.getSelectedIndex())));
		} catch (InputException e) {

		}
	}

	/**
	 * Function to load existing groups
	 * 
	 */
	public void loadGroups() {
		if (AdminFunctions.setToList(AdminFunctions.getAllGroups(), "gruppenname") != null) {
			JoinGroup.allGroupsList = AdminFunctions.setToList(AdminFunctions.getAllGroups(), "gruppenname");
		}
	}

}
