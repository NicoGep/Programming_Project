package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import screens.KarteScreen;

public class KarteSliderFunktion implements ChangeListener {
	JSlider sliderFunktionHoehe;
	JSlider sliderFunktionLaenge;
	protected static int streckenLaenge;
	protected static int hoehenMeter;

	public KarteSliderFunktion(KarteScreen karteScreen) {
		sliderFunktionLaenge = karteScreen.streckenLaengeSlider;
		sliderFunktionHoehe = karteScreen.hoehenunterschiedSlider;
		KarteUpdateFunktion updateKarte = new KarteUpdateFunktion();
		updateKarte.start();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource() == sliderFunktionLaenge) {
			streckenLaenge = sliderFunktionLaenge.getValue();
		}
		else if(e.getSource() == sliderFunktionHoehe) {
			hoehenMeter = sliderFunktionHoehe.getValue();
		}
		
	}
}
