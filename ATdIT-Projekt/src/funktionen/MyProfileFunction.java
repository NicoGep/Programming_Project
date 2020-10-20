package funktionen;

import connection.User;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import screens.MyProfile;

/**
 * Class for the functions of the class "MyProfile"
 * 
 * @author Group3
 */
public class MyProfileFunction {

	/**
	 * method to load user data
	 */
	public void loadData() {
		MyProfile.name = User.getName();
		MyProfile.level = User.getLevel();
		MyProfile.mail = User.getMail();
		MyProfile.profilepictureaddress = User.getProfilePicture();
		addGroups();
	}

	/**
	 * method to add groups
	 */
	public void addGroups() {
		try {
			DatabaseConnection.connectDatabase();
			MyProfile.groupList = AdminFunctions.setToList(User.getAllGroups(), "gruppenname");
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

	}

	/**
	 * the screens 'edit profile', 'create group' or 'group' will open when the
	 * associated button is clicked
	 */

}
