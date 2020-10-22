package funktionen;

import java.util.Iterator;
import connection.User;
import connection.Groups;
import connection.Validator;
import exceptions.InputException;
import screens.JoinLeaveGroup;

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
		JoinLeaveGroup.groups.removeAllItems();
		new JoinLeaveGroupFunction().loadGroups();
		Iterator<Groups> it = JoinLeaveGroup.allGroupsList.iterator();
		while (it.hasNext()) {
			String item = (String) it.next().getGroupName();
			String search = JoinLeaveGroup.groupNameTextfield.getText();
			if (item.contains(search)) {
				JoinLeaveGroup.groups.addItem(item);
				System.out.println(item);
			}
		}
		JoinLeaveGroup.groups.setVisible(true);
	}

	public static void leaveGroup() {

	try {
		String group = JoinLeaveGroup.groups.getItemAt(JoinLeaveGroup.groups.getSelectedIndex());
		if(User.getLoggedUser().isInGroup(Validator.getValidator().getGroup(group))) {
			User.getLoggedUser().removeFromGroup(Validator.getValidator().getGroup(group));
		}
	} catch (InputException e) {}

	}
	
	public static void joinGroup() {
		try {
			
			String group = JoinLeaveGroup.groups.getItemAt(JoinLeaveGroup.groups.getSelectedIndex());
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
			JoinLeaveGroup.allGroupsList = Groups.getAllGroups();
		}
	}

}
