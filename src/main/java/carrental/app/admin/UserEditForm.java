package carrental.app.admin;
import java.time.LocalDate;

import java.util.List;

import carrental.domain.model.RoleName;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *管理者画面：ユーザー編集フォーム
 * 
 * @author kurokawa
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEditForm {
	
	
		@Size(min=2,max=20)
		private String fullnameId;
		@Size(min=1,max=20)
		private String username;
		@Size(min=1,max=6)
		private String sex;
		@Size(min=8,max=200)
		private String password;
		
		private LocalDate birth;
		private RoleName rolename;
		private List<RoleName> roleNameList;
	

}
