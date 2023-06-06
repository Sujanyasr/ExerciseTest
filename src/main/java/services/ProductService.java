package services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.CartResponse;
import pojos.CategoryResponse;
import pojos.Product;
import pojos.ProductResponse;

public class ProductService {
	public List<Product> getAllProducts() throws JsonParseException, JsonMappingException, IOException{
		Response response=RestAssured.given().get("https://dummyjson.com/products");
		ObjectMapper mapper=new ObjectMapper();
		ProductResponse productResponse= mapper.readValue(response.getBody().asString(), ProductResponse.class);
		return productResponse.getProducts();
	}
	
	public List<Product> getAllProducts(int limit, int skip, String... fields) throws JsonParseException, JsonMappingException, IOException{
		String fieldValues="";
		for(String field:fields) {
			fieldValues=fieldValues+","+field;
		}
		if(!fieldValues.equals("")) {
			fieldValues=fieldValues.substring(1);
		}
		Response response=RestAssured.given().get("https://dummyjson.com/products?limit="+limit+"&skip="+skip+"&select="+fieldValues);
		ObjectMapper mapper=new ObjectMapper();
		ProductResponse productResponse= mapper.readValue(response.getBody().asString(), ProductResponse.class);
		return productResponse.getProducts();
	}
	
	public Product getProduct(Integer productId) throws JsonParseException, JsonMappingException, IOException {
		Response response=RestAssured.given().get("https://dummyjson.com/products/"+productId);
		ObjectMapper mapper=new ObjectMapper();
		Product productResponse= mapper.readValue(response.getBody().asString(), Product.class);
		return productResponse;
	}
	
	public List<Product> searchProducts(String query) throws JsonParseException, JsonMappingException, IOException {
		Response response=RestAssured.given().get("https://dummyjson.com/products/search?q="+query);
		ObjectMapper mapper=new ObjectMapper();
		ProductResponse productResponse= mapper.readValue(response.getBody().asString(), ProductResponse.class);
		return productResponse.getProducts();
	}
	
	public List<Product> getProductsByCategory(String categoryName) throws JsonParseException, JsonMappingException, IOException {
		Response response=RestAssured.given().get("https://dummyjson.com/products/category/"+categoryName);
		ObjectMapper mapper=new ObjectMapper();
		ProductResponse productResponse= mapper.readValue(response.getBody().asString(), ProductResponse.class);
		return productResponse.getProducts();
	}
	
	public List<String> getCategories() throws JsonParseException, JsonMappingException, IOException {
		Response response=RestAssured.given().get("https://dummyjson.com/products/categories");
		ObjectMapper mapper=new ObjectMapper();
		CategoryResponse categoryResponse= mapper.readValue(response.getBody().asString(), CategoryResponse.class);
		return categoryResponse.getCategories();
	}
	


}
