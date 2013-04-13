package ie.nct.groupproject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel LoginForm;
	
	JTextField passwordInput = new JPasswordField(15);
	JTextField usernameInput = new JTextField(15);

	JButton sub;

	public static String password;
	public static String username;

	String SPassword;
	String SUsername;
	
	protected String dbUser = "LoginBot";
	protected String dbPassword = "rawr";
	// Connection connect = null;
	//Statement UsernameStatement = null;
	DB LoginDBObject = null;

	public Login() {
		
		LoginForm = new JPanel();
		// TODO Auto-generated method stub
		JLabel user = new JLabel("Username: ");
		JLabel title = new JLabel("Login Page ");
		JLabel password = new JLabel("Password: ");
		JButton sub = new JButton("Submit");
		title.setFont(new Font("Serif", Font.PLAIN, 30));

		
		LoginForm.setPreferredSize(new Dimension(10, 200));
		LoginForm.setBounds(400, 210, 200, 200);
		LoginForm.add(title);
		LoginForm.add(user);
		LoginForm.add(usernameInput);
		LoginForm.add(password);
		LoginForm.add(passwordInput);
		LoginForm.add(sub);
		LoginHandler LoginHandlerObject = new LoginHandler();
		sub.addActionListener(LoginHandlerObject);

	}
	
	
	
	private class LoginHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try {
				LoginDBObject = new DB(dbUser, dbPassword);
				System.out.println("\n Loggin into database");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("\n Login into database failed");

				
			}
			// TODO Auto-generated method stub
		
			try {
				
				SUsername = usernameInput.getText();
				SPassword = passwordInput.getText();
				System.out.println(SUsername + SPassword);


				String CallUsername = "SELECT Staff_Name FROM staff WHERE Staff_Name='"+ SUsername +"'"  ;
		        PreparedStatement UsernameStatement = LoginDBObject.connect.prepareStatement(CallUsername);
				ResultSet ResultsUsername = UsernameStatement.executeQuery();


				while(ResultsUsername.next()){
					
				String QueriedUser = ResultsUsername.getString("Staff_Name");
				System.out.println("in loop userloop "+ QueriedUser);
				if (SUsername.equals(QueriedUser)) {
					System.out.println("user name accepted");
					
					String CallPassword = "SELECT Password FROM staff where Staff_Name='"
					+SUsername+"' && Password='"+SPassword+"'";
					
					PreparedStatement PasswordStatement = LoginDBObject.connect.prepareStatement(CallPassword);
					ResultSet ResultsPassword = PasswordStatement.executeQuery();
					
					while(ResultsPassword.next()){
						String QueriedPassword = ResultsPassword.getString("Password");
						
						if(SUsername.equals(QueriedUser) && SPassword.equals(QueriedPassword)){
							System.out.println("User logged in");
							// done something to switch to next screen
						}else{
							System.out.println("User not logged in password failed");
						}
					}
					
				}else{
					System.out.println("user name not accepted");

				}
				}
				
			} catch (SQLException se) {
				se.printStackTrace();
			} 
		}
	}

}
