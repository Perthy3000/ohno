package pokeball;

import control.GameManager;
import control.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mainmenu.MainMenuScene;
import pokemon.*;

public class LevelUp extends HBox {
	
	private InfoArea infoArea;
	private StatArea statArea;
	private Image buttonImage;
	private Button exitButton;
	private Label nameLabel ;
	private Stage primaryStage;
	private ImageView pokemonImage;
	
	public LevelUp(GameManager manager, int index) {
		Player player = manager.getPlayer();
		this.primaryStage = manager.getStage();
		Pokemon pokemon = player.getpokenList().get(index);
		statArea = new StatArea(index, player);
		infoArea = new InfoArea(index, manager, statArea,this);
		Image image = new Image ("uplvlbg.png");
	    setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
	                                                                  BackgroundRepeat.REPEAT,
	                                                                  BackgroundPosition.DEFAULT,
	                                                                  BackgroundSize.DEFAULT)));
		VBox vBox = new VBox();
		//pokemon image
		pokemonImage = new ImageView();
		setPokemonImage(pokemon);
		exitButton = new Button();
		exitButton.setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		exitButton.setStyle("-fx-background-color: transparent;");
		buttonImage = new Image(ClassLoader.getSystemResource("exitbf.png").toString(), 70, 42, false, false);
		exitButton.setGraphic(new ImageView(buttonImage));
		nameLabel = new Label(pokemon.getName());
		nameLabel.setStyle("-fx-text-fill: white;-fx-font-size: 30;");
		vBox.setAlignment(Pos.BOTTOM_CENTER);
		vBox.setSpacing(50);
		vBox.getChildren().addAll(pokemonImage,nameLabel);
		//set exit button
		exitButton.setOnAction(new EventHandler<ActionEvent>() {	
			@Override
			public void handle(ActionEvent arg0) {
				MainMenuScene nextMainMenuScene = new MainMenuScene(manager);
				Scene nextScene = new Scene(nextMainMenuScene, 500, 800);
				primaryStage.setScene(nextScene);
			}
			
		});
		exitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				exitButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exitaf.png").toString(), 70, 42, false, false)));
			}
		 });
		exitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				exitButton.setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exitbf.png").toString(), 70, 42, false, false)));
			}
		});
		getChildren().addAll(infoArea, vBox, statArea);
		
		setPadding(new Insets(20));
		setSpacing(0);
	}
	
	public void setPokemonImage(Pokemon pokemon) {
		double h;
		double w;
		if(pokemon instanceof Charmander) {h=350;
		w=350;}
		else if(pokemon instanceof Bulbasaur) {h=160;
		w=175;}
		else if(pokemon instanceof Squirtle) {h=195;
		w=200;}
		else if(pokemon instanceof Pikachu) {h=250;
		w=250;}
		else if(pokemon instanceof Gyarados) { h=320;
		w=305;
		 }
		else {h=350;
		w=350;}
		pokemonImage.setImage(new Image(ClassLoader.getSystemResource(findImage(pokemon)).toString(), w, h, true, false));
	}
	
	//find pokemon image
	private String findImage(Pokemon pokemon) {
		String url;
		if(pokemon instanceof Charmander) url = "tenor.gif";
		else if(pokemon instanceof Bulbasaur) url = "Bulbasaurg.gif";
		else if(pokemon instanceof Squirtle) url = "squirtleg.gif";
		else if(pokemon instanceof Pikachu) url = "pikag.gif";
		else if(pokemon instanceof Gyarados) url = "Gyarados.gif";
		else url = "Magikrap.gif";
		return url;
	}
	public void setNameLabel(String name) {
		if(!name.trim().isBlank()) nameLabel.setText(name);
	}
	public Stage getPrimaryStage() {
		return this.primaryStage;
	}
	public void setPrimaryStage(Scene nextScene) {
		primaryStage.setScene(nextScene);
	}
}
