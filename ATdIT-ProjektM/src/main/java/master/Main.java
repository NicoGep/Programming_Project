package master;

import connection.Groups;
import connection.Validator;
import exceptions.InputException;

/** Main-Klasse: main-Methode starten, um die Applikation zu starten
 * 
 * @author I518230
 *
 */
public class Main {
	
	/**	main-Methode
	 * 
	 * @param args : String[] (args-Array)
	 * @throws InterruptedException 
	 * @throws InputException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Window frame = new Window();
//		Window.reset();
		Window.showDisconnectScreen(1);
		
		Validator.createValidator();
		
		frame.setVisible(true);
	
		
	}
	
	
	//########################### Zugriff von mehreren Ger�ten ##########################
	
}
