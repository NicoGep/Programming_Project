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

import connection.User;
import funktionen.ForgotPasswordFunction;
import master.Body;
import master.Window;

/** UI for screen "PasswortVerg"
 * 
 * @author Group3
 *
 */
public class ForgotPassword extends Body {
	
	public static JButton backButton;
	
	/**
	 * Konstruktor für die Erstelleung des Passwort Vergessen-Screens
	 * @param panel : JPanel
	 * @param forgotpasswordLabel : JLabel
	 * @param forgotpasswordLabel2 : JLabel
	 * @param title : Font
	 * @param text : JLabel
	 * @param text1 : JLabel
	 * @param text2 : JLabel
	 * @param codeTextfield : JTextField
	 * @param loginButton : JButton
	 * @param backButton : JButton
	 * @param space : JLabel
	 * @param space1 : JLabel
	 * @param space2 : JLabel
	 * @param space3 : JLabel
	 */
	public ForgotPassword() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(13,1));
		panel.setBounds(0,0,450,800);
		
		JLabel forgotpasswordLabel = new JLabel ("Passwort ");
		JLabel forgotpasswordLabel2 = new JLabel ("vergessen?");
		Font title = new Font ("Segoe UI", Font.BOLD, 30);
		forgotpasswordLabel.setFont(title);
		forgotpasswordLabel.setFont(title);
		
		JLabel text = new JLabel("Ein Code wurde an Ihre hinterlegte ");
		JLabel text1 = new JLabel("E-Mail Adresse gesendet!");
		JLabel text2 = new JLabel("Code eingeben: ");
		
		JTextField codeTextfield = new JTextField();
		
		
		JButton loginButton = new JButton("Einloggen");
		backButton = new JButton("Zurück");
		
		JLabel space = new JLabel();
		JLabel space1 = new JLabel();
		JLabel space2 = new JLabel();
		JLabel space3 = new JLabel();
		
		panel.add(space);
		panel.add(forgotpasswordLabel);
		panel.add(forgotpasswordLabel2);
		panel.add(space1);
		panel.add(text);
		panel.add(text1);
		panel.add(text2);
		panel.add(codeTextfield);
		panel.add(space2);
		panel.add(loginButton);
		panel.add(space3);
		panel.add(backButton);
	
		this.add(panel);
		
		backButton.addActionListener(new ForgotPasswordFunction());
	}
	
	/** background image is drawn
	 * 
	 */
	@Override
	protected void paintComponent (Graphics g) {
	Image img = Toolkit.getDefaultToolkit().getImage("./ui/images/wandern (2).jpg");	
	super.paintComponent(g);
	g.drawImage(img, 0, 0 , null);
	setVisible(true);
	}

}
