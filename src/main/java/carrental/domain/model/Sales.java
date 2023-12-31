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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sales {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salesid;
	private LocalDate startdate;
	private LocalDate enddate;
	private Integer carid;	
	@ManyToOne
	@JoinColumn(name="carid", insertable=false, updatable=false)
	private Car car;
	private String fullnameid;
	@ManyToOne
	@JoinColumn(name="fullnameid", insertable=false, updatable=false)
	private User user;
	private LocalDateTime reservetime;
	private LocalDate salesdate;
	private Integer amount;
	private boolean enableflag;
	
	public Sales(LocalDate startdate, LocalDate enddate, Integer carid, String fullnameid,
			LocalDateTime reservetime, LocalDate salesdate, Integer amount, boolean enableflag) {
			this.startdate = startdate;
			this.enddate = enddate;
			this.carid = carid;
			this.fullnameid = fullnameid;
			this.reservetime = reservetime;
			this.salesdate = salesdate;
			this.amount = amount;
			this.enableflag = enableflag;
	}
	
}
	
