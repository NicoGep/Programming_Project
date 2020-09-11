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

public class PasswortVerg extends Body {
	
	public static JButton back;
	
	public PasswortVerg() {
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(13,1));
		pan.setBounds(0,0,450,800);
		
		JLabel passwortVergessenTitel = new JLabel ("Passwort ");
		JLabel passwortVergessenTitel2 = new JLabel ("vergessen?");
		Font titel = new Font ("Segoe UI", Font.BOLD, 30);
		passwortVergessenTitel.setFont(titel);
		passwortVergessenTitel2.setFont(titel);
		
		JLabel text = new JLabel("Ein Code wurde an Ihre hinterlegte ");
		JLabel text1 = new JLabel("E-Mail Adresse gesendet!");
		JLabel text2 = new JLabel("Code eingeben: ");
		
		JTextField codetx = new JTextField();
		
		
		JButton einloggen = new JButton("Einloggen");
		back = new JButton("Zurück");
		
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		JLabel leer2 = new JLabel();
		JLabel leer3 = new JLabel();
		
		pan.add(leer);
		pan.add(passwortVergessenTitel);
		pan.add(passwortVergessenTitel2);
		pan.add(leer1);
		pan.add(text);
		pan.add(text1);
		pan.add(text2);
		pan.add(codetx);
		pan.add(leer2);
		pan.add(einloggen);
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
