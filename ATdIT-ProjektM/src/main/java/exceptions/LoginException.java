package exceptions;

import java.awt.Color;

import javax.swing.JLabel;



@SuppressWarnings("serial")
public class LoginException extends Exception {
	public LoginException(int state, String message, JLabel redErrorText) {
		redErrorText.setBackground(Color.WHITE);
		redErrorText.setForeground(Color.RED);
		switch (state) {
		case 1:
			redErrorText.setText(message);
			break;
		case 2:
			redErrorText.setText(message);
			break;

		}

	}
}
