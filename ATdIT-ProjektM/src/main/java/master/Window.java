package master;

import javax.swing.*;
import connection.User;
import screens.DisconnectScreen;
import screens.EstablishingConnection;
import screens.Login;
import java.util.*;
import java.awt.*;

/**
 * Window class sets size of the window, title and more
 * @author Group3
 *
 */
@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private final int SIZE_X = 466, SIZE_Y = 839;
	
	private static final int MAX_HISTORY_SIZE = 5;
	
	private static Window masterFrame;
	private static Container content;
	
	private static boolean disconnectScreenFlag = false;
	
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
	public Window() {
		
		masterFrame = this;
		
		Window.addToHistory(new Panel(new Login()));

		this.setTitle("wanderoo");
		this.setBounds(20, 20, SIZE_X, SIZE_Y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public static void showDisconnectScreen(int i) {
		
		if(!disconnectScreenFlag) {
			
			switch(i) {
			case 0: Window.addToFrame(new Panel(new DisconnectScreen())); break;
			case 1: Window.newDraw(new Panel(new EstablishingConnection())); break;
			}
		}
		
		disconnectScreenFlag = true;
	}
	
	public static void hideDisconnectScreen() {
		
		if(disconnectScreenFlag)
			Window.lastContent();
		
		disconnectScreenFlag = false;
	}
	
	//TEMP
	@SuppressWarnings("unused")
	private static void printHistory() {
		for(int i = 0; i < history.size(); i++)
			System.out.println(history.get(i));
	}
	
	/**
	 *  return the last window of the stack
	 */
	public static void lastContent() {
		if(history.size() > 0)
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
		User.logoutUser();
		clearHistory();
		disconnectScreenFlag = false;
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