package my.mood.spring_framework.example.s4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class MeriClassA{
	
}

// Lazy Initialization
@Lazy
@Component
class MeriClassB{
	
	MeriClassA mCA;
	
	public MeriClassB(MeriClassA mCA) {
		System.out.println("Lazy Initialization!");
		this.mCA = mCA;
	}
	
	public void doSomething() {
		System.out.println("Do Something!");
	}
	
}

@Configuration
@ComponentScan
public class LazyInitializationSpringApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitializationSpringApplication.class)){
			
			System.out.println(context.getBean(MeriClassB.class));
			
			context.getBean(MeriClassB.class).doSomething();
			
		}
		
	}

}
