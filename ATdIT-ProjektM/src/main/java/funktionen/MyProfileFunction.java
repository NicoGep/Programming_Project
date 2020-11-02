package funktionen;

import connection.User;

import java.util.List;
import java.util.ResourceBundle;

import connection.Groups;
import screens.MyProfile;

/**
 * Class for the functions of the class "MeinProfil"
 * 
 * @author Group3
 */
public class MyProfileFunction {
	public String name;
	public String level;
	public String mail;
	public String profilepictureaddress;
	public List<Groups> groupList;
	private final ResourceBundle STRING_TEXT = ResourceBundle.getBundle("i18n/Funktionen/MyProfileFunction/myprofilefunction");
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
		if ((b.getNiveau()).equals("1")) {
			MyProfile.level = STRING_TEXT.getString("beginner");
		}
		else if ((b.getNiveau()).equals("2")) {
			MyProfile.level = STRING_TEXT.getString("medium");
		}
		else if ((b.getNiveau()).equals("3")) {
			MyProfile.level = STRING_TEXT.getString("pro");
		}
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
