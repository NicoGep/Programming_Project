package master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 	Masterklasse, um einheitliche Fenstergröße festzulegen
 * @author I518230
 *
 */
public class Body extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 800;
	
	/**
	 * Konstruktor
	 */
	public Body() {

		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		
		
	}
	
	/**
	 * Funktion um einen MasterScreen zum Body hinzuzufügen
	 * @param screen : MasterScreen
	 */
	protected void addToBody(MasterScreen screen) {
		
		this.add(screen);
		
	}
	
}
