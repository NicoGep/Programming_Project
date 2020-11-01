package master;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private final int SIZE_X = 450, SIZE_Y = 800;
	
	String toString_identity;
	
	public Panel() {
		
		this.setLayout(null);
		this.setBounds(0, 0, SIZE_X, SIZE_Y);
		
	}
	
	public Panel(Body body) {
		this();
		toString_identity = body.getClass().getSimpleName();
//		body.setBounds(0, 0, SIZE_X, SIZE_Y);
		this.add(body);
		
	}
	
	public Panel(MasterScreen screen) {
		this();
		toString_identity = screen.getClass().getSimpleName();		
		this.add(new MasterBanner());
		this.add(screen);
		
	}
	
	public Panel(MasterScreen screen, MasterBanner banner) {
		this();
		toString_identity = screen.getClass().getSimpleName();		
		this.add(banner);
		this.add(screen);
		
	}
	

	@Override
	public String toString() {
		return toString_identity;
	}


}
