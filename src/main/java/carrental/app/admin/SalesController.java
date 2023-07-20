package carrental.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carrental.CustomThymeleafFunctions;
import carrental.app.sales.SalesService;
import carrental.domain.model.Sales;

@Controller
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	@Autowired
	CustomThymeleafFunctions customThymeleafFunctions;
	
//	@GetMapping("admin/reserve")
//	String reserve(Model model) {
//	List<Reserve> reserves =reserveService.findAllReserve();
//	model.addAttribute("reserves", reserves);
//	return "admin/reserve";	
//	}
	@GetMapping("admin/saleslist")
	public String saleslist(Model model) {
		List<Sales> saleslist =  salesService.findAllSales();
		model.addAttribute("saleslist", saleslist);
		model.addAttribute("custom", customThymeleafFunctions);
		model.addAttribute("total", salesService.findTotalAmount());
		return "admin/saleslist";
	}
	
	
	
}