package carrental.app.sales;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrental.domain.model.Car;
import carrental.domain.model.Sales;
import carrental.domain.repository.car.Carrepository;
import carrental.domain.repository.sales.SalesRepository;

@Service
public class SalesService {
    private final SalesRepository salesRepository;
    private final Carrepository carRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository, Carrepository carRepository) {
        this.salesRepository = salesRepository;
        this.carRepository = carRepository;
    }

    public void createSale(LocalDateTime reservetime,Integer userId, String fullName,
    		Integer carId, LocalDate startDate, LocalDate endDate,  Integer amount, Integer totalamount) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        LocalDateTime saleTime = LocalDateTime.now();

        Sales sales = new Sales(car, startDate, endDate, fullName, saleTime, amount);
        salesRepository.save(sales);
    }
}