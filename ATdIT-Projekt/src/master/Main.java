package master;

import screens.*;

/** Main-Klasse: main-Methode starten, um die Applikation zu starten
 * 
 * @author I518230
 *
 */
public class Main {
	
	/**	main-Methode
	 * 
	 * @param args : String[] (args-Array)
	 */
	public static void main(String[] args) {
		Fenster frame = new Fenster();
		frame.setVisible(true);
		Fenster.reset();
	}
	
}
