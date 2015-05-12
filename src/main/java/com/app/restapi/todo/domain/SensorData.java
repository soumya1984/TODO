package com.app.restapi.todo.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sensorData")
@XmlType(propOrder = { "sensorId", "sensorData", "sensorStatus"})

public class SensorData {
	private String sensorId;
	private String sensorData;
	private String sensorStatus;
	private String sensorPowerStatus;

	/**
	 * @return the sensorPowerStatus
	 */
	public String getSensorPowerStatus() {
		return sensorPowerStatus;
	}

	/**
	 * @param sensorPowerStatus the sensorPowerStatus to set
	 */
	public void setSensorPowerStatus(String sensorPowerStatus) {
		this.sensorPowerStatus = sensorPowerStatus;
	}

	/**
	 * @return the sensorId
	 */
	@XmlElement
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * @return the sensorData
	 */
	@XmlElement
	public String getSensorData() {
		return sensorData;
	}

	/**
	 * @return the sensorStatus
	 */
	@XmlElement
	public String getSensorStatus() {
		return sensorStatus;
	}

	/**
	 * @param sensorId
	 *            the sensorId to set
	 */
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	/**
	 * @param sensorData
	 *            the sensorData to set
	 */
	public void setSensorData(String sensorData) {
		this.sensorData = sensorData;
	}

	/**
	 * @param sensorStatus
	 *            the sensorStatus to set
	 */
	public void setSensorStatus(String sensorStatus) {
		this.sensorStatus = sensorStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SensorData [sensorId=").append(sensorId)
				.append(", sensorData=").append(sensorData)
				.append(", sensorStatus=").append(sensorStatus).append("]");
		return builder.toString();
	}

}
