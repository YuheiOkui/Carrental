package carrental.app.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {
	
//新規登録
	@GetMapping("signup")
	public String showSignupForm() {
		return "signup";
	}
	
	//signupしてからDBに登録してからリザーブ画面を表示
	@PostMapping("signup")
	public String successSignin(String fullnameId,String password) {
		return "reserve/reserve";   //レンタカー一覧画面
	}
	

}
