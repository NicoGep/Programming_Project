package screens;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import funktionen.LoginFunktion;
import master.Body;



public class Login extends Body {
	
	public static JButton reg;
	public static JButton login;
	public static JButton passVer;
	
	
	public Login() {
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(13,1));
		pan.setBounds(0,0,450,800);
		
		
		JLabel einlog = new JLabel ("Log-In");
		Font titel = new Font ("Segoe UI", Font.BOLD, 30);
		einlog.setFont(titel);
		
		
		JLabel benutzer = new JLabel("Benutzername");
		JTextField benutzertx = new JTextField();
		
		JLabel passwort = new JLabel("Passwort");
		JPasswordField passworttx = new JPasswordField();
		
		JLabel leer0 = new JLabel();
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		JLabel leer2 = new JLabel();
		
		
		reg = new JButton("Registrieren");
		passVer = new JButton("Passwort vergessen?");
		login = new JButton ("Einloggen");
		
	
//		pan.add(leer0);
		pan.add(leer);
		pan.add(einlog);
		pan.add(benutzer);
		pan.add(benutzertx);
		pan.add(passwort);
		pan.add(passworttx);
		pan.add(leer1);
		pan.add(reg);
		pan.add(passVer);	
		pan.add(leer2);
		pan.add(login);
		
		this.add(pan);
		
		
		LoginFunktion regF = new LoginFunktion();
		reg.addActionListener(regF);
		
		LoginFunktion einl = new LoginFunktion();
		login.addActionListener(einl);
		
		LoginFunktion pwV = new LoginFunktion();
		passVer.addActionListener(pwV);
		
	
		
	}
		@Override
		protected void paintComponent (Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\I518194\\Pictures\\wandern (2).jpg");	
		super.paintComponent(g);
		g.drawImage(img, 0, 0 , null);
		setVisible(true);
		
		}  
		
		
		public static void main(String[] args) {
			new Login();
		}
		
		
	
//	JButton button, button2, button3, button4;
//	
//	public Login() {
//
//		this.setLayout(new GridLayout(4, 1));
//		this.setBackground(Color.red);
//
//		button = new JButton("Login");
//		button2 = new JButton("Loginscreen");
//		button3 = new JButton("TestScreen + Banner");
//		button4 = new JButton("Ms Teams");
//		
//		this.add(button);
//		this.add(button2);
//		this.add(button3);
//		this.add(button4);
//		
//		button.addActionListener(this);
//		button2.addActionListener(this);
//		button3.addActionListener(this);
//		button4.addActionListener(this);
//		
//	}
//
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//			if(e.getSource() == button) {
//				Fenster.addToFrame(new LoginScreen());
//			}
//			else if(e.getSource() == button2) {
//				Fenster.addToFrame(new TestScreen());
//			}
//			else if(e.getSource() == button3) {
//				Fenster.addToFrame(new TestScreen(), new BeispielBanner());
//			}
//			else if(e.getSource() == button4) {
//				Fenster.addToFrame(new MsTeams());
//			}
//			
//			
//		}
//		
//	
//	
}
