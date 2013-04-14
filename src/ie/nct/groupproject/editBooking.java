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

public class booking extends JFrame{

	JPanel contentPane;
	JPanel body;
	
	
	
	public booking() {
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
		JLabel title = new JLabel("Edit Booking");
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
		form.setLayout(new GridLayout(7,4,10,10));
		JLabel fname = new JLabel("First Name: ");
		JLabel sname = new JLabel("Surname: ");
		JLabel add1 = new JLabel("Address 1: ");
		JLabel add2 = new JLabel("Address 2: ");
		JLabel add3 = new JLabel("Address 3: ");
		JLabel reg = new JLabel("Registration: ");
		JLabel contact = new JLabel("Contact No.: ");
		JLabel make = new JLabel("Make: ");
		JLabel model = new JLabel("Model: ");
		JLabel date = new JLabel("Date: ");
		JLabel time = new JLabel("Time: ");
		JTextField snamein = new JTextField(15);
		JButton sub = new JButton("Submit");
		
		JTextField fnamein = new JTextField(15);
		JTextField regin = new JTextField(15);
		JTextField add1in = new JTextField(15);
		JTextField add2in = new JTextField(15);
		JTextField add3in = new JTextField(15);
		JTextField datein = new JTextField(15);
		JTextField timein = new JTextField(15);
		JTextField contactin = new JTextField(15);
		JTextField makein = new JTextField(15);
		JTextField modelin = new JTextField(15);
		//form.setPreferredSize(new Dimension(400, 400));
		form.setBounds(110, 110, 700, 300);
		
		form.add(fname);
		form.add(fnamein);
		form.add(reg);
		form.add(regin);
		form.add(sname);
		form.add(snamein);
		form.add(date);
		form.add(datein);
		form.add(add1);
		form.add(add1in);
		form.add(time);
		form.add(timein);
		form.add(add2);
		form.add(add2in);
		form.add(make);
		form.add(makein);
		form.add(add3);
		form.add(add3in);
		form.add(model);
		form.add(modelin);
		form.add(contact);
		form.add(contactin);
		form.add(sub);
		return form;
	}
	
}
