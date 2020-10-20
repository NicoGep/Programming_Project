package master;

import javax.swing.*;

import connection.Validator;
import exceptions.DatabaseConnectException;

/** Klasse, um den MasterScreen bereitzustellen
 * 
 * @author Gruppe 3
 *
 */
public class MasterScreen extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 700;
	
	
	public MasterScreen() {

		this.setBounds(0, 100, SIZE_X, SIZE_Y);
		
	}

}
