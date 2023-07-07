package carrental.app.admin;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEditconf {
	private Integer carid;
	@Size(min=1, max=16)
	private String carname;
	@Min(1)
	@Max(9999)
	private String cartype;
	private String color;
	private String maker;
	private int passengers;
	private int carprice;
	private boolean enableflag;
}
