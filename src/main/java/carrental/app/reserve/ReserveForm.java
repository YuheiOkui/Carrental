package carrental.app.reserve;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	@FutureOrPresent
	private LocalDate startdate;
	@NotNull
	@FutureOrPresent
	private LocalDate enddate;
	@NotNull
	private Integer carid;
	private String fullnameid;
	private LocalDateTime reservetime;
	@NotNull
	private Integer amount;
	
}
