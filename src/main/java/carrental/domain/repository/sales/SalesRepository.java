package carrental.domain.repository.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import carrental.domain.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

}
