package exceptions;

import java.awt.Color;

import screens.Registration;

@SuppressWarnings("serial")
public class RegistrationException extends Exception {

	public RegistrationException(int state, String message) {

		switch (state) {
		case 1:
			Registration.userexistsLabel.setText(message);
			Registration.userexistsLabel.setBackground(Color.WHITE);
			Registration.userexistsLabel.setForeground(Color.RED);
			break;
		case 2:
			Registration.passworddoesnotmatchLabel.setText(message);
			Registration.passworddoesnotmatchLabel.setBackground(Color.WHITE);
			Registration.passworddoesnotmatchLabel.setForeground(Color.RED);
			break;

		}

	}

}
