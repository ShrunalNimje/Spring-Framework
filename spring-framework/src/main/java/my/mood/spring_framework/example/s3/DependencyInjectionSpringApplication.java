package my.mood.spring_framework.example.s3;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class MyOwnClass{
	
	@Autowired
	Dependency1 a;
	@Autowired
	Dependency2 b;
	
	// method 1 - dependency injection using field or methods
	public String toString() {
		return "Dependencies are " + a + " and " + b ;
	}
	
	// method 2 - Dependency injection using setter
	@Autowired
	public void setDependency1(Dependency1 a) {
		System.out.println("Dependency 1 is a");
		this.a = a;
	}
	
	@Autowired
	public void setDependency2(Dependency2 b) {
		System.out.println("Dependency 2 is b");
		this.b = b;
	}
	
	// method 3 - Dependency injection using Constructor
	public MyOwnClass(Dependency1 a, Dependency2 b) {
		System.out.println(a + " and " + b);
		this.a = a;
		this.b = b;
	}
	
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DependencyInjectionSpringApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(DependencyInjectionSpringApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(MyOwnClass.class));
		}
		
	}

}
