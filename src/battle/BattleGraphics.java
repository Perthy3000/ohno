package battle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import pokemon.Bulbasaur;
import pokemon.Charmander;
import pokemon.Gyarados;
import pokemon.Magikarp;
import pokemon.Pikachu;
import pokemon.Squirtle;
import pokemon.Pokemon;

public class BattleGraphics extends StackPane {
	
	private Canvas backgroundLayer;
	private Canvas characterLayer;
	private Canvas vfxLayer;
	private GraphicsContext gc;
	private GraphicsContext gc2;
	private GraphicsContext gc3;
	private Image backgroundImage;
	private Image partnerImage;
	private Image enemyImage;
	
	public BattleGraphics() {
		try {
			backgroundLayer = new Canvas(400,200);
			characterLayer = new Canvas(400, 200);
			vfxLayer = new Canvas(400, 200);
			gc = backgroundLayer.getGraphicsContext2D();
			gc2 = characterLayer.getGraphicsContext2D();
			gc3 = vfxLayer.getGraphicsContext2D();
			backgroundImage = new Image(ClassLoader.getSystemResource("background-scene.png").toString(), 400, 200, false, false);
			getChildren().addAll(backgroundLayer, characterLayer, vfxLayer);
			gc.drawImage(backgroundImage, 0, 0);
			setBorder();
		} catch (Exception e) {
			System.out.println("cannot find image");
		}
		
	}
	
	private void setBorder() {
		String url = ClassLoader.getSystemResource("border4.png").toString();
		setStyle("-fx-padding: 15;" + 
                "-fx-background-insets: 5;" + 
                "-fx-background-image: url(" + url + ");" +
                "-fx-background-size: 460 230;" +
                "-fx-background-position: top center;" +
                "-fx-background-repeat: no-repeat;");
	}
	
	public void drawPartner(Pokemon currentPokemon) {
		clearPartner();
		partnerImage = new Image(ClassLoader.getSystemResource(getUrl(currentPokemon)).toString(), 100, 0, true, true);
		gc2.drawImage(partnerImage, 70, 130);
	}
	
	public void clearPartner() {
		gc2.clearRect(70, 130, 100, 200);
	}
	
	public void clearEnemyPokemon() {
		gc2.clearRect(245, 45, 80, 80);
	}
	
	public void drawEnemyPokemon(Pokemon enemyPokemon) {
		enemyImage = new Image(ClassLoader.getSystemResource(getUrl(enemyPokemon)).toString(), 80, 0, true, true);
		gc2.drawImage(enemyImage, 245, 45);
	}
	
	private String getUrl(Pokemon pokemon) {
		String url = "charmander.png";
		if(pokemon instanceof Charmander) url = "charmander.png";
		else if(pokemon instanceof Bulbasaur) url = "Bulbasaur.png";
		else if(pokemon instanceof Squirtle) url = "squirtle.png";
		else if(pokemon instanceof Pikachu) url = "Pikachu.png";
		else if(pokemon instanceof Magikarp) url = "yo.png";
		else if(pokemon instanceof Gyarados) url = "Gyarados.png";
		return url;
	}
	
	public void resetCanvas() {
		backgroundLayer = new Canvas();
		backgroundImage = new Image(ClassLoader.getSystemResource("background-scene.png").toString(), 400, 200, false, false);
		getChildren().add(backgroundLayer);
		gc.drawImage(backgroundImage, 0, 0);
	}
	
	public GraphicsContext getGraphicsContext() {
		return gc3;
	}
}
