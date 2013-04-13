package ie.nct.groupproject;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * 
 * Main GUI frame 
 *  
 * 
 * 
 */
public class GUI extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JPanel body;
	JPanel LoginForm;
	JPanel main;
	JPanel BG;
	JLabel imagelabel;
	
	static JFrame frame;

	

	public GUI() {

		contentPane = createContentPane();
		main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		main.setLayout(null);
		main.setBackground(new Color(0, 255, 255));//shit
		main.setPreferredSize(new Dimension(962, 600));
		main.setBounds(202, 104, 962, 665);
		//main.add(LoginForm);
		createBanner();
		createBackground();
		MakeFrame();
		

		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(50, 50));
		panel.setBackground(new Color(0, 0, 255)); //blue
		panel.setLocation(400, 80);

		contentPane.add(BG);
		BG.add(imagelabel);
		BG.add(main);
		frame.add(contentPane);
		System.out.println("end of GUI");
		

	}

	private JPanel createContentPane() {
		// TODO Auto-generated method stub
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setBackground(new Color(0, 233, 0));//green
		return pane;
	}

	private void createBanner() {
		setLayout(new FlowLayout());
		imagelabel = new JLabel();
		imagelabel.setBounds(202, 0, 962, 103);
		imagelabel.setIcon(new ImageIcon("banner.png"));

	}

	private  void createBackground() {
		 BG = new JPanel(new FlowLayout(FlowLayout.CENTER));
		BG.setLayout(null);
		BG.setBounds(0, 0, 1366, 768);
		BG.setPreferredSize(new Dimension(1366, 768));
		BG.setBackground(new Color(255, 0, 0));//red
		BG.add(imagelabel);
		BG.add(main);


	}
	
	
	public void MakeFrame(){
		frame = new JFrame("Foo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 1366, 768);
		frame.setVisible(true);
	}

	/*private JPanel createBody() {
		form();
		System.out.println("LoginForm created");
		JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		main.setLayout(null);
		main.setBackground(new Color(0, 255, 255));//shit
		main.setPreferredSize(new Dimension(962, 600));
		main.setBounds(202, 104, 962, 665);
		main.add(LoginForm);
		return main;

	}

	private void form() {
		LoginForm = new JPanel();
		// TODO Auto-generated method stub
		JLabel user = new JLabel("Username: ");
		JLabel title = new JLabel("Login Page ");
		JLabel password = new JLabel("Password: ");
		JTextField passin = new JTextField(15);
		JButton sub = new JButton("Submit");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		JTextField userinput = new JTextField(15);
		LoginForm.setPreferredSize(new Dimension(200, 200));
		LoginForm.setBounds(400, 210, 200, 200);
		LoginForm.add(title);
		LoginForm.add(user);
		LoginForm.add(userinput);
		LoginForm.add(password);
		LoginForm.add(passin);
		LoginForm.add(sub);
	}*/
}
