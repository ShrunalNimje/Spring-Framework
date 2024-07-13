package my.mood.spring_framework.example.s4_1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Lazy
class SimpleClass{
	
//	public SimpleClass() {
//		System.out.println("Haahahahahahaha....");
//	}
	
}

// Scope Prototype
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{
	
}

@Configuration
@ComponentScan
public class PrototypeScopeSpringApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(PrototypeScopeSpringApplication.class)){
			
			// Singleton Scope
			System.out.println("Singleton Scope - one object instance per spring or IOC container");
			System.out.println(context.getBean(SimpleClass.class));
			System.out.println(context.getBean(SimpleClass.class));
			System.out.println(context.getBean(SimpleClass.class));
			System.out.println(context.getBean(SimpleClass.class));
			
			// Prototype Scope
			System.out.println("Prototype Scope - many object instances per spring or IOC container");
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			
		}
		
	}

}
