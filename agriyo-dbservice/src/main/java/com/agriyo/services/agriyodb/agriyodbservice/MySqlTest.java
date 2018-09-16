package com.agriyo.services.agriyodb.agriyodbservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/agriyo_db","agriyo","Welc0me_1");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select id,s_id,state_Name from m_district");  
		List<String> districtList=new ArrayList<>(); 
		while(rs.next()) { 
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"");
			districtList.add(rs.getString(3));
		}
		
		 stmt=con.createStatement();
		for(String state:districtList) {
		ResultSet rs2=stmt.executeQuery("select id,state_name from m_state where state_name= '"+state+"'");
		
		while(rs2.next()) { 
		System.out.println("update m_district set s_id="+rs2.getInt(1)+" where state_name='"+state+"';");
		}
		}
		//stmt.executeQuery("upadte m_district");
		con.close();  
		}


}
