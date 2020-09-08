package master;

import javax.swing.*;

import connection.Benutzer;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class Fenster extends JFrame {
	
	private final int SIZE_X = 466, SIZE_Y = 839;
	
	private static Fenster masterFrame;
	private static Container content;
	
	
	public Fenster() {
		
		masterFrame = this;
		content = this.getContentPane();

		this.setTitle("ATdIT Projekt");
		this.setBounds(20, 20, SIZE_X, SIZE_Y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}

	public static void addToFrame(Body body) {
		
//		lastContent.add(content);
		
		Panel p = new Panel(body);		
		neuZeichnen(p);
		
	}
	
	public static void addToFrame(MasterScreen screen) {
		
//		lastContent.add(content);
		
		Panel p = new Panel(screen);
		neuZeichnen(p);
		
	}
	
	public static void addToFrame(MasterScreen screen, MasterBanner banner) {
		
//		lastContent.add(content);

		Panel p = new Panel(screen, banner);
		neuZeichnen(p);
	
	}
	
	
	private static void neuZeichnen(Panel p) {

		masterFrame.remove(content);
		masterFrame.add(p);
		content = p;
		
		masterFrame.revalidate();
		masterFrame.repaint();
		
	}
	
	
}
