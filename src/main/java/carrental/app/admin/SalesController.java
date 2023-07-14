package carrental.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carrental.domain.model.Reserve;
import carrental.domain.service.reserve.ReserveService;

@Controller
public class SalesController {
	
	@Autowired
	ReserveService reserveService;
	
	@GetMapping("admin/reserve")
	String reserve(Model model) {
	List<Reserve> reserves =reserveService.findAllReserve();
	model.addAttribute("reserves", reserves);
	return "admin/reserve";	
	}
	@GetMapping("/sales")
	public String showSalesPage() {
		return "redirect:/sales";
	}
	
}