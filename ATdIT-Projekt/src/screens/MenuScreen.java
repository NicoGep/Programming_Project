package screens;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.*;

import funktionen.AusloggenFunktion;
import funktionen.KarteFunktion;
import funktionen.MountainBikeFunktion;
import master.Fenster;
import master.MasterBanner;
import master.MasterScreen;

public class MenuScreen extends MasterScreen {
	
	JPanel menuPanel;
	JLabel menuLabel;
	JButton karteButton;
	JButton mountainbikeKarteButton;
	JButton meinProfilButton;
	JButton ausloggenButton;
	
	
	public MenuScreen( ) {
		this.setBackground(Color.white);
		this.setLayout(null);
		
//		menuPanel = new JPanel();
//		menuPanel.setBounds(150, 25, 50, 50);
//		menuPanel.setLayout(new BorderLayout());
//		menuLabel = new JLabel("MENÜ");
//		menuPanel.add(menuLabel, java.awt.BorderLayout.CENTER);
//		this.add(menuPanel);
		
		karteButton = new JButton("Karte");
		karteButton.setBackground(Color.white);
		karteButton.setBounds(75, 100, 300, 50);
		karteButton.setBorderPainted(false);
		karteButton.setFont(new Font("Calibri", Font.BOLD, 16));
		mountainbikeKarteButton = new JButton("Mountainbiking");
		mountainbikeKarteButton.setBackground(Color.white);
		mountainbikeKarteButton.setBounds(75, 200, 300, 50);
		mountainbikeKarteButton.setBorderPainted(false);
		mountainbikeKarteButton.setFont(new Font("Calibri", Font.BOLD, 16));
		meinProfilButton = new JButton("Mein Profil");
		meinProfilButton.setBounds(75, 300, 300, 50);
		meinProfilButton.setBackground(Color.white);
		meinProfilButton.setBorderPainted(false);
		meinProfilButton.setFont(new Font("Calibri", Font.BOLD, 16));
		ausloggenButton = new JButton("Ausloggen");
		ausloggenButton.setBackground(Color.white);
		ausloggenButton.setBounds(170, 600, 125, 50);
		ausloggenButton.setBorderPainted(false);
		ausloggenButton.setFont(new Font("Calibri", Font.BOLD, 16));
		
		karteButton.addActionListener(new KarteFunktion());
		mountainbikeKarteButton.addActionListener(new MountainBikeFunktion());
		//meinProfilButton.addActionListener(new MeinProfilFunktion());
		ausloggenButton.addActionListener(new AusloggenFunktion());
		this.add(karteButton);
		this.add(mountainbikeKarteButton);
		this.add(meinProfilButton);
		this.add(ausloggenButton);
	}



}
