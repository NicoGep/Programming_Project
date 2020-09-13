package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import connection.Benutzer;
import exceptions.InputException;
import screens.KarteScreen;

public class FunktionKarte implements Runnable, ChangeListener {
	
	private JSlider len, high;
	
	private Thread t;
	
	private int sLen = 0, hi = 0;
	
	
	public FunktionKarte(KarteScreen screen) {

		this.len = screen.streckenLaengeSlider;
		this.high = screen.hoehenunterschiedSlider;
		
		this.t = new Thread(this);
		
		t.start();
		
	}


	@Override
	public void run() {

		while(!t.isInterrupted()) {
			
			try {
				
				wait(10000);
				
				Benutzer.updateParameter(sLen, hi);
				
				
			} catch (InterruptedException | InputException e) {
				t.interrupt();
			}

			
		}
		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
		sLen = len.getValue();
		hi = high.getValue();
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		t.notify();
	}

}
