package carrental.domain.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.Car;

public interface Carrepository extends JpaRepository<Car, Integer> {
 
}
 