package screens;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;
import connection.DatabaseConnection;
import exceptions.ChangePasswordException;
import exceptions.DatabaseConnectException;
import funktionen.ChangePasswordFunction;
import master.Window;
import master.MasterScreen;

/**
 * UI for "PasswortAendern" screen
 * 
 * @author Group3
 *
 */
public class ChangePassword extends MasterScreen {

	public JButton saveButton;
	public JButton cancelButton;

	public static JPasswordField oldpasswordPasswordfield;
	public static JPasswordField newpasswordPasswordfield;
	public static JPasswordField newpasswordcontrolPasswordfield;

	JLabel oldpasswordLabel;
	JLabel newpasswordLabel;
	JLabel newpasswordcontrolLabel;
<<<<<<< HEAD
	public static JLabel newpassworddoesnotmatchLabel;
	public static JLabel stateoldpasswordLabel;
=======
	public JLabel newpassworddoesnotmatchLabel;
	public JLabel stateoldpasswordLabel;
<<<<<<< HEAD
=======
	private final ResourceBundle STRING_TEXT;
>>>>>>> 23f808221443bc60226e306a4b229ae5fe30dbdd
>>>>>>> parent of c386e70... Revert "m erge"

	/**
	 * constructor without Layout
	 */
	public ChangePassword() {
		this.setLayout(null);
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/ChangePassword/changep");

		oldpasswordLabel = new JLabel(STRING_TEXT.getString("old_pw"));
		oldpasswordLabel.setBounds(0, 0, 450, 100);
		oldpasswordLabel.setBackground(Color.LIGHT_GRAY);
		oldpasswordLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		newpasswordLabel = new JLabel(STRING_TEXT.getString("new_pw"));
		newpasswordLabel.setBounds(0, 150, 450, 100);
		newpasswordLabel.setBackground(Color.LIGHT_GRAY);
		newpasswordLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		newpasswordcontrolLabel = new JLabel(STRING_TEXT.getString("repeat_pw"));
		newpasswordcontrolLabel.setBounds(0, 300, 450, 100);
		newpasswordcontrolLabel.setBackground(Color.LIGHT_GRAY);
		newpasswordcontrolLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		newpassworddoesnotmatchLabel = new JLabel(STRING_TEXT.getString("x_pw"));
		newpassworddoesnotmatchLabel.setBounds(0, 450, 450, 75);
		newpassworddoesnotmatchLabel.setBackground(Color.WHITE);
		newpassworddoesnotmatchLabel.setForeground(Color.RED);
		newpassworddoesnotmatchLabel.setVisible(false);

		stateoldpasswordLabel = new JLabel(STRING_TEXT.getString("old_pw_wrong"));
		stateoldpasswordLabel.setBounds(0, 525, 450, 75);
		stateoldpasswordLabel.setBackground(Color.WHITE);
		stateoldpasswordLabel.setForeground(Color.RED);
		stateoldpasswordLabel.setVisible(false);

		oldpasswordPasswordfield = new JPasswordField();
		oldpasswordPasswordfield.setBounds(0, 100, 450, 50);

		newpasswordPasswordfield = new JPasswordField();
		newpasswordPasswordfield.setBounds(0, 250, 450, 50);

		newpasswordcontrolPasswordfield = new JPasswordField();
		newpasswordcontrolPasswordfield.setBounds(0, 400, 450, 50);

		saveButton = new JButton(STRING_TEXT.getString("save"));
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(d -> {
				try {
					ChangePasswordFunction.changePassword();
				} catch (ChangePasswordException e) {}				
		});

		cancelButton = new JButton(STRING_TEXT.getString("cancel"));
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(0, 600, 225, 100);
		cancelButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		cancelButton.addActionListener(d -> {
			Window.addToFrame(new EditProfile());
		});

		this.add(oldpasswordLabel);
		this.add(oldpasswordPasswordfield);
		this.add(newpasswordLabel);
		this.add(newpasswordPasswordfield);
		this.add(newpasswordcontrolLabel);
		this.add(newpasswordcontrolPasswordfield);
		this.add(newpassworddoesnotmatchLabel);
		this.add(stateoldpasswordLabel);
		this.add(cancelButton);
		this.add(saveButton);
	}

	public static JPasswordField getOldPassword() {
		return oldpasswordPasswordfield;
	}

	public static JPasswordField getNewPassword() {
		return newpasswordPasswordfield;
	}

	public static JPasswordField getNewPasswordControl() {
		return newpasswordcontrolPasswordfield;
	}

}
