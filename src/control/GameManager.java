package control;

import javafx.stage.Stage;
import pokemon.Magikarp;
import pokemon.Status;
import pokemon.Pokemon;

public class GameManager {
	
	private Player player1;
	private Stage primaryStage;
	
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void createPlayer(String name, String gender) {
		player1 = new Player(name, gender);
	}
	
	public Player getPlayer() {
		return player1;
	}
	
	public Stage getStage() {
		return primaryStage;
	}
}