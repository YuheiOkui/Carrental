																																																																																																																																																																																																																																																																																																																											package carrental.app.reserve;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class ReserveListForm {
	
	@NotBlank
	private LocalDate date;
	@NotBlank
	private Integer userid;
	@NotBlank
	private String name;
	@NotBlank
	private LocalDate startdate;
	@NotBlank
	private LocalDate enddate;
	@NotBlank
	private Integer carid;
	@NotBlank
	private Integer cartype;
	@NotBlank
	private LocalDateTime reservetime;
}
