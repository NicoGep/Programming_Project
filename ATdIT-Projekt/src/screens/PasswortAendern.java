package screens;

import java.awt.*;
import javax.swing.*;
import connection.DatabaseConnection;
import exceptions.ChangePasswordException;
import exceptions.DatabaseConnectException;
import funktionen.FunktionPasswortAendern;
import master.Fenster;
import master.MasterScreen;

/**
 * UI for "PasswortAendern" screen
 * 
 * @author Group3
 *
 */
public class PasswortAendern extends MasterScreen {

	public JButton saveButton;
	public JButton cancelButton;

	public static JPasswordField oldpasswordPasswordfield;
	public static JPasswordField newpasswordPasswordfield;
	public static JPasswordField newpasswordcontrolPasswordfield;

	JLabel oldpasswordLabel;
	JLabel newpasswordLabel;
	JLabel newpasswordcontrolLabel;
	public static JLabel newpassworddoesnotmatchLabel;
	public static JLabel stateoldpasswordLabel;

	/**
	 * constructor without Layout
	 */
	public PasswortAendern() {
		this.setLayout(null);

		oldpasswordLabel = new JLabel("Altes Passwort: ");
		oldpasswordLabel.setBounds(0, 0, 450, 100);
		oldpasswordLabel.setBackground(Color.LIGHT_GRAY);
		oldpasswordLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		newpasswordLabel = new JLabel("Neues Passwort: ");
		newpasswordLabel.setBounds(0, 150, 450, 100);
		newpasswordLabel.setBackground(Color.LIGHT_GRAY);
		newpasswordLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		newpasswordcontrolLabel = new JLabel("Wiederholen Sie Ihr neues Passwort: ");
		newpasswordcontrolLabel.setBounds(0, 300, 450, 100);
		newpasswordcontrolLabel.setBackground(Color.LIGHT_GRAY);
		newpasswordcontrolLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		newpassworddoesnotmatchLabel = new JLabel("Das neue Passwort stimmt nicht überein!");
		newpassworddoesnotmatchLabel.setBounds(0, 450, 450, 75);
		newpassworddoesnotmatchLabel.setBackground(Color.WHITE);
		newpassworddoesnotmatchLabel.setForeground(Color.RED);
		newpassworddoesnotmatchLabel.setVisible(false);

		stateoldpasswordLabel = new JLabel("Altes Passwort ist falsch!");
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

		saveButton = new JButton("Speichern");
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(d -> {
			try {
				DatabaseConnection.connectDatabase();
				try {
					FunktionPasswortAendern.changePassword();
				} catch (ChangePasswordException e) {

				}
				DatabaseConnection.disconnectDatabase();
			} catch (DatabaseConnectException e) {

			}
		});

		cancelButton = new JButton("Abbrechen");
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(0, 600, 225, 100);
		cancelButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		cancelButton.addActionListener(d -> {
			Fenster.addToFrame(new ProfilBearbeiten());
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
