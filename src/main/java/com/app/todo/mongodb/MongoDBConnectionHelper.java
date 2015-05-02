package com.app.todo.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDBConnectionHelper {
	private static String DB_URL = "localhost";
	private static String DB_NAME = "sensitouch";
	private final static int MONGO_DB_PORT_NO = 27017;
	private static DBCollection conn;

	private static DB getConnection() throws UnknownHostException {
		MongoClient mongodb = new MongoClient(DB_URL, MONGO_DB_PORT_NO);
		return mongodb.getDB(DB_NAME);

	}

	public static DBCollection getCollection(String collectionName)
			throws UnknownHostException {
		if (conn != null)
			return conn;
		return conn = getConnection().getCollection(collectionName);

	}

}
