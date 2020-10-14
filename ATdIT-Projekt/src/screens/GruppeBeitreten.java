package screens;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.*;

import funktionen.FunktionGruppeBeitreten;

import master.MasterScreen;

/**
 * GUI for screen "GruppeBeitreten"
 * 
 * @author Group3 
 *
 */
public class GruppeBeitreten extends MasterScreen {

	public static JButton backButton;
	public static JButton joinButton;
	public static JButton deleteButton;
	public static JButton searchButton;

	public static JComboBox<String> groups;
	
	public static List<String> groupList;

	JLabel groupNameLabel;
	public static JLabel results;

	public static JTextField groupNameTextfield;

	/**
	 * constructor GruppeBeitreten
	 * @param groupNameLabel : JLabel
	 * @param groupNameTextfield : JTextField
	 * @param results : JLabel
	 * @param groups : JComboBox<String>
	 * @param searchButton : JButton
	 * @param joinButton : JButton
	 * @param deleteButton : JButton
	 * @param backButton : JButton
	 */
	public GruppeBeitreten() {

		this.setLayout(null);
		ActionListener gruppeBeitretenAL = new FunktionGruppeBeitreten();
//		new FunktionGruppeBeitreten().gruppenLaden();

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
		searchButton.addActionListener(gruppeBeitretenAL);

		joinButton = new JButton("Beitreten");
		joinButton.setBackground(Color.LIGHT_GRAY);
		joinButton.setBounds(225, 500, 225, 100);
		joinButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		joinButton.addActionListener(gruppeBeitretenAL);

		deleteButton = new JButton("Austreten");
		deleteButton.setBackground(Color.LIGHT_GRAY);
		deleteButton.setBounds(0, 500, 225, 100);
		deleteButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		deleteButton.addActionListener(gruppeBeitretenAL);		

		backButton = new JButton("Zurück");
		backButton.setBackground(Color.RED);
		backButton.setBounds(0, 600, 450, 100);
		backButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		backButton.addActionListener(gruppeBeitretenAL);

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
