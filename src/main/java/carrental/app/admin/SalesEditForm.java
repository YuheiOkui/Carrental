package carrental.app.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesEditForm {
	@NotNull
	private Integer salesid;
	@NotNull
	@PastOrPresent
	private LocalDate startdate;
	@NotNull
	@PastOrPresent
	private LocalDate enddate;
	@NotNull
	private Integer carid;	
	@Size(min=2,max=20)
	private String fullnameid;
	private LocalDateTime reservetime;
	@NotNull
	@PastOrPresent
	private LocalDate salesdate;
	@NotNull
	private Integer amount;
	private boolean enableflag;
	}
	
