package my.mood.spring_framework.example.s4_2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// PreDestroy and PostConstruct annotations
@Component
class PrePost{

	DependencyOne one;
	DependencyTwo two;
	
	public PrePost(DependencyOne one, DependencyTwo two) {
		this.one = one;
		this.two = two;
		
		System.out.println("Depedencies " + one + " and " + two + " are ready!");
		
	}
	
	@PostConstruct
	public void initializePost() {
		one.runOne();
	}
	
	@PreDestroy
	public void initializePre() {
		two.runTwo();
	}
	
	public void initialize() {
		System.out.println("Without Pre and Post annotations!");
	}
}

@Component
class DependencyOne{
	
	public void runOne() {
		System.out.println("Run One() using Post Construct!");
	}
}

@Component
class DependencyTwo{
	
	public void runTwo() {
		System.out.println("Run Two() using Pre destroy!");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationSpringApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(PrePostAnnotationSpringApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			context.getBean(PrePost.class).initialize();
		}
		
	}

}
