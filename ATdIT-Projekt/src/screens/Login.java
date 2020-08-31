package screens;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import master.Body;
import master.Fenster;

public class Login extends Body implements ActionListener {
	
	JButton button, button2, button3, button4, button5;
	
	public Login() {

		this.setLayout(new FlowLayout());
		this.setBackground(Color.red);

		button = new JButton("Login");
		button2 = new JButton("TestScreen");
		button3 = new JButton("TestScreen + Banner");
		button4 = new JButton("Ms Teams");
		button5 = new JButton("Vero");
		
		this.add(button);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
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
			else if(e.getSource() == button5) {
				Fenster.addToFrame(new VeronikasKlasse());
			}
			
			
		}
		
	
	
}
