package screens;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import funktionen.PasswortVergFunktion;
import master.Body;
import master.MasterScreen;

public class PasswortVerg extends Body {
	
	public static JButton back;
	
	public PasswortVerg() {
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(13,1));
		pan.setBounds(0,0,450,800);
		
		JLabel passVerg = new JLabel ("Passwort ");
		JLabel passVerg2 = new JLabel ("vergessen?");
		Font titel = new Font ("Segoe UI", Font.BOLD, 30);
		passVerg.setFont(titel);
		passVerg2.setFont(titel);
		
		JLabel text = new JLabel("Ein Code wurde an Ihre hinterlegte ");
		JLabel text1 = new JLabel("E-Mail Adresse gesendet!");
		JLabel text2 = new JLabel("Code eingeben: ");
		
		JTextField c1 = new JTextField();
		
		
		JButton einl = new JButton("Einloggen");
		back = new JButton("Zur�ck");
		
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		JLabel leer2 = new JLabel();
		JLabel leer3 = new JLabel();
		
		pan.add(leer);
		pan.add(passVerg);
		pan.add(passVerg2);
		pan.add(leer1);
		pan.add(text);
		pan.add(text1);
		pan.add(text2);
		pan.add(c1);
		pan.add(leer2);
		pan.add(einl);
		pan.add(leer3);
		pan.add(back);
	
		this.add(pan);
		
		back.addActionListener(new PasswortVergFunktion());
	}
	
	@Override
	protected void paintComponent (Graphics g) {
	Image img = Toolkit.getDefaultToolkit().getImage("./ui/images/wandern (2).jpg");	
	super.paintComponent(g);
	g.drawImage(img, 0, 0 , null);
	setVisible(true);
	}

}
