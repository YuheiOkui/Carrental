package carrental;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class CustomThymeleafFunctions {
	
	    public Integer getDaysDifferencePlusOne(LocalDate date1, LocalDate date2) {
	        return (date2.compareTo(date1) + 1);

		}
}
