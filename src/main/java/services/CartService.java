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

public class CartService {
	public List<Cart> getAllCarts() throws JsonParseException, JsonMappingException, IOException{
		Response response=RestAssured.given().get("https://dummyjson.com/carts");
		ObjectMapper mapper=new ObjectMapper();
		CartResponse cartResponse= mapper.readValue(response.getBody().asString(), CartResponse.class);
		return cartResponse.getCarts();
	}
	
	public Cart getCart(int cartId) throws JsonParseException, JsonMappingException, IOException {
		Response response=RestAssured.given().get("https://dummyjson.com/carts/"+cartId);
		ObjectMapper mapper=new ObjectMapper();
		Cart cartResponse= mapper.readValue(response.getBody().asString(), Cart.class);
		return cartResponse;
	}
	
	public List<Cart> getUserCarts(int userId) throws JsonParseException, JsonMappingException, IOException{
		Response response=RestAssured.given().get("https://dummyjson.com/carts/user/"+userId);
		ObjectMapper mapper=new ObjectMapper();
		CartResponse cartResponse= mapper.readValue(response.getBody().asString(), CartResponse.class);
		return cartResponse.getCarts();
	}
	
	
	
	

}
