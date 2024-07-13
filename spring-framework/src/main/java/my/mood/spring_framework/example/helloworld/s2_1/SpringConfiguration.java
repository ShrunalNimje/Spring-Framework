package my.mood.spring_framework.example.helloworld.s2_1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
}

record Address(String address) {
}


@Configuration
public class SpringConfiguration {
	
	@Bean
	public String name() {
		return "Shrunal";
	}
	
	@Bean
	public int age() {
		return 21;
	}
	
	@Bean
	@Primary
	public Person person() {
		return new Person("Adam", 14, new Address("Nashik"));
	}
	
	@Bean
	public Person person2ByMethodCalls() {
		return new Person(name(), age(), address2()); // --> calling by existing bean methods
	}
	
	@Bean
	public Person person3ByMethodCalls() {
		return new Person(name(), age(), address()); // --> calling by existing bean methods
	}
	
	@Bean
	public Person person4ByParameterCallc(String name, int age, @Qualifier("person3Qualifier") Address add) {
		return new Person(name, age, add); // --> calling by existing bean methods
	}
	
	@Bean(name = "myAddress") // --> we can customize bean method name as required
	@Primary
	public Address address() {
		return new Address("Nagpur");
	}
	
	@Bean
	@Qualifier("person3Qualifier")
	public Address address2() {
		return new Address("Mumbai");
	}
	
}
