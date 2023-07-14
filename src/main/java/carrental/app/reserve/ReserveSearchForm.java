package carrental.app.reserve;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 予約条件検索のフォーム
 * @author 奥井
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveSearchForm {
	@NotNull
	@FutureOrPresent
	private LocalDate startdate;
	@NotNull
	@FutureOrPresent
	private LocalDate enddate;
	@NotNull
	private Integer carid;
}
