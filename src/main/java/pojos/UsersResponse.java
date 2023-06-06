package pojos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersResponse {
	private List<User> users;
	private Integer total;
	private Integer skip;
	private Integer limit;

}
