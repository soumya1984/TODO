package com.app.restapi.todo.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "user")
@XmlType(propOrder = { "userId", "firstName", "lastName", "mobile", "emailId",
		"addressLine1", "addressLine2" ,"city","country","zip"})
public class User {
	
	private String userId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String emailId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String country;
	private int zip;
	
	
	/**
	 * @return the userId
	 */
	@XmlElement
	public String getUserId() {
		return userId;
	}


	/**
	 * @return the firstName
	 */
	@XmlElement
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @return the lastName
	 */
	@XmlElement
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the mobile
	 */
	@XmlElement
	public String getMobile() {
		return mobile;
	}


	/**
	 * @return the emailId
	 */
	@XmlElement
	public String getEmailId() {
		return emailId;
	}


	/**
	 * @return the addressLine1
	 */
	@XmlElement
	public String getAddressLine1() {
		return addressLine1;
	}


	/**
	 * @return the addressLine2
	 */
	@XmlElement
	public String getAddressLine2() {
		return addressLine2;
	}


	/**
	 * @return the city
	 */
	@XmlElement
	public String getCity() {
		return city;
	}


	/**
	 * @return the country
	 */
	@XmlElement
	public String getCountry() {
		return country;
	}


	/**
	 * @return the zip
	 */
	@XmlElement
	public int getZip() {
		return zip;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobile=" + mobile
				+ ", emailId=" + emailId + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", country=" + country + ", zip=" + zip + "]";
	}


}
