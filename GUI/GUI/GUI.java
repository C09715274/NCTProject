package ie.nct.groupproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

private static final long serialVersionUID = 1L;


	JPanel contentPane;
	JPanel body;

	
	
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(0, 0, 1366, 768);
		contentPane = createContentPane();
		setContentPane(contentPane);
		contentPane.add(createBackground());

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(50, 50));
		panel.setBackground(new Color(25, 255, 255));
		panel.setLocation(400, 80);

		contentPane.add(createBackground());
		createBackground().add(createBanner());
		//createBackground().add(createBody());

	}

	private JPanel createContentPane() {
		// TODO Auto-generated method stub
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setBackground(new Color(238, 233, 233));
		return pane;
	}

	private JLabel createBanner() {
		setLayout(new FlowLayout());
		JLabel imagelabel = new JLabel();
		imagelabel.setBounds(202, 0, 962, 103);
		imagelabel.setIcon(new ImageIcon("banner.png"));

		return imagelabel;
	}

	private JPanel createBackground() {
		JPanel BG = new JPanel(new FlowLayout(FlowLayout.CENTER));
		BG.setLayout(null);
		BG.setBounds(0, 0, 1366, 768);
		BG.setPreferredSize(new Dimension(1366, 768));
		BG.setBackground(new Color(0, 108, 90));
		BG.add(createBanner());
		BG.add(createBody());

		return BG;

	}

	private JPanel createBody() {

		JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		main.setLayout(null);
		main.setBackground(new Color(255, 255, 255));
		main.setPreferredSize(new Dimension(962, 600));
		main.setBounds(202, 104, 962, 665);
		main.add(form());
		return main;

	}

	private JPanel form() {
		// TODO Auto-generated method stub
		JPanel form = new JPanel();
		JLabel user = new JLabel("Username: ");
		JLabel title = new JLabel("LOGIN FORM");
		JLabel password = new JLabel("Password: ");
		JTextField passin = new JTextField(15);
		JButton sub = new JButton("Submit");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		JTextField userinput = new JTextField(15);
		form.setPreferredSize(new Dimension(200, 200));
		form.setBounds(400, 210, 200, 200);
		form.add(title);
		form.add(user);
		form.add(userinput);
		form.add(password);
		form.add(passin);
		form.add(sub);
		return form;
	}
}
