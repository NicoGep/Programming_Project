package funktionen;

import connection.User;
import connection.DatabaseConnection;
import connection.Groups;
import exceptions.DatabaseConnectException;
import screens.MyProfile;

/**
 * Class for the functions of the class "MeinProfil"
 * 
 * @author Group3
 */
public class MyProfileFunction {

	/**
	 * method to load user data
	 */
	public void loadData() {
		User b = User.getLoggedUser();
		MyProfile.name = b.getName();
		MyProfile.level = b.getNiveau();
		MyProfile.mail = b.getEmail();
		MyProfile.profilepictureaddress = b.getProfilBild();
		addGroups();
	}

	/**
	 * method to add groups
	 */
	public void addGroups() {
			MyProfile.groupList = Groups.getAllGroups();
	}

	/**
	 * the screens 'edit profile', 'create group' or 'group' will open when the
	 * associated button is clicked
	 */

}
