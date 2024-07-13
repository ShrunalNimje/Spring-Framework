package my.mood.spring_framework.game.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("my.mood.spring_framework.game.a1")
public class GamingLauncherApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(GamingLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).
			forEach(System.out::println);
			
			System.out.println(context.getBean(GameRunner.class));
		}
	}
}
