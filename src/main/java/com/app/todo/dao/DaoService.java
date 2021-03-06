package com.app.todo.dao;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public interface DaoService {
	public void createRecord(BasicDBObject dbObj, DBCollection collectionName);

	public BasicDBObject updateRecoed(BasicDBObject dbObj,
			DBCollection collectionName);

	public List<DBObject> retrieveAllTodo(BasicDBObject dbObj,
			DBCollection collectionName);
	
	public List<DBObject> retrieveSensor(BasicDBObject dbObj,
			DBCollection collectionName);
	
	public List<DBObject> retrieveUsers(BasicDBObject dbObj,
			DBCollection collectionName);

	public BasicDBObject deleteRecoed(BasicDBObject dbObj,
			DBCollection collectionName);
	
	public BasicDBObject searchRecoed(BasicDBObject dbObj,
			DBCollection collectionName,String id);
	
	public List<DBObject> retrieveSensorData(BasicDBObject whereQuery,
			DBCollection collectionName);
	
	public void saveObject(DBCollection collectionName,DBObject db);

}
