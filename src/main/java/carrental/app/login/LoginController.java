package carrental.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログインフォーム作成
 * 
 * @author 田中
 *
 */

@Controller
public class LoginController {
	@GetMapping("login")
	public String showLoginForm() {
		return "loginForm";
	}

	@GetMapping("loginError")
	public String showLoginErrorForm() {
		return "loginError";
	}
	
	@PostMapping("loginForm")
	public String successLogin(String name,String pass) {
		return "login";//未完成　修正必要
	}
	
}
