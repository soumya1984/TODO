package com.app.restapi.todo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.app.restapi.todo.domain.TodoList;

public interface TODOResource {
	public Response createTodo(TodoList todolist,@Context UriInfo uriInfo);
	public Response searchTodobyId(@Context UriInfo uriInfo);

	/**
	 * public TodoListHelper getTodo();
	 * 
	 * 
	 * public void deleteTodo(TodoListHelper todolist);
	 * 
	 * public void updateTodo(TodoListHelper todolist);
	 * 
	 * public void updateStatus(TodoListHelper todolist);
	 * 
	 * public void searchTodobyId(TodoListHelper todoList);
	 **/

}
