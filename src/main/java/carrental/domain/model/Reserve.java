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

/**
 * 予約内容のエンティティ
 * @author 奥井
 */
@Data
@Entity
@Table(name = "reserve")
public class Reserve {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reserveid; 
	private LocalDate startdate;
	private LocalDate enddate;
	private Integer carid;
	@ManyToOne
	@JoinColumn(name="carid", insertable=false, updatable=false)
	private Car car;
	private String fullnameid;
	private LocalDateTime reservetime;
	private Integer amount;
	
	
	public Reserve() {
	}
	
	public Reserve(LocalDate startdate, LocalDate enddate, Integer carid, String fullnameid, 
			LocalDateTime reservetime, Integer amount) {
		this.startdate = startdate;
		this.enddate = enddate;
		this.carid = carid;
		this.fullnameid = fullnameid;
		this.reservetime = reservetime; 
		this.amount = amount;
	}
}
	

