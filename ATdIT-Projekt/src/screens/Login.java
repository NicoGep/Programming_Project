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

import connection.Benutzer;
import connection.DatabaseConnection;
import exceptions.DatabaseConnectException;
import exceptions.LoginCredentialsException;
import funktionen.LoginFunktion;
import master.Body;

public class Login extends Body {

	public static JButton reg;
	public static JButton passVer;
	public static JButton login;
	
	private JTextField benutzertx;
	private JPasswordField passworttx;

	public Login() {
//		try {
//			DatabaseConnection.connectDatabase();
//			Benutzer.loginUser("Test2", "a");
//			DatabaseConnection.disconnectDatabase();
//		} catch (LoginCredentialsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DatabaseConnectException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(13, 1));
		pan.setBounds(0, 0, 450, 800);

		JLabel einlog = new JLabel("Log-In");
		Font titel = new Font("Segoe UI", Font.BOLD, 30);
		einlog.setFont(titel);

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

		reg = new JButton("Registrieren");
		passVer = new JButton("Passwort vergessen?");
		login = new JButton("Einloggen");

		// pan.add(leer0);
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
		
		ActionListener aL = new LoginFunktion(benutzertx, passworttx);

		reg.addActionListener(aL);
		passVer.addActionListener(aL);
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
