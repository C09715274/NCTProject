package com.model.deo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.bean.Person;

public class PersonDAO {

	public Person selectById(int id){
		
		Connection conn =null;
		Statement st = null;
		ResultSet rs = null;
		Person p = new Person();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamproject","root","");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM staff WHERE Staff_Id="+id+"");
			while(rs.next()){
				
				p.setId(rs.getInt("Staff_Id")); 
				p.setFirstName(rs.getString("Staff_Name"));
				p.setLastName(rs.getString("Staff_Type"));
				return p;	
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
					}
			}	
			if(st!=null){
				try{
					st.close();	
				}catch(SQLException e){
						e.printStackTrace();
				}
			}
				if(conn!=null){
					try{
					conn.close();	
				}catch(SQLException e){
						e.printStackTrace();
				}
			}
		}
		return p;
	}
	
	public List<Person> selectAll(){
		Connection conn =null;
		Statement st = null;
		ResultSet rs = null;
		List<Person> persons = new ArrayList<Person>();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamproject","root","");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM staff");
			while(rs.next()){
				Person p = new Person();
				p.setId(rs.getInt("Staff_Id"));
				p.setFirstName(rs.getString("Staff_Name"));
				p.setLastName(rs.getString("Staff_Type"));
				persons.add(p);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
					}
			}	
			if(st!=null){
				try{
					st.close();	
				}catch(SQLException e){
						e.printStackTrace();
				}
			}
				if(conn!=null){
					try{
					conn.close();	
				}catch(SQLException e){
						e.printStackTrace();
				}
			}
		}
		return persons;
	}
	
	public void insert(Person p){
		Connection conn = null;
		java.sql.PreparedStatement pst = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamproject","root","");
			pst = conn.prepareStatement("INSERT INTO staff (Staff_Id,Staff_Name,Staff_Type ) VALUES (?,?,?)");
			pst.setLong(1, p.getId());
			pst.setString(2, p.getFirstName());
			pst.setString(3, p.getLastName());
			pst.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pst!=null){
				try{
					pst.close();
				}catch(SQLException e){
					e.printStackTrace();
					}
			}	
			
		}
	}
		
		public void delete(int id){
			Connection conn = null;
			Statement st = null;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamproject","root","");
				st = conn.createStatement();
				st.execute("DELETE FROM staff WHERE Staff_Id="+id+"");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(st!=null){
					try{
						st.close();
					}catch(SQLException e){
						e.printStackTrace();
						}
				}	
				
			}
	}
		
		public void update(Person p, int id){
			Connection conn = null;
			Statement st = null;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teamproject","root","");
				st = conn.createStatement();
				st.execute("UPDATE staff SET Staff_Id='"+p.getId()+"',Staff_Name='"+p.getFirstName()+"', Staff_Type='"+p.getLastName()+"' WHERE Staff_Id="+id+"");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(st!=null){
					try{
						st.close();
					}catch(SQLException e){
						e.printStackTrace();
						}
				}	
				
			}
	}
}
