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
	@Size(min=2005,max=3000)
	private Date year;
	@Size(min=1,max=12)
	private Date month;
	@Size(min=1,max=31)
	private Date day;
	@Size(min=1,max=1)
	private String sex;
		
}
