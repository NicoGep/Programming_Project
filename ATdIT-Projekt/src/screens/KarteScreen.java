package screens;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import master.MasterScreen;

/** UI for class "KarteScreen"
 * 
 * @author Group3
 *
 */
public class KarteScreen extends MasterScreen {
	
	/**	constructor without Layout
	 * @param mapPanel : JPanel
	 * @param mapLabel : JLabel
	 * @param routelengthPanel : JPanel
	 * @param routelengthLabel : JLabel
	 * @param routelengthSlider : JSlider
	 * @param heightdifferencePanel : JPanel
	 * @param heightdifferenceLabel : JLabel
	 * @param heigtdifferenceSlider : JSlider
	 */
	public KarteScreen() {
		this.setLayout(null);
		this.setBackground(Color.white);
		
//		Image mapImage = Toolkit.getDefaultToolkit().createImage("/.ui/images/mapImage.jpg");
		Icon mapImage = new ImageIcon("./ui/images/mapImage.jpg");
		JPanel mapPanel = new JPanel();
		mapPanel.setBounds(75, 50, 300, 300);
		
		
		JLabel mapLabel = new JLabel(mapImage);
//		karteLabel.setFont(new Font("Calibri", Font.BOLD, 40));
//		karteLabel.setBackground(Color.white);
		mapPanel.add(mapLabel);

		JPanel routelengthPanel = new JPanel();
		routelengthPanel.setBackground(Color.white);
		routelengthPanel.setBounds(7, 375, 400, 50);
		
		JLabel routelengthLabel = new JLabel("Streckenlänge (in Metern):");
		routelengthLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		routelengthLabel.setBackground(Color.white);
		routelengthPanel.add(routelengthLabel);
		
		JTextField routelengthTextField = new JTextField();
		routelengthTextField.setBounds(70, 425, 300, 50);
		routelengthTextField.setBackground(Color.white);
		

		JPanel heightdifferencePanel = new JPanel();
		heightdifferencePanel.setBackground(Color.white);
		heightdifferencePanel.setBounds(30, 490, 400, 50);
		
		
		JLabel heightdifferenceLabel = new JLabel("Höhenunterschied (in Metern):");
		heightdifferenceLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		heightdifferenceLabel.setBackground(Color.white);
		heightdifferencePanel.add(heightdifferenceLabel);
		
		JTextField heightdifferenceTextField = new JTextField();
		heightdifferenceTextField.setBackground(Color.white);
		heightdifferenceTextField.setBounds(70, 530, 300, 50);
		
		

		this.add(mapPanel);
		this.add(routelengthPanel);
		this.add(heightdifferencePanel);
		this.add(routelengthTextField);
		this.add(heightdifferenceTextField);
	}	
}
	
