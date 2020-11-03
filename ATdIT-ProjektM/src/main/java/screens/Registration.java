package screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import connection.User;
import exceptions.RegistrationException;
import funktionen.RegisterFunction;
import master.Body;
import master.Window;

/**
 * UI class for class "Registrierung"
 * 
 * @author Group3
 *
 */
@SuppressWarnings("serial")
public class Registration extends Body {

	public JTextField userTextfield;
	public JPasswordField passwordPasswordfield;
	public JTextField mailTextfield;
	public JPasswordField repeatpasswordPasswordfield;

	public JButton registerButton;
	public JButton backButton;

	public static JLabel passworddoesnotmatchLabel;
	public static JLabel userexistsLabel;
	private final ResourceBundle STRING_TEXT;
	private final String LOGIN_IMAGE_STRING = "/images/wandern (2).jpg";

	/**
	 * constructor (GridLayout)
	 */
	public Registration() {
		
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/Registration/Registration");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(17, 1));
		panel.setBounds(0, 0, 450, 800);

		JLabel registerLabel = new JLabel(STRING_TEXT.getString("Registrieren"));
		Font title = new Font("Segoe UI", Font.BOLD, 30);
		registerLabel.setFont(title);

		JLabel mailLabel = new JLabel(STRING_TEXT.getString("email"));
		mailTextfield = new JTextField();

		JLabel userLabel = new JLabel(STRING_TEXT.getString("username"));
		userTextfield = new JTextField();

		JLabel passwordLabel = new JLabel(STRING_TEXT.getString("password"));
		passwordPasswordfield = new JPasswordField();

		JLabel repeatpasswordLabel = new JLabel(STRING_TEXT.getString("repeat_password"));
		repeatpasswordPasswordfield = new JPasswordField();

		JCheckBox agbCheckbox = new JCheckBox(STRING_TEXT.getString("AGB"));

		registerButton = new JButton(STRING_TEXT.getString("Registrieren"));

		backButton = new JButton(STRING_TEXT.getString("back"));

		passworddoesnotmatchLabel = new JLabel(STRING_TEXT.getString("password_match"));
		passworddoesnotmatchLabel.setBackground(Color.WHITE);
		passworddoesnotmatchLabel.setForeground(Color.RED);
		passworddoesnotmatchLabel.setVisible(false);
		
		userexistsLabel = new JLabel(STRING_TEXT.getString("user_exists"));
		userexistsLabel.setBackground(Color.WHITE);
		userexistsLabel.setForeground(Color.RED);
		userexistsLabel.setVisible(false);
		

		JLabel space = new JLabel();
		JLabel space1 = new JLabel();
		JLabel space2 = new JLabel();

		panel.add(space);
		panel.add(registerLabel);
		panel.add(mailLabel);
		panel.add(mailTextfield);
		panel.add(userLabel);
		panel.add(userTextfield);
		panel.add(passwordLabel);
		panel.add(passwordPasswordfield);
		panel.add(repeatpasswordLabel);
		panel.add(repeatpasswordPasswordfield);
		panel.add(agbCheckbox);
		panel.add(space1);
		panel.add(registerButton);
		panel.add(space2);
		panel.add(backButton);
		panel.add(passworddoesnotmatchLabel);
		panel.add(userexistsLabel);

		this.add(panel);

		registerButton.addActionListener(l -> {

			try {
				new RegisterFunction(userTextfield, mailTextfield, passwordPasswordfield, repeatpasswordPasswordfield)
						.register();
			} catch (RegistrationException e) {
				
			}
		});

		backButton.addActionListener(l -> {
			User.logoutUser();
			Window.clearHistory();
			Window.newDraw(new Login());
		});

	}

	/**
	 * background image is drawn
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
