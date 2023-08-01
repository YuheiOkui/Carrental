package carrental.app.admin;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import carrental.CustomThymeleafFunctions;
import carrental.app.sales.SalesService;
import carrental.domain.model.Reserve;
import carrental.domain.model.Sales;
import carrental.domain.service.reserve.ReserveService;

@Controller
public class SalesController {
	
	@Autowired
	SalesService salesService;
	
	@Autowired
	ReserveService reserveService;
	
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
	

	@GetMapping("admin/salesupdate")
	public String salesupdate(Model model) {
		LocalDate now = LocalDate.now();
		List<Reserve> reservelist = reserveService.findAllReserve();
		for (Reserve reserve : reservelist) {
			if (now.isEqual(reserve.getEnddate()) || now.isAfter(reserve.getEnddate())) {
				Sales sales = new Sales(reserve.getStartdate(),reserve.getEnddate(),
								reserve.getCarid(), reserve.getFullnameid(), reserve.getReservetime(),
								reserve.getStartdate(), reserve.getAmount(), reserve.isEnableflag());
				salesService.save(sales);
				reserveService.deleteReserve(reserve.getReserveid());
			}
		}
//		List<Sales> saleslist =  salesService.findAllSales();
//		model.addAttribute("saleslist", saleslist);
//		model.addAttribute("custom", customThymeleafFunctions);
//		model.addAttribute("total", salesService.findTotalAmount());
		return "redirect:/admin/saleslist";
	}


	@GetMapping("admin/salesedit")
	public String salesedit(@RequestParam("salesid") Integer salesid, Model model) {
		Sales sales = salesService.findReserve(salesid).get();
		model.addAttribute("sales", sales);
		model.addAttribute("custom", customThymeleafFunctions);
		return "admin/salesedit";
	}
	
	@PostMapping("admin/saleseditconf")
	public String saleseditconf(@Validated SalesEditForm salesEditForm, BindingResult br, Model model){
			if (br.hasErrors()) {
				Sales sales = salesService.findReserve(salesEditForm.getSalesid()).get();
				model.addAttribute("sales", sales);
				model.addAttribute("custom", customThymeleafFunctions);
				return "admin/salesedit";
			}
			Sales sales = salesService.findReserve(salesEditForm.getSalesid()).get();   
			if (sales.getReservetime() != salesEditForm.getReservetime()) {
				sales.setReservetime(salesEditForm.getReservetime());
			}
			if (!sales.getFullnameid().equals(salesEditForm.getFullnameid())) {
				sales.setFullnameid(salesEditForm.getFullnameid());
			} 
			if (sales.getCarid() != salesEditForm.getCarid()) {
				sales.setCarid(salesEditForm.getCarid());
			}
			if (sales.getStartdate() != salesEditForm.getStartdate()) {
				sales.setStartdate(salesEditForm.getStartdate());
			}
			if (sales.getEnddate() != salesEditForm.getEnddate()) {
				sales.setEnddate(salesEditForm.getEnddate());
			}
			if (sales.getSalesdate() != salesEditForm.getSalesdate()) {
				sales.setSalesdate(salesEditForm.getSalesdate());
			}
			if (sales.getAmount() != salesEditForm.getAmount()) {
				sales.setAmount(salesEditForm.getAmount());
			}
			if (sales.isEnableflag() != salesEditForm.isEnableflag()) {
				sales.setEnableflag(salesEditForm.isEnableflag());
			}
			salesService.save(sales);
			model.addAttribute("sales", sales);
//			model.addAttribute("username", reserve.getUser().getUsername());
//			model.addAttribute("car", reserve.getCar());
			model.addAttribute("custom", customThymeleafFunctions);
			return "admin/saleseditconf";
		}

	
}