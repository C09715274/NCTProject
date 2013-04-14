package ie.nct.groupproject;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Booking {

	JPanel BookingForm;

	JTextField fnamein;
	JTextField snamein;

	JTextField regin;
	JTextField add1in;
	JTextField add2in;
	JTextField add3in;
	JTextField datein;
	JTextField timein;
	JTextField contactin;
	JTextField makein;
	JTextField modelin;
	JTextField CustomerIDin;
	protected String dbUser = "LoginBot";
	protected String dbPassword = "rawr";

	DB LoginDBObject = null;

	public Booking() {

		// TODO Auto-generated method stub

		BookingForm = new JPanel();
		BookingForm.setLayout(new GridLayout(7, 4, 10, 10));

		BookingForm.setPreferredSize(new Dimension(700, 400));
		BookingForm.setBounds(110, 110, 700, 300);
		JLabel customerID = new JLabel("CustomerID(If avaiable)");
		JLabel fname = new JLabel("First Name: ");
		JLabel sname = new JLabel("Surname: ");
		JLabel add1 = new JLabel("Address 1: ");
		JLabel add2 = new JLabel("Address 2: ");
		JLabel add3 = new JLabel("Address 3: ");
		JLabel reg = new JLabel("Registration: ");
		JLabel contact = new JLabel("Contact No.: ");
		JLabel date = new JLabel("Date: ");
		JLabel time = new JLabel("Time: ");
		JButton sub = new JButton("Submit");

		snamein = new JTextField(15);
		CustomerIDin = new JTextField(15);
		fnamein = new JTextField(15);
		regin = new JTextField(15);
		add1in = new JTextField(15);
		add2in = new JTextField(15);
		add3in = new JTextField(15);
		datein = new JTextField(15);
		timein = new JTextField(15);
		contactin = new JTextField(15);

		BookingForm.add(customerID);
		BookingForm.add(CustomerIDin);
		BookingForm.add(fname);
		BookingForm.add(fnamein);
		BookingForm.add(reg);
		BookingForm.add(regin);
		BookingForm.add(sname);
		BookingForm.add(snamein);
		BookingForm.add(date);
		BookingForm.add(datein);
		BookingForm.add(add1);
		BookingForm.add(add1in);
		BookingForm.add(time);
		BookingForm.add(timein);
		BookingForm.add(add2);
		BookingForm.add(add2in);
		BookingForm.add(add3);
		BookingForm.add(add3in);
		BookingForm.add(contact);
		BookingForm.add(contactin);
		BookingForm.add(sub);

		BookingHandler BookingHandlerObject = new BookingHandler();
		sub.addActionListener(BookingHandlerObject);

	}

	private class BookingHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			try {
				LoginDBObject = new DB(dbUser, dbPassword);
				System.out.println("\n Booking database");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("\n Booking database failed");
			}

			try {

				String SCustomerIDin = CustomerIDin.getText();
				String SFnameIn = fnamein.getText();
				String SSnameIn = snamein.getText();
				String SAddIn1 = add1in.getText();
				String SAddIn2 = add2in.getText();
				String SAddIn3 = add3in.getText();
				String SDateIn = datein.getText();
				String STimeIn = timein.getText();
				String SContactIn = contactin.getText();

				DB bookingDB = new DB();
				Statement callStatement = bookingDB.connect.createStatement();

				// String selectCustomerID =
				// "Select Customer_ID From Customer ";
				if (SCustomerIDin.isEmpty()) {
					String InsertCustomerDetails = "INSERT INTO Customers (Customer_First_Name, Customer_Last_Name, Customer_PHNumber, Address1, Address2, Address3) "
							+ "VALUES('"
							+ SFnameIn
							+ "', '"
							+ SSnameIn
							+ "', '"
							+ SContactIn
							+ "', '"
							+ SAddIn1
							+ "', '"
							+ SAddIn2 + "','" + SAddIn3;
					String InsertBookingAppointment = "INSERT INTO Appointment (Appointment_Time, Appointment_date, Customer_ID) VALUES('"
							+ STimeIn
							+ "', '"
							+ SDateIn
							+ "', '"
							+ SCustomerIDin + "')";

					callStatement.execute(InsertCustomerDetails);
					callStatement.execute(InsertBookingAppointment);

				} else {
					String InsertBookingAppointment = "INSERT INTO Appointment (Appointment_Time, Appointment_date, Customer_ID) VALUES('"
							+ STimeIn
							+ "', '"
							+ SDateIn
							+ "', '"
							+ SCustomerIDin + "')";
					callStatement.execute(InsertBookingAppointment);

				}

			} catch (SQLException bookingExc) {
				bookingExc.printStackTrace();
			}

		}
	}

}
