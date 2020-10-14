package screens;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import funktionen.KarteSliderFunktion;
import master.MasterScreen;

/** UI-Klasse um das Kartenfenster zu definieren
 * 
 * @author Gruppe 3
 *
 */
public class KarteScreen extends MasterScreen {

	public JSlider streckenLaengeSlider;
	public JSlider hoehenunterschiedSlider;
	
	/**	Konstruktor ohne Layout für den Karte-Screen
	 * @param kartePanel : JPanel
	 * @param karteLabel : JLabel
	 * @param streckenLaengePanel : JPanel
	 * @param streckenLaengeLabel : JLabel
	 * @param streckenLaengeSlider : JSlider
	 * @param hoehenunterschiedPanel : JPanel
	 * @param hoehenunterschiedLabel : JLabel
	 * @param hoehenunterschiedSlider : JSlider
	 */
	public KarteScreen() {
		this.setLayout(null);
		this.setBackground(Color.white);
		
//		Image mapImage = Toolkit.getDefaultToolkit().createImage("/.ui/images/mapImage.jpg");
		Icon mapImage = new ImageIcon("./ui/images/mapImage.jpg");
		JPanel kartePanel = new JPanel();
		kartePanel.setBounds(75, 50, 300, 300);
		
		
		JLabel karteLabel = new JLabel(mapImage);
//		karteLabel.setFont(new Font("Calibri", Font.BOLD, 40));
//		karteLabel.setBackground(Color.white);
		kartePanel.add(karteLabel);

		JPanel streckenLaengePanel = new JPanel();
		streckenLaengePanel.setBackground(Color.white);
		streckenLaengePanel.setBounds(10, 375, 400, 50);
		
		JLabel streckenLaengeLabel = new JLabel("Streckenlänge (in Metern)");
		streckenLaengeLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		streckenLaengeLabel.setBackground(Color.white);
		streckenLaengePanel.add(streckenLaengeLabel);
		

		ChangeListener cL = new KarteSliderFunktion(this);
//		ChangeListener cL = new FunktionKarte(this);

		hoehenunterschiedSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 1000, 250);
		
		streckenLaengeSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 20000, 10000);
		streckenLaengeSlider.setBounds(50, 425, 300, 50);
		streckenLaengeSlider.setBackground(Color.white);
		streckenLaengeSlider.setMinorTickSpacing(500);
		streckenLaengeSlider.addChangeListener(cL);

		JPanel hoehenunterschiedPanel = new JPanel();
		hoehenunterschiedPanel.setBackground(Color.white);
		hoehenunterschiedPanel.setBounds(10, 475, 400, 50);
		
		JLabel hoehenunterschiedLabel = new JLabel("Höhenunterschied (in Metern)");
		hoehenunterschiedLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		hoehenunterschiedLabel.setBackground(Color.white);
		hoehenunterschiedPanel.add(hoehenunterschiedLabel);
		
		hoehenunterschiedSlider.setBounds(50, 525, 300, 50);
		hoehenunterschiedSlider.setBackground(Color.white);
		hoehenunterschiedSlider.setMinorTickSpacing(50);
		hoehenunterschiedSlider.addChangeListener(cL);
		
		

		this.add(kartePanel);
		this.add(streckenLaengePanel);
		this.add(hoehenunterschiedPanel);
		this.add(streckenLaengeSlider);
		this.add(hoehenunterschiedSlider);
	}
	
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Image img = Toolkit.getDefaultToolkit().getImage("./ui/images/mapImage.jpg");
//		g.drawImage(img, 0, 0, null);
//		setVisible(true);
//		repaint();
//	}
	
}