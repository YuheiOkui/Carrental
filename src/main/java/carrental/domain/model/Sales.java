package carrental.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sales")
public class Sales {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salesId;
	
	@ManyToOne
	@JoinColumn(name = "carid")
	private Car car;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private String fullName;
	private LocalDateTime saleTime;
	private Integer amount;
	
	public Sales() {
	}
	
	public Sales(Car car, LocalDate startDate, LocalDate endDate, String fullName, LocalDateTime saleTime, Integer amount) {
		this.car = car;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fullName = fullName;
		this.saleTime = saleTime;
		this.amount = amount;
	 }
	}
	
