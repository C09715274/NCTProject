package ie.nct.groupproject;

import java.awt.*;
import javax.swing.*;

public class MainC extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					GUI GUIObject = new GUI();

				//	Login LoginObject = new Login();
					
			//		GUIObject.main.add(BookingTestObject.BookingForm);

				//	results resultsObject = new results();
					BookingFixed BookingTestObject = new BookingFixed(null);
					results2 results2Object = new results2(null);
					GUIObject.main.add(BookingTestObject.BookingForm);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
