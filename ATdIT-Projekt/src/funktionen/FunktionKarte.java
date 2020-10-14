package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import connection.Benutzer;
import exceptions.InputException;
import screens.KarteScreen;

public class FunktionKarte implements Runnable, ChangeListener {
	
	private JSlider length, height;
	
	private Thread thread;
	
	private int lengthValue = 0, heightValue = 0;
	
	
	public FunktionKarte(KarteScreen screen) {

		this.length = screen.routelengthSlider;
		this.height = screen.heightdifferenceSlider;
		
		this.thread = new Thread(this);
		
		thread.start();
		
	}


	@Override
	public void run() {

		while(!thread.isInterrupted()) {
			
			try {
				
				wait(10000);
				
				Benutzer.updateParameter(lengthValue, heightValue);
				
				
			} catch (InterruptedException | InputException e) {
				thread.interrupt();
			}

			
		}
		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		lengthValue = length.getValue();
		heightValue = height.getValue();
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		thread.notify();
	}

}
