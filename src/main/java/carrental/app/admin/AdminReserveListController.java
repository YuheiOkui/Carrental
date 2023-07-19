                                                                                                                                                                                                                       package carrental.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import carrental.domain.model.Reserve;
import carrental.domain.service.reserve.ReserveService;

@Controller
public class AdminReserveListController {

	@Autowired
	ReserveService reserveService;
	
@GetMapping("/admin/reservelist")
String reservelist(Model model) {
List<Reserve> reservelist =reserveService.findAllReserve();
model.addAttribute("reservelist", reservelist);
return "admin/reservelist";
}

 
@PostMapping("admin/reserveedit")
String reserveedit(@RequestParam("reserveid") Integer reserveid, ReserveEditForm ReserveEditForm, Model model){
	 Reserve reserve = reserveService.findReserve(reserveid).get();
	 	ReserveEditForm.setReserveid(reserve.getReserveid());
	 	ReserveEditForm.setReservetime(reserve.getReservetime());
	 	ReserveEditForm.setFullnameid(reserve.getFullnameid());
	 	ReserveEditForm.setUsername(reserve.getUser().getUsername());
	 	ReserveEditForm.setStartdate(reserve.getStartdate());
	 	ReserveEditForm.setEnddate(reserve.getEnddate());
	 	ReserveEditForm.setCarid(reserve.getCarid());
	 	ReserveEditForm.setCarname(reserve.getCar().getCarname());
	 	ReserveEditForm.setEnableflag(reserve.isEnableflag());
		model.addAttribute("ReserveEditForm", ReserveEditForm);
		return "admin/reserveedit";
	}
 @PostMapping("admin/reserveeditconf")   
	String reserveeditconf(@ModelAttribute("reserveEditForm") @Validated ReserveEditForm reserveEditForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "admin/reserveedit";
		}
		Reserve reserve = reserveService.findReserve(reserveEditForm.getReserveid()).get();   
		if (reserve.getReservetime() != reserveEditForm.getReservetime()) {
			reserve.setReservetime(reserveEditForm.getReservetime());
		}
		if (!reserve.getFullnameid().equals(reserveEditForm.getFullnameid())) {
			reserve.setFullnameid(reserveEditForm.getFullnameid());
		} 
		if (reserve.getUser().getUsername() != reserveEditForm.getUsername()) {
			reserve.getUser().setUsername(reserveEditForm.getUsername());
		}
		if (reserve.getStartdate() != reserveEditForm.getStartdate()) {
			reserve.setStartdate(reserveEditForm.getStartdate());
		}
		if (reserve.getEnddate() != reserveEditForm.getEnddate()) {
			reserve.setEnddate(reserveEditForm.getEnddate());
		}
		if (reserve.getCarid() != reserveEditForm.getCarid()) {
			reserve.setCarid(reserveEditForm.getCarid());
		}
		if (reserve.isEnableflag() != reserveEditForm.isEnableflag()) {
			reserve.setEnableflag(reserveEditForm.isEnableflag());
		}
		reserveService.save(reserve);
		model.addAttribute("reserve", reserve);
		model.addAttribute("username", reserve.getUser().getUsername());
		model.addAttribute("car", reserve.getCar());
		return "admin/reserveeditconf";
	}
 
}