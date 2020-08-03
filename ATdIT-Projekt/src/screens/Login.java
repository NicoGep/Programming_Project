package screens;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import master.Body;
import master.Fenster;

public class Login extends Body implements ActionListener {
	
	JButton button, button2, button3, button4;
	
	public Login() {

		this.setLayout(new GridLayout(4, 1));
		this.setBackground(Color.red);

		button = new JButton("Login");
		button2 = new JButton("TestScreen");
		button3 = new JButton("TestScreen + Banner");
		button4 = new JButton("Ms Teams");
		
		this.add(button);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
	}


		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == button) {
				Fenster.addToFrame(new Test2());
			}
			else if(e.getSource() == button2) {
				Fenster.addToFrame(new TestScreen());
			}
			else if(e.getSource() == button3) {
				Fenster.addToFrame(new TestScreen(), new BeispielBanner());
			}
			else if(e.getSource() == button4) {
				Fenster.addToFrame(new MsTeams());
			}
			
			
		}
		
	
	
}
