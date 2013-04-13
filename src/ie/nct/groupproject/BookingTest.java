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

public class BookingTest{

	JPanel contentPane;
	JPanel body;
	JPanel form;
	

	public BookingTest() {
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
		
		System.out.println("Booking form created");
		
	}
	
}
