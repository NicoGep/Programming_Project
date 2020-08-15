package funktionen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import master.Fenster;
import screens.MeinProfil;
import screens.ProfilBearbeiten;

public class FunktionProfilBearbeiten implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ProfilBearbeiten.abbrechen) {
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == ProfilBearbeiten.speichern) {
			// Speichern der Daten einfügen
			Fenster.addToFrame(new MeinProfil());
		}
		if (e.getSource() == ProfilBearbeiten.neuesProfilbild) {
			JDialog profilBildAdresse = new JDialog(new Fenster(), true);
			profilBildAdresse.getContentPane();
			profilBildAdresse.setLayout(new BorderLayout());
			profilBildAdresse.setSize(250, 400);
			profilBildAdresse.add(new JLabel("Geben Sie die Adresse des Profilbilds an:"), BorderLayout.NORTH);
			JTextField adresse = new JTextField();
			profilBildAdresse.add(adresse, BorderLayout.CENTER);
			JButton speichern = new JButton("Speichern");
			speichern.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					MeinProfil.profilBildAdresse = adresse.getText();
					profilBildAdresse.dispose();
					profilBildAdresse.setModal(false);
				}
			});
			profilBildAdresse.add(speichern,BorderLayout.SOUTH);
			profilBildAdresse.setVisible(true);
		}

	}

}
