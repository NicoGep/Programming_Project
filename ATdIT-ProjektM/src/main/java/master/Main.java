package master;

import connection.Validator;

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
		
			
		Validator.createValidator();
			
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {		}
		
		Window frame = new Window();
		Window.reset();
		frame.setVisible(true);
		

		
		
	}
	
	
	//########################### Zugriff von mehreren Geräten ##########################
	
}
