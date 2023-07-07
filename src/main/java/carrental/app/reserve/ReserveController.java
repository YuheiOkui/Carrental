package carrental.app.reserve;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import carrental.domain.model.Reserve;
import carrental.domain.service.car.CarService;
import carrental.domain.service.reserve.ReserveService;
import carrental.domain.service.user.CarUserDetail;

/**
 * 予約機能コントローラー
 * @author 奥井
 */ 

@Controller
public class ReserveController {
	@Autowired
	CarService carService;
	
	@Autowired
	ReserveService reserveService;
	
	@GetMapping("reserve")
	String reserve(Model model) {
		model.addAttribute("carList",carService.findCars());
		return "reserve/reserve";
	}
	 
	//その日付で車空いてるかの判定を行いたい
	@PostMapping("reservein")
	String reservein(@Validated ReserveForm reserveForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "reserve/reserve";//エラーメッセージ必要？
		}
		List<Reserve> allreserve = reserveService.findReserveCar(reserveForm.getCarid());
		for (Reserve list : allreserve) {
			if (reserveForm.getStartdate().isEqual(list.getStartdate()) ||
			   (reserveForm.getStartdate().isAfter(list.getStartdate()) && reserveForm.getStartdate().isBefore(list.getEnddate())) ||
				reserveForm.getStartdate().isEqual(list.getEnddate()) ||
				reserveForm.getEnddate().isEqual(list.getStartdate()) ||
				(reserveForm.getEnddate().isAfter(list.getStartdate()) && reserveForm.getEnddate().isBefore(list.getEnddate())) ||
				reserveForm.getEnddate().isEqual(list.getEnddate())){
				return "reserve/reservefail";
			}
		} 
		reserveForm.setReservetime(LocalDateTime.now());
		reserveForm.setFullnameid(((CarUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getFullnameId());
		Reserve reserve = new Reserve(reserveForm.getStartdate(), reserveForm.getEnddate(),
									  reserveForm.getCarid(), reserveForm.getFullnameid(),
									  reserveForm.getReservetime());
		reserveService.save(reserve);
		model.addAttribute("reserve", reserve);
		return "reserve/reserveconf";
	}
	
}
