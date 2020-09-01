package master;

import screens.Login;
import screens.LoginScreen;

public class Main {

	
	public static void main(String[] args) {
		
		Fenster frame = new Fenster();
		frame.setVisible(true);
		Fenster.addToFrame(new LoginScreen());
		
	}
	
}
