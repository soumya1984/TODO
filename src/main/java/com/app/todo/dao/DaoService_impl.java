package com.app.todo.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class DaoService_impl implements DaoService {

	public void createRecord(BasicDBObject dbObj, DBCollection collectionName) {
		// perform a insert operation..
		collectionName.insert(dbObj);

	}

	public BasicDBObject updateRecoed(BasicDBObject dbObj,
			DBCollection collectionName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * return all the obj associate with the document ..
	 */
	public List<DBObject> retrieveAllTodo(BasicDBObject dbObj,
			DBCollection collectionName) {
		List<DBObject> dbOBJ = new ArrayList<DBObject>();
		DBCursor cursor = collectionName.find();
		while (cursor.hasNext()) {
			dbOBJ.add(cursor.next());
		}
		return dbOBJ;
	}

	public BasicDBObject deleteRecoed(BasicDBObject dbObj,
			DBCollection collectionName) {
		// TODO Auto-generated method stub
		return null;
	}

	public BasicDBObject searchRecoed(BasicDBObject dbObj,
			DBCollection collectionName, String id) {
		// / collectionName.find();
		return null;
	}

	public void saveObject(DBCollection collectionName, DBObject db) {
		collectionName.insert(db);
	}

	public List<DBObject> retrieveSensor(BasicDBObject dbObj,
			DBCollection collectionName) {
		List<DBObject> dbOBJ = new ArrayList<DBObject>();
		DBCursor cursor = collectionName.find();
		while (cursor.hasNext()) {
			dbOBJ.add(cursor.next());
		}
		return dbOBJ;
	}
	
	public List<DBObject> retrieveUsers(BasicDBObject dbObj,
			DBCollection collectionName) {
		List<DBObject> dbOBJ = new ArrayList<DBObject>();
		DBCursor cursor = collectionName.find();
		while (cursor.hasNext()) {
			dbOBJ.add(cursor.next());
		}
		return dbOBJ;
	}

}
