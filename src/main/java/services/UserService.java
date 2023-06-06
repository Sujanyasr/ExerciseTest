package services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Cart;
import pojos.CartResponse;
import pojos.User;
import pojos.UsersResponse;

public class UserService {
	public List<User> getAllUsers() throws JsonParseException, JsonMappingException, IOException{
		Response response=RestAssured.given().get("https://dummyjson.com/users");
		ObjectMapper mapper=new ObjectMapper();
		UsersResponse userResponse= mapper.readValue(response.getBody().asString(), UsersResponse.class);
		return userResponse.getUsers();
	}
	
	public User getUser(int userId) throws JsonParseException, JsonMappingException, IOException{
		Response response=RestAssured.given().get("https://dummyjson.com/users/"+userId);
		ObjectMapper mapper=new ObjectMapper();
		User userResponse= mapper.readValue(response.getBody().asString(), User.class);
		return userResponse;
	}
	
	public List<User> searchUsers(String query) throws JsonParseException, JsonMappingException, IOException{
		Response response=RestAssured.given().get("https://dummyjson.com/users/search?q="+query);
		ObjectMapper mapper=new ObjectMapper();
		UsersResponse userResponse= mapper.readValue(response.getBody().asString(), UsersResponse.class);
		return userResponse.getUsers();
	}

}
