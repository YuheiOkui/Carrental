package carrental.app.reserve;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 予約内容のフォーム
 * @author 奥井
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveForm {
	@NotBlank
	private LocalDate startdate;
	@NotBlank
	private LocalDate enddate;
	@NotBlank
	private Integer carid;
	@NotBlank
	private String fullnameid;
	@NotBlank
	private LocalDateTime reservetime;
}
