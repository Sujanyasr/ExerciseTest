package pojos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cart {
	private int id;
	private List<Product> products;
	private int total;
	private int discountedTotal;
	private int userId;
	private int totalProducts;
	private int totalQuantity;
}

