package master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Master class, to set a general window size
 * @author Group3
 *
 */
public class Body extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 800;
	
	/**
	 * constructor
	 */
	public Body() {

		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		
		
	}
	
	/**
	 * Function to add a MasterScreen to the Body
	 * @param screen : MasterScreen
	 */
	protected void addToBody(MasterScreen screen) {
		
		this.add(screen);
		
	}
	
}
