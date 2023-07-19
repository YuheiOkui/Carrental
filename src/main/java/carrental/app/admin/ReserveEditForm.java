package carrental.app.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveEditForm {
	
	
		private Integer reserveid;
		private LocalDateTime reservetime;
		private String fullnameid;
		private String username;
		private LocalDate startdate;
		private LocalDate enddate;
		private Integer carid;
		@Size(min=1, max=52)
		private String carname;
		private boolean enableflag;
	}
	