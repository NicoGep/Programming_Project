package tests;

import javax.swing.*;
import java.awt.*;

public class LambdaTest extends JFrame {

	Container c;
	
	JButton b;
	
	public LambdaTest() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(10, 10, 100, 200);
		this.setVisible(true);
		
		c = this.getContentPane();
		
		b = new JButton("Knopf");
		
		c.add(b);
		
		b.addActionListener(w -> { System.out.println("Test Ausgabe"); System.out.println("Test2"); } );
		
	}

	public static void main(String[] args) {
		new LambdaTest();
	}
	
}
