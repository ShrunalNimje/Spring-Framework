package my.mood.spring_framework.example.exercise.s2_2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DepedencyInjectionSpringExercise {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(DepedencyInjectionSpringExercise.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println("Max value : " + context.getBean(BusinessCalculationService.class).findMax());
		}
		
	}

}
