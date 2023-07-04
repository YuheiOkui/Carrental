package carrental.app.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carrental.domain.service.car.CarService;

/**
 * 予約機能コントローラー
 * @author 奥井
 */ 

@Controller
public class ReserveController {
	@Autowired
	CarService carService;
	
	@GetMapping("reserve")
	String reserve(Model model) {
		model.addAttribute("reserve",carService.findCars());
		return "reserve/reserve";
	}
	
	
}
