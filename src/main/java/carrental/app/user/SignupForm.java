package carrental.app.user;

import java.util.Date;

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
	private Date birth;	
	@Size(min=1,max=1)
	private String sex;
	
	
}
