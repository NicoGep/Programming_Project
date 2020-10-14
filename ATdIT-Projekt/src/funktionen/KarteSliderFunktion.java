package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import screens.KarteScreen;

/** Klasse die die Funktion zu den Slidern der Karte festlegt
 * 	Erzeugt einen neuen Thread pro Aufruf, der dann nach 30 Sekunden die gewünschten Daten
 * 	für den Benutzer auf die Datenbank speichert
 *
 */
public class KarteSliderFunktion implements ChangeListener {
	JSlider sliderFunktionHoehe;
	JSlider sliderFunktionLaenge;
	protected static int streckenLaenge;
	protected static int hoehenMeter;

	/** Konstruktor: Erzeugen eines neuen Threads
	 * 
	 * @param karteScreen : KarteScreen (Ein KarteScreen-Objekt wird übergeben, in dem
	 * 	die Daten der Slider vorhanden sind)
	 */
	public KarteSliderFunktion(KarteScreen karteScreen) {
		sliderFunktionLaenge = karteScreen.streckenLaengeSlider;
		sliderFunktionHoehe = karteScreen.hoehenunterschiedSlider;
		KarteUpdateFunktion updateKarte = new KarteUpdateFunktion();
		updateKarte.start();
	}

	/**
	 * Werte der Slider werden in die Veriablen geschrieben
	 */
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
