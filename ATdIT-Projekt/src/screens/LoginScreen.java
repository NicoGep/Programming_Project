package screens;

import java.awt.Font;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import funktionen.LoginFunktion;
import funktionen.PasswVergFunktion;
import master.Body;

public class LoginScreen extends Body {
	

	public LoginScreen() {
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
		
		
		JButton reg = new JButton("Registrieren");
		JButton passVer = new JButton("Passwort vergessen?");
		JButton login = new JButton ("Einloggen");
		
	
		pan.add(leer0);
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
		
		PasswVergFunktion pwV = new PasswVergFunktion();
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
			new LoginScreen();
		}
		
		
		
		
	
	}


		
		
	


		
	



	


