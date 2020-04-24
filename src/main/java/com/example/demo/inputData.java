package com.example.demo;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


public class inputData {
 private  String genre;
	private String exp;
	private String stream;
	Map<String,String> out=new HashMap<String,String>();	
public Map<String, String> getOut() {
		return out;
	}


	public void setOut(Map<String, String> out) {
		this.out = out;
	}


public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
		System.out.println("DATA IN THE INPUT DATA CLASS IS "+this.genre );
	}


	public String getExp() {
		return exp;
	}


	public void setExp(String exp) {
		this.exp = exp;
		System.out.println("DATA IN THE INPUT DATA CLASS IS "+this.exp );
	}


	public String getStream() {
		return stream;
	}


	public void setStream(String stream) {
		this.stream = stream;
		System.out.println("DATA IN THE INPUT DATA CLASS IS "+this.stream );
		putinfo();
	}


public void putinfo()
{  
	
	String gen="%"+genre+"%";
	String st=stream.substring(0,4)+"%";
	Integer exper=new Integer(exp);
	System.out.println("DATA IN THE INPUT DATA CLASS IS "+gen+" "+st+""+exper);
	
	String str="select * from anime where genre LIKE ? and exp=? and stream LIKE ?";
	
	 try (
             Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/postgres",
				"postgres", "xxxx");
             
               Statement stmt = conn.createStatement();
             ){
		 
		 PreparedStatement pre=conn.prepareStatement(str); 
		 pre.setString(1, gen);
		 pre.setInt(2, exper);
		 pre.setString(3, st);
		ResultSet se= pre.executeQuery();
		while(se.next())
		{   String s1=se.getString(2);
		     String s2=se.getString(6);
		     out.put(s1, s2);
			System.out.println(s1);
			System.out.println(s2);
		}
	
	
	
	
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	
}
}
