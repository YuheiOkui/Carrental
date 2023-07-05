package carrental.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carrental.domain.model.User;
import carrental.domain.service.user.CarUserService;

@Controller
public class AdminUserListController {

	@Autowired
	CarUserService carUserService;
	
	@GetMapping("admin/userlist")
	String userlist(Model model) {
		List<User> userlist =carUserService.getUserAll();
		model.addAttribute("userlist", userlist);
		return "admin/userlist";
	}
}
