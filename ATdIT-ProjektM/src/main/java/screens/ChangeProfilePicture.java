package screens;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;
import connection.User;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import master.Window;
import master.MasterScreen;

/**
 * UI class for class "ProfilbildAendern"
 * 
 * @author Group3
 *
 */
public class ChangeProfilePicture extends MasterScreen {
	public JButton saveButton;
	public JButton cancelButton;

	public static JTextField addressTextfield;
	public JLabel addressLabel;
//	public JTextField addressTextfield;
	private final ResourceBundle STRING_TEXT;

	/**
	 * constructor without layout
	 */
	public ChangeProfilePicture() {
		this.setLayout(null);
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/ChangeProfilePicture/changepp");

		addressLabel = new JLabel(STRING_TEXT.getString("adress"));
		addressLabel.setBounds(0, 0, 450, 100);
		addressLabel.setBackground(Color.LIGHT_GRAY);
		addressLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		addressTextfield = new JTextField(MyProfile.profilepictureaddress);
		addressTextfield.setBounds(0, 100, 450, 50);

		saveButton = new JButton(STRING_TEXT.getString("save"));
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(l -> {			
			User.getLoggedUser().setProfilePic(ChangeProfilePicture.addressTextfield.getText());
			Window.addToFrame(new EditProfile());
		});

		cancelButton = new JButton(STRING_TEXT.getString("cancel"));
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
