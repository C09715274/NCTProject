package ie.nct.groupproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class results2 extends JFrame {

	
	JPanel contentPane;
	JPanel body;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					results2 frame = new results2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public results2() {
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
		getContentPane().setLayout(new FlowLayout());
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
		form.setBounds(110, 110, 700, 400);
		form.setLayout(new GridLayout(7,4,10,10));
		
		JLabel blank = new JLabel();
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank6 = new JLabel();
		JLabel blank7 = new JLabel();
		JLabel blank8 = new JLabel();
		JLabel parkbreako = new JLabel("Park Break Off");
		JLabel effort = new JLabel("Break Effort");
		JLabel faxeln = new JLabel("Front Axel Near: ");
		JLabel raxeln = new JLabel("Rear Axel Near: ");
		JLabel faxelo = new JLabel("Front Axel Off:");
		JLabel raxelo = new JLabel("Rear Axel Off: ");
		JLabel parkbreakn = new JLabel("Park Break Near");
		JLabel ovality = new JLabel("Ovality");
		JLabel ovalfrontn = new JLabel("Front Axel Near:");
		JLabel ovalrearn = new JLabel("Rear Axel Near:");
		JLabel ovalfronto = new JLabel("Front Axel Off: ");
		JLabel ovalrearo = new JLabel("Rear Axel Off");
	
		
		JTextField raxelnin = new JTextField(15);
		JTextField faxelnin = new JTextField(15);
		JTextField parkbreaknin = new JTextField(15);
		JTextField parkbreakoin = new JTextField(15);
		JTextField faxeloin = new JTextField(15);
		JTextField raxeloin = new JTextField(15);
		JTextField ovalfrontnin = new JTextField(15);
		JTextField ovalrearnin = new JTextField(15);
		JTextField ovalfrontoin = new JTextField(15);
		JTextField ovalrearoin = new JTextField(15);
		
		
		form.add(effort);
		form.add(blank);
		form.add(blank1);
		form.add(blank2);
		form.add(faxeln);
		form.add(faxelnin);
		form.add(raxeln);
		form.add(raxelnin);
		form.add(faxelo);
		form.add(faxeloin);
		form.add(raxelo);
		form.add(raxeloin);
		form.add(parkbreakn);
		form.add(parkbreaknin);
		form.add(parkbreako);
		form.add(parkbreakoin);
		form.add(ovality);
		form.add(blank6);
		form.add(blank7);
		form.add(blank8);
		form.add(ovalfrontn);
		form.add(ovalfrontnin);
		form.add(ovalrearn);
		form.add(ovalrearnin);
		form.add(ovalfronto);
		form.add(ovalfrontoin);
		form.add(ovalrearo);
		form.add(ovalrearoin);
		return form;
	}
	
}
