package my.mood.spring_framework.example.exercise.s2_2;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveDate() {
		return new int [] {1, 3, 5, 7, 9};
	}

}
