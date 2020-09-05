package screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.*;

import funktionen.AusloggenFunktion;
import funktionen.KarteFunktion;
import funktionen.MeinProfilFunktion;
import funktionen.MountainBikeFunktion;
import master.Fenster;
import master.MasterBanner;
import master.MasterScreen;

public class MenuScreen extends MasterScreen {
	
	public JPanel menuPanel;
	public JLabel menuLabel;
	public static JButton karteButton;
	public static JButton mountainbikeKarteButton;
	public static JButton meinProfilButton;
	public static JButton ausloggenButton;
	
	
	public MenuScreen( ) {
		
		//Definition UI-Layout
		this.setBackground(Color.white);
		this.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(75, 50, 300, 50);
		menuLabel = new JLabel("MENÜ");
		menuLabel.setBackground(Color.white);
		menuLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		menuPanel.add(menuLabel);
		menuPanel.setBackground(Color.white);
		
		
		karteButton = new JButton("Karte");
		karteButton.setBackground(Color.white);
		karteButton.setBounds(75, 150, 300, 50);
		karteButton.setBorderPainted(false);
		karteButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		mountainbikeKarteButton = new JButton("Mountainbiking");
		mountainbikeKarteButton.setBackground(Color.white);
		mountainbikeKarteButton.setBounds(75, 250, 300, 50);
		mountainbikeKarteButton.setBorderPainted(false);
		mountainbikeKarteButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		meinProfilButton = new JButton("Mein Profil");
		meinProfilButton.setBounds(75, 350, 300, 50);
		meinProfilButton.setBackground(Color.white);
		meinProfilButton.setBorderPainted(false);
		meinProfilButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		ausloggenButton = new JButton("Ausloggen");
		ausloggenButton.setBackground(Color.white);
		ausloggenButton.setBounds(170, 600, 125, 50);
		ausloggenButton.setBorderPainted(false);
		ausloggenButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		//Funktionsaufruf ActionListener für Buttons
		karteButton.addActionListener(new KarteFunktion());
		mountainbikeKarteButton.addActionListener(new MountainBikeFunktion());
		meinProfilButton.addActionListener(new MeinProfilFunktion());
		ausloggenButton.addActionListener(new AusloggenFunktion());
		this.add(menuPanel);
		this.add(karteButton);
		this.add(mountainbikeKarteButton);
		this.add(meinProfilButton);
		this.add(ausloggenButton);
	}
}
