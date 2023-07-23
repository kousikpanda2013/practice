package com.example.util;

import java.io.File;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import com.example.mongo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.client.MongoClients;

public class RetriveDataFromMongoDB {
	
	public static void main(String[] args) {
		
		MongoTemplate mongoTemplate=new MongoTemplate(MongoClients.create("mongodb://localhost:27017"),"dbName");
		
		List<User> users=mongoTemplate.findAll(User.class);
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		try {
			
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			String jsonStr=objectMapper.writeValueAsString(users);
			
			File opFile=new File("user.json");
			
			objectMapper.writeValue(opFile, jsonStr);
			
			System.out.println("Data saved successfully");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
