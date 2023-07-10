package carrental.app.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー新規登録フォーム
 * 
 * @param birth 生年月日 
 * 
 * @author Tanaka
 *
 */

@Data
public class SignupForm {
	@Size(min=8,max=20)
	private String fullnameId;
	@Size(min=1,max=20)
	private String username;
	@Size(min=8,max=20)
	private String password;
	@Size(min=1,max=5)
	private String sex;
	private LocalDate birth;	
	
	
}
