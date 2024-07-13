package my.mood.spring_framework.game.a1;
import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GameConsole {

	public void Up() {
		System.out.println("Jump");
	}
	
	public void Down() {
		System.out.println("Down");
	}
	
	public void Left() {
		System.out.println("Go back");
	}
	
	public void Right() {
		System.out.println("Go forward");
	}
	
}