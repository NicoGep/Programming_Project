package funktionen;

import java.util.Iterator;
import connection.User;
import connection.Groups;
import connection.Validator;
import exceptions.InputException;
import screens.EditGroup;

/**
 * class with functions for class "GruppeBeitreten"
 *
 */
public class JoinLeaveGroupFunction {

	/**
	 * Implementation of the function for the join group button
	 * 
	 */

	public static void search() {
		EditGroup.groups.removeAllItems();
		new JoinLeaveGroupFunction().loadGroups();
		Iterator<Groups> it = EditGroup.allGroupsList.iterator();
		while (it.hasNext()) {
			String item = (String) it.next().getGroupName();
			String search = EditGroup.groupNameTextfield.getText();
			if (item.contains(search)) {
				EditGroup.groups.addItem(item);
				System.out.println(item);
			}
		}
		EditGroup.groups.setVisible(true);
	}

	public static void leaveGroup() {
		try {
			User.leaveGroup((EditGroup.groups.getItemAt(EditGroup.groups.getSelectedIndex())));
		} catch (InputException e) {
			System.out.println("Fehler beim Verlassen der Gruppe");
		}
	}

	public static void joinGroup() {
		try {
			
			String group = EditGroup.groups.getItemAt(EditGroup.groups.getSelectedIndex());
			if(!User.getLoggedUser().isInGroup(Validator.getValidator().getGroup(group))) {
				User.getLoggedUser().addToGroup(Validator.getValidator().getGroup(group));
			}
		} catch (InputException e) {

		}
	}

	/**
	 * Function to load existing groups
	 * 
	 */
	public void loadGroups() {
		if (Groups.getAllGroups() != null) {
			EditGroup.allGroupsList = Groups.getAllGroups();
		}
	}

}
