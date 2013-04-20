package ie.nct.groupproject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class results2 {

	JPanel contentPane;
	JPanel body;
	JPanel form;

	JTextField RearAxleNearIn;
	JTextField FrontAxleNearIn;
	JTextField ParkBreakNearIn;
	JTextField ParkBreakOffIn;
	JTextField FrontAxleOffIn;
	JTextField RearAxleOffIn;
	JTextField ovalfrontnin;
	JTextField ovalrearnin;
	JTextField ovalfrontoin;
	JTextField ovalrearoin;

	DB Results2DBObject = new DB();

	protected String dbUser = "LoginBot";
	protected String dbPassword = "rawr";
	
	String _appointmentID;

	int iAppointmentID;
	private void checkIsDone() {


		String checkIsComplete = "SELECT * FROM Results2 WHERE appointmentId ="
				+ iAppointmentID;

		PreparedStatement checkIsCompleteStatement;
		try {
			checkIsCompleteStatement = Results2DBObject.connect
					.prepareStatement(checkIsComplete);

			ResultSet callResults = checkIsCompleteStatement.executeQuery();
			while (callResults.next()) {
				RearAxleNearIn.setText(callResults.getString("REARAXLENEAR"));
				FrontAxleNearIn.setText(callResults.getString("FRONTAXLENEAR"));
				ParkBreakNearIn.setText(callResults.getString("PARKBREAKNEAR"));
				ParkBreakOffIn.setText(callResults.getString("PARKBREAKOFF"));
				FrontAxleOffIn.setText(callResults.getString("FRONTAXLEOFF"));
				RearAxleOffIn.setText(callResults.getString("REARAXLEOFF"));
				ovalfrontnin.setText(callResults.getString("FRONTAXLENEAROVALITY"));
				ovalrearnin.setText(callResults.getString("REARAXLENEAROVALITY"));
				ovalfrontoin.setText(callResults.getString("REARAXLEOFFOVALITY"));
				ovalrearoin.setText(callResults.getString("FRONTAXLEOFFOVALITY"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public results2(String appointmentID) {

		 iAppointmentID =  Integer.parseInt(appointmentID);

		// TODO Auto-generated method stub
		form = new JPanel();
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
		JLabel faxlen = new JLabel("Front axle Near: ");
		JLabel raxlen = new JLabel("Rear axle Near: ");
		JLabel faxleo = new JLabel("Front axle Off:");
		JLabel raxleo = new JLabel("Rear axle Off: ");
		JLabel parkbreakn = new JLabel("Park Break Near");
		JLabel ovality = new JLabel("Ovality");
		JLabel ovalfrontn = new JLabel("Front axle Near:");
		JLabel ovalrearn = new JLabel("Rear axle Near:");
		JLabel ovalfronto = new JLabel("Front axle Off: ");
		JLabel ovalrearo = new JLabel("Rear axle Off");

		JButton sub = new JButton();

		RearAxleNearIn = new JTextField(15);
		FrontAxleNearIn = new JTextField(15);
		ParkBreakNearIn = new JTextField(15);
		ParkBreakOffIn = new JTextField(15);
		FrontAxleOffIn = new JTextField(15);
		RearAxleOffIn = new JTextField(15);
		ovalfrontnin = new JTextField(15);
		ovalrearnin = new JTextField(15);
		ovalfrontoin = new JTextField(15);
		ovalrearoin = new JTextField(15);

		form.add(effort);
		form.add(blank);
		form.add(blank1);
		form.add(blank2);
		form.add(faxlen);
		form.add(FrontAxleNearIn);
		form.add(raxlen);
		form.add(RearAxleNearIn);
		form.add(faxleo);
		form.add(FrontAxleOffIn);
		form.add(raxleo);
		form.add(RearAxleOffIn);
		form.add(parkbreakn);
		form.add(ParkBreakNearIn);
		form.add(parkbreako);
		form.add(ParkBreakOffIn);
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

		if (appointmentID != null) {
			checkIsDone();
		}

		form.add(sub);

		Results2Handler Results1HandlerObject = new Results2Handler();
		sub.addActionListener(Results1HandlerObject);

	}

	private class Results2Handler implements ActionListener {

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

				String sRearAxleNearIn = RearAxleNearIn.getText();
				String sFrontAxleNearIn = FrontAxleNearIn.getText();

				String sParkBreakNearIn = ParkBreakNearIn.getText();
				String sParkBreakOffIn = ParkBreakOffIn.getText();

				String sFrontAxleOffIn = FrontAxleOffIn.getText();
				String sRearAxleOffIn = RearAxleOffIn.getText();

				String sovalfrontin = ovalfrontnin.getText();
				String sovalrearnin = ovalrearnin.getText();
				String sovalfrontoin = ovalfrontoin.getText();
				String sovalrearoin = ovalrearoin.getText();

				DB bookingDB = new DB();
				Statement callStatement = bookingDB.connect.createStatement();

				String InsertTestResults1 = "INSERT INTO Results2 (appointment_id, REARAXLENEAR, FRONTAXLENEAR, PARKBREAKNEAR, PARKBREAKOFF, FRONTAXLEOFF, REARAXLEOFF, FRONAXLENEAROVALITY, REARAXLENEAROVALITY, REARAXLEOFFOVALITY, FRONTAXLEOFFOVALITY) Values("
						+iAppointmentID
						+", '"
						+ sRearAxleNearIn
						+ "', '"
						+ sFrontAxleNearIn
						+ "', '"
						+ sParkBreakNearIn
						+ "', '"
						+ sParkBreakOffIn
						+ "', '"
						+ sFrontAxleOffIn
						+ "', '"
						+ sRearAxleOffIn
						+ "', '"
						+ sovalfrontin
						+ "', '"
						+ sovalrearnin
						+ "', '"
						+ sovalfrontoin + "', '" + sovalrearoin + "')";

				callStatement.execute(InsertTestResults1);

			} catch (SQLException bookingExc) {
				bookingExc.printStackTrace();
			}

		}
	}

}
