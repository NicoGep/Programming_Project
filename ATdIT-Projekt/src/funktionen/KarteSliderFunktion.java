package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import connection.Benutzer;
import exceptions.InputException;
import screens.KarteScreen;

public class KarteSliderFunktion extends Thread implements ChangeListener {
	JSlider sliderFunktionHoehe;
	JSlider sliderFunktionLaenge;
	int streckenLaenge;
	int hoehenMeter;
	int sleeper = 0;
	public KarteSliderFunktion(KarteScreen karteScreen) {
		sliderFunktionLaenge = karteScreen.streckenLaengeSlider;
		sliderFunktionHoehe = karteScreen.hoehenunterschiedSlider;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		streckenLaenge = sliderFunktionLaenge.getValue();
		hoehenMeter = sliderFunktionHoehe.getValue();
		try {
			while (sleeper < 1) {
				try {
					Thread.sleep(3000);
					Benutzer.updateParameter(streckenLaenge, hoehenMeter);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (InputException e1) {
			e1.printStackTrace();
		}
	}

}
