                                                                                                                                                                                                                       package carrental.app.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		model.addAttribute("ReserveEditForm", ReserveEditForm);
		return "admin/reserveedit";
	}

}