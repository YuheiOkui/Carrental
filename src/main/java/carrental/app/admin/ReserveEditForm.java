package carrental.app.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
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
		@Size(min=2,max=20)
		private String fullnameid;
		@Size(min=1,max=20)
		private String username;
		@FutureOrPresent
		private LocalDate startdate;
		@FutureOrPresent
		private LocalDate enddate;
		private Integer carid;
		@Size(min=1, max=52)
		private String carname;
		private boolean enableflag;
	}
	