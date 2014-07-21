package com.app.restapi.todo.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "todo")
@XmlType(propOrder = { "todoId", "title", "assignee", "createDate", "status",
		"priority", "descriptions" })
public class Todo {
	private String title;
	private String assignee;
	private String createDate;
	private String status;
	private int priority;
	private String descriptions;
	private long todoId;

	public Todo(long todoId, String title, String assignee, String createDate,
			String status, int priority, String descriptions) {
		// super();
		this.todoId = todoId;
		this.title = title;
		this.assignee = assignee;
		this.createDate = createDate;
		this.status = status;
		this.priority = priority;
		this.descriptions = descriptions;
	}
	public Todo(){
		//dummy
	}

	/**
	 * @return the todoId
	 */
	@XmlElement
	public long getTodoId() {
		return todoId;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	@XmlElement
	public String getAssignee() {
		return assignee;
	}

	@XmlElement
	public String getCreateDate() {
		return createDate;
	}

	@XmlElement
	public String getStatus() {
		return status;
	}

	@XmlElement
	public int getPriority() {
		return priority;
	}

	@XmlElement
	public String getDescriptions() {
		return descriptions;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public void setStatus(String status) {
		status = status;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}


	/**
	 * @param todoId
	 *            the todoId to set
	 */
	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	@Override
	public String toString() {
		return "todo{" + "id=" + todoId + ", title='" + title + '\''
				+ ", assignee='" + assignee + '\'' + ", createDate='"
				+ createDate + '\'' + ", Status='" + status + '\''
				+ ", priority='" + priority + '\'' + ", Ddescriptions='"
				+ descriptions + '\'' + '}';
	}

}
