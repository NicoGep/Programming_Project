package screens;

import java.awt.*;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.*;
import connection.DatabaseConnection;
import connection.Groups;
import exceptions.DatabaseConnectException;
import funktionen.JoinLeaveGroupFunction;
import master.Window;
import master.MasterScreen;

/**
 * GUI for screen "GruppeBeitreten"
 * 
 * @author Group3
 *
 */
public class JoinLeaveGroup extends MasterScreen {

	public JButton backButton;
	public JButton joinButton;
	public JButton deleteButton;
	public JButton searchButton;

	public static JComboBox<String> groups;

	public static List<Groups> allGroupsList;

	JLabel groupNameLabel;
	public static JLabel results;

	public static JTextField groupNameTextfield;
//	public JTextField groupNameTextfield;
	private final ResourceBundle STRING_TEXT;

	/**
	 * constructor GruppeBeitreten
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
	public JoinLeaveGroup() {
		
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/JoinLeaveGroup/joinleaveg");

		this.setLayout(null);

		groupNameLabel = new JLabel(STRING_TEXT.getString("group_name"));
		groupNameLabel.setBounds(0, 0, 450, 100);
		groupNameLabel.setBackground(Color.LIGHT_GRAY);
		groupNameLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		groupNameTextfield = new JTextField();
		groupNameTextfield.setBounds(0, 100, 450, 50);

		results = new JLabel(STRING_TEXT.getString("search_result"));
		results.setBounds(0, 150, 450, 100);
		results.setBackground(Color.LIGHT_GRAY);
		results.setFont(new Font("Ueberschrift", Font.BOLD, 20));
		results.setVisible(false);

		groups = new JComboBox<String>();
		groups.setBounds(0, 250, 450, 50);
		groups.setVisible(false);

		searchButton = new JButton(STRING_TEXT.getString("search"));
		searchButton.setBackground(Color.BLUE);
		searchButton.setBounds(0, 400, 450, 100);
		searchButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		searchButton.addActionListener(l -> {
				JoinLeaveGroupFunction.search();
		});

		joinButton = new JButton(STRING_TEXT.getString("join"));
		joinButton.setBackground(Color.LIGHT_GRAY);
		joinButton.setBounds(225, 500, 225, 100);
		joinButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		joinButton.addActionListener(l -> {			
				JoinLeaveGroupFunction.joinGroup();
		});

		deleteButton = new JButton(STRING_TEXT.getString("leave"));
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setBounds(0, 500, 225, 100);
		deleteButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		deleteButton.addActionListener(l -> {
				JoinLeaveGroupFunction.leaveGroup();
		});

		backButton = new JButton(STRING_TEXT.getString("back"));
		backButton.setBackground(Color.RED);
		backButton.setBounds(0, 600, 450, 100);
		backButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		backButton.addActionListener(l -> {
			Window.addToFrame(new MyProfile());
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
