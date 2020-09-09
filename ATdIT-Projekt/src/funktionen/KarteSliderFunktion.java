package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import screens.KarteScreen;

public class KarteSliderFunktion implements ChangeListener {
	JSlider sliderFunktionHoehe;
	JSlider sliderFunktionLaenge;
	int streckenLaenge;
	int hoehenMeter;
	public KarteSliderFunktion(KarteScreen karteScreen) {
		sliderFunktionLaenge = karteScreen.streckenLaengeSlider;
		sliderFunktionHoehe = karteScreen.hoehenunterschiedSlider;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		streckenLaenge = sliderFunktionLaenge.getValue();
		hoehenMeter = sliderFunktionHoehe.getValue();
	}

}
