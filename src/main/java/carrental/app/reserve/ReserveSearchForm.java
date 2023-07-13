package carrental.app.reserve;

import java.time.LocalDate;

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
	private LocalDate startdate;
	@NotNull
	private LocalDate enddate;
	@NotNull
	private Integer carid;
}
