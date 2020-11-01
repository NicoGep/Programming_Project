package funktionen;

import connection.User;
import connection.Groups;
import connection.Validator;
import exceptions.InputException;
import screens.CreateGroup;

/**
 * Class with the functions for class "GruppeErstellen"
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
			User.getLoggedUser()
					.addToGroup(Groups.addNewGroup(CreateGroup.groupNameTextfield.getText(),
							(String) CreateGroup.levelSelection
									.getItemAt(CreateGroup.levelSelection.getSelectedIndex())));
		} catch (InputException e) {

		}

	}

}
