package ie.nct.groupproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

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
	JPanel form;

	JTextField raxelnin;
	JTextField faxelnin;
	JTextField parkbreaknin;
	JTextField parkbreakoin;
	JTextField faxeloin;
	JTextField raxeloin;
	JTextField ovalfrontnin;
	JTextField ovalrearnin;
	JTextField ovalfrontoin;
	JTextField ovalrearoin;
	
	DB Results2DBObject = null;

	protected String dbUser = "LoginBot";
	protected String dbPassword = "rawr";

	public results2() {

		// TODO Auto-generated method stub
		JPanel form = new JPanel();
		form.setBounds(110, 110, 700, 400);
		form.setLayout(new GridLayout(7, 4, 10, 10));

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

		raxelnin = new JTextField(15);
		faxelnin = new JTextField(15);
		parkbreaknin = new JTextField(15);
		parkbreakoin = new JTextField(15);
		faxeloin = new JTextField(15);
		raxeloin = new JTextField(15);
		ovalfrontnin = new JTextField(15);
		ovalrearnin = new JTextField(15);
		ovalfrontoin = new JTextField(15);
		ovalrearoin = new JTextField(15);

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
	}

	private class BookingHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			try {
				Results2DBObject = new DB(dbUser, dbPassword);
				System.out.println("\n Booking database");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("\n Booking database failed");
			}

			try {

				String sraxelnin = raxelnin.getText();
				String sfaxelnin = faxelnin.getText();
				
				String sparkbreaknin = parkbreaknin.getText();
				String sparkbreakoin = parkbreakoin.getText();
				
				String sfaxeloin = faxeloin.getText();
				String sraxeloin = raxeloin.getText();
			
				String sovalfrontin = ovalfrontnin.getText();
				String sovalrearnin =ovalrearnin.getText();
				String sovalfrontoin =ovalfrontoin.getText();
				String sovalrearoin =ovalrearoin.getText();
			
				DB bookingDB = new DB();
				Statement callStatement = bookingDB.connect.createStatement();

				String InsertTestResults1 = "INSERT";

				callStatement.execute(InsertTestResults1);

			} catch (SQLException bookingExc) {
				bookingExc.printStackTrace();
			}

		}
	}

}
