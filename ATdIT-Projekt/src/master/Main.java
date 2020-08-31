package master;

import screens.Login;

public class Main {

	
	public static void main(String[] args) {
		
		Fenster frame = new Fenster();
		frame.setVisible(true);
		Fenster.addToFrame(new Login());
		
	}
	
}
