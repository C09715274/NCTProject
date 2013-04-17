package ie.nct.groupproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class results {

	JPanel contentPane;
	JPanel body;
	JPanel form;

	JTextField RearAxelin;
	JTextField FrontAxelin;
	JTextField RearAxelNearIn;
	JTextField FrontAxelNearIn;
	JTextField RearAxelOffIn;
	JTextField FrontAxelOffIn;
	JTextField lowIdlein;
	JTextField highIdlein;

	DB Results1DBObject = null;

	protected String dbUser = "LoginBot";
	protected String dbPassword = "rawr";

	public results() {
		// TODO Auto-generated method stub
		form = new JPanel();
		JLabel blank = new JLabel();
		JLabel blank1 = new JLabel();
		JLabel blank2 = new JLabel();
		JLabel blank3 = new JLabel();
		JLabel blank4 = new JLabel();
		JLabel blank5 = new JLabel();
		JLabel blank6 = new JLabel();
		JLabel blank7 = new JLabel();
		JLabel blank8 = new JLabel();
		form.setLayout(new GridLayout(7, 4, 10, 10));
		JLabel AlignmentTestHeader = new JLabel("Side-Slip/Alignment Test");
		JLabel FAxel = new JLabel("Front Axel: ");
		JLabel RAxel = new JLabel("Rear Axel: ");
		JLabel RearAxelNear = new JLabel("Rear Axel Near: ");
		JLabel RearAxelOff = new JLabel("Rear Axel Off: ");
		JLabel FrontAxelOff = new JLabel("Front Axel Off:");
		JLabel SuspensionTestHeader = new JLabel("Suspension Test");
		JLabel FrontAxelNear = new JLabel("Front Axel Near:");
		JLabel emissionsHeader = new JLabel("Emissions Test");
		JLabel lowIdle = new JLabel("Low Idle");
		JLabel highIdle = new JLabel("High Idle");

		RearAxelin = new JTextField(15);
		FrontAxelin = new JTextField(15);
		RearAxelNearIn = new JTextField(15);
		FrontAxelNearIn = new JTextField(15);
		RearAxelOffIn = new JTextField(15);
		FrontAxelOffIn = new JTextField(15);
		lowIdlein = new JTextField(15);
		highIdlein = new JTextField(15);
		form.setBounds(110, 110, 700, 400);

		form.add(AlignmentTestHeader);
		form.add(blank);
		form.add(blank1);
		form.add(blank2);
		form.add(FAxel);
		form.add(FrontAxelin);
		form.add(RAxel);
		form.add(RearAxelin);
		form.add(SuspensionTestHeader);
		form.add(blank3);
		form.add(blank4);
		form.add(blank5);
		form.add(FrontAxelNear);
		form.add(FrontAxelNearIn);
		form.add(RearAxelNear);
		form.add(RearAxelNearIn);
		form.add(FrontAxelOff);
		form.add(FrontAxelOffIn);
		form.add(RearAxelOff);
		form.add(RearAxelOffIn);
		form.add(emissionsHeader);
		form.add(blank6);
		form.add(blank7);
		form.add(blank8);
		form.add(lowIdle);
		form.add(lowIdlein);
		form.add(highIdle);
		form.add(highIdlein);

	}

	private class BookingHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			try {
				Results1DBObject = new DB(dbUser, dbPassword);
				System.out.println("\n Booking database");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("\n Booking database failed");
			}

			try {

				String sRearAxelin = RearAxelin.getText();
				String sFrontAxelin = FrontAxelin.getText();
				String sRearAxelNearIn = RearAxelNearIn.getText();
				String sFrontAxelNearIn = FrontAxelNearIn.getText();
				String sRearAxelOffIn = RearAxelOffIn.getText();
				String sFrontAxelOffIn = FrontAxelOffIn.getText();
				String slowIdlein = lowIdlein.getText();
				String sHighIdlein = highIdlein.getText();

				DB bookingDB = new DB();
				Statement callStatement = bookingDB.connect.createStatement();

				String InsertTestResults1 = "INSERT INTO Results1 " +
						"(REAXLE, FRONTAXLE, REARAXLENEAR, FRONTAXELNEAR, REARAXLEOFF, FRONTAXLEOF, LOWIDLE, HIGHIDLE) " +
						"VALUES ('" +sRearAxelin+"', '"+ sFrontAxelin+ "', '"+sRearAxelNearIn+ "', '"+sFrontAxelNearIn+ "', '"+sRearAxelOffIn+ "', '"+sFrontAxelOffIn+ "', '"+slowIdlein+ "', '"+highIdlein+ "')";

				callStatement.execute(InsertTestResults1);

			} catch (SQLException bookingExc) {
				bookingExc.printStackTrace();
			}

		}
	}

}
