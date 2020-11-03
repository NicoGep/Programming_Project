package funktionen;

import java.util.Iterator;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import connection.User;
import connection.Groups;
import connection.Validator;
import exceptions.InputException;
import master.Main;


/**
 * class with functions for class "GruppeBeitreten"
 *
 */
public class JoinLeaveGroupFunction {
	public JComboBox<String> groups;
	public List<Groups> allGroupsList;
	public JLabel results;
	public JTextField groupNameTextfield;

	/**
	 * Implementation of the function for the join group button
	 * 
	 */
	public JoinLeaveGroupFunction(JComboBox<String> groups, List<Groups> allGroupsList, JLabel results,
			JTextField groupNameTextfield) {
		this.groups = groups;
		this.allGroupsList = allGroupsList;
		this.results = results;
		this.groupNameTextfield = groupNameTextfield;
	}


	public void search() {
		groups.removeAllItems();
		this.loadGroups();
		Iterator<Groups> it = allGroupsList.iterator();
		while (it.hasNext()) {
			String item = (String) it.next().getGroupName();
			String search = groupNameTextfield.getText();
			if (item.contains(search)) {
				groups.addItem(item);
				System.out.println(item);
			}
		}
		results.setVisible(true);
		groups.setVisible(true);
	}

	public void leaveGroup() {

		try {
			String group = groups.getItemAt(groups.getSelectedIndex());
			if (User.getLoggedUser().isInGroup(Validator.getValidator().getGroup(group))) {
				User.getLoggedUser().removeFromGroup(Validator.getValidator().getGroup(group));
			}
		} catch (InputException e) {
		}

	}

	public void joinGroup() {
		try {

			String group = groups.getItemAt(groups.getSelectedIndex());
			if (!User.getLoggedUser().isInGroup(Validator.getValidator().getGroup(group))) {
				User.getLoggedUser().addToGroup(Validator.getValidator().getGroup(group));
			}
		} catch (InputException e) {
			Main.printError(e);
		}
	}

	/**
	 * Function to load existing groups
	 * 
	 */
	public void loadGroups() {
		if (Groups.getAllGroups() != null) {
			allGroupsList = Groups.getAllGroups();
		}
	}

}
