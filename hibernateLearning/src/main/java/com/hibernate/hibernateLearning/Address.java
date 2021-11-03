package com.hibernate.hibernateLearning;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="address_id")
	private int addressId;
	@Column(length=50,name="Street")
	private String street;
	@Column(length=50,name="City")
	private String city;
	@Column(name="isQuarantined")
	private boolean isQuarantine;
	@Transient
	private double x;
	@Column(name="quarantine_date")
	@Temporal(TemporalType.DATE)
	private Date quarantinedDate;
	@Lob
	private byte[] image;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int addressId, String street, String city, boolean isQuarantine, double x, Date quarantinedDate,
			byte[] image) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isQuarantine = isQuarantine;
		this.x = x;
		this.quarantinedDate = quarantinedDate;
		this.image = image;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isQuarantine() {
		return isQuarantine;
	}
	public void setQuarantine(boolean isQuarantine) {
		this.isQuarantine = isQuarantine;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public Date getQuarantinedDate() {
		return quarantinedDate;
	}
	public void setQuarantinedDate(Date quarantinedDate) {
		this.quarantinedDate = quarantinedDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isQuarantine="
				+ isQuarantine + ", x=" + x + ", quarantinedDate=" + quarantinedDate + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	

}
