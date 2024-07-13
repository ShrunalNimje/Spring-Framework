package my.mood.spring_framework.example.exercise.s2_2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {

	@Override
	public int[] retrieveDate() {
		return new int [] {11, 23, 45, 67, 89};
	}

}
