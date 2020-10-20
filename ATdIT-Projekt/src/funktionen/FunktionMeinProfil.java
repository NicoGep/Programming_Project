package funktionen;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import screens.MeinProfil;

/**
 * Class for the functions of the class "MeinProfil"
 * 
 * @author Group3
 */
public class FunktionMeinProfil {

	/**
	 * method to load user data
	 */
	public void loadData() {
		MeinProfil.name = Benutzer.getName();
		MeinProfil.level = Benutzer.getLevel();
		MeinProfil.mail = Benutzer.getMail();
		MeinProfil.profilepictureaddress = Benutzer.getProfilePicture();
		addGroups();
	}

	/**
	 * method to add groups
	 */
	public void addGroups() {
		try {
			DatabaseConnection.connectDatabase();
			MeinProfil.groupList = AdminFunctions.setToList(Benutzer.getAllGroups(), "gruppenname");
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
