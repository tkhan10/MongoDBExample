package com.tofek.java.mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.tofek.java.mongo.model.User;

public class MongoDBExample {

	public static void main(String[] args) throws UnknownHostException {
		
		User user = createUser();
		DBObject doc = createDBObject(user);
		
		MongoClient client = new MongoClient("localhost", 27017);
		DB userDB = client.getDB("UserDB");
		
		DBCollection collection = userDB.getCollection("users");
		
		// Create user 
		/*
		WriteResult result = collection.insert(doc);
		
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.getLastConcern());
		System.out.println(result.isUpdateOfExisting()); 
		*/
		
		//read example
		DBObject query = BasicDBObjectBuilder.start().add("id", user.getId()).get();
		DBCursor cursor = collection.find(query);
		while(cursor.hasNext()) {
			
			System.out.println(cursor.next());
		}
		
		/*
		// Update example
		user.setId(2);
		user.setName("Mark Waugh");
		doc = createDBObject(user);
		collection.update(query, doc);
		*/
		
		// delete example
		collection.remove(query);
		
		
		client.close();
		
				
		
		
		
		

	}
	
	private static DBObject createDBObject(User user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("id", user.getId());
		docBuilder.append("name", user.getName());
		docBuilder.append("role", user.getRole());
		docBuilder.append("isEmployee", user.isEmployee());
		return docBuilder.get();
	}

	private static User createUser() {
		User u = new User();
		u.setId(1);
		u.setName("Adam Donald");
		u.setEmployee(true);
		u.setRole("Football Coach");
		return u;
	}

}
