package funktionen;

import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import master.Fenster;
import screens.GruppeBeitreten;
import screens.GruppeErstellen;
import screens.MeinProfil;
import screens.ProfilBearbeiten;

/** Class for the functions of the class "MeinProfil"
 * 
 *  @author Group3
 */
public class FunktionMeinProfil implements ActionListener {

	/**
	 * method to load user data
	 */
	public void loadData() {
		MeinProfil.name = Benutzer.getName();
		MeinProfil.level = Benutzer.getLevel();
		MeinProfil.mail = Benutzer.getMail();
		MeinProfil.profilepictureaddress = Benutzer.getProfilePicture();
//				"./ui/images/github_profilbild.jpg";
		addGroups();
	}
	
	/**
	 * method to add groups
	 */
	public void addGroups() {
		try {
			DatabaseConnection.connectDatabase();
			if (AdminFunctions.setToList(Benutzer.getAllGroups(), "gruppenname") != null) {
				MeinProfil.groupList = AdminFunctions.setToList(Benutzer.getAllGroups(), "gruppenname");
			}
			DatabaseConnection.disconnectDatabase();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		}

	}

	/**
	 * the screens 'edit profile', 'create group' or 'group' will open when the associated button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == MeinProfil.editprofileButton) {
			Fenster.addToFrame(new ProfilBearbeiten());
		}
		if (e.getSource() == MeinProfil.creategroupButton) {
			Fenster.addToFrame(new GruppeErstellen());
		}
		if (e.getSource() == MeinProfil.joingroupButton) {
			Fenster.addToFrame(new GruppeBeitreten());
		}

	}

}
