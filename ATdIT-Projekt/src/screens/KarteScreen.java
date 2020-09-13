package screens;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import funktionen.FunktionKarte;
import funktionen.KarteSliderFunktion;
import master.MasterScreen;

public class KarteScreen extends MasterScreen {

	public JSlider streckenLaengeSlider;
	public JSlider hoehenunterschiedSlider;
	
	public KarteScreen() {
		this.setLayout(null);
		this.setBackground(Color.white);

		JPanel kartePanel = new JPanel();
		kartePanel.setBackground(Color.gray);
		kartePanel.setBounds(75, 150, 300, 50);
		
		JLabel karteLabel = new JLabel("KARTE");
		karteLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		karteLabel.setBackground(Color.white);
		kartePanel.add(karteLabel);

		JPanel streckenLaengePanel = new JPanel();
		streckenLaengePanel.setBackground(Color.white);
		streckenLaengePanel.setBounds(10, 375, 400, 50);
		
		JLabel streckenLaengeLabel = new JLabel("Streckenlänge (in Metern)");
		streckenLaengeLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		streckenLaengeLabel.setBackground(Color.white);
		streckenLaengePanel.add(streckenLaengeLabel);
		

		ChangeListener cL = new KarteSliderFunktion(this);
//		ChangeListener cL = new FunktionKarte(this);

		hoehenunterschiedSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 1000, 250);
		
		streckenLaengeSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 20000, 10000);
		streckenLaengeSlider.setBounds(50, 425, 300, 50);
		streckenLaengeSlider.setBackground(Color.white);
		streckenLaengeSlider.setMinorTickSpacing(500);
		streckenLaengeSlider.addChangeListener(cL);

		JPanel hoehenunterschiedPanel = new JPanel();
		hoehenunterschiedPanel.setBackground(Color.white);
		hoehenunterschiedPanel.setBounds(10, 475, 400, 50);
		
		JLabel hoehenunterschiedLabel = new JLabel("Höhenunterschied (in Metern)");
		hoehenunterschiedLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		hoehenunterschiedLabel.setBackground(Color.white);
		hoehenunterschiedPanel.add(hoehenunterschiedLabel);
		
		hoehenunterschiedSlider.setBounds(50, 525, 300, 50);
		hoehenunterschiedSlider.setBackground(Color.white);
		hoehenunterschiedSlider.setMinorTickSpacing(50);
		hoehenunterschiedSlider.addChangeListener(cL);

		this.add(kartePanel);
		this.add(streckenLaengePanel);
		this.add(hoehenunterschiedPanel);
		this.add(streckenLaengeSlider);
		this.add(hoehenunterschiedSlider);
	}
	
}