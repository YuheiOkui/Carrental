package carrental.domain.repository.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.Car;
/**
 * 車両レポジトリー
 * @author 奥井
 */
public interface Carrepository extends JpaRepository<Car, Integer> {
	List<Car> findAllByOrderByCarid(); 
}
 