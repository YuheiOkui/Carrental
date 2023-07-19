package carrental.app.admin;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEditForm {
	private Integer carid;
	@Size(min=1, max=52)
	private String carname;
	@Size(min=1, max=10)
	private String cartype;
	@Size(min=1, max=10)
	private String color;
	@Size(min=1, max=15)
	private String maker;
	@Min(1)
	@Max(10)
	private int passengers;
	@Range(min=1, max=500000)
	private int carprice;
	private boolean enableflag;
}