package my.mood.spring_framework.game.a1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	GameConsole game;
	
	public GameRunner(GameConsole game) {
		this.game = game;
	}
	 
	@Autowired
	public void run() {
		System.out.println("Game Runner : " + game);
		
		game.Up();
		game.Down();
		game.Left();
		game.Right();
		
	}
	
}
