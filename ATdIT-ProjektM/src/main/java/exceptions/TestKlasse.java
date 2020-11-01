package exceptions;

import master.Window;
import screens.*;

public class TestKlasse {
	
	public static void main(String[] args) throws InterruptedException {
		new Window().setVisible(true);;
		Window.addToFrame(new Login());
		Thread.sleep(1000);
		Window.showDisconnectScreen();
	}

}
