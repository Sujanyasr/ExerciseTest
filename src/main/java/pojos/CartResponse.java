package pojos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartResponse {
	private List<Cart> carts;
	private int total;
	private int skip;
	private int limit;
}
