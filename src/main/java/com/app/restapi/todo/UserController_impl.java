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

import com.app.restapi.todo.domain.User;
import com.app.todo.dao.DaoService;
import com.app.todo.dao.DaoService_impl;
import com.app.todo.dao.MongoDAOProcessHelper;
import com.app.todo.mongodb.MongoDBConnectionHelper;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Path("/sensitouch/user")
public class UserController_impl {
	@POST
	@Path("/create")
	@Consumes("application/json")
	public Response CreateUser(User user, @Context UriInfo uriInfo) {
		MongoDAOProcessHelper daoHelper = new MongoDAOProcessHelper();
		daoHelper.processCreateUserRequest(user);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		return Response.created(builder.build()).build();

	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public Response getAllUsers(@Context UriInfo uriInfo) {
		List<DBObject> objList = null;
		BasicDBObject searchQuery = new BasicDBObject();
		DaoService service = new DaoService_impl();
		try {
			objList = service.retrieveUsers(searchQuery,
					MongoDBConnectionHelper.getCollection("user"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();

		return Response.created(builder.build()).status(200)
				.entity(new Gson().toJson(objList)).build();
	}

}
