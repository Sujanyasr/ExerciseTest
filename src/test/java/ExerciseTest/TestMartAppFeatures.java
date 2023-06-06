package ExerciseTest;

import services.CartService;
import services.ProductService;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.util.*;

import pojos.Cart;
import pojos.Product;

public class TestMartAppFeatures {
	
	public void getProductTitlesByWorseRating(double rating) throws JsonParseException, JsonMappingException, IOException {
		ProductService productService=new ProductService();
		List<Product> products=productService.getAllProducts();
		for(Product product:products) {
			if(product.getRating()<=rating) {
				System.out.println(product.getTitle());
			}
		}
	}
	
	public Cart getCartWithHighestTotal() throws JsonParseException, JsonMappingException, IOException {
		CartService cartService=new CartService();
		List<Cart> allCarts=cartService.getAllCarts();
		Cart highestCart = new Cart();
		int highestCartTotal=0;
		for(Cart cart:allCarts) {
			if(cart.getTotal()>highestCartTotal) {
				highestCartTotal=cart.getTotal();
				highestCart=cart;
			}
		}
		return highestCart;
	}
	public Cart getCartWithLowestTotal() throws JsonParseException, JsonMappingException, IOException {
		CartService cartService=new CartService();
		List<Cart> allCarts=cartService.getAllCarts();
		Cart lowestCart = new Cart();
		int lowestCartTotal=Integer.MAX_VALUE;
		for(Cart cart:allCarts) {
			if(cart.getTotal()<lowestCartTotal) {
				lowestCartTotal=cart.getTotal();
				lowestCart=cart;
			}
		}
		return lowestCart;
	}
	
	public List<Product> addProductImagesToUserCart(Integer userId) throws JsonParseException, JsonMappingException, IOException{
		CartService cartService=new CartService();
		Cart userCart=cartService.getCart(userId);
		return userCart.getProducts();
		
	}
}
