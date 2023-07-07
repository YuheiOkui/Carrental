package carrental.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログインフォーム画面
 * 新規登録画面
 * 
 * @author 田中
 *
 */
//ログイン
@Controller
public class LoginController {
	@GetMapping("loginForm")
	public String showLoginForm() {
		return "login/loginForm";
	}

}
