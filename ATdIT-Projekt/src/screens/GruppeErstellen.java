package screens;

import java.awt.*;
import javax.swing.*;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import funktionen.FunktionGruppeErstellen;
import master.Fenster;
import master.MasterScreen;

/**
 * UI for screen "GruppeErstellen"
 * 
 * @author Group3
 *
 */
public class GruppeErstellen extends MasterScreen {

	public JButton cancelButton;
	public JButton saveButton;

	public static JComboBox<String> levelSelection;

	public static JTextField groupNameTextfield;

	JLabel groupNameLabel;
	JLabel levelLabel;

	/**
	 * constructor Gruppe Erstellen Layout : null
	 * 
	 * @param groupNameLabel : JLabel
	 * @param levelLabel     : JLabel
	 * @param groupName      : JTextField
	 * @param levelSelection : JComboBox<String>
	 * @param saveButton     : JButton
	 * @param cancelButton   : JButton
	 */
	public GruppeErstellen() {

		this.setLayout(null);

		groupNameLabel = new JLabel("Name der Gruppe:");
		groupNameLabel.setBounds(0, 0, 450, 100);
		groupNameLabel.setBackground(Color.LIGHT_GRAY);
		groupNameLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		levelLabel = new JLabel("Niveau der Gruppe:");
		levelLabel.setBounds(0, 150, 450, 100);
		levelLabel.setBackground(Color.LIGHT_GRAY);
		levelLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		groupNameTextfield = new JTextField();
		groupNameTextfield.setBounds(0, 100, 450, 50);

		levelSelection = new JComboBox<String>();
		levelSelection.addItem("Anfänger");
		levelSelection.addItem("Medium");
		levelSelection.addItem("Professionell");
		levelSelection.setBounds(0, 250, 450, 50);

		saveButton = new JButton("Speichern");
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(l -> {
			try {
				DatabaseConnection.connectDatabase();
				FunktionGruppeErstellen.save();
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

		this.add(groupNameLabel);
		this.add(groupNameTextfield);
		this.add(levelLabel);
		this.add(levelSelection);
		this.add(cancelButton);
		this.add(saveButton);

	}
}
