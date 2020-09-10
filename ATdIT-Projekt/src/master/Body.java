package master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Body extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 800;
	
	public Body() {

		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		
		
	}
	
	protected void addToBody(MasterScreen screen) {
		
		this.add(screen);
		
	}
	
}
