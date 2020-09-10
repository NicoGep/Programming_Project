package funktionen;

import connection.Benutzer;
import exceptions.InputException;

/** Klasse nur als Thread gestartet werden kann, um die Datenbank nicht übermaßig zu belasten,
 * 	da erst nach dreißig Sekunden die Datenbank aktualisiert wird.
 *  Zunächst eine Zwischenlösung, da nur am Anfang einmalig die Werte geändert werden können.
 * 
 * @author I518230
 *
 */
public class KarteUpdateFunktion extends Thread {
	public void run() {
		try {
			Thread.sleep(30000);
			Benutzer.updateParameter(KarteSliderFunktion.streckenLaenge, KarteSliderFunktion.hoehenMeter);
			System.out.println("Update Database");
		} catch (InterruptedException | InputException e) {
			e.printStackTrace();
		}
	}
}
