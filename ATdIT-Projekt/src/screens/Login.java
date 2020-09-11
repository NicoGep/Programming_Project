package screens;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import funktionen.LoginFunktion;
import master.Body;

public class Login extends Body {

	public static JButton registrieren;
	public static JButton passwortVergessen;
	public static JButton login;
	
	private JTextField benutzertx;
	private JPasswordField passworttx;
	
	private JLabel falscherName;
	private JLabel falschesPasswort;

	public Login() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(13, 1));
		pan.setBounds(0, 0, 450, 800);

		JLabel einloggen = new JLabel("Log-In");
		Font titel = new Font("Segoe UI", Font.BOLD, 30);
		einloggen.setFont(titel);

		JLabel benutzer = new JLabel("Benutzername");
		benutzertx = new JTextField();
		benutzertx.setText("Test");

		JLabel passwort = new JLabel("Passwort");
		passworttx = new JPasswordField();
		passworttx.setText("key");

		// JLabel leer0 = new JLabel();
		JLabel leer = new JLabel();
		JLabel leer1 = new JLabel();
		JLabel leer2 = new JLabel();

		registrieren = new JButton("Registrieren");
		passwortVergessen = new JButton("Passwort vergessen?");
		login = new JButton("Einloggen");

		falscherName = new JLabel("");
		falschesPasswort = new JLabel("");
	
		// pan.add(leer0);
		pan.add(leer);
		pan.add(einloggen);

		pan.add(benutzer);
		pan.add(benutzertx);

		pan.add(passwort);
		pan.add(passworttx);

		pan.add(leer1);
		pan.add(registrieren);
		pan.add(passwortVergessen);
		pan.add(leer2);
		pan.add(login);
		
		pan.add(falscherName);
		pan.add(falschesPasswort);

		this.add(pan);
		
		ActionListener aL = new LoginFunktion(benutzertx, passworttx, falscherName, falschesPasswort);

		registrieren.addActionListener(aL);
		passwortVergessen.addActionListener(aL);
		login.addActionListener(aL);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = Toolkit.getDefaultToolkit().getImage("./ui/images/wandern (2).jpg");
		g.drawImage(img, 0, 0, null);
		setVisible(true);
		repaint();
	}
}
