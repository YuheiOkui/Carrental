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
 * admincontroller セールスは未作成の為コメントアウトしています。
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
		carEditForm.setCarprice(car.getCarprice());
		carEditForm.setEnableflag(car.isEnableflag());
		model.addAttribute("car", carEditForm);
		return "admin/caredit";
	}
										// admin に careditconfをつくる
	@PostMapping("admin/CarEditconf")   // 編集画面で書き換えたデータをもとに入力チェック
	String careditconf(@ModelAttribute("carEditForm") @Validated CarEditForm carEditForm, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "admin/caredit";
		}
		Car car = carService.findItem(carEditForm.getCarid());   // caridを呼んできて比較、
		if (!car.getCarname().equals(carEditForm.getCarname())) {
			car.setCarname(carEditForm.getCarname());
		}                                                                 //データが同じでなければ上書き
		if (car.getCarprice() != carEditForm.getCarprice()) {
			car.setCarprice(carEditForm.getCarprice());
		}
		if (car.isEnableflag() != carEditForm.isEnableflag()) {
			car.setEnableflag(carEditForm.isEnableflag());
		}
		carService.carregist(car);
		return "admin/careditconf";
	}
	
//	セールス
//	@GetMapping("admin/saleslist/sarch")
//	String serch(@ModelAttribute("serchForm") @Validated SearchForm serchForm, BindingResult br, Model model) {
//		if(br.hasErrors()) {
//			return "admin/saleslist";
//		}
//		salesForm.setSalesList(salesService.findSalesAll());
//		return "admin/salesList";
	
}


