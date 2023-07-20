package carrental.app.reserve;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import carrental.domain.service.car.CarService;
import carrental.domain.service.user.CarUserDetail;
import carrental.domain.service.user.CarUserService;



@Controller
public class ReserveContentsController {
	
	@Autowired
	CarUserService carUserService;
	
	@Autowired
	CarService carservice;
	
	@GetMapping("price")
	String price(Model model) {
		
		model.addAttribute("user", carUserService.findById(((CarUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getFullnameId()));
		model.addAttribute("carlist",carservice.findCars());
		return "reserve/price";
	}
	
	@GetMapping("lineup")
	String lineup(Model model) {
		model.addAttribute("user", carUserService.findById(((CarUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getFullnameId()));
		model.addAttribute("carlist",carservice.findCars());
		return "reserve/lineup";
	}
}
