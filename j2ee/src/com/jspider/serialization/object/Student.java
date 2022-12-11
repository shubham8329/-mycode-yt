package com.jspider.serialization.object;
import java.io.Serializable;
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ID;
	private String Name;
	private String Email;
	private String Address;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	@Override
	public String toString() {
		return "student[ID ="+ ID +",Name="+ Name +",Email="+ Email +",Address="+ Address +"]";
	}
	public static char[] getAbsolutePath() {
		// TODO Auto-generated method stub
		return null;
	}
}
