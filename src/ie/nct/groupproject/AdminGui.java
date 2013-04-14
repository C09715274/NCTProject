package com.model.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.model.bean.Person;
import com.model.deo.PersonDAO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGui extends JFrame {
	
	Person p = new Person();
	PersonDAO pd = new PersonDAO();
	
	JPanel contentPane;
	JPanel body;
	JLabel adminPage = new JLabel("Administrator");
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[] {"DATE", "TIME", "REGISTRATION", "NAME"} );
	//private JPanel main;
	
	
	public AdminGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(0, 0, 1366, 768);
		contentPane = createContentPane();
		setContentPane(contentPane);
		
	}

	private JPanel createContentPane() {
		JPanel pane = new JPanel();
		pane.setLayout(null);
		pane.setPreferredSize(new Dimension(1366, 768));
		pane.setBackground(new Color(0, 108, 90));
		pane.add(createBanner());
		pane.add(createBody());
		return pane;
	}

	private JLabel createBanner() {
		getContentPane().setLayout(new FlowLayout());
		JLabel imagelabel = new JLabel();
		imagelabel.setBounds(202, 0, 962, 103);
		imagelabel.setIcon(new ImageIcon("banner.png"));

		return imagelabel;
	}

	
	private JPanel createBody() {

		
		JPanel main = new JPanel();
		main.setLayout(null);
		main.setBackground(new Color(255, 255, 255));
		main.setBounds(202, 104, 962, 665);
		main.setPreferredSize(new Dimension(962,665));
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(202, 104, 558, 250);
	    adminPage.setFont(new Font("Serif", Font.PLAIN, 30));
	    adminPage.setBounds(420, 0, 300, 100);
	    main.add(adminPage);
	    scrollPane.getHorizontalScrollBar().setValue(0);
		main.add(scrollPane, BorderLayout.CENTER);
		
		JButton btnTested = new JButton("Tested Cars");
		btnTested.setBackground(new Color(0, 108, 90));
		btnTested.setForeground(new Color(244, 235, 58));
		btnTested.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTested.setBounds(420, 513, 156, 50);
		main.add(btnTested);
		
		JButton btnEdit = new JButton("Edit Appointment");
		btnEdit.setBackground(new Color(0, 108, 90));
		btnEdit.setForeground(new Color(244, 235, 58));
		btnEdit.setBounds(420, 440, 156, 50);
		
		main.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete Appointment");
		btnDelete.setBackground(new Color(0, 108, 90));
		btnDelete.setForeground(new Color(244, 235, 58));
		btnDelete.setBounds(628, 440, 156, 50);
		main.add(btnDelete);
		
		JButton btnNew = new JButton("New Appointment");
		btnNew.setBackground(new Color(0, 108, 90));
		btnNew.setForeground(new Color(244, 235, 58));
		btnNew.setBounds(202, 440, 156, 50);
		main.add(btnNew);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(0, 108, 90));
		btnBack.setForeground(new Color(244, 235, 58));
		btnBack.setBounds(48, 601, 89, 23);
		main.add(btnBack);
		refresh();
		return main;

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				AdminGui ga = new AdminGui();
				ga.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ga.setLocationByPlatform(true);
				ga.pack();
				ga.setVisible(true);
			}
		});
	}
	
	public void refresh(){
		List<Person> persons = pd.selectAll();
		for(Person p : persons){
			model.addRow(new Object[]{p.getId(),p.getFirstName(),p.getLastName()});
		}
	}
}
