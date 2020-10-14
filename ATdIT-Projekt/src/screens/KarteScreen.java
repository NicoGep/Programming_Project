package screens;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import funktionen.KarteSliderFunktion;
import master.MasterScreen;

/** GUI class to define Karte-Screen
 * 
 * @author Group3
 *
 */
public class KarteScreen extends MasterScreen {

	public JSlider routelengthSlider;
	public JSlider heightdifferenceSlider;
	
	/**	construcor without Layout for Karte-Screen
	 * @param mapPanel : JPanel
	 * @param mapLabel : JLabel
	 * @param routelenghtPanel : JPanel
	 * @param routelengthLabel : JLabel
	 * @param routelengthSlider : JSlider
	 * @param heightdifferencePanel : JPanel
	 * @param heightdifferenceLabel : JLabel
	 * @param heightdifferenceSlider : JSlider
	 */
	public KarteScreen() {
		this.setLayout(null);
		this.setBackground(Color.white);

		JPanel mapPanel = new JPanel();
		mapPanel.setBackground(Color.gray);
		mapPanel.setBounds(75, 150, 300, 50);
		
		JLabel mapLabel = new JLabel("KARTE");
		mapLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		mapLabel.setBackground(Color.white);
		mapPanel.add(mapLabel);

		JPanel routelengthPanel = new JPanel();
		routelengthPanel.setBackground(Color.white);
		routelengthPanel.setBounds(10, 375, 400, 50);
		
		JLabel routelengthLabel = new JLabel("Streckenlänge (in Metern)");
		routelengthLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		routelengthLabel.setBackground(Color.white);
		routelengthPanel.add(routelengthLabel);
		

		ChangeListener changelistener = new KarteSliderFunktion(this);
//		ChangeListener changelistener = new FunktionKarte(this);

		heightdifferenceSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 1000, 250);
		
		routelengthSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 20000, 10000);
		routelengthSlider.setBounds(50, 425, 300, 50);
		routelengthSlider.setBackground(Color.white);
		routelengthSlider.setMinorTickSpacing(500);
		routelengthSlider.addChangeListener(changelistener);

		JPanel heightdifferencePanel = new JPanel();
		heightdifferencePanel.setBackground(Color.white);
		heightdifferencePanel.setBounds(10, 475, 400, 50);
		
		JLabel heightdifferenceLabel = new JLabel("Höhenunterschied (in Metern)");
		heightdifferenceLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		heightdifferenceLabel.setBackground(Color.white);
		heightdifferenceLabel.add(heightdifferenceLabel);
		
		heightdifferenceSlider.setBounds(50, 525, 300, 50);
		heightdifferenceSlider.setBackground(Color.white);
		heightdifferenceSlider.setMinorTickSpacing(50);
		heightdifferenceSlider.addChangeListener(changelistener);

		this.add(mapPanel);
		this.add(routelengthPanel);
		this.add(heightdifferencePanel);
		this.add(routelengthSlider);
		this.add(heightdifferenceSlider);
	}
	
}