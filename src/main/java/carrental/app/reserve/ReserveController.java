package carrental.app.reserve;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;

import carrental.domain.model.Reserve;
import carrental.domain.service.car.CarService;
import carrental.domain.service.reserve.ReserveService;
import carrental.domain.service.user.CarUserDetail;
import carrental.domain.service.user.CarUserService;

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
	
	@Autowired
	CarUserService carUserService;
	
	@GetMapping("reserve")
	String reserve(Model model) {
		model.addAttribute("carList",carService.findCars());
		model.addAttribute("today",LocalDate.now());
		model.addAttribute("user", carUserService.findById(((CarUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getFullnameId()));
		return "reserve/reserve";
	}
	 
	//その日付で車空いてるかの判定を行いたい
	@PostMapping("reservein")
	String reservein(@Validated ReserveSearchForm reserveSearchForm, BindingResult br, Model model) {
			if (br.hasErrors()) {
				model.addAttribute("carList",carService.findCars());
				return "reserve/reserve";//エラーメッセージ必要？
		}
		List<Reserve> allreserve = reserveService.findReserveCar(reserveSearchForm.getCarid());
		for (Reserve list : allreserve) {
			if (reserveSearchForm.getStartdate().isEqual(list.getStartdate()) ||
			   (reserveSearchForm.getStartdate().isAfter(list.getStartdate()) && reserveSearchForm.getStartdate().isBefore(list.getEnddate())) ||
			    reserveSearchForm.getStartdate().isEqual(list.getEnddate()) ||
			    reserveSearchForm.getEnddate().isEqual(list.getStartdate()) ||
				(reserveSearchForm.getEnddate().isAfter(list.getStartdate()) && reserveSearchForm.getEnddate().isBefore(list.getEnddate())) ||
				reserveSearchForm.getEnddate().isEqual(list.getEnddate()) || 
				(list.getStartdate().isAfter(reserveSearchForm.getStartdate()) && list.getStartdate().isBefore(reserveSearchForm.getEnddate())) ||
				(list.getEnddate().isAfter(reserveSearchForm.getStartdate()) && list.getEnddate().isBefore(reserveSearchForm.getEnddate()))) {
				return "reserve/reservefail";
			}
		} 
		ReserveForm reserveForm = new ReserveForm(reserveSearchForm.getStartdate(),
												  reserveSearchForm.getEnddate(),
												  reserveSearchForm.getCarid(),
												  ((CarUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getFullnameId(),
												  LocalDateTime.now(),
												  carService.findItem(reserveSearchForm.getCarid()).getCarprice() * (reserveSearchForm.getEnddate().compareTo(reserveSearchForm.getStartdate()) + 1));
		model.addAttribute("reserveForm", reserveForm);
		model.addAttribute("car", carService.findItem(reserveForm.getCarid()));
		return "reserve/reserveconf";
	}
	
	@PostMapping("reserved")
	String reserved(@Validated ReserveForm reserveForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("carList",carService.findCars());
			return "reserve/reserve";//エラーメッセージ必要？
		}
		Reserve reserve = new Reserve(reserveForm.getStartdate(), reserveForm.getEnddate(),
				  reserveForm.getCarid(), reserveForm.getFullnameid(),
				  reserveForm.getReservetime(),reserveForm.getAmount());
		reserveService.save(reserve);
		return "reserve/reservecpl";
	}
	
	@GetMapping("reservation")
	String reservation(Model model) {
		List<Reserve> reservation = reserveService.findReserveUser(((CarUserDetail)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getFullnameId());
		model.addAttribute("reservation", reservation);
		return "reserve/reservation";
	}
	
	@GetMapping("reservecancel")
	String reservecancel(@RequestParam("reserveid") Integer reserveid, Model model) {
		reserveService.deleteReserve(reserveid);
		return "reserve/reservecancelcpl";
	}
	
	@GetMapping("reserveextension")
	String reserveextension(@RequestParam("reserveid") Integer reserveid, Model model) {
		Reserve reserve = reserveService.findReserve(reserveid).get();
		model.addAttribute("car", carService.findItem(reserve.getCarid()));
		model.addAttribute("reserve", reserve);
		return "reserve/reserveextension";
	}
	
	@PostMapping("reserveextensionconf")
	String reserveextensionconf(@RequestParam("endafter") LocalDate endafter, Reserve reserve, Model model) {
		List<Reserve> allreserve = reserveService.findReserveCar(reserve.getCarid());
		for (Reserve list : allreserve) {
			if (endafter.isEqual(list.getStartdate()) ||
			   (endafter.isAfter(list.getStartdate()) && endafter.isBefore(list.getEnddate())) ||
				endafter.isEqual(list.getEnddate()) ||
			   (list.getStartdate().isAfter(reserve.getEnddate()) && list.getStartdate().isBefore(endafter)) ||
			   (list.getEnddate().isAfter(reserve.getEnddate()) && list.getEnddate().isBefore(endafter))) {
				model.addAttribute("car", carService.findItem(reserve.getCarid()));
				model.addAttribute("reserve", reserve);
				model.addAttribute("error", true);
				return "reserve/reserveextension";
			}
		} 
		reserve.setEnddate(endafter);
		reserve.setReservetime(LocalDateTime.now());
		reserve.setAmount(carService.findItem(reserve.getCarid()).getCarprice() * (reserve.getEnddate().compareTo(reserve.getStartdate()) + 1));
		reserveService.save(reserve);
		model.addAttribute("car", carService.findItem(reserve.getCarid()));
		model.addAttribute("reserve", reserve);
		return "reserve/reserveextensioncpl";
	}
	
}
