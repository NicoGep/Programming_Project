package funktionen;

import connection.User;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import connection.Groups;
import exceptions.InputException;

/**
 * Class with the functions for class "GruppeErstellen"
 * 
 * @author Group3
 *
 */
public class CreateGroupFunction {
	public JTextField groupNameTextfield;
	public JComboBox<String> levelSelection;

	/**
	 * Creates a new group when the create button is clicked The screen of 'my
	 * profile' opens when the cancel button is clicked
	 */
	public CreateGroupFunction(JTextField groupNameTextfield, JComboBox<String> levelSelection) {
		this.groupNameTextfield = groupNameTextfield;
		this.levelSelection = levelSelection;
	}

	public void save() {
		try {
			User.getLoggedUser().addToGroup(Groups.addNewGroup(groupNameTextfield.getText(),
					(String) levelSelection.getItemAt(levelSelection.getSelectedIndex())));
		} catch (InputException e) {

		}

	}

}
