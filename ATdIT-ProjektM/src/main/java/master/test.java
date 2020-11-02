package master;

import screens.MenuScreen;

public class test {
	
	public static void main(String[] args) throws Exception {
		Window frame = new Window();
		frame.setVisible(true);
		Window.reset();
		Thread.sleep(5000);
		Window.addToFrame(new MenuScreen());
	}

}
