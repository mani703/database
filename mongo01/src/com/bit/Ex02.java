package com.bit;

import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class Ex02 {

	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 27017;
		String dbName = "testDB";
		String colName = "sales";
		
		MongoClient client = new MongoClient(new ServerAddress(ip, port));
		DB db = client.getDB(dbName);
		DBCollection collection = db.getCollection(colName);
		
		BasicDBObject obj = new BasicDBObject();
		obj.append("item", "item" + System.currentTimeMillis());
		obj.append("date", new Date());
		collection.insert(obj);
		
		DBCursor cursor = collection.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

}
