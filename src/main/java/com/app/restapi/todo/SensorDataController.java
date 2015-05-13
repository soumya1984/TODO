package com.app.restapi.todo;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.amazon.sns.SendMailSSL;
import com.app.restapi.todo.domain.SensorData;
import com.app.todo.dao.DaoService;
import com.app.todo.dao.DaoService_impl;
import com.app.todo.dao.MongoDAOProcessHelper;
import com.app.todo.mongodb.MongoDBConnectionHelper;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Path("/sensitouch/sensordata")
public class SensorDataController {
	/**
	 * Service to add a new sensor into the system
	 * 
	 * @param sensor
	 * @param uriInfo
	 * @return
	 */
	@Path("/{id}/publish")
	@POST
	@Consumes("application/json")
	public Response publishSensorData(@PathParam("id") String id, SensorData sensorData,
			@Context UriInfo uriInfo) {
		MongoDAOProcessHelper daoHelper = new MongoDAOProcessHelper();
		DBObject db = daoHelper.publishSensorDataRequest(id, sensorData);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		//return Response.created(builder.build()).build();
		//Send Out emergency Email
		SendMailSSL.SendMailWithSSL();
		return Response.created(builder.build()).status(201).entity(new Gson().toJson(db)).build();
	}

     /**
      * Get the list of the sensors
      * @param uriInfo
      * @return
      */
	@GET
	@Path("/{id}")
	@Produces({ "application/xml", "application/json" })
	public Response searchDatabyId(@PathParam("id") String id, @Context UriInfo uriInfo) {
		List<DBObject> objList = null;
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("sensorId", id);		
		DaoService service = new DaoService_impl();
		try {
			objList = service.retrieveSensor(searchQuery,
					MongoDBConnectionHelper.getCollection("SensorData"));
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
