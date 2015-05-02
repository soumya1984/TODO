package com.app.restapi.todo;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.app.restapi.todo.domain.Sensor;
import com.app.restapi.todo.domain.TodoList;
import com.app.restapi.todo.domain.User;
import com.app.restapi.todo.smsservice.SmsService;
import com.app.restapi.todo.smsservice.SmsService_impl;
import com.app.todo.dao.DaoService;
import com.app.todo.dao.DaoService_impl;
import com.app.todo.dao.MongoDAOProcessHelper;
import com.app.todo.mongodb.MongoDBConnectionHelper;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Path("/sensitouch/sensor")
public class SensorController_impl {
	@POST
	@Consumes("application/json")
	public Response CreateUser(User user, @Context UriInfo uriInfo) {
		return null;
		/*MongoDAOProcessHelper daoHelper = new MongoDAOProcessHelper();
		List<String> todoidlist = daoHelper.processCreateRequest(todolist);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(new Gson().toJson(todoidlist));
		SmsService service = new SmsService_impl();
		service.sendSms("Hello","","");
		return Response.created(builder.build()).build();*/
		
		
	}
	@Path("/create")
	@POST
	@Consumes("application/json")
	public Response CreateSensors(Sensor sensor, @Context UriInfo uriInfo) {
		MongoDAOProcessHelper daoHelper = new MongoDAOProcessHelper();
		DBObject db = daoHelper.processCreateSensorRequest(sensor);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		return Response.created(builder.build()).build();
		
		
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response searchTodobyId(@Context UriInfo uriInfo) {
		List<DBObject> objList = null;
		BasicDBObject searchQuery = new BasicDBObject();
		// searchQuery.put("_id", id);
		DaoService service = new DaoService_impl();
		try {
			objList = service.retrieveAllTodo(searchQuery,
					MongoDBConnectionHelper.getCollection("sensor"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// for()
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();

		return Response.created(builder.build()).status(200)
				.entity(new Gson().toJson(objList)).build();
	}
	
	
	

}
