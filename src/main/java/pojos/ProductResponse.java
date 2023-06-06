package pojos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {
	private List<Product> products;
	private int total;
	private int skip;
	private int limit;
}
