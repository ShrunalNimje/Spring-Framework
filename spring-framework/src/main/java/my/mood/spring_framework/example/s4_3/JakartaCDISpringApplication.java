package my.mood.spring_framework.example.s4_3;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component --> @Named from jakarta is similar to @Component from Spring
@Named 
class BusinessClass{
	
	SerciveClass depedencyClass;
	
	// @Autowired --> @Inject from jakarta is similar to @Autowired from Spring
	@Inject 
	public void setDepedency(SerciveClass depedencyClass) {
		System.out.println("Jakarta Contexts and Depedency Injection(CDI)");
		this.depedencyClass = depedencyClass;
	}
	
	public SerciveClass getDepedency() {
		return depedencyClass;
	}
}

// @Component
@Named
class SerciveClass{
	
}

@Configuration
@ComponentScan
public class JakartaCDISpringApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(JakartaCDISpringApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);

			System.out.println(context.getBean(BusinessClass.class));
		}
		
	}

}
