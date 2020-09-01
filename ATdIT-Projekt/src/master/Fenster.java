package master;

import javax.swing.*;

import connection.Benutzer;

import java.awt.event.*;
import java.awt.*;

public class Fenster extends JFrame {
	
	private final int SIZE_X = 466, SIZE_Y = 839;
	
	private static Fenster masterFrame;
	private static Container content;
	
	private static Benutzer user;
	
	public Fenster() {
		
		masterFrame = this;
		content = this.getContentPane();

		this.setTitle("ATdIT Projekt");
		this.setBounds(-900, 20, SIZE_X, SIZE_Y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public static Benutzer getUser() {
		return Fenster.user;
	}
	
	public static boolean setUser(Benutzer user) {
		Fenster.user = user;
		return true;		
	}

	public static void addToFrame(Body body) {
		
		neuZeichnen(new Panel(body));
		
	}
	
	public static void addToFrame(MasterScreen screen) {

		neuZeichnen(new Panel(screen));
		
	}
	
	public static void addToFrame(MasterScreen screen, MasterBanner banner) {

		neuZeichnen(new Panel(screen, banner));
	
	}
	
	
	private static void neuZeichnen(Panel p) {

		masterFrame.remove(content);
		masterFrame.add(p);
		content = p;
		
		masterFrame.revalidate();
		masterFrame.repaint();
		
	}
	
	public static void malen() {
		masterFrame.revalidate();
		masterFrame.repaint();
	}
	
}
