package carrental.app.user;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupForm {
	@Size(min=10,max=20)
	private String fullnameId;
	@Size(min=1,max=20)
	private String username;
	@Size(min=10,max=20)
	private String password;
	@Size(min=4,max=8)
	private String birth;
	private String sex;
	
}
