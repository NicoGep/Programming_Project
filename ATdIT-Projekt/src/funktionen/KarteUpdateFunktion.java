package funktionen;

import connection.Benutzer;
import exceptions.InputException;

/** Klasse nur als Thread gestartet werden kann, um die Datenbank nicht übermaßig zu belasten,
 * 	da erst nach dreißig Sekunden die Datenbank aktualisiert wird.
 *  Zunächst eine Zwischenlösung, da nur am Anfang einmalig die Werte geändert werden können.
 *
 */
public class KarteUpdateFunktion extends Thread {
	
	/**
	 *  Methode wird ausgeführt, sobald ein erstelltes Objekt KarteUpdateFunktion gestartet wird
	 *  THREAD
	 */
	public void run() {
		try {
			Thread.sleep(30000);
			Benutzer.updateParameter(KarteSliderFunktion.streckenLaenge, KarteSliderFunktion.hoehenMeter);
		} catch (InterruptedException | InputException e) {
			e.printStackTrace();
		}
	}
}
