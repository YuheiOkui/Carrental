package carrental.app.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carrental.domain.service.car.CarService;

@Controller
public class CarsController {

	@Autowired
	CarService carService ;
	
		@GetMapping("Car")
		String car(Model model) {
			
			model.addAttribute("Car", carService.findCars());
			return "Car/car";
		}
	}