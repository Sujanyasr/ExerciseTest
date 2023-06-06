package pojos;

import lombok.Setter;

import java.util.List;

import lombok.Getter;

@Getter
@Setter
public class Product {
	private int id;
	private String title;
	private int price;
	private int total;
	private int quantity;
	private double discountPercentage;
	private int discountedPrice;
	private String description;
	private double rating;
	private int stock;
	private String brand;
	private String category;
	private String thumbnail;
	private List<String> images;
}
