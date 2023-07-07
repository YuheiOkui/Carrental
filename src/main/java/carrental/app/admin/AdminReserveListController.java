package carrental.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carrental.domain.model.Reserve;
import carrental.domain.service.reserve.ReserveService;

@Controller
public class AdminReserveListController {

	@Autowired
	ReserveService reserveService;
	
 @GetMapping("admin/reservelist")
String reservelist(Model model) {
List<Reserve> reservelist =reserveService.findAllReserve();
model.addAttribute("reservelist", reservelist);
return "admin/reservelist";
}
}