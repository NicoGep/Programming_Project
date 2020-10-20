package funktionen;

import connection.User;
import exceptions.InputException;
import screens.JoinGroup;

/**
 * Class with the functions for class "CreateGroupFunction"
 * 
 * @author Group3
 *
 */
public class CreateGroupFunction {

	/**
	 * Creates a new group when the create button is clicked The screen of 'my
	 * profile' opens when the cancel button is clicked
	 */

	public static void save() {
		try {
			AdminFunctions.createGroup(CreateGroup.groupNameTextfield.getText(),
					(String) CreateGroup.levelSelection
							.getItemAt(CreateGroup.levelSelection.getSelectedIndex()));
			User.joinGroup(CreateGroup.groupNameTextfield.getText());
		} catch (InputException e) {

		}

	}

}
