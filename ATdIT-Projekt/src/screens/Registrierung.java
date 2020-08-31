package screens;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import master.MasterScreen;



public class Registrierung extends MasterScreen {

	public Registrierung() {
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(13,1));
		pan.setBounds(0,0,450,800);
		
		JLabel registr = new JLabel ("Registrieren");
		Font titel = new Font ("Segoe UI", Font.BOLD, 30);
		registr.setFont(titel);
		
		JLabel mail = new JLabel("E-Mail Adresse: ");
		JTextField mailtx = new JTextField();
		
		JLabel bname = new JLabel("Benutzername: ");
		JTextField bnametx = new JTextField();
		
		JLabel pw = new JLabel("Passwort: ");
		JPasswordField pwtx = new JPasswordField();
		
		JLabel pwwied = new JLabel("Passwort wiederholen: ");
		JPasswordField pwwiedtx = new JPasswordField();
		
		JCheckBox agb = new JCheckBox("Ich stimme den AGB zu ...");
		
		JButton reg = new JButton("Registieren");
		
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		
		pan.add(leer);
		pan.add(registr);
		pan.add(mail);
		pan.add(mailtx);
		pan.add(bname);
		pan.add(bnametx);
		pan.add(pw);
		pan.add(pwtx);
		pan.add(pwwied);
		pan.add(pwwiedtx);
		pan.add(agb);
		pan.add(leer1);
		pan.add(reg);
		
		this.add(pan);
			
		
	}

	@Override
		protected void paintComponent (Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\I518194\\Pictures\\wandern (2).jpg");	
		super.paintComponent(g);
		g.drawImage(img, 0, 0 , null);
		setVisible(true);
		}
	
	public static void main (String[] args) {
		new Registrierung();
	}
	}

