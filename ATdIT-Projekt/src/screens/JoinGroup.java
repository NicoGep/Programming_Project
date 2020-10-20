package screens;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import funktionen.JoinGroupFunction;
import master.Window;
import master.MasterScreen;

/**
 * GUI for screen "JoinGroup"
 * 
 * @author Group3
 *
 */
public class JoinGroup extends MasterScreen {

	public JButton backButton;
	public JButton joinButton;
	public JButton deleteButton;
	public JButton searchButton;

	public static JComboBox<String> groups;

	public static List<String> allGroupsList;

	JLabel groupNameLabel;
	public static JLabel results;

	public static JTextField groupNameTextfield;

	/**
	 * constructor JoinGroup
	 * 
	 * @param groupNameLabel     : JLabel
	 * @param groupNameTextfield : JTextField
	 * @param results            : JLabel
	 * @param groups             : JComboBox<String>
	 * @param searchButton       : JButton
	 * @param joinButton         : JButton
	 * @param deleteButton       : JButton
	 * @param backButton         : JButton
	 */
	public JoinGroup() {

		this.setLayout(null);

		groupNameLabel = new JLabel("Name der Gruppe:");
		groupNameLabel.setBounds(0, 0, 450, 100);
		groupNameLabel.setBackground(Color.LIGHT_GRAY);
		groupNameLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		groupNameTextfield = new JTextField();
		groupNameTextfield.setBounds(0, 100, 450, 50);

		results = new JLabel("Ergebnisse der Suche");
		results.setBounds(0, 150, 450, 100);
		results.setBackground(Color.LIGHT_GRAY);
		results.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		results.setVisible(false);

		groups = new JComboBox<String>();
		groups.setBounds(0, 250, 450, 50);
		groups.setVisible(false);

		searchButton = new JButton("Suchen");
		searchButton.setBackground(Color.BLUE);
		searchButton.setBounds(0, 400, 450, 100);
		searchButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		searchButton.addActionListener(l -> {
			try {
				DatabaseConnection.connectDatabase();
				JoinGroupFunction.search();
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e) {

			}

		});

		joinButton = new JButton("Beitreten");
		joinButton.setBackground(Color.LIGHT_GRAY);
		joinButton.setBounds(225, 500, 225, 100);
		joinButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		joinButton.addActionListener(l -> {
			try {
				DatabaseConnection.connectDatabase();
				JoinGroupFunction.joinGroup();
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e) {

			}
		});

		deleteButton = new JButton("Austreten");
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setBounds(0, 500, 225, 100);
		deleteButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		deleteButton.addActionListener(l -> {
			try {
				DatabaseConnection.connectDatabase();
				JoinGroupFunction.leaveGroup();
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e) {

			}
		});

		backButton = new JButton("Zurück");
		backButton.setBackground(Color.RED);
		backButton.setBounds(0, 600, 450, 100);
		backButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		backButton.addActionListener(l -> {
			Fenster.addToFrame(new MyProfile());
		});

		this.add(groupNameLabel);
		this.add(groupNameTextfield);
		this.add(results);
		this.add(groups);
		this.add(searchButton);
		this.add(deleteButton);
		this.add(joinButton);
		this.add(backButton);

	}
}
