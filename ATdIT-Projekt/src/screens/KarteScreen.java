package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import master.MasterScreen;

public class KarteScreen extends MasterScreen {

    public KarteScreen() {
    	this.setLayout(null);
    	this.setBackground(Color.white);
    	JPanel kartePanel = new JPanel();
    	JLabel karteLabel = new JLabel("KARTE");
    	karteLabel.setFont(new Font("Calibri", Font.BOLD, 40));
    	karteLabel.setBackground(Color.white);
    	kartePanel.setBackground(Color.white);
    	kartePanel.add(karteLabel);
    	kartePanel.setBounds(75, 150, 300, 50);
    	
    	JPanel streckenLaengePanel = new JPanel();
    	JLabel streckenLaengeLabel = new JLabel("Streckenlänge (in Kilometern)");
    	streckenLaengeLabel.setFont(new Font("Calibri", Font.BOLD, 25));
    	streckenLaengeLabel.setBackground(Color.white);
    	streckenLaengePanel.setBackground(Color.white);
    	streckenLaengePanel.setBounds(10, 375, 400, 50);
    	streckenLaengePanel.add(streckenLaengeLabel);
    	JSlider streckenLaengeSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 10);
    	streckenLaengeSlider.setBounds(50, 425, 300, 50);
    	streckenLaengeSlider.setBackground(Color.white);
    
    	
    	JPanel hoehenunterschiedPanel = new JPanel();
    	JLabel hoehenunterschiedLabel = new JLabel("Höhenunterschied (in Metern)");
    	hoehenunterschiedLabel.setFont(new Font("Calibri", Font.BOLD, 25));
    	hoehenunterschiedLabel.setBackground(Color.white);
    	hoehenunterschiedPanel.setBackground(Color.white);
    	hoehenunterschiedPanel.setBounds(10, 475, 400, 50);
    	hoehenunterschiedPanel.add(hoehenunterschiedLabel);
    	JSlider hoehenunterschiedSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 1000, 250);
    	hoehenunterschiedSlider.setBounds(50, 525, 300, 50);
    	hoehenunterschiedSlider.setBackground(Color.white);
    	
    	this.add(kartePanel);
    	this.add(streckenLaengePanel);
    	this.add(hoehenunterschiedPanel);
    	this.add(streckenLaengeSlider);
    	this.add(hoehenunterschiedSlider);
    	
    	int streckenLaenge = streckenLaengeSlider.getValue();
    	int hoehenunterschied = hoehenunterschiedSlider.getValue();
    	
    }
}