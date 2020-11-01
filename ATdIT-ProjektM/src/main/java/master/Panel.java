package master;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 800;
	
	String temp;
	
	public Panel() {
		
		this.setLayout(null);
		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		
	}
	
	public Panel(Body body) {
		this();
		temp = body.getClass().getSimpleName();
//		body.setBounds(0, 0, SIZE_X, SIZE_Y);
		this.add(body);
		
	}
	
	public Panel(MasterScreen screen) {
		this();
		temp = screen.getClass().getSimpleName();		
		this.add(new MasterBanner());
		this.add(screen);
		
	}
	
	public Panel(MasterScreen screen, MasterBanner banner) {
		this();
		temp = screen.getClass().getSimpleName();		
		this.add(banner);
		this.add(screen);
		
	}
	

	@Override
	public String toString() {
		return temp;
	}


}
