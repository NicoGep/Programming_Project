package funktionen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funktion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		e.getSource();
		
		Funktion2 f = new Funktion2(this);
		
	}

}
