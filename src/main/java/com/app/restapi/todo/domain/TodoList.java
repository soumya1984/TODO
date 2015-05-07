package com.app.restapi.todo.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "todolist")
public class TodoList {

	private Collection<Todo> todo = new ArrayList<Todo>();
    @XmlElementRef
	public Collection<Todo> getTodo() {
		return todo;
	}

	public void setTodo(Collection<Todo> todo) {
		this.todo = todo;
	}

}
