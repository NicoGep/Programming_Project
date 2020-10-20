package tests;

import java.io.*;

import javax.swing.*;

public class TestScreen extends JFrame {
	
	JTextArea text;
	
	StringWriter writer;
	
	public TestScreen() {
		
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("TestScreen");
		
		text = new JTextArea();
		
		
		this.add(text);
		
		this.setVisible(true);
	
	}
	
	public void addText(String text) {
		this.text.setText(this.text.getText().concat("\n\n" + text));
	}
	
	public void addText(Exception e) {
		writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		String str = "";
		writer.write(str);
		JLabel l = new JLabel(str);
		this.add(l);
	}
	
	public static void main(String[] args) {
		TestScreen s = new TestScreen();
		
	}
	

}
