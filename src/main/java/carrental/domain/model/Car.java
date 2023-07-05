package carrental.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//車両のエンティティ
@Data
@Entity
@Table(name = "car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carid;
	private String maker;
	private String cartype; 
	private String carname;
	private String color;
	private Integer passengers;
	private Integer carprice;
	private boolean enableflag;
}
 