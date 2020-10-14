package funktionen;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import screens.KarteScreen;

/**Class with the functions for class "KarteScreen"
 * Generates a new thread per call, 
 * which then saves the desired data for the user in the database after 30 seconds
 */
public class KarteSliderFunktion implements ChangeListener {
	JSlider sliderFunctionHeight;
	JSlider sliderFunctionLength;
	protected static int routeLength;
	protected static int heightMeter;

	/** Constructor: creating a new thread
	 * @param KarteScreen : KarteScreen 
	 * (A KarteScreen object is transferred in which the data of the slider are available)
	 */
	public KarteSliderFunktion(KarteScreen mapScreen) {
		sliderFunctionLength = mapScreen.routelengthSlider;
		sliderFunctionHeight = mapScreen.heightdifferenceSlider;
		KarteUpdateFunktion updateMap = new KarteUpdateFunktion();
		updateMap.start();
	}

	/**
	 * Values of the Slider are written in the variable
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource() == sliderFunctionLength) {
			routeLength = sliderFunctionLength.getValue();
		}
		else if(e.getSource() == sliderFunctionHeight) {
			heightMeter = sliderFunctionHeight.getValue();
		}
		
	}
}
