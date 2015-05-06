package com.app.todo.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.app.restapi.todo.domain.Sensor;
import com.app.restapi.todo.domain.Todo;
import com.app.restapi.todo.domain.TodoList;
import com.app.restapi.todo.domain.User;
import com.app.todo.mongodb.MongoDBConnectionHelper;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

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
	
	public DBObject processCreateSensorRequest(Sensor sensor) {
		DaoService service = new DaoService_impl();
		UUID Id = UUID.randomUUID();
		
		sensor.setSensorId(Id.toString());
		
		Gson gson = new Gson();
		DBObject db = (DBObject) JSON.parse( gson.toJson(sensor));
		
		try {
			service.saveObject(MongoDBConnectionHelper.getCollection("sensor"), db);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return db;
		
				
	}
	
	public DBObject processCreateUserRequest(User user) {
		DaoService service = new DaoService_impl();
		UUID Id = UUID.randomUUID();
		
		user.setUserId(Id.toString());
		
		Gson gson = new Gson();
		DBObject db = (DBObject) JSON.parse( gson.toJson(user));
		
		try {
			service.saveObject(MongoDBConnectionHelper.getCollection("user"), db);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return db;
		
				
	}

}
