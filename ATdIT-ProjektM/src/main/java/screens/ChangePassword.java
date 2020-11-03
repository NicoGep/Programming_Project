package screens;

import java.awt.*;
import java.util.ResourceBundle;

import javax.swing.*;
import exceptions.ChangePasswordException;
import funktionen.ChangePasswordFunction;
import master.Window;
import master.Main;
import master.MasterScreen;

/**
 * UI for "PasswortAendern" screen
 * 
 * @author Group3
 *
 */

@SuppressWarnings("serial")
public class ChangePassword extends MasterScreen {

	public JButton saveButton;
	public JButton cancelButton;

	public JPasswordField oldpasswordPasswordfield;
	public JPasswordField newpasswordPasswordfield;
	public JPasswordField newpasswordcontrolPasswordfield;

	JLabel oldpasswordLabel;
	JLabel newpasswordLabel;
	JLabel newpasswordcontrolLabel;
	public JLabel newpassworddoesnotmatchLabel;
	public JLabel stateoldpasswordLabel;
	private final ResourceBundle STRING_TEXT;

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
				new ChangePasswordFunction(newpassworddoesnotmatchLabel, stateoldpasswordLabel).changePassword(newpasswordPasswordfield, newpasswordcontrolPasswordfield,
						oldpasswordPasswordfield);
			} catch (ChangePasswordException e) {
				Main.printError(e);
			}
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

}
