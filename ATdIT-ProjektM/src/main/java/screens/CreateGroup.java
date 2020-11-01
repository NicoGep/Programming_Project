package screens;

import java.awt.*;
import javax.swing.*;
import funktionen.CreateGroupFunction;
import master.Window;
import master.MasterScreen;

/**
 * UI for screen "GruppeErstellen"
 * 
 * @author Group3
 *
 */
@SuppressWarnings("serial")
public class CreateGroup extends MasterScreen {

	public JButton cancelButton;
	public JButton saveButton;

	public JComboBox<String> levelSelection;

	public JTextField groupNameTextfield;

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
	public CreateGroup() {

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
			new CreateGroupFunction(groupNameTextfield, levelSelection).save();
			Window.addToFrame(new MyProfile());
		});

		cancelButton = new JButton("Abbrechen");
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(0, 600, 225, 100);
		cancelButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		cancelButton.addActionListener(l -> {
			Window.addToFrame(new MyProfile());
		});

		this.add(groupNameLabel);
		this.add(groupNameTextfield);
		this.add(levelLabel);
		this.add(levelSelection);
		this.add(cancelButton);
		this.add(saveButton);

	}
}
