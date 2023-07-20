package carrental.domain.repository.sales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
	List<Sales> findByCaridOrderBySalesidAsc(Integer carid);
	List<Sales> findByFullnameidOrderBySalesidAsc(String fullnameid);
}
