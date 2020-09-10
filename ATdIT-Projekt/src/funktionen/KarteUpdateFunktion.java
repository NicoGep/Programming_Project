package funktionen;

import connection.Benutzer;
import exceptions.InputException;

/** Klasse nur als Thread gestartet werden kann, um die Datenbank nicht �berma�ig zu belasten,
 * 	da erst nach drei�ig Sekunden die Datenbank aktualisiert wird.
 *  Zun�chst eine Zwischenl�sung, da nur am Anfang einmalig die Werte ge�ndert werden k�nnen.
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
