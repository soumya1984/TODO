package com.app.restapi.todo.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sensorlist")
public class Sensors {

	private Collection<Sensor> sensor = new ArrayList<Sensor>();

	@XmlElementRef
	public Collection<Sensor> getTodo() {
		return sensor;
	}

	public void setTodo(Collection<Sensor> sensor) {
		this.sensor = sensor;
	}

}
