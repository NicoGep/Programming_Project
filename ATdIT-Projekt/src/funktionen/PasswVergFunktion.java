package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import master.Fenster;
import screens.PasswortVerg;

public class PasswVergFunktion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
			e.getSource();
			Fenster.addToFrame(new PasswortVerg());
		
	}
	

}
