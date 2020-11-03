package screens;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import exceptions.LoginException;
import funktionen.LoginFunction;
import master.Body;
import master.Main;
import master.Window;

/**	UI class for the "Login" screen
 * 
 * @author Group3
 *
 */
@SuppressWarnings("serial")
public class Login extends Body {

	public JButton registerButton;
	public JButton forgotpasswordButton;
	public JButton loginButton;
	
	private JTextField userTextfield;
	private JPasswordField passwordPasswordfield;
	
	private JLabel wrongnameLabel;
	private JLabel wrongpasswordLabel;
	private final String LOGIN_IMAGE_STRING = "/images/wandern (2).jpg";
	private final ResourceBundle STRING_TEXT;
	
	/** constructor for creating UI of Login-Screen
	 *  @param panel : JPanel
	 *  @param loginLabel : JLabel
	 *  @param userLabel : JLabel
	 *  @param passwordLabel : JLabel
	 *  @param space : JLabel
	 *  @param space1 : JLabel
	 *  @param space2 : JLabel
	 *  @param registerButton: JButton
	 *  @param forgotpasswordButton : new JButton
	 *  @param loginButton : JButton
	 *  @param wrongnameLabel : JLabel
	 *  @param wrongpasswortLabel : JLabels
	 */
	public Login() {
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/Login/login");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(13, 1));
		panel.setBounds(0, 0, 450, 800);

		JLabel loginLabel = new JLabel(STRING_TEXT.getString("login"));
		Font title = new Font("Segoe UI", Font.BOLD, 30);
		loginLabel.setFont(title);

		JLabel userLabel = new JLabel(STRING_TEXT.getString("username"));
		userTextfield = new JTextField();
		userTextfield.setText("TestBenutzer1");

		JLabel passwordLabel = new JLabel(STRING_TEXT.getString("password"));
		passwordPasswordfield = new JPasswordField();
		passwordPasswordfield.setText("pass");

		JLabel space = new JLabel();
		JLabel space1 = new JLabel();
		JLabel space2 = new JLabel();

		registerButton = new JButton(STRING_TEXT.getString("registration"));
		forgotpasswordButton = new JButton(STRING_TEXT.getString("forgot_password"));
		loginButton = new JButton(STRING_TEXT.getString("log_in"));

		wrongnameLabel = new JLabel("");
		wrongpasswordLabel = new JLabel("");
	
	
		panel.add(space);
		panel.add(loginLabel);

		panel.add(userLabel);
		panel.add(userTextfield);

		panel.add(passwordLabel);
		panel.add(passwordPasswordfield);

		panel.add(space1);
		panel.add(registerButton);
		panel.add(forgotpasswordButton);
		panel.add(space2);
		panel.add(loginButton);
		
		panel.add(wrongnameLabel);
		panel.add(wrongpasswordLabel);

		this.add(panel);
		

		registerButton.addActionListener(l -> {
			Window.clearHistory();
			Window.newDraw(new Registration());
			});
		forgotpasswordButton.addActionListener(l -> {
			Window.addToFrame(new ForgotPassword());
			});
		loginButton.addActionListener(l -> {
			try {
				new LoginFunction(userTextfield, passwordPasswordfield, wrongnameLabel, wrongpasswordLabel).login();
			} catch (LoginException e) {
				Main.printError(e);
			}
		});


	}
	
	/** 
	 * Background image is drawn
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		var url = getClass().getResource(LOGIN_IMAGE_STRING);
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		g.drawImage(img, 0, 0, null);
		setVisible(true);
		repaint();
	}
}
