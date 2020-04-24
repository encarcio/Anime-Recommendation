package com.example.demo.jdbc;

import java.sql.*;
import java.sql.Statement;

public class jdbc {

	int result=0;
	static int res = 0;

	public int getdata()
	{
	    result=process();
		  
		   return res;
	   }
	
	
	public void setdata() {
		
	}
	  public static int process()
	  {
		  		  try (
				  Connection conn = DriverManager.getConnection(
			               "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
			               "root", "");  
			         Statement stmt = conn.createStatement();
			      ){
			  String strSelect = "select * from user where id=3";
			  ResultSet rset = stmt.executeQuery(strSelect);
			  while(rset.next()) {
				res=rset.getInt(3);//res= rset.getInt("id");
			  }
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  } 
		  return res;
	  }
}
