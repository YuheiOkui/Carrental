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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import carrental.domain.model.Car;
import carrental.domain.service.car.CarService;
/**
 * admincontroller 
 * @author 飯田
 */
@Controller
public class AdminController {

	
	@Autowired
	CarService carService;
	
	@RequestMapping("admin")
	String admin() {
		return "admin/adminmenu";
	}
	@GetMapping("admin/carlist")
	String carslist(Model model) {
		List<Car> carlist = carService.findCars();
		model.addAttribute("carList", carlist);
		return "admin/carlist";
	}
	@GetMapping("admin/caredit")
	String caredit(@RequestParam("carid") Integer carid, CarEditForm carEditForm, Model model) {
		Car car = carService.findItem(carid);
		carEditForm.setCarid(car.getCarid());
		carEditForm.setCartype(car.getCartype());
		carEditForm.setCarname(car.getCarname());
		carEditForm.setMaker(car.getMaker());
		carEditForm.setColor(car.getColor());
		carEditForm.setPassengers(car.getPassengers());
		carEditForm.setCarprice(car.getCarprice());
		carEditForm.setEnableflag(car.isEnableflag());
		model.addAttribute("carEditForm", carEditForm);
		return "admin/carlistedit";
	}
										// admin に careditconfを作成
	@PostMapping("admin/carlisteditconf")   // 編集画面で書き換えたデータをもとに入力チェック
	String careditconf(@ModelAttribute("carEditForm") @Validated CarEditForm carEditForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "admin/carlistedit";
		}
		Car car = carService.findItem(carEditForm.getCarid());   // caridを呼んできて比較、データが同じでなければ上書き
		if (car.getCartype() != carEditForm.getCartype()) {
			car.setCartype(carEditForm.getCartype());
		}
		if (!car.getCarname().equals(carEditForm.getCarname())) {
			car.setCarname(carEditForm.getCarname());
		} 
		if (car.getMaker() != carEditForm.getMaker()) {
			car.setMaker(carEditForm.getMaker());
		}
		if (car.getColor() != carEditForm.getColor()) {
			car.setColor(carEditForm.getColor());
		}
		if (car.getPassengers() != carEditForm.getPassengers()) {
			car.setPassengers(carEditForm.getPassengers());
		}
		if (car.getCarprice() != carEditForm.getCarprice()) {
			car.setCarprice(carEditForm.getCarprice());
		}
		if (car.isEnableflag() != carEditForm.isEnableflag()) {
			car.setEnableflag(carEditForm.isEnableflag());
		}
		carService.carregist(car);
		return "admin/carlisteditconf";
	}	
}


