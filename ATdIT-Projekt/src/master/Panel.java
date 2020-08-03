package master;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 800;
	
	public Panel() {
		
		this.setLayout(null);
		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		
	}
	
	public Panel(Body body) {
		
		this();
//		body.setBounds(0, 0, SIZE_X, SIZE_Y);
		this.add(body);
		
	}
	
	public Panel(MasterScreen screen) {
		
		this();
		this.add(new MasterBanner());
		this.add(screen);
		
	}
	
	public Panel(MasterScreen screen, MasterBanner banner) {
		
		this();
		this.add(banner);
		this.add(screen);
		
	}

}
