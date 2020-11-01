package screens;

import java.awt.*;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Iterator;
import javax.swing.*;

import connection.User;
import connection.Groups;
import funktionen.MyProfileFunction;
import master.Window;
import master.MasterScreen;

/**
 * UI class for class "MeinProfil"
 * 
 * @author Group3
 *
 */
@SuppressWarnings("serial")
public class MyProfile extends MasterScreen {

	public static String name;
	public static String level;
	public static String mail;
	public static String profilepictureaddress;
	public static List<Groups> groupList;

	JPanel dataPanel;
	JPanel groupsPanel;
	JPanel profilepicturePanel;
	JPanel namelevelPanel;
	JPanel mygrouplistPanel;

	public JButton editprofileButton;
	public JButton joingroupButton;
	public JButton creategroupButton;

	public JLabel profilepictureLabel;
	public JLabel mygroupsLabel;
	public JLabel nameLabel;
	public JLabel levelLabel;
	public Icon profilepictureIcon;
	private final ResourceBundle STRING_TEXT;

	/**
	 * constructor without Layout
	 */
	public MyProfile() {

		this.setBackground(Color.lightGray);
		this.setLayout(null);
<<<<<<< HEAD
//		new MyProfileFunction().loadData();
=======
		this.STRING_TEXT = ResourceBundle.getBundle("i18n/screens/MyProfile/myprofile");
		new MyProfileFunction().loadData();
>>>>>>> 23f808221443bc60226e306a4b229ae5fe30dbdd
		Image image = Toolkit.getDefaultToolkit().createImage(profilepictureaddress);

		dataPanel = new JPanel();
		dataPanel.setBounds(0, 0, 450, 100);
		dataPanel.setLayout(new GridLayout(0, 2));
		dataPanel.setBackground(Color.GRAY);

		groupsPanel = new JPanel();
		groupsPanel.setLayout(null);
		groupsPanel.setBounds(0, 100, 450, 600);

		profilepicturePanel = new JPanel();
		profilepicturePanel.setLayout(null);
		profilepicturePanel.setBackground(Color.GRAY);

		namelevelPanel = new JPanel();
		namelevelPanel.setLayout(null);
		namelevelPanel.setBackground(Color.GRAY);

		mygrouplistPanel = new JPanel();
		mygrouplistPanel.setBounds(0, 200, 450, 400);
		mygrouplistPanel.setLayout(new GridLayout(0, 1));
		mygrouplistPanel.setBackground(Color.WHITE);

		/**
		 * Creation of the Button including the position and background color
		 **/
		editprofileButton = new JButton(STRING_TEXT.getString("edit_p"));
		editprofileButton.setBounds(0, 0, 450, 50);
		editprofileButton.setBackground(Color.LIGHT_GRAY);

		editprofileButton.addActionListener(l -> {
			Window.addToFrame(new EditProfile());
		});

		joingroupButton = new JButton(STRING_TEXT.getString("join_delete_g"));
		joingroupButton.setBounds(0, 50, 450, 50);
		joingroupButton.setBackground(Color.LIGHT_GRAY);
		joingroupButton.addActionListener(l -> {
			Window.addToFrame(new JoinLeaveGroup());
		});

		creategroupButton = new JButton(STRING_TEXT.getString("create_group"));
		creategroupButton.setBounds(0, 100, 450, 50);
		creategroupButton.setBackground(Color.LIGHT_GRAY);
		creategroupButton.addActionListener(l -> {
			Window.addToFrame(new CreateGroup());
		});

		profilepictureIcon = new ImageIcon(profilepictureaddress);

		/**
		 * Creation of the Labels including position and background color
		 **/
		mygroupsLabel = new JLabel(STRING_TEXT.getString("my_groups"));
		mygroupsLabel.setBounds(175, 150, 450, 50);
		mygroupsLabel.setBackground(Color.GRAY);
		mygroupsLabel.setFont(new Font("Ueberschrift", Font.BOLD, 14));

		profilepictureLabel = new JLabel(new ImageIcon(image));
		profilepictureLabel.setBounds(75, 0, 100, 100);
		profilepictureLabel.setBackground(Color.GRAY);

		JLabel nameLabeling = new JLabel(STRING_TEXT.getString("name"));
		nameLabeling.setBounds(0, 0, 75, 50);
		nameLabeling.setFont(new Font("Ueberschrift", Font.BOLD, 14));

		nameLabel = new JLabel(name);
		nameLabel.setBounds(100, 0, 100, 50);

		JLabel levelLabeling = new JLabel(STRING_TEXT.getString("level"));
		levelLabeling.setBounds(0, 50, 75, 50);
		levelLabeling.setFont(new Font("Ueberschrift", Font.BOLD, 14));

		levelLabel = new JLabel(level);
		levelLabel.setBounds(100, 50, 100, 50);

		profilepicturePanel.add(profilepictureLabel);

		namelevelPanel.add(nameLabeling);
		namelevelPanel.add(nameLabel);
		namelevelPanel.add(levelLabeling);
		namelevelPanel.add(levelLabel);

		dataPanel.add(profilepicturePanel);
		dataPanel.add(namelevelPanel);

		Iterator<Groups> it;

		if (groupList != null) {
			it = groupList.iterator();

			while (it.hasNext()) {
					Groups currentGroup = it.next();
					if (User.getLoggedUser().isInGroup(currentGroup)) {
						mygrouplistPanel.add(new JLabel(currentGroup.getGroupName()));
					}
					
				
			}
		}

		groupsPanel.add(editprofileButton);
		groupsPanel.add(joingroupButton);
		groupsPanel.add(creategroupButton);
		groupsPanel.add(mygroupsLabel);
		groupsPanel.add(mygrouplistPanel);

		this.add(dataPanel, BorderLayout.NORTH);
		this.add(groupsPanel, BorderLayout.CENTER);

	}
}
