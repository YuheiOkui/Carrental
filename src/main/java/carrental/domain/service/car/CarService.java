package carrental.domain.service.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrental.domain.model.Car;
import carrental.domain.repository.car.Carrepository;
import jakarta.transaction.Transactional;

/**
 * 車サービス
 * @author 奥井
 */
@Service
@Transactional
public class CarService {
	@Autowired
	Carrepository carRepository;
	
	public List<Car> findCars() {
		return carRepository.findAllByOrderByCarid();
	}
	
	public Car findItem(Integer carid) {
		return carRepository.findById(carid).get();
	}
	
	public void carregist(Car car) {
		carRepository.save(car);
	}
	
}
