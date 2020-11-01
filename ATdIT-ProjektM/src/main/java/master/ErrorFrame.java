package master;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.*;

import exceptions.DatabaseConnectException;

public class ErrorFrame extends JFrame {
	
	JTextArea text;
	
	public ErrorFrame(DatabaseConnectException dbE) {
		this();
//		System.out.println("dbEx");
		
		StringWriter buffer = new StringWriter();
		PrintWriter writer = new PrintWriter(buffer);
		
		dbE.printStackTrace(writer);
		
		String str = "Datenbank konnte nicht verbunden werden. \n" + buffer.toString();
		
		text.setText(str);
		
	}
	
	public ErrorFrame(Exception e) {
		this();
		System.out.println(e.getClass());
		
		StringWriter buffer = new StringWriter();
		PrintWriter writer = new PrintWriter(buffer);
		
		e.printStackTrace(writer);
		
		String str = buffer.toString();
		
		text.setText(str);
		
	}
	
	
	public ErrorFrame() {

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(-900, 20, 600, 400);
		
		text = new JTextArea();
		this.getContentPane().add(text);
		
		this.setVisible(true);
		
	}

}
