																																																																																																																																																																																																																																																																																																																											package carrental.app.reserve;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class ReserveListForm {
	
	@NotBlank
	private LocalDateTime reservetime;
	@NotBlank
	private Integer userid;
	@NotBlank
	private String fullname;
	@NotBlank
	private LocalDate startDate;
	@NotBlank
	private LocalDate enddate;
	@NotBlank
	private Integer carid;
	@NotBlank
	private Integer cartype;
	
}
