package ie.nct.groupproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class results extends JFrame{

	JPanel contentPane;
	JPanel body;
	
	
	
	public results() {
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
		createBackground().add(createBody());

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
		
		JButton backButton = new JButton("Back");
		JButton submitButton = new JButton("Submit");
		backButton.setBounds(500, 650, 100, 40);
		submitButton.setBounds(650, 650, 100, 40);
		BG.add(createBanner());
		BG.add(createBody());
		BG.add(backButton);
		BG.add(submitButton);
		return BG;

	}

	private JPanel createBody() {

		JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER));
		main.setLayout(null);
		main.setBackground(new Color(255, 255, 255));
		main.setPreferredSize(new Dimension(962, 600));
		main.setBounds(202, 104, 962, 665);
		JLabel title = new JLabel("Results");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		title.setBounds(420, 0, 300, 100);
		main.add(title);
		main.add(form());
		return main;

	}
	
	private JPanel form() {
		// TODO Auto-generated method stub
		JPanel form = new JPanel();
		JLabel blank = new JLabel();
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		JLabel blank5 = new JLabel();
		JLabel blank6 = new JLabel();
		JLabel blank7 = new JLabel();
		JLabel blank8 = new JLabel();
		form.setLayout(new GridLayout(7,4,10,10));
		JLabel wheel = new JLabel("Side-Slip/Alignment Test");
		JLabel faxel = new JLabel("Front Axel: ");
		JLabel raxel = new JLabel("Rear Axel: ");
		JLabel add2 = new JLabel("Rear Axel Near: ");
		JLabel add3 = new JLabel("Rear Axel Off: ");
		JLabel make = new JLabel("Front Axel Off:");
		JLabel date = new JLabel("Suspension Test");
		JLabel time = new JLabel("Front Axel Near:");
		JLabel emissions = new JLabel("Emissions Test");
		JLabel low = new JLabel("Low Idle");
		JLabel high = new JLabel("High Idle");
		
		JTextField snamein = new JTextField(15);
		JTextField fnamein = new JTextField(15);
		JTextField add1in = new JTextField(15);
		JTextField add3in = new JTextField(15);
		JTextField timein = new JTextField(15);
		JTextField makein = new JTextField(15);
		JTextField lowin = new JTextField(15);
		JTextField highin = new JTextField(15);
		form.setBounds(110, 110, 700, 400);
		
		form.add(wheel);
		form.add(blank);
		form.add(blank1);
		form.add(blank2);
		form.add(faxel);
		form.add(fnamein);
		form.add(raxel);
		form.add(snamein);
		form.add(date);
		form.add(blank3);
		form.add(blank4);
		form.add(blank5);
		form.add(time);
		form.add(add1in);
		form.add(add2);
		form.add(timein);
		form.add(make);
		form.add(makein);
		form.add(add3);
		form.add(add3in);
		form.add(emissions);
		form.add(blank6);
		form.add(blank7);
		form.add(blank8);
		form.add(low);
		form.add(lowin);
		form.add(high);
		form.add(highin);
		return form;
	}
	
}
