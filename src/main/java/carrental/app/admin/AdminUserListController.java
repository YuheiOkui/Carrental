package carrental.app.admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import carrental.domain.model.RoleName;
import carrental.domain.model.User;
import carrental.domain.service.user.CarUserService;

/**
 * 管理者画面：ユーザー一覧コントローラ
 * @author 黒川
 *
 */

@Controller
public class AdminUserListController {

	@Autowired
	CarUserService carUserService;
	
	@Autowired
	PasswordEncoder passwordencorder;
	
	@GetMapping("admin/userlist")
	String userlist(Model model) {
		List<User> userlist =carUserService.getUserAll();
		model.addAttribute("userlist", userlist);
		return "admin/userlist";
	}
	@GetMapping("admin/edit")
	String userEdit(@RequestParam("fullnameId") String fullnameId, UserEditForm userEditForm,BindingResult br,
			Model model) {
		User user= carUserService.findById(fullnameId);
		userEditForm.setFullnameId(user.getFullnameId());
		userEditForm.setUsername(user.getUsername());
		userEditForm.setBirth(user.getBirth());
		userEditForm.setSex(user.getSex());
		userEditForm.setRolename(user.getRoleName());
		userEditForm.setRoleNameList(new ArrayList<RoleName>(Arrays.asList(RoleName.ADMIN,RoleName.USER)));
		userEditForm.setPassword(user.getPassword());
		model.addAttribute("userEditForm",userEditForm);
		
		//ラジオボタンで性別を判定する為にMapに格納する
		Map<String,String> male = new LinkedHashMap<>();
		Map<String,String> female = new LinkedHashMap<>();
		Map<String,String> LGBTQ = new LinkedHashMap<>();
		
		male.put("male","male");
		female.put("female", "female");
		LGBTQ.put("LGBTQ", "LGBTQ");
		
		model.addAttribute("male",male);
		model.addAttribute("female", female);
		model.addAttribute("LGBTQ", LGBTQ);
		
		
		return "admin/useredit";
	}
	
	
	@PostMapping("admin/editconf")
	String userEditConf(@ModelAttribute("userEditForm")@Validated UserEditForm userEditForm,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth,  
			BindingResult br,Model model) {
		if(br.hasErrors()) { 
			userEditForm.setRoleNameList(new ArrayList<RoleName>(Arrays.asList(RoleName.ADMIN,RoleName.USER)));
			return "admin/useredit";
		}
		User user = carUserService.findById(userEditForm.getFullnameId());
		if(!user.getFullnameId().equals(userEditForm.getFullnameId())) {
		user.setFullnameId(userEditForm.getFullnameId());
		}
		
		
		if(!user.getUsername().equals(userEditForm.getUsername())) {
			user.setUsername(userEditForm.getUsername());
		}
		if(!user.getBirth().equals(userEditForm.getBirth())){
			user.setBirth(userEditForm.getBirth());
		}
		if(!user.getSex().equals(userEditForm.getSex())) {
			user.setSex(userEditForm.getSex());
		}	
		if(!user.getRoleName().getValue().equals(userEditForm.getRolename().getValue())){
			user.setRoleName(userEditForm.getRolename());
		}
		
		if(!user.getPassword().equals(userEditForm.getPassword())) {
			user.setPassword(userEditForm.getPassword());
		}
		
		carUserService.userupdateregist(user);
		model.addAttribute("userEditForm",userEditForm);
		return "admin/editconf";
		
	}
}

