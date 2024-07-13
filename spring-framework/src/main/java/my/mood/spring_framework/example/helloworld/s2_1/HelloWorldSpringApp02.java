package my.mood.spring_framework.example.helloworld.s2_1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpringApp02 {

	public static void main(String[] args) {

		// Spring Context
		// HelloWorldConfiguration - @Configuration
		try(var context = 
				new AnnotationConfigApplicationContext
				(SpringConfiguration.class)){
			
			// Retrieving the Beans managed by Spring
			// name - @Bean
			System.out.println(context.getBean("name")); // --> calling by bean name
			
			// age - @Bean
			System.out.println(context.getBean("age")); // --> calling by bean name
			
			// person - @Bean
			System.out.println(context.getBean("person")); // --> calling by bean name
			
			System.out.println(context.getBean(Person.class)); // --> calling by type name

			System.out.println(context.getBean("person2ByMethodCalls"));
			
			System.out.println(context.getBean("person3ByMethodCalls"));
			
			System.out.println(context.getBean("person4ByParameterCallc"));

			// address - @Bean
			System.out.println(context.getBean("myAddress"));

			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean(Address.class));
			
			// List of all Spring Beans by interface programming
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);	
			
		}
		
	}

}
