package carrental.app.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carrental.domain.model.Sales;
import carrental.domain.repository.car.Carrepository;
import carrental.domain.repository.sales.SalesRepository;

@Service
public class SalesService {
	@Autowired
	SalesRepository salesRepository;
	 
	@Autowired
    Carrepository carRepository;

//    public void createSale(LocalDateTime reservetime,Integer userId, String fullName,
//    		Integer carId, LocalDate startDate, LocalDate endDate,  Integer amount, Integer totalamount) {
//        Car car = carRepository.findById(carId)
//                .orElseThrow(() -> new RuntimeException("Car not found"));
//
//        LocalDateTime saleTime = LocalDateTime.now();
//   
//        2023/07/14 追加訂正
//        Sales sales = new Sales();
//        sales.setReserveTime(reservetime);
//        sales.setUserId(userId);
//        sales.setFullName(fullName);
//        sales.setCar(car);
//        sales.setStartDate(startDate);
//        sales.setEndDate(endDate);
//        sales.setAmount(amount);
//        sales.setEnable(true);
//
//        salesRepository.save(sales);
//    }
	public void save(Sales sales) {
		salesRepository.save(sales);
	}
	
	public Optional<Sales> findReserve(Integer salesid) {
		return salesRepository.findById(salesid);
	}
	
	public List<Sales> findSalesCar(Integer carid) {
		return salesRepository.findByCaridOrderBySalesidAsc(carid);
	}
	
	public List<Sales> findReserveUser(String fullnameid) {
		return salesRepository.findByFullnameidOrderBySalesidAsc(fullnameid);
	}
	
    public List<Sales> findAllSales() {
        return salesRepository.findAll();
    }
    
    public Integer findTotalAmount() {
        return salesRepository.getTotalAmount();
    }
    
//    public int calculateTotalAmount() {
//        List<Sales> salesList = salesRepository.findAll();
//        int totalAmount = 0;
//        for (Sales sales : salesList) {
//            totalAmount += sales.getAmount();
//        }
//        return totalAmount;
//    }
//			2023/07/14 訂正　、（訂正前）確認とれるまでコメントアウト
//        Sales sales = new Sales(car, startDate, endDate, fullName, saleTime, amount);
//        salesRepository.save(sales);
//    }
        
}