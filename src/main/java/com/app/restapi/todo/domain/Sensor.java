package com.app.restapi.todo.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sensor")
@XmlType(propOrder = { "sensorId", "sensorName", "sensorStatus", "userid",
		"sensorType", "sensorDescription" })
public class Sensor {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	private String sensorId;
	private String sensorName;
	private String sensorStatus;
	private String userid;
	private String sensorType;
	private double latitude;
	private double longitude;
	private String sensorDescription;

	/**
	 * @return the sensorDescription
	 */
	@XmlElement
	public String getSensorDescription() {
		return sensorDescription;
	}

	/**
	 * @return the sensorId
	 */
	@XmlElement
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * @return the sensorName
	 */
	@XmlElement
	public String getSensorName() {
		return sensorName;
	}

	/**
	 * @return the sensorStatus
	 */
	@XmlElement
	public String getSensorStatus() {
		return sensorStatus;
	}

	/**
	 * @return the userid
	 */
	@XmlElement
	public String getUserid() {
		return userid;
	}

	/**
	 * @return the sensorType
	 */
	@XmlElement
	public String getSensorType() {
		return sensorType;
	}

	/**
	 * @return the latitude
	 */
	@XmlElement
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	@XmlElement
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param sensorId
	 *            the sensorId to set
	 */
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	/**
	 * @param sensorName
	 *            the sensorName to set
	 */
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	/**
	 * @param sensorStatus
	 *            the sensorStatus to set
	 */
	public void setSensorStatus(String sensorStatus) {
		this.sensorStatus = sensorStatus;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @param sensorType
	 *            the sensorType to set
	 */
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	/**
	 * @param sensorDescription
	 *            the sensorDescription to set
	 */
	public void setSensorDescription(String sensorDescription) {
		this.sensorDescription = sensorDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sensor [sensorId=" + sensorId + ", sensorName=" + sensorName
				+ ", sensorStatus=" + sensorStatus + ", userid=" + userid
				+ ", sensorType=" + sensorType + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", sensorDescription="
				+ sensorDescription + "]";
	}

}
