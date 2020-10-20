package screens;

import master.Fenster;
import master.MasterScreen;
import java.awt.*;

import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;

import javax.swing.*;

import funktionen.FunktionProfilBearbeiten;

/**
 * UI class for class "ProfilBearbeiten"
 * 
 * @author Group3
 *
 */
public class ProfilBearbeiten extends MasterScreen {

	JLabel nameLabel;
	JLabel levelLabel;
	JLabel mailLabel;

	public static JComboBox<String> levelSelection;

	public static JTextField newnameTextfield;
	public static JTextField newmailTextfield;

	public JButton saveButton;
	public JButton cancelButton;
	public JButton newprofilepictureButton;
	public JButton changepasswordButton;

	/**
	 * constructor without layout
	 */
	public ProfilBearbeiten() {

		this.setLayout(null);
		this.setBackground(Color.WHITE);

		nameLabel = new JLabel("Name");
		nameLabel.setBounds(0, 0, 450, 100);
		nameLabel.setBackground(Color.LIGHT_GRAY);
		nameLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		levelLabel = new JLabel("Niveau");
		levelLabel.setBounds(0, 150, 450, 100);
		levelLabel.setBackground(Color.LIGHT_GRAY);
		levelLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		mailLabel = new JLabel("E-Mail:");
		mailLabel.setBounds(0, 300, 450, 100);
		mailLabel.setBackground(Color.LIGHT_GRAY);
		mailLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		levelSelection = new JComboBox<String>();
		levelSelection.addItem("Anfänger");
		levelSelection.addItem("Medium");
		levelSelection.addItem("Professionell");
		levelSelection.setBounds(0, 250, 450, 50);
		levelSelection.setSelectedItem(MeinProfil.level);

		newnameTextfield = new JTextField(MeinProfil.name);
		newnameTextfield.setBounds(0, 100, 450, 50);

		newmailTextfield = new JTextField(MeinProfil.mail);
		newmailTextfield.setBounds(0, 400, 450, 50);

		newprofilepictureButton = new JButton("Neues Profilbild");
		newprofilepictureButton.setBounds(0, 450, 450, 100);
		newprofilepictureButton.setBackground(Color.LIGHT_GRAY);
		newprofilepictureButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		newprofilepictureButton.addActionListener(l -> {
			Fenster.addToFrame(new ProfilbildAendern());
		});

		changepasswordButton = new JButton("Passwort ändern");
		changepasswordButton.setBounds(0, 550, 450, 50);
		changepasswordButton.setBackground(Color.LIGHT_GRAY);
		changepasswordButton.setForeground(Color.RED);
		changepasswordButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		changepasswordButton.addActionListener(l -> {
			Fenster.addToFrame(new PasswortAendern());
		});

		saveButton = new JButton("Speichern");
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(l -> {

			try {
				DatabaseConnection.connectDatabase();
				FunktionProfilBearbeiten.saveChanges();
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e) {

			}
			Fenster.addToFrame(new MeinProfil());
		});

		cancelButton = new JButton("Abbrechen");
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(0, 600, 225, 100);
		cancelButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		cancelButton.addActionListener(l -> {
			Fenster.addToFrame(new MeinProfil());
		});

		this.add(nameLabel);
		this.add(newnameTextfield);
		this.add(levelLabel);
		this.add(levelSelection);
		this.add(mailLabel);
		this.add(newmailTextfield);
		this.add(newprofilepictureButton);
		this.add(changepasswordButton);
		this.add(cancelButton);
		this.add(saveButton);

	}

}
