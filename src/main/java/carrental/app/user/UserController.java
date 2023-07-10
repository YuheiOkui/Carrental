package carrental.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import carrental.domain.model.RoleName;
import carrental.domain.model.User;
import carrental.domain.service.user.CarUserService;


/**
 * コントローラー
 * ユーザー登録
 * 
 * @author Tanaka
 */


@Controller
public class UserController {
	
	@Autowired
	CarUserService carUserService;
	
	/**
	 * ユーザ登録画面表示
	 * 
	 * @param gignupForm
	 * @return user/userregist View
	 */
	
	@GetMapping("signup")
	public String signup(SignupForm signupForm) {
		return "user/userregist";
	}
	
	/**
	 * ユーザー情報登録
	 * 
	 * @param signupForm
	 * @param br
	 * @param model
	 * @return login画面表示へリダイレクト
	 */
	
	@PostMapping("signup")
	public String userregist(@ModelAttribute("signupForm") @Validated SignupForm signupForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "user/userregist";
		}
		User user = new User(signupForm.getFullnameId(),
				signupForm.getUsername(),
				signupForm.getBirth(),
				signupForm.getSex(),
				signupForm.getPassword(),
				RoleName.USER);
		
		carUserService.userregist(user);
		return "redirect:/loginForm";
	}
}
