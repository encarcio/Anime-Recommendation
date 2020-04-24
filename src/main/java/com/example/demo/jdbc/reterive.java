package com.example.demo.jdbc;

public class reterive {
	public int id;
	
	public void set() {
		jdbc obj=new jdbc();
		id=obj.getdata();

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
