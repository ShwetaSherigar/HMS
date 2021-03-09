package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	private int customerId;
	private String name;
	private long phone;
	private String gender;
	private String address;
	private String emailId;
	private String password;

	public Customer(int customerId, String name, long phone, String gender, String address, String emailId,
			String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
	}

	public Customer() {
		super();
	}

	@Id
	@GeneratedValue
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phone=" + phone + ", gender=" + gender
				+ ", address=" + address + ", emailId=" + emailId + ", password=" + password + "]";
	}

}
