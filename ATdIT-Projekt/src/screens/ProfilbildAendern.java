package screens;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import funktionen.FunktionProfilbildAendern;
import master.MasterScreen;

public class ProfilbildAendern extends MasterScreen {
	public static JButton speichern;
	public static JButton abbrechen;

	JLabel addresseLabel;
	public static JTextField addresse;

	public ProfilbildAendern() {
		this.setLayout(null);
		ActionListener ProfilbildAendernAL = new FunktionProfilbildAendern();

		addresseLabel = new JLabel("Adresse des neuen Profilbilds: ");
		addresseLabel.setBounds(0, 0, 450, 100);
		addresseLabel.setBackground(Color.LIGHT_GRAY);
		addresseLabel.setFont(new Font("Ueberschrift", Font.BOLD, 20));

		addresse = new JTextField(MeinProfil.profilBildAdresse);
		addresse.setBounds(0, 100, 450, 50);

		speichern = new JButton("Speichern");
		speichern.setBackground(Color.GREEN);
		speichern.setBounds(225, 600, 225, 100);
		speichern.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		speichern.addActionListener(ProfilbildAendernAL);

		abbrechen = new JButton("Abbrechen");
		abbrechen.setBackground(Color.RED);
		abbrechen.setBounds(0, 600, 225, 100);
		abbrechen.setFont(new Font("Ueberschrift", Font.BOLD, 18));
		abbrechen.addActionListener(ProfilbildAendernAL);
		
		this.add(addresseLabel);
		this.add(addresse);
		this.add(abbrechen);
		this.add(speichern);
	}

}
