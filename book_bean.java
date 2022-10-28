package com.pack;

import java.sql.Date;

public class book_bean {
	String b_name, b_email,b_cont_no, b_address, b_where_to;
	int b_how_many;
	Date b_arrival, b_leaving;
	int b_id;
	
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_cont_no() {
		return b_cont_no;
	}
	public void setB_cont_no(String b_cont_no) {
		this.b_cont_no = b_cont_no;
	}
	public String getB_address() {
		return b_address;
	}
	public void setB_address(String b_address) {
		this.b_address = b_address;
	}
	public String getB_where_to() {
		return b_where_to;
	}
	public void setB_where_to(String b_where_to) {
		this.b_where_to = b_where_to;
	}
	public int getB_how_many() {
		return b_how_many;
	}
	public void setB_how_many(int b_how_many) {
		this.b_how_many = b_how_many;
	}
	public Date getB_arrival() {
		return b_arrival;
	}
	public void setB_arrival(java.util.Date bar) {
		this.b_arrival = (Date) bar;
	}
	public Date getB_leaving() {
		return b_leaving;
	}
	public void setB_leaving(java.util.Date bl) {
		this.b_leaving = (Date) bl;
	}

}
