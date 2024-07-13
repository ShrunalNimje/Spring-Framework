package my.mood.spring_framework.example.s4_4;

import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import my.mood.spring_framework.game.a1.GameRunner;

public class XMLConfigurationSpringApplication {
	public static void main(String[] args) {
		
		try(var context = 
				new ClassPathXmlApplicationContext
				("SpringConfiguration.xml")){
			
			Arrays.stream(context.getBeanDefinitionNames()).
			forEach(System.out::println);
			
			System.out.println(context.getBean("Name"));
			
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
			
		}
	}

}
