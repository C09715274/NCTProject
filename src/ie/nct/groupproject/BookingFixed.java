package ie.nct.groupproject;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookingFixed {

	JPanel BookingForm;

	private JTextField fnamein;
	private JTextField snamein;

	private JTextField regin;
	private JTextField add1in;
	private JTextField add2in;
	private JTextField add3in;
	private JTextField datein;
	private JTextField timein;
	private JTextField contactin;
	private JTextField CustomerIDin;
	protected String dbUser = "LoginBot";
	protected String dbPassword = "rawr";
	private String customerIDForUpdate = null;

	DB bookingDB ;
	
	

	private void getCustomers(String customerID) {
		
	int i =  Integer.parseInt(customerID);
		//System.out.println(customerID+i);
		//Integer i = Integer.getInteger(CustomerIDin.getText());
		System.out.println("string: "+customerID+" int: "+i);

		
		//System.out.println("Random string to see if this works");

	//	Integer foo = Integer.valueOf(customerID);
		//System.out.println(foo);
		String callCustomerForUpdate = "SELECT Customer_ID, Customer_First_Name, Customer_Second_Name, Customer_PHNumber" +
				",Customer_Address1,Customer_Address2,Customer_Address3 FROM Customer WHERE Customer_ID = "+i;
	//	PreparedStatement callCustomerStatement;
		try {
			
			PreparedStatement callCustomerStatement = bookingDB.connect
					.prepareStatement(callCustomerForUpdate);
			


			ResultSet callCustomerResults = callCustomerStatement
					.executeQuery();
			while (callCustomerResults.next()) {
				fnamein.setText(callCustomerResults
						.getString("Customer_First_Name"));
				snamein.setText(callCustomerResults
						.getString("Customer_Second_Name"));
				contactin.setText(callCustomerResults.getString("Customer_PHNumber"));
				add1in.setText(callCustomerResults
						.getString("Customer_Address1"));
				add2in.setText(callCustomerResults
						.getString("Customer_Address2"));
				add3in.setText(callCustomerResults
						.getString("Customer_Address3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public BookingFixed(String appointmentKey) {

		// TODO Auto-generated method stub
		try {
			bookingDB = new DB(dbUser, dbPassword);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
		JButton CustomerSub=new JButton("Get details given Id");
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
		BookingForm.add(CustomerSub);
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
		
		//for edit appointment
		if (appointmentKey != null) {

			try {
				String callAppointmentForUpdate = "SELECT * FROM Appointment WHERE Appointment_ID = '"
						+ appointmentKey + "'";

				PreparedStatement callAppointmentStatement = bookingDB.connect
						.prepareStatement(callAppointmentForUpdate);
				ResultSet callAppointmentResults = callAppointmentStatement
						.executeQuery();

				while (callAppointmentResults.next()) {
					customerIDForUpdate = callAppointmentResults
							.getString("Customer_ID");
					CustomerIDin.setText(customerIDForUpdate);
					datein.setText(callAppointmentResults
							.getString("Appointment_time"));
					timein.setText(callAppointmentResults
							.getString("Appointment_date"));

				}
				getCustomers(customerIDForUpdate);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		BookingHandler BookingHandlerObject = new BookingHandler();
		sub.addActionListener(BookingHandlerObject);
		CallCustomer callCustomerObject = new CallCustomer();
		CustomerSub.addActionListener(callCustomerObject);
		
	}

	private class CallCustomer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			

			getCustomers(CustomerIDin.getText());
		}
	}

	private class BookingHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub}

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

				Statement callStatement = bookingDB.connect.createStatement();

				// String selectCustomerID =
				// "Select Customer_ID From Customer ";
				if (SCustomerIDin.isEmpty()) {
					String InsertCustomerDetails = "INSERT INTO Customers (Customer_ID, Customer_First_Name, Customer_Last_Name, Customer_PHNumber, Address1, Address2, Address3) "
							+ "VALUES('"
							+null
							+"', '"
							+ SFnameIn
							+ "', '"
							+ SSnameIn
							+ "', '"
							+ SContactIn
							+ "', '"
							+ SAddIn1
							+ "', '"
							+ SAddIn2 + "','" + SAddIn3;
					
					
					
					String InsertBookingAppointment = "INSERT INTO Appointment (Appointment_ID, Appointment_Creation, Appointment_Time, Appointment_date, Customer_ID) VALUES("
							+null
							+","
							+null
							+",'"
							+ STimeIn
							+ "', '"
							+ SDateIn
							+ "', '"
							+ SCustomerIDin + "')";

					callStatement.execute(InsertCustomerDetails);
					callStatement.execute(InsertBookingAppointment);

				} else {
					String InsertBookingAppointment = "INSERT INTO Appointment (Appointment_ID, Appointment_Creation, Appointment_Time, Appointment_date, Customer_ID) VALUES("
							+null
							+","
							+null
							+",'"
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
