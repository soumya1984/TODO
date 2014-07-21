package com.app.todo.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.app.restapi.todo.domain.Todo;
import com.app.restapi.todo.domain.TodoList;
import com.app.todo.mongodb.MongoDBConnectionHelper;
import com.mongodb.BasicDBObject;

public class MongoDAOProcessHelper {
	

	public List<String> processCreateRequest(TodoList todolist) {
		DaoService service = new DaoService_impl();
		List<String> string = new ArrayList<String>();
		for(Todo todo:todolist.getTodo()){
			BasicDBObject document = new BasicDBObject();
			UUID Id = UUID.randomUUID();
			document.put("_id", Id);
			string.add(Id.toString());
			document.put("title", todo.getTitle());
			document.put("status", todo.getStatus());
			document.put("priority", todo.getPriority());
			document.put("desc", todo.getDescriptions());
			document.put("createdDate", todo.getCreateDate());
			document.put("assignee", todo.getAssignee());
			try {
				service.createRecord(document, MongoDBConnectionHelper.getCollection("todo"));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return string;
		
	}

}
