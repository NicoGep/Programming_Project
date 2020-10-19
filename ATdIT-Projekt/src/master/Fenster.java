package master;

import javax.swing.*;
import connection.Benutzer;
import screens.Login;
import java.util.*;
import java.awt.*;

/**
 * Window class sets size of the window, title and more
 * @author Group3
 *
 */
public class Fenster extends JFrame {
	
	private final int SIZE_X = 466, SIZE_Y = 839;
	
	private static final int MAX_HISTORY_SIZE = 5;
	
	private static Fenster masterFrame;
	private static Container content;
	
	/**
	 * Stack for the window history so that the back button can function perfectly
	 */
	private static Stack<Container> history = new Stack<Container>();
	
	/**
	 * constructor
	 * sets the name of the window
	 * sets the size of the window
	 * sets the exit function
	 * specifies that the window size cannot be changed
	 * 
	 */
	public Fenster() {
		
		masterFrame = this;

		this.setTitle("wanderoo");
		this.setBounds(20, 20, SIZE_X, SIZE_Y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	//TEMP
	private static void printHistory() {
		for(int i = 0; i < history.size(); i++)
			System.out.println(history.get(i));
	}
	
	/**
	 *  return the last window of the stack
	 */
	public static void lastContent() {
		newDraw(history.pop());
	}
	
	/**
	 * History-Container is emptied
	 */
	public static void clearHistory() {
		history = new Stack<Container>();
	}
	
	/** current window is added to the History-Stack
	 * 
	 * @param container : Container (window-container)
	 */
	private static void addToHistory(Container container) {
		if(history.size() >= MAX_HISTORY_SIZE)
			history.pop();
		history.push(container);
	}
	
	/**
	 * method to logout the user, empty the history-stack and open a new login window
	 */
	public static void reset() {
		Benutzer.logoutUser();
		clearHistory();
		newDraw(new Panel(new Login()));
	}
	
	
	//------------------------------------------------------------------- Add To Frame ----------------------------------------------------------
	
	private static void addToFrame(Panel p) {
		addToHistory(content);
		newDraw(p);
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
	
	public static void newDraw() {
		newDraw(content);
	}
	
	public static void newDraw(Container p) {
	
		content = p;
		masterFrame.setContentPane(content);
		
		content.revalidate();
		content.repaint();
		
		masterFrame.revalidate();
		masterFrame.repaint();
		
	}
	
}
