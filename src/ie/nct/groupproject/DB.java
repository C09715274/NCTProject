package ie.nct.groupproject;

import java.sql.*;
public  class DB{
	String dbUrl = "jdbc:mysql://localhost/teamproject";
	Connection connect = null;

	public DB(){} //no argument constructor
	public DB( String _username, String _password ) throws Exception{
		
		try {
			System.out.println("connecting to driver");

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connected to driver");

			connect = DriverManager
					.getConnection(dbUrl , _username, _password);
			
			System.out.printf("Its working!"+ _username+ _password);

		} catch (ClassNotFoundException error) {
			System.out.println("error" + error);
		} 
	}
}
