package exceptions;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EditProfileException extends Exception {
	JLabel userexists;
	public EditProfileException(JLabel userexists, String message) {
		this.userexists = userexists;
		userexists.setText(message);
		userexists.setBackground(Color.WHITE);
		userexists.setForeground(Color.RED);
	}
}
