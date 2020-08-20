package screens;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		JTextField passworttx = new JTextField();
		
		JLabel leer0 = new JLabel();
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		JLabel leer2 = new JLabel();
		
		
		JButton reg = new JButton("Registrieren");
		JButton passVer = new JButton("Passwort vergessen?");
		JButton login = new JButton ("Einloggen");
		
	
		JLabel btBild;
		Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\I518194\\Pictures\\wandern (2).jpg");
		btBild = new JLabel(new ImageIcon(image));
	
		
		
	
		
		
		
		this.add(btBild);
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
		
		this.add(pan, 0);
		
		LoginFunktion regF = new LoginFunktion();
		reg.addActionListener(regF);
		
		PasswVergFunktion pwV = new PasswVergFunktion();
		passVer.addActionListener(pwV);
		
	}

	
		
	}


		
	



	


