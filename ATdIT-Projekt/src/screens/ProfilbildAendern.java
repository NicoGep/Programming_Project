package screens;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import funktionen.FunktionProfilbildAendern;
import master.MasterScreen;

/** UI class for class "ProfilbildAendern"
 * 
 * @author Group3
 *
 */
public class ProfilbildAendern extends MasterScreen {
	public static JButton saveButton;
	public static JButton cancelButton;

	JLabel addressLabel;
	public static JTextField addressTextfield;

	/**
	 * constructor without layout 
	 */
	public ProfilbildAendern() {
		this.setLayout(null);
		ActionListener ProfilbildAendernAL = new FunktionProfilbildAendern();

		addressLabel = new JLabel("Adresse des neuen Profilbilds: ");
		addressLabel.setBounds(0, 0, 450, 100);
		addressLabel.setBackground(Color.LIGHT_GRAY);
		addressLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		addressTextfield = new JTextField(MeinProfil.profilepictureaddress);
		addressTextfield.setBounds(0, 100, 450, 50);

		saveButton = new JButton("Speichern");
		saveButton.setBackground(Color.GREEN);
		saveButton.setBounds(225, 600, 225, 100);
		saveButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		saveButton.addActionListener(ProfilbildAendernAL);

		cancelButton = new JButton("Abbrechen");
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(0, 600, 225, 100);
		cancelButton.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		cancelButton.addActionListener(ProfilbildAendernAL);
		
		this.add(addressLabel);
		this.add(addressTextfield);
		this.add(cancelButton);
		this.add(saveButton);
	}

}
