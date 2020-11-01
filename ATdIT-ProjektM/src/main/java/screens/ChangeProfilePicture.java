package screens;

import java.awt.*;
import javax.swing.*;
import connection.User;
import master.Window;
import master.MasterScreen;

/**
 * UI class for class "ProfilbildAendern"
 * 
 * @author Group3
 *
 */
@SuppressWarnings("serial")
public class ChangeProfilePicture extends MasterScreen {
	public JButton saveButton;
	public JButton cancelButton;

	public JLabel addressLabel;
	public JTextField addressTextfield;

	/**
	 * constructor without layout
	 */
	public ChangeProfilePicture() {
		this.setLayout(null);

		addressLabel = new JLabel("Adresse des neuen Profilbilds: ");
		addressLabel.setBounds(0, 0, 450, 100);
		addressLabel.setBackground(Color.LIGHT_GRAY);
		addressLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		addressTextfield = new JTextField(MyProfile.profilepictureaddress);
		addressTextfield.setBounds(0, 100, 450, 50);

		saveButton = new JButton("Speichern");
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(l -> {			
			User.getLoggedUser().setProfilePic(addressTextfield.getText());
			Window.addToFrame(new EditProfile());
		});

		cancelButton = new JButton("Abbrechen");
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(0, 600, 225, 100);
		cancelButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		cancelButton.addActionListener(l -> {
			Window.addToFrame(new EditProfile());
		});

		this.add(addressLabel);
		this.add(addressTextfield);
		this.add(cancelButton);
		this.add(saveButton);
	}

}
