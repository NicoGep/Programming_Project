package master;

import javax.swing.*;

import connection.Benutzer;
import screens.Login;

import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Fenster extends JFrame {
	
	private final int SIZE_X = 466, SIZE_Y = 839;
	
	private static final int MAX_HISTORY_SIZE = 5;
	
	private static Fenster masterFrame;
	private static Container content;
	
	private static Stack<Container> history = new Stack<Container>();
	
	
	public Fenster() {
		
		masterFrame = this;

		this.setTitle("ATdIT Projekt");
		this.setBounds(-900, 20, SIZE_X, SIZE_Y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	//TEMP
	private static void printHistory() {
		for(int i = 0; i < history.size(); i++)
			System.out.println(history.get(i));
	}
	
	public static void lastContent() {
		neuZeichnen(history.pop());
	}
	
	public static void clearHistory() {
		history = new Stack<Container>();
	}
	
	private static void addToHistory(Container cont) {
		if(history.size() >= MAX_HISTORY_SIZE)
			history.pop();
		history.push(cont);
	}
	
	public static void reset() {
		Benutzer.logoutUser();
		clearHistory();
		neuZeichnen(new Panel(new Login()));
	}
	
	
	//------------------------------------------------------------------- Add To Frame ----------------------------------------------------------
	
	private static void addToFrame(Panel p) {
		addToHistory(content);
		neuZeichnen(p);
	}

	public static void addToFrame(Body body) {
		addToFrame(new Panel(body));		
	}
	
	public static void addToFrame(MasterScreen screen) {
		addToFrame(new Panel(screen));
	}
	
	public static void addToFrame(MasterScreen screen, MasterBanner banner) {
		addToFrame(new Panel(screen, banner));
	}
	
	
	private static void neuZeichnen(Container p) {
	
		content = p;
		masterFrame.setContentPane(content);
		
		content.revalidate();
		content.repaint();
		
		masterFrame.revalidate();
		masterFrame.repaint();
		
	}
	
}
