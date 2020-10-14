package master;

import screens.*;

/** Main class : main method to start the Application
 * 
 * @author Group3
 *
 */
public class Main {
	
	/**	main method
	 * 
	 * @param args : String[] (args-Array)
	 */
	public static void main(String[] args) {
		Fenster frame = new Fenster();
		frame.setVisible(true);
		Fenster.reset();
	}
	
}
