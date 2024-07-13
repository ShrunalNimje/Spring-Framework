package my.mood.spring_framework.example.exercise.s2_2;

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {

	DataService dataService;
	
	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveDate())
				.max().orElse(0);
	}
	
}
