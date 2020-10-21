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
		Benutzer b = Benutzer.getLoggedUser();
		MeinProfil.name = b.getName();
		MeinProfil.level = b.getNiveau();
		MeinProfil.mail = b.getEmail();
		MeinProfil.profilepictureaddress = b.getProfilBild();
		addGroups();
	}

	/**
	 * method to add groups
	 */
	public void addGroups() {
//			MeinProfil.groupList = AdminFunctions.setToList(Benutzer.getAllGroups(), "gruppenname");
	}

	/**
	 * the screens 'edit profile', 'create group' or 'group' will open when the
	 * associated button is clicked
	 */

}
