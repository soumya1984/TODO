package com.app.restapi.todo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	/**
	 * Service to add a new sensor into the system
	 * 
	 * @param sensor
	 * @param uriInfo
	 * @return
	 */
	@Path("/create")
	@POST
	@Consumes("application/json")
	public Response CreateSensors(Sensor sensor, @Context UriInfo uriInfo) {
		MongoDAOProcessHelper daoHelper = new MongoDAOProcessHelper();
		DBObject db = daoHelper.processCreateSensorRequest(sensor);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		return Response.created(builder.build()).status(201).entity(new Gson().toJson(db)).build();

	}

     /**
      * Get the list of the sensors
      * @param uriInfo
      * @return
      */
	@GET
	@Produces({ "application/xml", "application/json" })
	public Response searchsSensors(@Context UriInfo uriInfo) {
		List<DBObject> objList = null;
		BasicDBObject searchQuery = new BasicDBObject();
		// searchQuery.put("_id", id);
		DaoService service = new DaoService_impl();
		try {
			objList = service.retrieveSensor(searchQuery,
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
	
    /**
     * Get the sensors by userId
     * @param uriInfo
     * @return
     */
	@GET
	@Path("/userid")
	@Produces({ "application/xml", "application/json" })
	public Response searchSensorById(@Context UriInfo uriInfo,@QueryParam(value = "userId") String userId) {
		List<DBObject> objList = null;
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		BasicDBObject searchQuery = new BasicDBObject();
		// searchQuery.put("_id", id);
		DaoService service = new DaoService_impl();
		List<DBObject> sensors=new ArrayList<DBObject>();
		try {
			objList = service.retrieveSensor(searchQuery,
					MongoDBConnectionHelper.getCollection("sensor"));
			for(DBObject dbobj:objList){
				if(userId.equals(dbobj.get("userid"))){
					sensors.add(dbobj);
					
				}
			}
			return Response.created(builder.build()).status(200)
					.entity(new Gson().toJson(sensors)).build();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

}
