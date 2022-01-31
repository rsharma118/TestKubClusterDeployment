package com.demo.model;

public class EmpDoc {
	  private String _id ;
	  private String name;
	  private String doj;
	  private String emailid ;
	  private String _rev = null;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	@Override
	public String toString() {
		return "EmpDoc [_id=" + _id + ", name=" + name + ", doj=" + doj + ", emailid=" + emailid + ", _rev=" + _rev
				+ "]";
	}
	
	
	 
	}
